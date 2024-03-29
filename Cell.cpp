#include "Cell.h"
#include <iostream>
int MINLEVEL = 3;
Cell::Cell(){
    this->type = "Grassland";
    this->Occupied = false;
    this->enemy = nullptr;
}
Cell::Cell(string type){
    this->type = type;
    this->Occupied = false;
    this->enemy = nullptr;
}
Cell::Cell(const Cell& cell){
    this->type = cell.type;
    this->Occupied = cell.Occupied;
    this->enemy = nullptr;
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
    if (enemy != nullptr){
        this->setOccupy(true);
    }
    else{
        this->setOccupy(false);
    }
    
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
void Cell::printElement(){
    vector<Element> elemen = this->enemy->getElements();
        if (elemen.size() == 1){
            if (elemen[0].getElementName() == "Water")
                if (this->enemy->getLevel() > MINLEVEL){
                    cout << " W |"; 
                }
                else{
                    cout << " w |";
                }
            if (elemen[0].getElementName() == "Ice")
                if (this->enemy->getLevel() > MINLEVEL){
                    cout << " I |"; 
                }
                else{
                    cout << " i |";
                }
            if (elemen[0].getElementName() == "Fire")
                if (this->enemy->getLevel() > MINLEVEL){
                    cout << " F |"; 
                }
                else{
                    cout << " f |";
                }
            if (elemen[0].getElementName() == "Ground")
                if (this->enemy->getLevel() > MINLEVEL){
                    cout << " G |"; 
                }
                else{
                    cout << " g |";
                }
            if (elemen[0].getElementName() == "Electric")
                if (this->enemy->getLevel() > MINLEVEL){
                    cout << " E |"; 
                }
                else{
                    cout << " e |";
                }
        }
        else{
            if (elemen[0].getElementName() == "Fire" && elemen[1].getElementName() == "Electric")
                if (this->enemy->getLevel() > MINLEVEL){
                    cout << " L |"; 
                }
                else{
                    cout << " l |";
                }
            else if (elemen[0].getElementName() == "Water" && elemen[1].getElementName() == "Ice")
                if (this->enemy->getLevel() > MINLEVEL){
                    cout << " S |"; 
                }
                else{
                    cout << " s |";
                }
            else if (elemen[0].getElementName() == "Water" && elemen[1].getElementName() == "Ground")
                if (this->enemy->getLevel() > MINLEVEL){
                    cout << " N |"; 
                }
                else{
                    cout << " n |";
                }
            //Symbol selain spek : dua huruf digabung. idk if this a good idea, need testing
            else
                cout << elemen[0].getElementName()[0] << elemen[1].getElementName()[0]<<" |";
        }
}
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
        cout << " P |";
        break;
    case 2:
        cout << " X |";
        break;
    case 3:
        printElement();
        break;
    case 4:
        if (this->type == "Grassland")
            cout << " - |";
        else
            cout << " o |";
        break;
    default:
        throw CellException();
        break;
    }

};

/*
void Cell::generateEnemy(){
    int x = rand() % 100;
    if (this->getType() == "Grassland"){
        if (x < 20){
            // gegara new keknya, jadi multi definisi
            this->enemy = new Enemy(Dio);
        }
        else if (x < 40){
            this->enemy = new Enemy(Raool);
        }
        else if (x < 60){
            this->enemy = new Enemy(Raoq);
        }
        else if (x < 80){
            this->enemy = new Enemy(Hilarious);
        }
        else if (x < 100){
            this->enemy = new Enemy(Valentine);
        }

    }
    else{
        if (x < 30){
            this->enemy = new Enemy(JackFrost);
        }
        else if (x < 60){
            this->enemy = new Enemy(Waluigi);
        }
        else if (x < 90){
            this->enemy = new Enemy(Mio);
        }
        else if (x < 100){
            this->enemy = new Enemy(Gaybon);
        }

    }
    this->setOccupy(true);
};
*/

