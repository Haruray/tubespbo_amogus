#include "Inventory.h"

int BaseInventory::capacity = 0;
int BaseInventory::maxCapacity = 100;

BaseInventory::BaseInventory() {
    
}

BaseInventory::BaseInventory(int maxcap) {
    BaseInventory::maxCapacity = maxcap;
}

BaseInventory::~BaseInventory() {}

//Engimon specialization
Inventory<Engimon>::Inventory() : BaseInventory() {
    
}

Inventory<Engimon>::Inventory(int maxcap) : BaseInventory(maxcap) {
    
}

Inventory<Engimon>::Inventory(const Inventory& i) {
    for (int j=0 ; j<i.items.size(); j++){
        this->items[j] = i.items[j];
    }
}

Inventory<Engimon>::~Inventory(){}

void Inventory<Engimon>::addItem(Engimon* e){
    if (this->isFull()==false){
        this->items.push_back(e);
        BaseInventory::capacity += 1;
    }
    else{
        //exception : inventory is full
        throw InventoryExceptionF();
    }
}



Engimon* Inventory<Engimon>::getItemByName(string name){
    for (int i=0 ; i<this->items.size(); i++){
        if (name == this->items[i]->getName())
            return this->items[i];
    }
    return nullptr;
}

Engimon* Inventory<Engimon>::getItemById(int id){
    for (int i=0 ; i<this->items.size(); i++){
        if (id == this->items[i]->getId())
            return this->items[i];
    }
    return nullptr;
}

void Inventory<Engimon>::printItems(){
    for (int i=0 ; i<this->items.size(); i++){
        cout << (i+1) << ". " << this->items[i]->getName() << endl;
    }
}

bool Inventory<Engimon>::doesItemExist(Engimon* e){
    for (int i=0 ; this->items.size() ; i++){
        if (this->items[i]->getId() == e->getId()){
            return true;
        }
    }
    return false;
}

bool Inventory<Engimon>::isFull(){
    return BaseInventory::capacity >= BaseInventory::maxCapacity;
}

int Inventory<Engimon>::getItemIdx(Engimon* e){
    for (int i=0 ; i<this->items.size();i++){
        if (this->items[i]->getName() == e->getName()){
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
            throw EngimonException();
        }
    }
    else{
        //exception : inventory kosong
        throw InventoryException();
    }
    
}
void Inventory<Engimon>::deleteItem(Engimon* e){
    if (this->items.size() > 0){
        if (doesItemExist(e)){
            this->items.erase(this->items.begin() + this->getItemIdx(e));
            BaseInventory::capacity -= 1;
        }
        else{
            //exception : engimon doesnt exist
            throw EngimonException();
        }
    }
    else{
        //exception : inventory kosong
        throw InventoryException();
    }
}

int Inventory<Engimon>::getSize() {
    return this->items.size();
}


//Skill specialization
Inventory<Skill>::Inventory() : BaseInventory() {

}

Inventory<Skill>::Inventory(int maxcap) : BaseInventory(maxcap) {

}

Inventory<Skill>::Inventory(const Inventory& i){
    for (int j=0 ; j<i.items.size(); j++){
        this->items[j] = i.items[j];
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
        BaseInventory::capacity += 1;
    }
    else{
        //exception : inventory is full
        throw InventoryExceptionF();
    }
    
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
        cout<< (i+1) << ". " << this->items[i].getSkillName() << " ("<<this->itemQty[i]<<")" << endl;
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
    return BaseInventory::capacity >= BaseInventory::maxCapacity;
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
            throw SkillException();
        }
    }
    else{
        //exception : inventory is empty
        throw InventoryException();
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
            BaseInventory::capacity -= 1;
        }
        else{
            ////exception : skill doesnt exist
            throw SkillException();
        }
    }
    else{
        //exception : inventory is empty
        throw InventoryException();
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
        throw ElementException();
    }
}

int Inventory<Skill>::getSize() {
    return this->items.size();
}