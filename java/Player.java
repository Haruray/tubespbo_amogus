package willywangkyjava;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    String playerName;
    Inventory<Skill> skillList = new Inventory<>();
    Inventory<Engimon> engimonList = new Inventory<>();
    Engimon activeEngimon;
    int posX;
    int posY;
    int activeEngimonPosX;
    int activeEngimonPosY;

    Player(String name, Inventory<Skill> is, Inventory<Engimon> ie, Engimon ae, int x, int y){
        this.setPlayerName(name);
        this.setInventorySkill(is);
        this.setInventoryEngimon(ie);
        this.setActiveEngimon(ae);
        this.setPosition(x,y); //starting position nanti bisa dirubah
        this.setActiveEngPos(1, 0);
    }

    void setPlayerName(String name){
        this.playerName=name;
    }
    void setInventorySkill(Inventory<Skill> is){

    }
    void setInventoryEngimon(Inventory<Engimon> ie){

    }
    void setActiveEngimon(Engimon ae){
        this.activeEngimon=ae;
    }
    void setPosition(int x,int y){
        this.posX=x;
        this.posY=y;
    }
    void setActiveEngPos(int x, int y){
        this.activeEngimonPosX=x;
        this.activeEngimonPosY=y;
    }

    String getPlayerName(){
        return this.playerName;
    }
//    Inventory<Skill> getInventorySkill(){
//
//    }
//    Inventory<Engimon> getInventoryEngimon(){
//
//    }
    Engimon getActiveEngimon(){
        return this.activeEngimon;
    }
    int getPosX(){
        return this.posX;
    }
    int getPosY(){
        return this.posY;
    }
    int ActiveX(){
        return this.activeEngimonPosX;
    }
    int ActiveY(){
        return this.activeEngimonPosY;
    }
    void moveUp(){

    }
    void moveLeft(){

    }
    void moveRight(){

    }
    void moveDown(){

    }
    void ActiveEngimonFollow(){

    }

    void showEngimonList(){

    }
    void showEngimonData(Engimon e){

    }

    void showSkillList(){

    }
    void useSkillItem(Skill s, Engimon e){

    }
    void skillSelection(Engimon e1, Engimon e2, List<Skill> newSkill, List<Skill> skillList){

    }
    void breeding(Engimon e1, Engimon e2){

    }

    void swapActiveEngimon(){

    }
    void interactWithActiveEngimon(){

    }

}
