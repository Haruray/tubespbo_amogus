#ifndef CELL_H
#define CELL_H

#include <iostream>
#include "Enemy.h"
using namespace std;

class Cell {
    private:
        string type;
        bool Occupied;
        Enemy* enemy;
    public:
        //4 sekawan
        Cell();
        Cell(string);
        Cell(const Cell&);
        ~Cell();
        Cell& operator=(const Cell&);

        //setter
        void setType(string);
        void setEnemy(Enemy*);
        void setOccupy(bool);

        //getter
        string getType();
        Enemy* getEnemy();

        //boolean
        bool isOccupied();

        //func
        void printSymbol(int); //print symbol sesuai peta
        // void generateEnemy(); // buat bikin enemy random di sel ini
};


class CellException: public exception{
    const char* what() const throw(){
        return "Invalid Input";
    }
};

#endif