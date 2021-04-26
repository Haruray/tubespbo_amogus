package willywank.mainobjects;

import java.util.ArrayList;
import java.util.List;

public class Engimon implements Comparable<Engimon> {
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
    int health;

    static int totalEngimon = 0;

    public Engimon(){
        setName("None");
        setParent(null,null);
        setSpecies(new Species());
        addElement(new Element());
        setLevel(0);
        setExp(0);
        setCumulativeExp(getLevel()*100 - 100);
        setExpLimit(0);
        this.health = 3;
        totalEngimon++;
    }

    public Engimon(String name, Engimon p1, Engimon p2, Species species, List<Skill> skills, List<Element> elements, int level, int explimit){
        this.id = totalEngimon+1;
        setName(name);
        setParent(p1,p2);
        setSpecies(species);
        addSkill(skills);
        try {
            addSkill(species.getUniqueSkill());
        } catch (SkillNotExist e) {
            // TODO Auto-generated catch block
            e.showErrors();
        } catch (SkillOverload e) {
            // TODO Auto-generated catch block
            e.showErrors();
        }
        addElement(elements);
        setLevel(level);
        setExp(0);
        setCumulativeExp(getLevel()*100 - 100);
        setExpLimit(explimit);
        this.health = 3;
        totalEngimon++;
    }

    public Engimon(Engimon e){
        this.id = e.id;
        setName(e.getName());
        setParent(e.getParents().get(0),e.getParents().get(1));
        setSpecies(e.getSpecies());
        addSkill(e.getSkills());
        try {
            addSkill(e.getSpecies().getUniqueSkill());
        } catch (SkillNotExist exception) {
            // TODO Auto-generated catch block
            exception.showErrors();
        } catch (SkillOverload exception) {
            // TODO Auto-generated catch block
            exception.showErrors();
        }
        addElement(e.getElements());
        setLevel(e.getLevel());
        setExp(0);
        setCumulativeExp(this.getLevel()*100 - 100);
        setExpLimit(e.getCumExpLimit());
        this.health = 3;
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

    @Override
    public int compareTo(Engimon e) {

        if (this.elements.get(0).elementToNumber() == e.getElements().get(0).elementToNumber()) {
            return 0;
        }
        if (this.elements.get(0).elementToNumber() < e.getElements().get(0).elementToNumber()) {
            return -1;
        }
        if (this.elements.get(0).elementToNumber() > e.getElements().get(0).elementToNumber()) {
            return 1;
        }
        return 0;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setParent(Engimon p1, Engimon p2){
        this.parents.add(p1);
        this.parents.add(p2);
    }
    public void setSpecies(Species species){
        this.species = species;
    }
    public void addSkill(Skill skill) throws SkillNotExist, SkillOverload{
        if (this.skills.size() < 4){
            if (!this.hasSkill(skill)){
                this.skills.add(skill);
            }
            else{
                throw new SkillNotExist();
            }
        }
        else{
            throw new SkillOverload();
        }

    }

    public void addSkill(List<Skill> arr){
        for (Skill skill : arr) {
            try {
                this.addSkill(skill);
            } catch (SkillNotExist e) {
                // TODO Auto-generated catch block
                e.showErrors();
            } catch (SkillOverload e) {
                // TODO Auto-generated catch block
                e.showErrors();
            }
        }
    }
    public void addElement(Element E){
        if (!isElement(E))
            this.elements.add(E);
    }
    public void addElement(List<Element> E){
        for (Element element : E) {
            this.addElement(element);
        }
    }
    public void levelUp(){
        this.exp -= 100;
        this.level++;
        System.out.println("\nEngimon Level Up!");
        System.out.println(this.name + ", current level" + this.level);
    }
    public void setLevel(int level){
        this.level = level;
        setCumulativeExp(this.level*100 - 100);
    }
    public void addExp(int exp){
        this.exp += exp;
        this.cumulativeExp +=exp;
        while (lvlUpEligibility()){
            levelUp();
        }
//        if (isDead()){
//            //idk, maybe some exception or something?
//        }
    } //ini berpengaruh ke exp dan cumulative exp
    public void setExp(int exp){
        this.exp = exp;
    }
    public void setCumulativeExp(int cumulative){
        this.cumulativeExp = cumulative;
    } //ini kurang perlu menurutku tapi jaga-jaga aja
    public void setExpLimit(int lim){
        this.explimit = lim;
    }
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public List<Engimon> getParents(){
        return this.parents;
    }
    public Species getSpecies(){
        return this.species;
    }
    public List<Skill> getSkills(){
        return this.skills;
    }
    public List<Element> getElements(){
        return this.elements;
    }
    public int getLevel(){
        return this.level;
    }
    public int getExp(){
        return this.exp;
    }
    public int getCumulativeExp(){
        return this.cumulativeExp;
    }
    public int getCumExpLimit(){
        return this.explimit;
    }
    public int getHealth(){return this.health;}
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
    public Boolean lvlUpEligibility(){
        return this.exp >= 100;
    } //refer to spek 1.c
    public Boolean isDead(){
        return getCumulativeExp() >= getCumExpLimit() || this.health<=0;
    } //refer to spek 1.d
    public Boolean isElement(Element E){
        return this.elements.contains(E);
    } //apakah engimon berelemen x
    public Boolean hasSkill(Skill S){
        return this.skills.contains(S);
    } //apakah engimon punya skill x
    public void decreaseHealth(){
        this.health--;
    }
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
