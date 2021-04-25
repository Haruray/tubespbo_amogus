package willywank.mainobjects;

import java.util.List;

public class SupplementaryFunctions {
    public float getHighestAdvantage(List<Element> le1, List<Element> le2){
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

    public float sumSkillLevelAndPower(List<Skill> ls){
        int sum = 0;
        for (int i = 0 ; i < ls.size() ; i++){
            sum += ls.get(i).getBasePower() * ls.get(i).getMasteryLevel();
        }
        return (float) sum;
    }

    public boolean battle(Engimon ourEngimon, Enemy enemyEngimon){
        float ourPower = ourEngimon.getLevel() * getHighestAdvantage(ourEngimon.getElements() , enemyEngimon.getElements()) + sumSkillLevelAndPower(ourEngimon.getSkills());
        float enemyPower = enemyEngimon.getLevel() * getHighestAdvantage(enemyEngimon.getElements() , ourEngimon.getElements()) + sumSkillLevelAndPower(enemyEngimon.getSkills());
        return ourPower >= enemyPower;
    }

    void playerMove(Player p, Map map, String input){
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
}
