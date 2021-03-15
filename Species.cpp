#include "Species.h"

//4 sekawan
Species::Species(){
    this->setSpeciesName("None");
    this->setSlogan("None");
    this->setUniqueSkill(Skill());
}
Species::Species(string name, string slogan, Skill skill){
    this->setSpeciesName(name);
    this->setSlogan(slogan);
    this->setUniqueSkill(skill);
}
Species::Species(const Species& s){
    this->setSpeciesName(s.speciesName);
    this->setSlogan(s.slogan);
    this->setUniqueSkill(s.uniqueSkill);
}
Species::~Species(){}

//setter
void Species::setSpeciesName(string name){
    this->speciesName = name;
}
void Species::setSlogan(string slogan){
    this->slogan = slogan;
}
void Species::setUniqueSkill(Skill skill){
    this->uniqueSkill = skill;
}

//getter
string Species::getSpeciesName(){
    return this->speciesName;
}
string Species::getSlogan(){
    return this->slogan;
}
Skill Species::getUniqueSkill(){
    return this->uniqueSkill;
}