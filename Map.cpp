#include "Map.h"
#include <iostream>

Map::Map(){
    
};
Map::~Map(){
    delete[] cells;
};

//setter

void Map::setCell(Cell C, int x, int y){
    this->cells[x][y] = C;
}; //set sebuah cell di posisi x dan y

void Map::generateMap(){
    // mapnya gini kira kira:
    //
    // o o o o o o o o o o
    // o o o o o o o o o o
    // o o - - - - - - o o
    // o o - - - - - - o o
    // o o - - - - - - o o
    // o o - - - - - - o o
    // o o - - - - - - o o
    // o o - - - - - - o o
    // o o o o o o o o o o
    // o o o o o o o o o o
    //
    // blom fix, ganti gpp
    for (int i = 0; i < this->size; i++)
    {
        for (int j = 0; j < this->size; j++)
        {
            if (i <= 2 || i >= 8 || j <= 2 || j >= 8){
                this->cells[i][j] = Cell("Sea");
            }
            else{
                this->cells[i][j] = Cell("Grassland");
            }
        }
        
    }
    
}; //Maksudnya adalah memasukkan cell ke cells, ini bisa didesain map nya gmn, atau random generated, belum aku putusin

//getter
Cell Map::getCell(int x, int y){
    return cells[x][y];
}; //get cell berdasarkan posisi

//function
void Map::printMap(Player P){
    for (int i = 0; i < this->size; i++)
    {
        for (int j = 0; j < this->size; j++)
        {
            Cell curr = this->cells[i][j];
            if (curr.isOccupied()){
                if (P.getPosX() == i && P.getPosY() == j){
                    curr.printSymbol(1);
                }
                else if (P.ActiveX() == i && P.ActiveY() == j)
                {
                    curr.printSymbol(2);
                }
                else if (curr.getEnemy()->getPosX() == i && curr.getEnemy()->getPosY() == j){
                    curr.printSymbol(3);
                }
            }
            else{
                curr.printSymbol(4);
            }
        }
    }
    
};