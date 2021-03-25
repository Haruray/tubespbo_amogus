#ifndef PLAYER_H
#define PLAYER_H

#include <iostream>
#include <algorithm>
#include <utility>
#include "Engimon.h"
#include "Inventory.h"

using namespace std;

class Player{
    protected:
        string playerName;
        Inventory<Skill>* skillList;
        Inventory<Engimon>* engimonList;
        Engimon* activeEngimon;
        struct Position{
            int x, y;
        } position, positionActiveEngimon;

    public:
        Player(); //ctor
        Player(string, Inventory<Skill>*, Inventory<Engimon>*, Engimon*, int, int); //ctor with arguments
        Player(const Player&); //cctor
        ~Player();

        //setter
        void setPlayerName(string);
        void setInventorySkill(Inventory<Skill>*);
        void setInventoryEngimon(Inventory<Engimon>*);
        void setActiveEngimon(Engimon*);
        void setPosition(int,int);
        void setActiveEngPos(int, int);

        //getter
        string getPlayerName();
        Inventory<Skill>* getInventorySkill();
        Inventory<Engimon>* getInventoryEngimon();
        Engimon* getActiveEngimon();
        int getPosX();
        int getPosY();
        int ActiveX();
        int ActiveY();

        //functions
        void moveUp();
        void moveLeft();
        void moveRight();
        void moveDown();
        void ActiveEngimonFollow();

        void showEngimonList();
        void showEngimonData(Engimon);

        void showSkillList();
        void useSkillItem(Skill, Engimon*);
        void skillSelection(Engimon*, Engimon*, vector<Skill>*, vector<Skill>*);
        void breeding(Engimon*, Engimon*, vector<Species*>*);

        void swapActiveEngimon();
        void interactWithActiveEngimon();
};

class BreedParentException: public exception{
    public:
        const char* what() const throw(){
            return "Parent ineligible for breeding";
        }
};

class BreedEngimonException: public exception{
    public:
        const char* what() const throw(){
            return "No such Engimon in Inventory";
        }
};

class EngimonInvException: public exception{
    public:
        const char* what() const throw(){
            return "No such Engimon in Inventory";
        }
};

class UseException: public exception{
    public:
        const char* what() const throw(){
            return "No such Engimon or Skill in Inventory";
        }
};
#endif