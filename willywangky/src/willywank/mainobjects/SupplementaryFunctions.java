package willywank.mainobjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import willywank.mainobjects.Enemy;
import willywank.mainobjects.EngimonUniverse;

public class SupplementaryFunctions {
    public static float getHighestAdvantage(List<Element> le1, List<Element> le2){
        float max = 0;
        for (int i = 0; i < le1.size() ; i++){
            for (int j = 0 ; j < le2.size() ; j++){
                if (le1.get(i).elementAdvantage(le2.get(j)) > max){
                    max = le1.get(i).elementAdvantage(le2.get(j));
                }
            }
        }
        return max;
    }

    public static float sumSkillLevelAndPower(List<Skill> ls){
        int sum = 0;
        for (int i = 0 ; i < ls.size() ; i++){
            sum += ls.get(i).getBasePower() * ls.get(i).getMasteryLevel();
        }
        return (float) sum;
    }

    public static boolean battle(Engimon ourEngimon, Enemy enemyEngimon){
        float ourPower = ourEngimon.getLevel() * getHighestAdvantage(ourEngimon.getElements() , enemyEngimon.getElements()) + sumSkillLevelAndPower(ourEngimon.getSkills());
        float enemyPower = enemyEngimon.getLevel() * getHighestAdvantage(enemyEngimon.getElements() , ourEngimon.getElements()) + sumSkillLevelAndPower(enemyEngimon.getSkills());
        return ourPower >= enemyPower;
    }

    public static void playerMove(Player p, Map map, String input){
        if (input.equals("w")){
            if (p.getPosX()-1 >= 0){
                if (!map.getCell(p.getPosX()-1, p.getPosY()).isOccupied()){ //tidak boleh tabrakan dengan enemy lain
                    p.moveUp();
                }
            }
        }
        else if (input.equals("a")){
            if (p.getPosY()-1 >= 0){
                if (!map.getCell(p.getPosX(), p.getPosY()-1).isOccupied()){
                    p.moveLeft();
                }

            }
        }
        else if (input.equals("s")){
            if (p.getPosX()+1 < map.size){
                if (!map.getCell(p.getPosX()+1, p.getPosY()).isOccupied()){
                    p.moveDown();
                }
            }
        }
        else if (input.equals("d")){
            if (p.getPosY()+1 < map.size){
                if (!map.getCell(p.getPosX(), p.getPosY()+1).isOccupied()){
                    p.moveRight();
                }

            }
        }
    }

    public static List<Enemy> checkEnemiesOnAdjacentTiles(Map map, int x, int y){
        List<Enemy> enemies = new ArrayList<Enemy>();
        //enemy di atas bawah kiri kanan diagonal
        if (x < 9 && map.getCell(x+1,y)!=null){
            if (map.getCell(x+1,y).isOccupied()){
                enemies.add(map.getCell(x+1,y).getEnemy());
            }
        }
        if (y < 9 && map.getCell(x,y+1)!=null){
            if (map.getCell(x,y+1).isOccupied()){
                enemies.add(map.getCell(x,y+1).getEnemy());
            }
        }
        if (x > 0 && map.getCell(x-1,y)!=null){
            if (map.getCell(x-1,y).isOccupied()){
                enemies.add(map.getCell(x-1,y).getEnemy());
            }
        }
        if (y > 0 && map.getCell(x,y-1)!=null){
            if (map.getCell(x,y-1).isOccupied()){
                enemies.add(map.getCell(x,y-1).getEnemy());
            }
        }
        
        return enemies;
    }

    //Cell movement checking
    public static Boolean cellAreaTypeCheck(Enemy e,int x, int y, Player p){
        //koordinat harus valid, cell tipe harus sesuai dengan elemen enemy, dan tidak boleh tabrakan dengan player dan engimonnya
        if (x >= 0 && x < EngimonUniverse.mapsize && y>=0 && y < EngimonUniverse.mapsize) {
            Cell c = EngimonUniverse.map.getCell(x,y);
            if (c.getType() == "Grassland"){
                return (e.isElement(EngimonUniverse.Fire) || e.isElement(EngimonUniverse.Ground) || e.isElement(EngimonUniverse.Electric)) && p.getPosX() != x && p.getPosY() != y && p.ActiveX() != x && p.ActiveY() != y && !c.isOccupied();
            }
            else{
                return (e.isElement(EngimonUniverse.Water) || e.isElement(EngimonUniverse.Ice)) && p.getPosX() != x && p.getPosY() != y && p.ActiveX() != x && p.ActiveY() != y && !c.isOccupied();
            }
        }
        else{
            return false;
        }
        
    }

    //Enemy movement
    public static void enemyRandomMove(Enemy e, Player p){
        Boolean valid = false;
        Random rand = new Random();
        int x;
        while (!valid){
            x = rand.nextInt(5);
            switch (x)
            {
            case 0:
                if (cellAreaTypeCheck(e, e.getPosX()-1,e.getPosY(), p) && e.getPosX()-1 > 0){
                    EngimonUniverse.map.getCell(e.getPosX(),e.getPosY()).setEnemy(null);
                    EngimonUniverse.map.getCell(e.getPosX(),e.getPosY()).setOccupy(false);
                    e.moveUp();
                    valid = true;
                }
                break;
            case 1:
                if (cellAreaTypeCheck(e, e.getPosX()+1,e.getPosY(), p) && e.getPosX()+1 < EngimonUniverse.mapsize){
                    EngimonUniverse.map.getCell(e.getPosX(),e.getPosY()).setEnemy(null);
                    EngimonUniverse.map.getCell(e.getPosX(),e.getPosY()).setOccupy(false);
                    e.moveDown();
                    valid = true;
                }
                break;
            case 2:
                if (cellAreaTypeCheck(e, e.getPosX(),e.getPosY()+1, p) && e.getPosY()+1 < EngimonUniverse.mapsize){
                    EngimonUniverse.map.getCell(e.getPosX(),e.getPosY()).setEnemy(null);
                    EngimonUniverse.map.getCell(e.getPosX(),e.getPosY()).setOccupy(false);
                    e.moveRight();
                    valid = true;
                }
                break;
            case 3:
                if (cellAreaTypeCheck(e, e.getPosX(),e.getPosY()-1, p) && e.getPosY()-1 > 0){
                    EngimonUniverse.map.getCell(e.getPosX(),e.getPosY()).setEnemy(null);
                    EngimonUniverse.map.getCell(e.getPosX(),e.getPosY()).setOccupy(false);
                    e.moveLeft();
                    valid = true;
                }
                break;
            case 4:
                valid = true;
                break;
            default:
                valid = true;
                break;
            }
        }
        
    }

    public static void deleteEnemy(Map map, Enemy e, List<Boolean> enemyReserved) {
        map.getCell(e.getPosX(),e.getPosY()).setEnemy(null);
        map.getCell(e.getPosX(),e.getPosY()).setOccupy(false);
        for (int i = 0 ; i < enemyReserved.size() ; i++){
            if (EngimonUniverse.enemies.get(i).getId() == e.getId()) {
                enemyReserved.set(i, false);
            }
        }
    }

    public static Boolean cellRandomizer (Cell c, List<Enemy> e, List<Boolean> reserved) {
        Random rand = new Random();
        int limit = 0;
        Boolean valid = false;
        int x;
        while (!valid && limit < e.size() * 10) {
            x = rand.nextInt(e.size());
            if (c.getType() == "Grassland") {
                if (e.get(x).isElement(EngimonUniverse.Fire) || e.get(x).isElement(EngimonUniverse.Ground) || e.get(x).isElement(EngimonUniverse.Electric) && reserved.get(x) == false) {
                    valid = true;
                    c.setEnemy(e.get(x));
                    c.setOccupy(true);
                    reserved.set(x, true);
                }
            } else {
                if (e.get(x).isElement(EngimonUniverse.Water) || e.get(x).isElement(EngimonUniverse.Water) && reserved.get(x) == false) {
                    valid = true;
                    c.setEnemy(e.get(x));
                    c.setOccupy(true);
                    reserved.set(x, true);
                }
            }
            limit++;
        }
        if (valid) return true;
        else return false;
    }

    public static void mapRandomizer(Map m, List<Boolean> enemyReserved) {
        Random rand = new Random();
        for (int i = 0; i < EngimonUniverse.enemies.size(); i++) {
            enemyReserved.add(false);
        }

        int limit = 0;
        while (limit < EngimonUniverse.enemies.size()) {
            int randX = rand.nextInt(m.size);
            int randY = rand.nextInt(m.size);
            Cell curr = m.getCell(randX, randY);
            if (!curr.isOccupied()) {
                if (cellRandomizer(curr, EngimonUniverse.enemies, enemyReserved)) {
                    m.cells[randX][randY].enemy.setPosX(randX);
                    m.cells[randX][randY].enemy.setPosY(randY);
                }
                limit++;
            }
        }
    }
}
