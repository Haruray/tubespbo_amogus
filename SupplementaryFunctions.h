#ifndef SUPPLEMENTARYFUNCTION_H
#define SUPPLEMENTARYFUNCTION_H
#include <iostream>
#include "EngimonUniverse.h"

//BATTLE FUNCTION
float getHighestAdvantage(vector<Element> ve1, vector<Element> ve2){
    float max = 0;
    for (int i = 0; i < ve1.size() ; i++){
        for (int j = 0 ; j < ve2.size() ; j++){
            if (ve1[i].elementAdvantage(ve2[j]) > max){
                max = ve1[i].elementAdvantage(ve2[j]);
            }
        }
    }
    return max;
}

float sumSkillLevelAndPower(vector<Skill> vs){
    int sum = 0;
    for (int i = 0 ; i < vs.size() ; i++){
        sum += vs[i].getBasePower() * vs[i].getMasteryLevel();
    }
    return float(sum);
}

bool battle(Engimon ourEngimon, Engimon enemyEngimon){
    float ourPower = ourEngimon.getLevel() * getHighestAdvantage(ourEngimon.getElements() , enemyEngimon.getElements()) + sumSkillLevelAndPower(ourEngimon.getSkills());
    float enemyPower = enemyEngimon.getLevel() * getHighestAdvantage(enemyEngimon.getElements() , ourEngimon.getElements()) + sumSkillLevelAndPower(enemyEngimon.getSkills());
    cout<<"Player Engimon's Power Level\t: "<<fixed<<setprecision(2)<<ourPower<<endl;
    cout<<"Enemy Engimon's Power Level\t: "<<fixed<<setprecision(2)<<enemyPower<<endl;
    return ourPower > enemyPower;
}

//Cell movement checking
bool cellAreaTypeCheck(Enemy* e,int x, int y){
    if (x >= 0 && x < mapsize && y>=0 && y<mapsize){
        Cell* c = map.getCell(x,y);
        if (c->getType() == "Grassland"){
            return e->isElement(Fire) || e->isElement(Ground) || e->isElement(Electric);
        }
        else{
            return e->isElement(Water) || e->isElement(Ice);
        }
    }
    else{
        return false;
    }
    
}
//Enemy movement
void enemyRandomMove(Enemy* e){
    bool valid = false;
    int x;
    while (!valid){
        x = rand() % 4;
        switch (x)
        {
        case 0:
            if (cellAreaTypeCheck(e, e->getPosX(),e->getPosY()-1) && e->getPosY()-1 > 0){
                map.getCell(e->getPosX(),e->getPosY())->setEnemy(nullptr);
                map.getCell(e->getPosX(),e->getPosY())->setOccupy(false);
                e->moveUp();
                valid = true;
            }
            break;
        case 1:
            if (cellAreaTypeCheck(e, e->getPosX(),e->getPosY()+1) && e->getPosY()+1 < mapsize){
                map.getCell(e->getPosX(),e->getPosY())->setEnemy(nullptr);
                map.getCell(e->getPosX(),e->getPosY())->setOccupy(false);
                e->moveDown();
                valid = true;
            }
            break;
        case 2:
            if (cellAreaTypeCheck(e, e->getPosX()+1,e->getPosY()) && e->getPosX()+1 < mapsize){
                map.getCell(e->getPosX(),e->getPosY())->setEnemy(nullptr);
                map.getCell(e->getPosX(),e->getPosY())->setOccupy(false);
                e->moveRight();
                valid = true;
            }
            break;
        case 3:
            if (cellAreaTypeCheck(e, e->getPosX()-1,e->getPosY()) && e->getPosX()-1 > 0){
                map.getCell(e->getPosX(),e->getPosY())->setEnemy(nullptr);
                map.getCell(e->getPosX(),e->getPosY())->setOccupy(false);
                e->moveLeft();
                valid = true;
            }
            break;
        default:
            valid=true;
            break;
        }
    }
        
}

#endif