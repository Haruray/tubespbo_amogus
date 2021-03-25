#include "Enemy.h"
#include <iostream>
#include <stdlib.h>

Enemy::Enemy() : Engimon(){
    this->setPosX(0);
    this->setPosY(0);
}
Enemy::Enemy(string name, Engimon* parent1, Engimon* parent2, Species species, vector<Skill> skills, vector<Element> elements, int level, int explimit, int x, int y) : Engimon(name, parent1, parent2, species, skills, elements, level, explimit){
    this->setPosX(x);
    this->setPosY(y);
}
Enemy::Enemy(const Enemy& e): Engimon(e){
    this->setPosX(e.position.x);
    this->setPosY(e.position.y);
    //aku lupa cara singkatnya
}

Enemy::Enemy(const Engimon& e): Engimon(e){
    this->setPosX(0);
    this->setPosY(0);
    //aku lupa cara singkatnya
}
Enemy::~Enemy(){}

void Enemy::setPosX(int x){
    this->position.x = x;
}
void Enemy::setPosY(int y){
    this->position.y = y;
}
int Enemy::getPosX(){
    return this->position.x;
}
int Enemy::getPosY(){
    return this->position.y;
}
string Enemy::getLogo(Player P){
    return "???";
}
void Enemy::moveUp(){
    this->position.x += 1;
}
void Enemy::moveDown(){
    this->position.x -= 1;
}
void Enemy::moveRight(){
    this->position.y += 1;
}
void Enemy::moveLeft(){
    this->position.y -= 1;
}

void Enemy::printEnemyDetails() {
    cout<<"Spesies"<<"\t: "<<this->getSpecies().getSpeciesName()<<endl;
    cout<<"Element\t: ";
    for (int i=0;i<this->getElements().size();i++){
        if (i<this->getElements().size()-1){
            cout<<this->getElements()[i].getElementName()<<", ";
        }
        else{
            cout<<this->getElements()[i].getElementName()<<endl;
        }
        
    }
    cout<<"Skill\t: ";
    for (int i=0;i<this->getSkills().size();i++){
        if (i<this->getSkills().size()-1){
            cout<<this->getSkills()[i].getSkillName()<<", ";
        }
        else{
            cout<<this->getSkills()[i].getSkillName()<<endl;
        }
        
    }
    cout<<"Level"<<"\t: "<<this->getLevel()<<endl;
}