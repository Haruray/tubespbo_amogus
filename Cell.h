#ifndef CELL_H
#define CELL_H

#include <iostream>
#include "Enemy.h"
using namespace std;

class Cell {
    private:
        string type;
        bool isOccupied;
        Enemy* enemy;
    public:
        //4 sekawan
        Cell();
        Cell(string);
        Cell(const Cell&);
        ~Cell();

        //setter
        void setType(string);
        void setEnemy(Enemy*);
        void setOccypy(bool);

        //getter
        string getType();
        Enemy* getEnemy();

        //boolean
        bool isOccupied();

        //func
        void printSymbol(); //print symbol sesuai peta

};

#endif