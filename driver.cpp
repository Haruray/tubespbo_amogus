#include <iostream>
#include "Engimon.h"
#include "Inventory.h"
using namespace std;

int main(){
    //Membuat vector skill
    vector<Skill> skills;
    skills.push_back(Skill("normal attack",100,100, {Element("Fire")}));
    skills.push_back(Skill("special attack",200,200, {Element("Fire")}));
    //Membuat objek engimon. Parameter bisa dilihat di file header Engimon.h
    //Parents dengan nullptr artinya engimon tsb yatim piatu
    Engimon p1("rila mandala",nullptr, nullptr,Species("human","im a human",Skill("walk",10,10,vector<Element> {Element("Fire")})),skills,vector<Element> {Element("Fire")},0,1000);
    Engimon p2("a woman",nullptr, nullptr,Species("human","im a human",Skill("walk",10,10,vector<Element> {Element("Fire")})),skills,vector<Element> {Element("Fire")},0,1000);
    Engimon e("rinaldi munir",&p1, &p2,Species("human","im a human",Skill("walk",10,10,vector<Element> {Element("Fire")})),skills,vector<Element> {Element("Fire")},0,1000);
    //Membuat Inventory Skill
    Inventory<Skill> is(5);
    is.addItem(Skill("normal attack",100,100, vector<Element> {Element("Fire")}));
    is.addItem(Skill("special attack",200,200, vector<Element> {Element("Fire")}));
    is.addItem(Skill("special attack",200,200, vector<Element> {Element("Fire")}));
    is.addItem(Skill("run",200,200, vector<Element> {Element("Fire")}));
    //Membuat Inventory Engimon
    Inventory<Engimon> ie(5);
    ie.addItem(p1);
    ie.addItem(p2);
    ie.addItem(e);
    //Print informasi engimon
    e.printDetail();
    cout<<"\n";
    //Print informasi inventory skill
    is.printItems();
    cout<<"\n";
    //Mencoba fungsi learn
    is.learn(Skill("run",200,200, vector<Element> {Element("Fire")}), &e);
    e.printDetail(); //skill engimon bertambah run
    cout<<"\n";
    //Print informasi Engimon
    ie.printItems();
    cout<<"\n";
    //Mencoba delete item dari inventory Engimon
    ie.deleteItem(p1);
    ie.printItems();

    return 0;
}