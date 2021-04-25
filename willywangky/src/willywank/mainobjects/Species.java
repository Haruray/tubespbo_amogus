package willywank.mainobjects;

public class Species {
    String speciesName;
    String slogan;
    Skill uniqueSkill;
    int life; //Update: ada informasi life, methods TBA

    public Species(){
        setSpeciesName("None");
        setSlogan("None");
        setUniqueSkill(new Skill());
    }
    Species(String name, String slogan, Skill skill){
        setSpeciesName(name);
        setSlogan(slogan);
        setUniqueSkill(skill);
    }
    void setSpeciesName(String name){
        this.speciesName = name;
    }
    void setSlogan(String slogan){
        this.slogan = slogan;
    }
    void setUniqueSkill(Skill skill){
        this.uniqueSkill = skill;
    }
    String getSpeciesName(){
        return this.speciesName;
    }
    String getSlogan(){
        return this.slogan;
    }
    Skill getUniqueSkill(){
        return this.uniqueSkill;
    }
}
