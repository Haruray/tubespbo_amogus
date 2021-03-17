#ifndef PLAYER_H
#define PLAYER_H

#include <iostream>
#include "Engimon.h"
#include "Inventory.h"

using namespace std;

class Player{
    protected:
        string playerName;
        Inventory<Skill> skillList;
        Inventory<Engimon> engimonList;
        Engimon activeEngimon;
        struct Position{
            int x, y;
        } position;

    public:
        Player(); //ctor
        Player(string, Inventory<Skill>, Inventory<Engimon>, Engimon, int, int); //ctor with arguments
        Player(const Player&); //cctor
        ~Player();

        //setter
        void setPlayerName(string);
        void setInventorySkill(Inventory<Skill>);
        void setInventoryEngimon(Inventory<Engimon>);
        void setActiveEngimon(Engimon);
        void setPosition(int,int);

        //getter
        string getPlayerName();
        Inventory<Skill> getInventorySkill();
        Inventory<Engimon> getInventoryEngimon();
        Engimon getActiveEngimon();
        int getPosX();
        int getPosY();

        //functions
        void moveUp();
        void moveLeft();
        void moveRight();
        void moveDown();

        void showEngimonList();
        void showEngimonData(Engimon);

        void showSkillList();
        void useSkillItem(Skill, Engimon*);
        void breeding(Engimon*, Engimon*);

        void interactWithActiveEngimon();
};

#endif