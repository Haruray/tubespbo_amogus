package willywangkyjava;

import java.util.*;

import javax.lang.model.element.Element;

public class Enemy extends Engimon{
    int posX;
    int posY;

    Enemy(String name, Engimon p1, Engimon p2, Species species, List<Skill> skills, List<willywangkyjava.Element> elements, int level, int explimit, int x, int y){
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

    }
}
