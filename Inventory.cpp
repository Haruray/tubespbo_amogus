#include "Inventory.h"

template<class T>
Inventory<T>::Inventory(){
    this->setMaxCap(0);
}

template<class T>
Inventory<T>::Inventory(int maxcap){
    this->setMaxCap(maxcap);
}

//Engimon items
Inventory<Engimon>::Inventory(){
    this->setMaxCap(0);
}

Inventory<Engimon>::Inventory(int maxcap){
    this->setMaxCap(maxcap);
}

Inventory<Engimon>::Inventory(const Inventory& i){
    this->setMaxCap(i.maxCapacity);
    for (int j=0 ; j<i.items.size(); j++){
        this->addItem(i.items[j]);
    }
}

Inventory<Engimon>::~Inventory(){}

void Inventory<Engimon>::addItem(Engimon e){
    this->items.push_back(e);
}

void Inventory<Engimon>::setMaxCap(int max){
    this->maxCapacity = max;
}

Engimon Inventory<Engimon>::getItemByName(string name){
    for (int i=0 ; i<this->items.size(); i++){
        if (name == this->items[i].getName())
            return this->items[i];
    }
    return Engimon();
}

Engimon Inventory<Engimon>::getItemById(int id){
    for (int i=0 ; i<this->items.size(); i++){
        if (id == this->items[i].getId())
            return this->items[i];
    }
    return Engimon();
}

void Inventory<Engimon>::printItems(){
    for (int i=0 ; i<this->items.size(); i++){
        cout<<this->items[i].getName()<<endl;
    }
}

bool Inventory<Engimon>::doesItemExist(Engimon e){
    for (int i=0 ; this->items.size() ; i++){
        if (this->items[i].getId() == e.getId()){
            return true;
        }
    }
    return false;
}


//Skill specialization

Inventory<Skill>::Inventory(){
    this->setMaxCap(0);
}

Inventory<Skill>::Inventory(int maxcap){
    this->setMaxCap(maxcap);
}

Inventory<Skill>::Inventory(const Inventory& i){
    this->setMaxCap(i.maxCapacity);
    for (int j=0 ; j<i.items.size(); j++){
        this->addItem(i.items[j]);
    }
}

Inventory<Skill>::~Inventory(){}

void Inventory<Skill>::addItem(Skill e){
    //Search existing item
    Skill search = this->getItemByName(e.getSkillName());
    if (search.getSkillName()!="None"){//ketemu
        int idx = this->getItemIdx(search);
        this->itemQty[idx] += 1;
    }
    else{ //tidak ketemu, maka add baru
        this->items.push_back(e);
        this->itemQty.push_back(1);
    }
}

void Inventory<Skill>::setMaxCap(int max){
    this->maxCapacity = max;
}

Skill Inventory<Skill>::getItemByName(string name){
    for (int i=0 ; i<this->items.size(); i++){
        if (name == this->items[i].getSkillName())
            return this->items[i];
    }
    return Skill();
}

void Inventory<Skill>::printItems(){
    for (int i=0 ; i<this->items.size(); i++){
        cout<<this->items[i].getSkillName()<<" ("<<this->itemQty[i]<<")"<<endl;
    }
}

bool Inventory<Skill>::doesItemExist(Skill s){
    for (int i=0 ; this->items.size() ; i++){
        if (this->items[i].getSkillName() == s.getSkillName()){
            return true;
        }
    }
    return false;
}
bool Inventory<Skill>::doesItemExist(string s){
    for (int i=0 ; this->items.size() ; i++){
        if (this->items[i].getSkillName() == s){
            return true;
        }
    }
    return false;
}

int Inventory<Skill>::getItemIdx(Skill s){
    for (int i=0 ; i<this->items.size() ; i++){
        if (this->items[i].getSkillName() == s.getSkillName()){
            return i;
        }
    }
    return -1;
}

void Inventory<Skill>::learn(Skill s, Engimon* e){
    bool isEligible; 
    for (int i = 0 ; i < s.getElmtReq().size() ; i++){
        for (int j = 0 ; j < e->getElements().size() ; j++){
            if (e->getElements()[i].getElementName() == s.getElmtReq()[i].getElementName()){ //jika ada yg sama, maka return true
                isEligible = true;
                break; //lanjut cek requirement element selanjutnya
            }
            else{
                isEligible = false;
            }
        }
    }
    if (isEligible){
        e->addSkill(s);
    }
    else{
        //throw exception
    }
}