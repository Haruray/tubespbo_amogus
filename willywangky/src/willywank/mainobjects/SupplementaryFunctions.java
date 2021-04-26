package willywank.mainobjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import willywank.Controller;
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
        //enemy di bawah kanan atas kiri
        if (x < map.size-1 && map.getCell(x+1,y)!=null){
            if (map.getCell(x+1,y).isOccupied()){
                enemies.add(map.getCell(x+1,y).getEnemy());
            }
            else{
                enemies.add(new Enemy());
            }
        }
        else{
            enemies.add(new Enemy());
        }
        if (y < map.size-1 && map.getCell(x,y+1)!=null){
            if (map.getCell(x,y+1).isOccupied()){
                enemies.add(map.getCell(x,y+1).getEnemy());
            }
            else{
                enemies.add(new Enemy());
            }
        }
        else{
            enemies.add(new Enemy());
        }
        if (x > 0 && map.getCell(x-1,y)!=null){
            if (map.getCell(x-1,y).isOccupied()){
                enemies.add(map.getCell(x-1,y).getEnemy());
            }
            else{
                enemies.add(new Enemy());
            }
        }
        else{
            enemies.add(new Enemy());
        }
        if (y > 0 && map.getCell(x,y-1)!=null){
            if (map.getCell(x,y-1).isOccupied()){
                enemies.add(map.getCell(x,y-1).getEnemy());
            }
            else{
                enemies.add(new Enemy());
            }
        }
        else{
            enemies.add(new Enemy());
        }
        
        return enemies;
    }

    //Cell movement checking
    public static Boolean cellAreaTypeCheck(Enemy e,int x, int y, Player p, Map map){
        //koordinat harus valid, cell tipe harus sesuai dengan elemen enemy, dan tidak boleh tabrakan dengan player dan engimonnya
        if (x >= 0 && x < map.size && y>=0 && y < map.size) {
            Cell c = map.getCell(x,y);
            if (c.getType() == "Mountains"){
                return e.isElement(EngimonUniverse.Fire) && p.getPosX() != x && p.getPosY() != y && p.ActiveX() != x && p.ActiveY() != y && !c.isOccupied();
            }
            else if (c.getType() == "Sea"){
                return e.isElement(EngimonUniverse.Water) && p.getPosX() != x && p.getPosY() != y && p.ActiveX() != x && p.ActiveY() != y && !c.isOccupied();
            }
            else if (c.getType() == "Grassland"){
                return (e.isElement(EngimonUniverse.Ground) || e.isElement(EngimonUniverse.Electric)) && p.getPosX() != x && p.getPosY() != y && p.ActiveX() != x && p.ActiveY() != y && !c.isOccupied();
            }
            else{
                return e.isElement(EngimonUniverse.Ice) && p.getPosX() != x && p.getPosY() != y && p.ActiveX() != x && p.ActiveY() != y && !c.isOccupied();
            }
        }
        else{
            return false;
        }
        
    }

    //Enemy movement
    public static void enemyRandomMove(Enemy e, Player p, Map m){
        Boolean valid = false;
        Random rand = new Random();
        int x;
        while (!valid){
            x = rand.nextInt(5);
            switch (x)
            {
            case 0:
                if (cellAreaTypeCheck(e, e.getPosX()-1,e.getPosY(), p, m) && e.getPosX()-1 > 0){
                    m.getCell(e.getPosX(),e.getPosY()).setEnemy(null);
                    m.getCell(e.getPosX(),e.getPosY()).setOccupy(false);
                    e.moveUp();
                    valid = true;
                }
                break;
            case 1:
                if (cellAreaTypeCheck(e, e.getPosX()+1,e.getPosY(), p, m) && e.getPosX()+1 < m.size){
                    m.getCell(e.getPosX(),e.getPosY()).setEnemy(null);
                    m.getCell(e.getPosX(),e.getPosY()).setOccupy(false);
                    e.moveDown();
                    valid = true;
                }
                break;
            case 2:
                if (cellAreaTypeCheck(e, e.getPosX(),e.getPosY()+1, p, m) && e.getPosY()+1 < m.size){
                    m.getCell(e.getPosX(),e.getPosY()).setEnemy(null);
                    m.getCell(e.getPosX(),e.getPosY()).setOccupy(false);
                    e.moveRight();
                    valid = true;
                }
                break;
            case 3:
                if (cellAreaTypeCheck(e, e.getPosX(),e.getPosY()-1, p, m) && e.getPosY()-1 > 0){
                    m.getCell(e.getPosX(),e.getPosY()).setEnemy(null);
                    m.getCell(e.getPosX(),e.getPosY()).setOccupy(false);
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
            if (c.getType().equals("Mountains") ) {
                if (e.get(x).isElement(EngimonUniverse.Fire) && reserved.get(x) == false) {
                    valid = true;
                    c.setEnemy(e.get(x));
                    c.setOccupy(true);
                    reserved.set(x, true);
                }
            }
            if (c.getType().equals("Sea")) {
                if (e.get(x).isElement(EngimonUniverse.Water) && reserved.get(x) == false) {
                    valid = true;
                    c.setEnemy(e.get(x));
                    c.setOccupy(true);
                    reserved.set(x, true);
                }
            }
            if (c.getType().equals("Grassland")) {
                if ((e.get(x).isElement(EngimonUniverse.Ground) || e.get(x).isElement(EngimonUniverse.Electric)) && reserved.get(x) == false) {
                    valid = true;
                    c.setEnemy(e.get(x));
                    c.setOccupy(true);
                    reserved.set(x, true);
                }
            }
            if (c.getType().equals("Tundra")) {
                if (e.get(x).isElement(EngimonUniverse.Ice) && reserved.get(x) == false) {
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

    public static void mapRandomizer(Player p,Map m, List<Boolean> enemyReserved) {
        setEnemies(p, m);
        Random rand = new Random();
        for (int i = 0; i < EngimonUniverse.enemies.size(); i++) {
            if (enemyReserved.size() <= i){
                enemyReserved.add(false);
            }
        }

        int limit = 0;
        while (limit < EngimonUniverse.enemies.size()) {
            int randX = rand.nextInt(m.size);
            int randY = rand.nextInt(m.size);
            while ((randX==p.getPosX() && randY==p.getPosY() )|| (randX== p.ActiveX() && randY== p.ActiveY())){
                randX=rand.nextInt(m.size);
                randY = rand.nextInt(m.size);
            }
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

    public static void setEnemies(Player p, Map m){
        //jumlah enemy adalah 1/5 dari luas map
        //awalnya sih gitu, tapi dibuat periodik ae, jadi setiap generate nambah 1/20 musuh
        Random rand = new Random();
        int totalEnemy = (m.size*m.size)/20;
        int randomChoice;
        for (int i = 0 ; i < totalEnemy ; i++){
            randomChoice = rand.nextInt(EngimonUniverse.singleElementSpecies.size());
            Species s = EngimonUniverse.singleElementSpecies.get(randomChoice);
            List<Skill> ls = new ArrayList<>();
            ls.add(s.getUniqueSkill());
            EngimonUniverse.enemies.add(new Enemy(s.getSpeciesName(), null, null, s, ls, s.getUniqueSkill().getElmtReq(), p.getActiveEngimon().getLevel()+rand.nextInt(2), 100000, 0, 0));
            ls.clear();
        }
    }

    public static void winReward(Player p, Enemy e){
        System.out.println("You won!!");
        System.out.println("Rewards\t:");

        Engimon reward = new Engimon(e.getName(),e.getParents().get(0), e.getParents().get(1), e.getSpecies(), e.getSkills(), e.getElements(), e.getLevel(), e.getCumExpLimit());
        Skill rewardSkill = new Skill(e.getSpecies().getUniqueSkill());
        try {
            p.getInventoryEngimon().addItem(reward);
            p.getInventorySkill().addItem(rewardSkill);
            System.out.println("- New Engimon!! "+ reward.getName() +", a " + reward.getSpecies().getSpeciesName());
            System.out.println("- New Skill item!! " + e.getSkills().get(0).getSkillName());
        } catch (Exception ex) {
            ex.printStackTrace();
            //TODO: handle exception
        }
        float ourPower = p.getActiveEngimon().getLevel() * getHighestAdvantage(p.getActiveEngimon().getElements() , e.getElements()) + sumSkillLevelAndPower(p.getActiveEngimon().getSkills());
        float enemyPower = p.getActiveEngimon().getLevel() * getHighestAdvantage(e.getElements() , p.getActiveEngimon().getElements()) + sumSkillLevelAndPower(e.getSkills());
        int expGained = (int)(((ourPower - enemyPower) / ourPower)*100);
        p.getActiveEngimon().addExp((200+expGained)*2);
        deleteEnemy(Controller.m, e, EngimonUniverse.enemyReserved);
        // aku ga ketemu array enemies, mungkin bsia bantu
        // for (int i = 0 ; i < enemies.size() ; i++){
        //     enemies[i].addExp(400);
        // }
    }
}
