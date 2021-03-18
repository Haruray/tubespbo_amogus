#ifndef ENEMY_H
#define ENEMY_H

#include <iostream>
#include "Player.h"
#include "Engimon.h"
using namespace std;

class Enemy : public Engimon{
    protected:
        struct Position{
            int x, y;
        } position;
    public:
        //4 sekawan

        //setter
        void setPosX(int);
        void setPosY(int);

        //getter
        int getPosX();
        int getPosY();
        string getLogo(Player); //mendapatkan logo sesuai acive engimon player ; refer ke spek poin 6
        //movement
        void moveUp();
        void moveLeft();
        void moveRight();
        void moveDown();
        void randomMove(); //fungsi random buat ingame nanti ; menentukan apakah dia bakal moveup atau movedown dst


};

#endif