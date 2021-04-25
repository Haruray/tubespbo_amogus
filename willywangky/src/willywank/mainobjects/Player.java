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
    void skillSelection(Engimon e1, Engimon e2, List<Skill> newSkill, List<Skill> skillList){

    }
    void breeding(Engimon e1, Engimon e2){

    }

    void swapActiveEngimon(){

    }
    void interactWithActiveEngimon(){

    }
}
