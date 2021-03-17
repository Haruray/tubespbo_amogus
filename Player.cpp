#include "Player.h"

Player::Player(){
    this->setPlayerName("None");
    this->setInventoryEngimon(Inventory<Engimon>());
    this->setInventorySkill(Inventory<Skill>());
    this->setActiveEngimon(Engimon());
    this->setPosition(0,0);
}
Player::Player(string name, Inventory<Skill> is, Inventory<Engimon> ie, Engimon e, int x, int y){
    this->setPlayerName(name);
    this->setInventorySkill(is);
    this->setInventoryEngimon(ie);
    this->setActiveEngimon(e);
    this->setPosition(x,y); //starting position nanti bisa dirubah
}
Player::Player(const Player& p){
    this->setPlayerName(p.playerName);
    this->setInventorySkill(p.skillList);
    this->setInventoryEngimon(p.engimonList);
    this->setActiveEngimon(p.activeEngimon);
    this->setPosition(p.position.x,p.position.y);
}
Player::~Player(){}

//setter
void Player::setPlayerName(string name){
    this->playerName = name;
}
void Player::setInventorySkill(Inventory<Skill> is){
    this->skillList = is;
}
void Player::setInventoryEngimon(Inventory<Engimon> ie){
    this->engimonList = ie;
}
void Player::setActiveEngimon(Engimon e){
    if (this->getInventoryEngimon().doesItemExist(e)){
        this->activeEngimon = e;
    }
    else{
        //exception : engimon doesnt exist in inventory
    }
}
void Player::setPosition(int x, int y){
    this->position.x = x;
    this->position.y = y;
}

//getter
string Player::getPlayerName(){
    return this->playerName;
}
Inventory<Skill> Player::getInventorySkill(){
    return this->skillList;
}
Inventory<Engimon> Player::getInventoryEngimon(){
    return this->engimonList;
}
Engimon Player::getActiveEngimon(){
    return this->activeEngimon;
}
int Player::getPosX(){
    return this->position.x;
}
int Player::getPosY(){
    return this->position.y;
}

//functions
void Player::moveUp(){
    this->setPosition(this->getPosX(), this->getPosY()+1);
}
void Player::moveLeft(){
    this->setPosition(this->getPosX()-1, this->getPosY());
}
void Player::moveRight(){
    this->setPosition(this->getPosX()+1, this->getPosY());
}
void Player::moveDown(){
    this->setPosition(this->getPosX(), this->getPosY()-1);
}

void Player::showEngimonList(){
    this->getInventoryEngimon().printItems();
}
void Player::showEngimonData(Engimon e){
    if (this->getInventoryEngimon().doesItemExist(e)){
        e.printDetail();
    }
    else{
        //exception : engimon doesnt exist in inventory
    }
}

void Player::showSkillList(){
    this->getInventorySkill().printItems();
}
void Player::useSkillItem(Skill s, Engimon* e){
    if (this->getInventorySkill().doesItemExist(s) && this->getInventoryEngimon().doesItemExist(*e)){
        this->getInventorySkill().learn(s,e);
    }
    else{
        //exception : skill or engimon doesnt exist
    }
}

void Player::breeding(Engimon* e1, Engimon* e2){
    //
}

void Player::interactWithActiveEngimon(){
    cout<<"["<<this->getActiveEngimon().getName()<<"] : "<<this->getActiveEngimon().getSpecies().getSlogan()<<endl;
}