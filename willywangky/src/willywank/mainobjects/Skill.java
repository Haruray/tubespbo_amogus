package willywank.mainobjects;

import java.util.ArrayList;
import java.util.List;

public class Skill implements Comparable<Skill> {
    final int masteryLimit = 3;
    String skillName;
    int basePower;
    int masteryLevel;
    List<Element> elmtReq = new ArrayList<>();

    public Skill(){
        setSkillName("None");
        setBasePower(0);
        setMasteryLevel(0);
    }
    public Skill(String name, int base, int mastery, List<Element> E){
        setSkillName(name);
        setBasePower(base);
        setMasteryLevel(mastery);
        setElmtReq(E);
    }
    public Skill(Skill s){
        setSkillName(s.getSkillName());
        setBasePower(s.getBasePower());
        setMasteryLevel(s.getMasteryLevel());
        setElmtReq(s.getElmtReq());
    }

    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Skill)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Skill s = (Skill) o;

        // Compare the data members and return accordingly
        return (this.skillName.equals(s.skillName));
    }

    @Override
    public int compareTo(Skill s) {

        if (this.basePower == s.basePower) {
            return 0;
        }
        if (this.basePower < s.basePower) {
            return -1;
        }
        if (this.basePower > s.basePower) {
            return 1;
        }
        return 0;
    }

    public void setSkillName(String name){
        this.skillName = name;
    }
    public void setBasePower(int base){
        this.basePower = base;
    }
    public void setMasteryLevel(int mastery) {
        // Update: mastery maks level 3
        if (mastery <= 3){
            this.masteryLevel = mastery;
        }
        else{
            // exception mastery melebihi batas (?)
            this.masteryLevel = 3;
        }
    }
    public void setElmtReq(List<Element> E){
        this.elmtReq.addAll(E);
    }
    public String getSkillName(){
        return this.skillName;
    }
    public int getBasePower(){
        return this.basePower;
    }
    public int getMasteryLevel(){
        return this.masteryLevel;
    }
    public List<Element> getElmtReq(){
        return this.elmtReq;
    }

    @Override
    public String toString() {
        return String.format(this.skillName + " / Base Power "+this.basePower+" / Master Lv."+this.masteryLevel);
    }

    public void printSkillDetail(){
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
