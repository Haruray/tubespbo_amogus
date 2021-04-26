package willywank.mainobjects;

import javax.lang.model.element.Element;
import java.util.*;

public class Cell {
    String type;
    boolean occupied;
    Enemy enemy;

    public Cell() {
        this.type = "Grassland";
        this.occupied = false;
        this.enemy = null;
    }
    Cell(String type){
        this.type = type;
        this.occupied = false;
        this.enemy = null;
    }
    void setType(String type){
        this.type = type;
    }
    void setEnemy(Enemy E){
        this.enemy = E;
    }
    void setOccupy(boolean occ){
        this.occupied = occ;
    }

    //getter
    public String getType(){
        return this.type;
    }
    public Enemy getEnemy(){
        return this.enemy;
    }

    //boolean
    public boolean isOccupied(){
        return this.occupied;
    }

    //func
    void printSymbol(int var){
        // ArrayList<Element> elemen;
        switch (var) {
            case 1:
                System.out.print(" P |");
                break;
            case 2:
                System.out.print(" X |");
                break;
            case 3:
                printElement();
                break;
            case 4:
                if (this.type.equals("Mountains")){
                    System.out.print(" ^ |");
                }
                else if (this.type.equals("Sea")){
                    System.out.print(" o |");
                }
                else if (this.type.equals("Grassland")){
                    System.out.print(" - |");
                }
                else{
                    System.out.print(" v |");
                }
                break;
            default:
                // throw exception
                break;
        }
    } //print symbol sesuai peta
    void printElement(){
        List<willywank.mainobjects.Element> elemen = this.enemy.getElements();
        if (elemen.size() == 1){
            if (elemen.get(0).getElementName().equals("Water")){
                if (this.enemy.getLevel() > 3){
                    System.out.print(" W |");
                }
                else{
                    System.out.print(" w |");
                }
            }
            if (elemen.get(0).getElementName().equals("Ice")){
                if (this.enemy.getLevel() > 3){
                    System.out.print(" I |");
                }
                else{
                    System.out.print(" i |");
                }
            }
            if (elemen.get(0).getElementName().equals("Fire")){
                if (this.enemy.getLevel() > 3){
                    System.out.print(" F |");
                }
                else{
                    System.out.print(" f |");
                }
            }
            if (elemen.get(0).getElementName().equals("Ground")){
                if (this.enemy.getLevel() > 3){
                    System.out.print(" G |");
                }
                else{
                    System.out.print(" g |");
                }
            }
            if (elemen.get(0).getElementName().equals("Electric")){
                if (this.enemy.getLevel() > 3){
                    System.out.print(" E |");
                }
                else{
                    System.out.print(" e |");
                }
            }
        }
        else{
            if (elemen.get(0).getElementName().equals("Fire") && elemen.get(1).getElementName().equals("Electric")){
                if (this.enemy.getLevel() > 3){
                    System.out.print(" L |");
                }
                else{
                    System.out.print(" l |");
                }
            }
            if (elemen.get(0).getElementName().equals("Water") && elemen.get(1).getElementName().equals("Ice")){
                if (this.enemy.getLevel() > 3){
                    System.out.print(" S |");
                }
                else{
                    System.out.print(" s |");
                }
            }
            if (elemen.get(0).getElementName().equals("Water") && elemen.get(1).getElementName().equals("Ground")){
                if (this.enemy.getLevel() > 3){
                    System.out.print(" N |");
                }
                else{
                    System.out.print(" n |");
                }
            }
        }
    }
}
