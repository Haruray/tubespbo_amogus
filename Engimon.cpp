#include "Engimon.h"
//4 sekawan
int Engimon::totalEngimon = 0;
Engimon::Engimon() : id(totalEngimon+1){
    this->setName("None");
    this->setParent(-1,"None");
    this->setSpecies(Species());
    this->addSkill(Skill());
    this->addElement(Element());
    this->setLevel(0);
    this->setExp(0);
    this->setCumulativeExp(0);
}

Engimon::Engimon(string name, Engimon parent, Species species, vector<Skill> skills, vector<Element> elements, int level, int exp, int cumxp) : id(totalEngimon+1){
    this->setName(name);
    this->setParent(parent);
    this->setSpecies(species);
    this->addSkill(skills);
    this->addElement(elements);
    this->setLevel(level);
    this->setExp(exp);
    this->setCumulativeExp(cumxp);
}

Engimon::Engimon(const Engimon& e) : id(e.id){
    this->setName(e.name);
    this->setParent(e.parentId, e.parentName);
    this->setSpecies(e.species);
    this->addSkill(e.skills);
    this->addElement(e.elements);
    this->setLevel(e.level);
    this->setExp(e.exp);
    this->setCumulativeExp(e.cumulativeExp);
}

Engimon::~Engimon(){}

Engimon& Engimon::operator=(const Engimon&){
    //
}

//setter
