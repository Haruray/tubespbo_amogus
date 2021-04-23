package willywangkyjava;

public class Species {
    String speciesName;
    String slogan;
    Skill uniqueSkill;
    int life; //Update: ada informasi life, methods TBA

    Species(){
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

// class Species{
//     protected:
//         string speciesName;
//         string slogan; //refer to spek 3.c.iv
//         Skill uniqueSkill;
//     public:
//         Species(); //ctor
//         Species(string,string,Skill); //ctor with arguments
//         Species(const Species&);
//         ~Species();

//         //setter
//         void setSpeciesName(string);
//         void setSlogan(string);
//         void setUniqueSkill(Skill);

//         //getter
//         string getSpeciesName();
//         string getSlogan();
//         Skill getUniqueSkill();
// };
