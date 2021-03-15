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
    this->addSkill(species.getUniqueSkill());
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

Engimon& Engimon::operator=(const Engimon& e){
    this->setName(e.name);
    this->setParent(e.parentId, e.parentName);
    this->setSpecies(e.species);
    this->addSkill(e.skills);
    this->addElement(e.elements);
    this->setLevel(e.level);
    this->setExp(e.exp);
    this->setCumulativeExp(e.cumulativeExp);
    return *this;
}

//setter
void Engimon::setName(string name){
    this->name = name;
}
void Engimon::setParent(Engimon e){
    this->parentId = e.id;
    this->parentName = e.name;
}
void Engimon::setParent(int id, string name){
    this->parentId = id;
    this->parentName = name;
}
void Engimon::setSpecies(Species s){
    this->species = s;
}
void Engimon::addSkill(Skill s){
    this->skills.push_back(s);
}
void Engimon::addSkill(vector<Skill> vs){
    for (int i=0; i<vs.size();i++){
        this->skills.push_back(vs[i]);
    }
}
void Engimon::addElement(Element e){
    this->elements.push_back(e);
}
void Engimon::addElement(vector<Element> ve){
    for (int i=0; i<ve.size();i++){
        this->elements.push_back(ve[i]);
    }
}
void Engimon::levelUp(){
    this->exp -= 100;
    this->level++;
}
void Engimon::setLevel(int lvl){
    this->level = lvl;
}
void Engimon::addExp(int exp){
    this->exp += exp;
    this->cumulativeExp +=exp;
    if (this->lvlUpEligibility()){
        this->levelUp();
    }
}
void Engimon::setExp(int exp){
    this->exp = exp;
}
void Engimon::setCumulativeExp(int cumxp){
    this->cumulativeExp = cumxp;
}

//getter
int Engimon::getId(){
    return this->id;
}
string Engimon::getName(){
    return this->name;
}
int Engimon::getParentId(){
    return this->parentId;
}
string Engimon::getParentName(){
    return this->parentName;
}
Species Engimon::getSpecies(){
    return this->species;
}
vector<Skill> Engimon::getSkills(){
    return this->skills;
}
vector<Element> Engimon::getElements(){
    return this->elements;
}
int Engimon::getLevel(){
    return this->level;
}
int Engimon::getExp(){
    return this->exp;
}
int Engimon::getCumulativeExp(){
    return this->cumulativeExp;
}

//get status
bool Engimon::lvlUpEligibility(){
    return this->exp>=100;
}
bool Engimon::isDead(){
    //masih ngga tau batas cumxp nya berapa
    return false;
}

//output func
void Engimon::printDetail(){
    cout<<"Nama Engimon"<<"\t: "<<this->getName()<<endl;
    cout<<"Nama Parent"<<"\t: "<<this->getParentName()<<endl;
    cout<<"Spesies"<<"\t\t: "<<this->getSpecies().getSpeciesName()<<endl;
    cout<<"Skill\t\t: ";
    for (int i=0;i<this->getSkills().size();i++){
        if (i<this->getSkills().size()-1){
            cout<<this->getSkills()[i].getSkillName()<<", ";
        }
        else{
            cout<<this->getSkills()[i].getSkillName()<<endl;
        }
        
    }
    cout<<"Element\t\t: ";
    for (int i=0;i<this->getElements().size();i++){
        if (i<this->getElements().size()-1){
            cout<<this->getElements()[i].getElementName()<<", ";
        }
        else{
            cout<<this->getElements()[i].getElementName()<<endl;
        }
        
    }
    cout<<"Level"<<"\t\t: "<<this->getLevel()<<endl;
    cout<<"Experience"<<"\t: "<<this->getExp()<<endl;
    cout<<"Cumulative Exp."<<"\t: "<<this->getCumulativeExp()<<endl;

}