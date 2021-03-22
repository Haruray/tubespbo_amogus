#ifndef MAP_H
#define MAP_H

#include <iostream>
#include "Cell.h"
#include "Player.h"
using namespace std;

class Map{
    //ku pikir mapnya kan ga pernah ganti ukuran dan kayaknya ga ada kasus dimana mesti copy map, jadi ku komen ctor sama cctornya
    // size jadi const juga, set size dikomen juga. Kalo mau diganti gpp
    private:
        const int size = 10; //ukuran map adalah size x size ; posisi berdasarkan ukuran array cells (contoh : cells[x][y])
        Cell cells[10][10];
    public:
        Map();
        // Map(int);
        // Map(const Map&);
        ~Map();

        //setter
        // void setSize();
        void setCell(Cell, int , int); //set sebuah cell di posisi x dan y

        void generateMap(); //Maksudnya adalah memasukkan cell ke cells, ini bisa didesain map nya gmn, atau random generated, belum aku putusin

        //getter
        Cell getCell(int, int); //get cell berdasarkan posisi

        //function
        void printMap(Player); //ngeprint map. Karena player belum terdata di cell, maka akan dijadikan argumen saja
};

#endif