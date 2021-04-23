package willywangkyjava;
import java.util.*;

public class Skill {
    final int masteryLimit = 3;
    String skillName;
    int basePower;
    int masteryLevel;
    List<Element> elmtReq = new ArrayList<>();

    Skill(){
        setSkillName("None");
        setBasePower(0);
        setMasteryLevel(0);
    }
    Skill(String name, int base, int mastery, List<Element> E){
        setSkillName(name);
        setBasePower(base);
        setMasteryLevel(mastery);
        setElmtReq(E);
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
        Skill s = (Skill) o;

        // Compare the data members and return accordingly
        return (this.skillName.equals(s.skillName));
    }

    void setSkillName(String name){
        this.skillName = name;
    }
    void setBasePower(int base){
        this.basePower = base;
    }
    void setMasteryLevel(int mastery){
        // Update: mastery maks level 3
        if (mastery <= 3){
            this.masteryLevel = mastery;
        }
        else{
            // exception mastery melebihi batas (?)
        }
    }
    void setElmtReq(List<Element> E){
        this.elmtReq.addAll(E);
    }
    String getSkillName(){
        return this.skillName;
    }
    int getBasePower(){
        return this.basePower;
    }
    int getMasteryLevel(){
        return this.masteryLevel;
    }
    ArrayList<Element> getElmtReq(){
        return getElmtReq();
    }

    @Override
    public String toString() {
        return String.format(this.skillName + " / Base Power "+this.basePower+" / Master Lv."+this.masteryLevel);
    }

    void printSkillDetail(){
        System.out.println("Skill Name: " + this.skillName);
        System.out.println("Base Power: " + this.basePower);
        System.out.println("Mastery Level: " + this.masteryLevel);
        System.out.print("Elmt Req:");
        for (int i = 0; i < this.elmtReq.size() - 1; i++) {
            System.out.printf("%s, ",this.elmtReq.get(i).getElementName());
        }
        System.out.println(this.elmtReq.get(this.elmtReq.size()-1));
    }
}

// class Skill{
//     protected:
//         string skillName;
//         int basePower;
//         int masteryLevel;
//         vector<Element> elmtReq;
//     public:
//         Skill(); //ctor
//         Skill(string, int,int, vector<Element>); //ctor with arguments
//         Skill(const Skill&);
//         ~Skill();

//         //operator overload
//         bool operator<(const Skill&) const;
//         bool operator>(const Skill&) const;

//         //setter
//         void setSkillName(string);
//         void setBasePower(int);
//         void setMasteryLevel(int);
//         void setElmtReq(vector<Element>);

//         //getter
//         string getSkillName();
//         int getBasePower();
//         int getMasteryLevel();
//         vector<Element> getElmtReq();

//         void printSkillDetail();
// };
