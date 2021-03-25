#include "Map.h"
#include <iostream>
#include <stdlib.h>

Map::Map(){
    this->cells.resize(10, vector<Cell*>(10));
};
Map::~Map(){
};

//setter

void Map::setCell(Cell* C, int x, int y){
    this->cells[x][y] = C;
}; //set sebuah cell di posisi x dan y

void Map::generateMap(vector<Cell>* vsea, vector<Cell>* vgrass){
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
    int vseaint = 0;
    int vgrassint = 0;
    for (int i = 0; i < this->size; i++)
    {
        for (int j = 0; j < this->size; j++)
        {
            if (i <= 2 || i >= 8 || j <= 2 || j >= 8){
                this->cells[i][j] = &vsea->at(vseaint);
                vseaint++;
            }
            else{
                this->cells[i][j] = &vgrass->at(vgrassint);
                vgrassint++;
            }
        }
        
    }
    
}; //Maksudnya adalah memasukkan cell ke cells, ini bisa didesain map nya gmn, atau random generated, belum aku putusin

//getter
Cell* Map::getCell(int x, int y){
    if (x>=0 || x<10 && (y>=0 && y<10))
        return cells[x][y];
    else
        return nullptr;
}; //get cell berdasarkan posisi

//function
void Map::printMap(Player* P){
    for (int i = 0; i < this->size; i++)
    {
        for (int j = 0; j < this->size; j++)
        {
            Cell* curr = this->cells[i][j];
            if (P->getPosX() == i && P->getPosY() == j){
                    curr->printSymbol(1);
            }
            else if (P->ActiveX() == i && P->ActiveY() == j){
                    curr->printSymbol(2);
            }
            else if (curr->isOccupied()){
                if (curr->getEnemy()->getPosX() == i && curr->getEnemy()->getPosY() == j){
                    curr->printSymbol(3);
                }
            }
            else{
                curr->printSymbol(4);
            }
        }
        cout<<"\n";
    }
    
};