#ifndef ENGIMONUNIVERSE_H
#define ENGIMONUNIVERSE_H

#include <iostream>
#include "Player.h"
#include "Engimon.h"
#include "Inventory.h"
#include "Map.h"
using namespace std;

//GLOBAL VARIABLE
int mapsize = 10;
Map map;
//ELEMENTS
Element Fire("Fire");
Element Water("Water");
Element Electric("Electric");
Element Ground("Ground");
Element Ice("Ice");

//Species
Species Watortle("Watortle", "Waaaa!", Skill("Waterfall", 100, 5, vector<Element> {Water}));
Species Koikingu("Koikingu", "I'm a fish, meow", Skill("WaterSplash", 100, 5, vector<Element> {Water}));
Species Impostor("Impostor", "Sus!", Skill("Sabotage", 100, 5, vector<Element> {Electric}));
Species Raishuu("Raishuu", "Rokubyou", Skill("Mandom", 100, 5, vector<Element> {Electric}));
Species Saider("Saider", "Apple Sauce", Skill("Crimson", 100, 5, vector<Element> {Fire}));
Species Rizadon("Rizadon", "420 Moyase!", Skill("FireFang", 100, 5, vector<Element> {Fire}));
Species Bufumon("Bufumon", "Hee Ho!", Skill("Bufu", 100, 5, vector<Element> {Ice}));
Species IceCube("IceCube", "I'm just an ice cube", Skill("White Album", 100, 5, vector<Element> {Ice}));
Species Golem("Golem", "I'm the gaming golem", Skill("Rock", 100, 5, vector<Element> {Ground}));
Species Diguda("Diguda", "Toransu!", Skill("SandAttack", 100, 5, vector<Element> {Ground}));

//Engimon
vector<Skill> skills;
Engimon JackFrost("Jack Frost", nullptr, nullptr, Bufumon, skills, vector<Element> {Ice}, 1, 10000);
Engimon Raool("Raool", nullptr, nullptr, Saider, skills, vector<Element> {Fire}, 1, 10000);
Engimon Dababy("Dababy", nullptr, nullptr, Golem, skills, vector<Element> {Ground}, 1, 10000);
Engimon Waluigi("Waluigi", nullptr, nullptr, Watortle, skills, vector<Element> {Water}, 1, 10000);
Engimon Ringo("Ringo", nullptr, nullptr, Raishuu, skills, vector<Element> {Electric}, 1, 10000);


#endif