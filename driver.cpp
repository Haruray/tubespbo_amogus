#include <iostream>
#include "Engimon.h"
using namespace std;

int main(){
    vector<Skill> skills;
    skills.push_back(Skill("normal attack",100,100));
    skills.push_back(Skill("special attack",200,200));
    vector<Element> el;
    el.push_back(Element("Fire"));
    Engimon p1("rila mandala",nullptr, nullptr,Species("human","im a human",Skill("walk",10,10)),skills,el,0,1000);
    Engimon p2("a woman",nullptr, nullptr,Species("human","im a human",Skill("walk",10,10)),skills,el,0,1000);
    Engimon e("rinaldi munir",&p1, &p2,Species("human","im a human",Skill("walk",10,10)),skills,el,0,1000);
    e.printDetail();
    return 0;
}