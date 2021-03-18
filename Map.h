#ifndef MAP_H
#define MAP_H

#include <iostream>
#include "Cell.h"
#include "Player.h"
using namespace std;

class Map{
    private:
        Cell* cells;
        int size; //ukuran map adalah size x size ; posisi berdasarkan ukuran array cells (contoh : cells[x][y])
    public:
        Map();
        Map(int);
        Map(const Map&);
        ~Map();

        //setter
        void setSize();
        void setCell(Cell, int , int); //set sebuah cell di posisi x dan y

        void generateMap(); //Maksudnya adalah memasukkan cell ke cells, ini bisa didesain map nya gmn, atau random generated, belum aku putusin

        //getter
        Cell getCell(int, int); //get cell berdasarkan posisi

        //function
        void printMap(Player); //ngeprint map. Karena player belum terdata di cell, maka akan dijadikan argumen saja
};

#endif