package java;
import java.util.ArrayList;

public class Skill {
    String skillName;
    int basePower;
    int masteryLevel;
    ArrayList<Element> elmtReq;

    Skill(){
        setSkillName("None");
        setBasePower(0);
        setMasteryLevel(0);
    }
    Skill(String name, int base, int mastery, ArrayList<Element> E){
        setSkillName(name);
        setBasePower(base);
        setMasteryLevel(mastery);
        setElmtReq(E);
    }
    void setSkillName(String name){
        this.skillName = name;
    }
    void setBasePower(int base){
        this.basePower = base;
    }
    void setMasteryLevel(int mastery){
        this.masteryLevel = mastery;
    }
    void setElmtReq(ArrayList<Element> E){
        this.elmtReq = new ArrayList<Element>(E);
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