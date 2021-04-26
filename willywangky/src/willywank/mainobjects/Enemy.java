package willywank.mainobjects;

import java.util.List;

public class Enemy extends Engimon {
    int posX;
    int posY;

    public Enemy(){
        super();
        setPosX(0);
        setPosY(0);
    }
    public Enemy(String name, Engimon p1, Engimon p2, Species species, List<Skill> skills, List<Element> elements, int level, int explimit, int x, int y){
        super(name, p1, p2, species, skills, elements, level, explimit);
        setPosX(x);
        setPosY(y);
    }
    public void setPosX(int x){
        this.posX=x;
    }
    public void setPosY(int y){
        this.posY=y;
    }
    public int getPosX(){
        return this.posX;
    }
    public int getPosY(){
        return this.posY;
    }
    String getLogo(Player P){
        return "???";
    } //mendapatkan logo sesuai acive engimon player ; refer ke spek poin 6
    //movement
    public void moveUp(){
        setPosX(getPosX()-1);
    }
    public void moveLeft(){
        setPosY(getPosY()-1);
    }
    public void moveRight(){
        setPosY(getPosY()+1);
    }
    public void moveDown(){
        setPosX(getPosX()+1);
    }
    public void levelUp(){
        this.exp -= 100;
        this.level += 1;
    }
    void printDetail(){

    }
}
