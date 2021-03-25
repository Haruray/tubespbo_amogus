#include "Skill.h"
//4 sekawan
Skill::Skill(){
    this->setSkillName("None");
    this->setBasePower(0);
    this->setMasteryLevel(0);
}

Skill::Skill(string name, int bp, int ml, vector<Element> elmtReq){
    this->setSkillName(name);
    this->setBasePower(bp);
    this->setMasteryLevel(ml);
    this->setElmtReq(elmtReq);
}

Skill::Skill(const Skill& s){
    this->setSkillName(s.skillName);
    this->setBasePower(s.basePower);
    this->setMasteryLevel(s.masteryLevel);
}

Skill::~Skill(){}

//operator overload
bool Skill::operator<(const Skill& s) const{
    return this->masteryLevel < s.masteryLevel;
}
bool Skill::operator>(const Skill& s) const{
    return this->masteryLevel > s.masteryLevel;
}
//setter
void Skill::setSkillName(string name){
    this->skillName = name;
}
void Skill::setBasePower(int bp){
    this->basePower=bp;
}
void Skill::setMasteryLevel(int ml){
    this->masteryLevel = ml;
}
void Skill::setElmtReq(vector<Element> elmtreq){
    for (int i=0 ; i < elmtreq.size() ; i++){
        this->elmtReq.push_back(elmtreq[i]);
    }
}

//getter
string Skill::getSkillName(){
    return this->skillName;
}
int Skill::getBasePower(){
    return this->basePower;
}
int Skill::getMasteryLevel(){
    return this->masteryLevel;
}
vector<Element> Skill::getElmtReq(){
    return this->elmtReq;
}
void Skill::printSkillDetail(){
    cout<<"Skill Name : "<<this->skillName<<endl;
    cout<<"Base power :"<<this->basePower<<endl;
    cout<<"Mastery lvl:"<<this->masteryLevel<<endl;
    cout<<"Elmt Req : ";
    for (int i = 0 ; i < this->elmtReq.size() ; i++){
        if (i < this->elmtReq.size()-1){
            cout<<this->elmtReq[i].getElementName()<<", ";
        }
        else{
            cout<<this->elmtReq[i].getElementName()<<endl;;
        }
        
    }
}