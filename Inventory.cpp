#include "Inventory.h"

template<class T>
Inventory<T>::Inventory(){
    this->setMaxCap(0);
}

template<class T>
Inventory<T>::Inventory(int maxcap){
    this->setMaxCap(maxcap);
}

//Engimon specialization
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
    if (this->isFull()==false){
        this->items.push_back(e);
    }
    else{
        //exception : inventory is full
    }
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

bool Inventory<Engimon>::isFull(){
    return this->items.size() >= this->maxCapacity;
}

int Inventory<Engimon>::getItemIdx(Engimon e){
    for (int i=0 ; i<this->items.size();i++){
        if (this->items[i].getName() == e.getName()){
            return i;
        }
    }
    return -1; //not found
}

void Inventory<Engimon>::deleteItem(int id){
    if (this->items.size()>0){
        if (doesItemExist(getItemById(id))){
            deleteItem(getItemById(id));
        }
        else{
            //exception : engimon doesnt exist
        }
    }
    else{
        //exception : inventory kosong
    }
    
}
void Inventory<Engimon>::deleteItem(Engimon e){
    if (this->items.size() > 0){
        if (doesItemExist(e)){
            this->items.erase(this->items.begin() + this->getItemIdx(e));
        }
        else{
            //exception : engimon doesnt exist
        }
    }
    else{
        //exception : inventory kosong
    }
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
    if (this->isFull()==false){
        //Search existing item
        Skill search = this->getItemByName(e.getSkillName());
        if (search.getSkillName()!="None"){//ketemu, maka tambah qty nya
            int idx = this->getItemIdx(search);
            this->itemQty[idx] += 1;
        }
        else{ //tidak ketemu, maka add baru
            this->items.push_back(e);
            this->itemQty.push_back(1);
        }
    }
    else{
        //exception : inventory is full
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

bool Inventory<Skill>::isFull(){
    //penjumlahan semua anggota qty, lalu dibandingkan dengan capacitynya
    int currentStorage=0;
    for (int i=0 ; i<this->itemQty.size(); i++){
        currentStorage += this->itemQty[i];
    }
    return currentStorage>=this->maxCapacity;
}

int Inventory<Skill>::getItemIdx(Skill s){
    for (int i=0 ; i<this->items.size() ; i++){
        if (this->items[i].getSkillName() == s.getSkillName()){
            return i;
        }
    }
    return -1;
}

void Inventory<Skill>::deleteItem(string s){
    if (this->items.size()>0){
        if (doesItemExist(s)){
            deleteItem(getItemByName(s));
        }
        else{
            //exception : skill doesnt exist
        }
    }
    else{
        //exception : inventory is empty
    }
}
void Inventory<Skill>::deleteItem(Skill s){
    if (this->items.size()>0){
        if (doesItemExist(s)){
            int idx = this->getItemIdx(s);
            if (this->itemQty[idx] > 1){ //qty > 1, maka kurangi qty item tsb
                this->itemQty[idx] -= 1;
            }
            else{ //delete dari list item
                this->items.erase(this->items.begin() + idx);
                this->itemQty.erase(this->itemQty.begin() + idx);
            }
        }
        else{
            ////exception : skill doesnt exist
        }
    }
    else{
        //exception : inventory is empty
    }
}

void Inventory<Skill>::learn(Skill s, Engimon* e){
    //Asumsi : skill dan engimon terdapat di inventory
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
        this->deleteItem(s);
    }
    else{
        //throw exception : engimon element nya tidak compatible dengan skill
    }
}