package java;

import java.util.ArrayList;

import javax.lang.model.element.Element;

public class Enemy extends Engimon{
    Point position;

    Enemy(){
        super();
        setPosX(0);
        setPosY(0);
    }
    Enemy(String name, Engimon p1, Engimon p2, Species species, ArrayList<Skill> skills, ArrayList<Element> elements, int level, int explimit, int x, int y){
        super(name, p1, p2, species, skills, elements, level, explimit, x, y);
        setPosX(x);
        setPosY(y);
    }
    void setPosX(int x){
        this.position.setLocation(x, this.position.getY());
    }
    void setPosY(int y){
        this.position.setLocation(this.position.getX(), y);
    }
    int getPosX(){
        return this.position.getX();
    }
    int getPosY(){
        return this.position.getY();
    }
    string getLogo(Player P){
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

    }
}
