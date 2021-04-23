package willywangkyjava;

import java.util.*;
import java.util.Collections;

public class Engimon {
    int id;
    String name;
    List<Engimon> parents = new ArrayList<>();
    Species species;
    List<Skill> skills = new ArrayList<>();
    List<Element> elements = new ArrayList<>();
    int level;
    int exp;
    int cumulativeExp;
    int explimit;

    static int totalEngimon = 0;

    Engimon(String name, Engimon p1, Engimon p2, Species species, List<Skill> skills, List<Element> elements, int level, int explimit){
        this.id = totalEngimon+1;
        setName(name);
        setParent(p1,p2);
        setSpecies(species);
        addSkill(skills);
        addSkill(species.getUniqueSkill());
        addElement(elements);
        setLevel(level);
        setExp(0);
        setCumulativeExp(getLevel()*100 - 100);
        setExpLimit(explimit);
        totalEngimon++;
    }

    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Engimon)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Engimon e = (Engimon) o;

        // Compare the data members and return accordingly
        return (id == e.id);
    }

    void setName(String name){
        this.name = name;
    }
    void setParent(Engimon p1, Engimon p2){
        this.parents.add(p1);
        this.parents.add(p2);
    }
    void setSpecies(Species species){
        this.species = species;
    }
    void addSkill(Skill skill){
        if (this.skills.size() < 4){
            if (!this.hasSkill(skill)){
                this.skills.add(skill);
            }
            else{
                //exception
            }
        }
        else{
            //exception
        }
        
    }

    void addSkill(List<Skill> arr){
        for (Skill skill : arr) {
            this.addSkill(skill);
        }
    }
    void addElement(Element E){
        if (!isElement(E))
            this.elements.add(E);
    }
    void addElement(List<Element> E){
        for (Element element : E) {
            this.addElement(element);
        }
    }
    void levelUp(){
        this.exp -= 100;
        this.level++;
        System.out.println("\nEngimon Level Up!");
        System.out.println(this.name + ", current level" + this.level);
    }
    void setLevel(int level){
        this.level = level;
        setCumulativeExp(this.level*100 - 100);
    }
    void addExp(int exp){
        this.exp += exp;
        this.cumulativeExp +=exp;
        while (lvlUpEligibility()){
            levelUp();
        }
        if (isDead()){
            //idk, maybe some exception or something?
        }
    } //ini berpengaruh ke exp dan cumulative exp
    void setExp(int exp){
        this.exp = exp;
    }
    void setCumulativeExp(int cumulative){
        this.cumulativeExp = cumulative;
    } //ini kurang perlu menurutku tapi jaga-jaga aja
    void setExpLimit(int lim){
        this.explimit = lim;
    }
    int getId(){
        return this.id;
    }
    String getName(){
        return this.name;
    }
    List<Engimon> getParents(){
        return this.parents;
    }
    Species getSpecies(){
        return this.species;
    }
    List<Skill> getSkills(){
        return this.skills;
    }
    List<Element> getElements(){
        return this.elements;
    }
    int getLevel(){
        return this.level;
    }
    int getExp(){
        return this.exp;
    }
    int getCumulativeExp(){
        return this.cumulativeExp;
    }
    int getCumExpLimit(){
        return this.explimit;
    }
    Skill getHighestMasteryLevel(){
        Skill maxSkill = this.skills.get(0);
        int max = maxSkill.getMasteryLevel();
        for (Skill skill : this.skills) {
            if (skill.getMasteryLevel() > max){
                max = skill.getMasteryLevel();
                maxSkill = skill;
            }
        }
        return maxSkill;
    }
    Boolean lvlUpEligibility(){
        return this.exp >= 100;
    } //refer to spek 1.c
    Boolean isDead(){
        return getCumulativeExp() >= getCumExpLimit();
    } //refer to spek 1.d
    Boolean isElement(Element E){
        return this.elements.contains(E);
    } //apakah engimon berelemen x 
    Boolean hasSkill(Skill S){
        return this.skills.contains(S);
    } //apakah engimon punya skill x
    
    //delete
    void replaceSkill(Skill S){

    } //replace skill by index

    // Update: Passive exp nambah buat engimon liar
    void passiveExp(){
        addExp(100);
    }

    //output function
    void printDetail(){

    }
    void printSkill(){

    }
    @Override
    public String toString() {
        return String.format(this.name+" / "+this.getElements().get(0).getElementName()+" / Lv."+this.getLevel());
    }

}

