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
    public Species(String name, String slogan, Skill skill){
        setSpeciesName(name);
        setSlogan(slogan);
        setUniqueSkill(skill);
    }
    public void setSpeciesName(String name){
        this.speciesName = name;
    }
    public void setSlogan(String slogan){
        this.slogan = slogan;
    }
    public void setUniqueSkill(Skill skill){
        this.uniqueSkill = skill;
    }
    public String getSpeciesName(){
        return this.speciesName;
    }
    public String getSlogan(){
        return this.slogan;
    }
    public Skill getUniqueSkill(){
        return this.uniqueSkill;
    }
    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Species)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Species s = (Species) o;

        // Compare the data members and return accordingly
        return (this.speciesName.equals(s.getSpeciesName()));
    }
}
