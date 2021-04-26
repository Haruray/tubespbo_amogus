package willywank.mainobjects;

import java.util.List;

public class Enemy extends Engimon {
    int posX;
    int posY;

    Enemy(String name, Engimon p1, Engimon p2, Species species, List<Skill> skills, List<Element> elements, int level, int explimit, int x, int y){
        super(name, p1, p2, species, skills, elements, level, explimit);
        setPosX(x);
        setPosY(y);
    }
    void setPosX(int x){
        this.posX=x;
    }
    void setPosY(int y){
        this.posY=y;
    }
    int getPosX(){
        return this.posX;
    }
    int getPosY(){
        return this.posY;
    }
    String getLogo(Player P){
        return "???";
    } //mendapatkan logo sesuai acive engimon player ; refer ke spek poin 6
    //movement
    void moveUp(){
        setPosX(getPosX()-1);
    }
    void moveLeft(){
        setPosY(getPosY()-1);
    }
    void moveRight(){
        setPosY(getPosY()+1);
    }
    void moveDown(){
        setPosX(getPosX()+1);
    }
    void levelUp(){
        this.exp -= 100;
        this.level += 1;
    }
    void printDetail(){
        System.out.println("Name: " + this.getName());
        System.out.println("Species: " + this.getSpecies().getSpeciesName());
        System.out.print("Element: ");
        for (int i = 0; i < this.getElements().size(); i++) {
            if (i < this.getElements().size() - 1){
                System.out.print(this.getElements().get(i).getElementName() + ", ");
            }
            else{
                System.out.println(this.getElements().get(i).getElementName());
            }
        }
        System.out.println("Skill: ");
        for (int i = 0; i < this.getSkills().size(); i++) {
            if (i < this.getSkills().size() - 1){
                System.out.print(this.getSkills().get(i).getSkillName() + ", ");
            }
            else{
                System.out.println(this.getSkills().get(i).getSkillName());
            }
        }
        System.out.println("Level: " + this.getLevel());
    }
}
