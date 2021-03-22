#include "Cell.h"
#include <iostream>

Cell::Cell(){
    this->type = "Grassland";
    this->Occupied = false;
}
Cell::Cell(string type){
    this->type = type;
    this->Occupied = false;
}
Cell::Cell(const Cell& cell){
    this->type = cell.type;
    this->Occupied = cell.Occupied;
}
Cell::~Cell(){
    
}
Cell& Cell::operator=(const Cell& C){
    this->enemy = C.enemy;
    this->Occupied = C.Occupied;
    this->type = C.type;
    return *this;
}
void Cell::setType(string type){
    this->type = type;
};
void Cell::setEnemy(Enemy* enemy){
    this->enemy = enemy;
};
void Cell::setOccupy(bool occ){
    this->Occupied = occ;
};

//getter
string Cell::getType(){
    return this->type;
};
Enemy* Cell::getEnemy(){
    return this->enemy;
};

//boolean
bool Cell::isOccupied(){
    return this->Occupied;
};

//func
void Cell::printSymbol(int var){
    // 1: player
    // 2: active engimon
    // 3: wild engimon
    // 4: kosong
    vector<Element> elemen;
    switch (var)
    {
    case 1:
        cout << "P";
        break;
    case 2:
        cout << "X";
        break;
    case 3:
        elemen = this->enemy->getElements();
        if (elemen.size() == 1){
            if (elemen[0].getElementName() == "Water")
                cout << "W";
            if (elemen[0].getElementName() == "Ice")
                cout << "I";
            if (elemen[0].getElementName() == "Fire")
                cout << "F";
            if (elemen[0].getElementName() == "Ground")
                cout << "G";
            if (elemen[0].getElementName() == "Electric")
                cout << "E";
        }
        else{
            if (elemen[0].getElementName() == "Fire" && elemen[1].getElementName() == "Electric")
                cout << "L";
            else if (elemen[0].getElementName() == "Water" && elemen[1].getElementName() == "Ice")
                cout << "S";
            else if (elemen[0].getElementName() == "Water" && elemen[1].getElementName() == "Ground")
                cout << "N";
            //Symbol selain spek : dua huruf digabung. idk if this a good idea, need testing
            else
                cout << elemen[0].getElementName()[0] << elemen[1].getElementName()[0];
        }
        
        break;
    case 4:
        if (this->type == "Grassland")
            cout << "-";
        else
            cout << "o";
        break;
    default:
        throw CellException();
        break;
    }

};

