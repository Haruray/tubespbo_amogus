package willywank.mainobjects;

import java.util.ArrayList;
import java.util.List;

public class Player {
    String playerName;
    Inventory<Skill> skillList = new Inventory<>();
    Inventory<Engimon> engimonList = new Inventory<>();
    Engimon activeEngimon;
    int posX;
    int posY;
    int activeEngimonPosX;
    int activeEngimonPosY;

    //    public Player(){
//        this.setPlayerName("tes");
//        Species s = new Species();
//        Element Fire = new Element("Fire");
//        List<Skill> ls = new ArrayList<>();
//        List<Element> le= new ArrayList<>();
//        Engimon e2 = new Engimon("cock2", null, null, s, ls, le, 10, 10);
//        this.setActiveEngimon(e2);
//        this.setPosition(0,0); //starting position nanti bisa dirubah
//        this.setActiveEngPos(1, 0);
//    }
    public Player(String name, Inventory<Skill> is, Inventory<Engimon> ie, Engimon ae, int x, int y){
        this.setPlayerName(name);
        this.setInventorySkill(is);
        this.setInventoryEngimon(ie);
        this.setActiveEngimon(ae);
        this.setPosition(x,y); //starting position nanti bisa dirubah
        this.setActiveEngPos(1, 0);
    }

    void setPlayerName(String name){
        this.playerName=name;
    }
    void setInventorySkill(Inventory<Skill> is){
        this.skillList.items.addAll(is.items);
    }
    void setInventoryEngimon(Inventory<Engimon> ie){
        this.engimonList.items.addAll(ie.items);
    }
    void setActiveEngimon(Engimon ae){
        this.activeEngimon=ae;
    }
    void setPosition(int x,int y){
        this.posX=x;
        this.posY=y;
    }
    void setActiveEngPos(int x, int y){
        this.activeEngimonPosX=x;
        this.activeEngimonPosY=y;
    }

    public String getPlayerName(){
        return this.playerName;
    }
    public Inventory<Skill> getInventorySkill(){
        return this.skillList;
    }
    public Inventory<Engimon> getInventoryEngimon(){
        return this.engimonList;
    }
    public Engimon getActiveEngimon(){
        return this.activeEngimon;
    }
    public int getPosX(){
        return this.posX;
    }
    public int getPosY(){
        return this.posY;
    }
    public int ActiveX(){
        return this.activeEngimonPosX;
    }
    public int ActiveY(){
        return this.activeEngimonPosY;
    }
    public void moveUp(){
        this.ActiveEngimonFollow();
        this.posX--;
    }
    public void moveLeft(){
        this.ActiveEngimonFollow();
        this.posY--;
    }
    public void moveRight(){
        this.ActiveEngimonFollow();
        this.posY++;
    }
    public void moveDown(){
        this.ActiveEngimonFollow();
        this.posX++;
    }
    public void ActiveEngimonFollow(){
        this.activeEngimonPosX = this.posX;
        this.activeEngimonPosY = this.posY;
    }

    void showEngimonList(){
        this.getInventoryEngimon().printItems();
    }
    void showEngimonData(Engimon e){
        e.printDetail();
    }

    void showSkillList(){
        this.getInventorySkill().printItems();
    }
    public void useSkillItem(Skill s, Engimon e){
        if (this.getInventorySkill().doesItemExist(s) && this.getInventoryEngimon().doesItemExist(e)){
            //learn something
        }
        else{
            //exception : skill or engimon doesn't exist in inventory
        }
    }

    boolean doesSkillExistInVector(String name, List<Skill> vs){
        for (int i = 0 ; i < vs.size() ; i++){
            if (vs.get(i).getSkillName().equals(name)){
                return true;
            }
        }
        return false;
    }

    void skillSelection(Engimon e1, Engimon e2, List<Skill> newSkill, List<Skill> skillList){
        for (int i = 0; i < e1.getSkills().size() ; i++){
            if (e1.getSkills().get(i).getMasteryLevel() >= e2.getSkills().get(i).getMasteryLevel()){ //mastery skill parent 1 paling besar
                if (e1.getSkills().get(i).getSkillName().equals(e2.getSkills().get(i).getSkillName())  && e1.getSkills().get(i).getMasteryLevel() == e2.getSkills().get(i).getMasteryLevel()){
                    //jika punya skill sama dan mastery level sama, maka mastery level anaknya adalah mastery level parent 1 +1
                    newSkill.add(e1.getSkills().get(i));
                    newSkill.get(newSkill.size()-1).setMasteryLevel(newSkill.get(newSkill.size()-1).getMasteryLevel()+1);
                }
                else if (e1.getSkills().get(i).getSkillName().equals(e2.getSkills().get(i).getSkillName())  && e1.getSkills().get(i).getMasteryLevel() != e2.getSkills().get(i).getMasteryLevel()){
                    //jika skill sama tapi mastery level berbeda, maka diambil mastery level yg terbesar
                    newSkill.add(new Skill(e1.getSkills().get(i).getSkillName(),e1.getSkills().get(i).getBasePower(), Math.max(e1.getSkills().get(i).getMasteryLevel(), e2.getSkills().get(i).getMasteryLevel()),e1.getSkills().get(i).getElmtReq()));
                }
                else{
                    //jika skill nya tidak sama tapi mastery level parent 1 lebih besar, maka masukin aja
                    newSkill.add(e1.getSkills().get(i));
                }
            }
            else{//parent 2 punya skill mastery level lebih besar
                newSkill.add(e2.getSkills().get(i));
            }
        }
        //edge case : karena pengambilan skill sebelumnya belum menjamin skill hasil breeding sudah penuh, maka dilakukan pengecekan lagi dan ditambahkan yg belum
        int j=0;
        while (newSkill.size() < 4 && j < skillList.size()){
            if (!doesSkillExistInVector(skillList.get(j).getSkillName(), newSkill)){
                //kalau skill belum diambil dari skillList, maka langsung masukin aja, idk
                newSkill.add(skillList.get(j));
            }
            j++;
        }
    }

    boolean compareVectorOfElements(List<Element> elist1, List<Element> elist2){
        if (elist1.size() > elist2.size()){
            for (int i = 0; i < elist1.size() ; i++){
                for (int j = 0 ; j < elist2.size() ; j++){
                    if (!elist1.get(i).getElementName().equals(elist2.get(j).getElementName())){
                        return false;
                    }
                }
            }
            return true;
        }
        else{
            for (int i = 0; i < elist2.size() ; i++){
                for (int j = 0 ; j < elist1.size() ; j++){
                    if (!elist2.get(i).getElementName().equals(elist1.get(j).getElementName())){
                        return false;
                    }
                }
            }
            return true;
        }
    }

    List<Element> getMostAdvantageousElmt(List<Element> elist1, List<Element> elist2){
        //Mencari himpunan elmt dengan adv terbesar. Metode nya adalah : penjumlahan
        //selain itu, dicatat per elist element mana yg nilai advantage nya yg paling besar ; e1max untuk elist1 dan e2max untuk elist2
        Element e1max = elist1.get(0);
        float e1maxf = elist1.get(0).elementAdvantage(elist2.get(0));
        Element e2max = elist2.get(0);
        float e2maxf = elist2.get(0).elementAdvantage(elist1.get(0));

        float adv1=0;
        float adv2=0;
        for (int i=0; i < elist1.size() ; i++){
            for (int j=0 ; j < elist2.size() ; j++){
                adv1 += elist1.get(i).elementAdvantage(elist2.get(j));
                if (elist1.get(i).elementAdvantage(elist2.get(j)) > e1maxf){
                    e1maxf = elist1.get(i).elementAdvantage(elist2.get(j));
                    e1max = elist1.get(i);
                }
            }
        }
        for (int i=0; i < elist2.size() ; i++){
            for (int j=0 ; j < elist1.size() ; j++){
                adv2 += elist2.get(i).elementAdvantage(elist1.get(j));
                if (elist2.get(i).elementAdvantage(elist1.get(j)) > e2maxf){
                    e2maxf = elist2.get(i).elementAdvantage(elist1.get(j));
                    e2max = elist2.get(i);
                }
            }
        }
        if (adv1 > adv2){
            return elist1;
        }
        else if (adv1 < adv2){
            return elist2;
        }
        else{ //kalau elemen sama, maka digabungkan e1max dan e2max
            List<Element> newEl = new ArrayList<>();
            newEl.add(e1max);
            newEl.add(e2max);
            return newEl;
        }
    }

    void breeding(Engimon e1, Engimon e2, String newname){
        List<Skill> newskill = new ArrayList<>();
        List<Element> newelement = new ArrayList<>();
        List<Skill> skillList = new ArrayList<>();
        Species newspecies = new Species();
        e1.setLevel(e1.getLevel()-3);
        e2.setLevel(e2.getLevel()-3);

        for (int i = 0 ; i < e1.getSkills().size() ; i++){
            skillList.add(e1.getSkills().get(i));
        }
        for (int i = 0 ; i < e2.getSkills().size() ; i++){
            skillList.add(e2.getSkills().get(i));
        }
        //Disini algoritma sorting ; nanti
        if (e1.getSkills().size() <= e2.getSkills().size()){
            //kalau jumlah skill e1 lebih kecil sama dengan jumlah skill e2, maka loop dibawah ini dilakukan
            this.skillSelection(e1,e2,newskill,skillList);
        }
        else{
            //kalau jumlah skill e2 jauh lebih kecil, maka dilakukan sebaliknya
            this.skillSelection(e2,e1,newskill,skillList);
        }

        newelement.addAll(getMostAdvantageousElmt(e1.getElements(),e2.getElements()));
        if (compareVectorOfElements(newelement, e1.getElements())){
            newspecies = e1.getSpecies();
        }
        else{
            newspecies = e2.getSpecies();
        }
        //Untuk sementara engga ada random
        Engimon newEngimon = new Engimon(newname, e1, e2, newspecies, newskill, newelement, 1, 10000);
        this.getInventoryEngimon().addItem(newEngimon);

    }

    void swapActiveEngimon(){

    }
    void interactWithActiveEngimon(){

    }
}
