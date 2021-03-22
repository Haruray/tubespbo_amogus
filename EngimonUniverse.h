#ifndef ENGIMONUNIVERSE_H
#define ENGIMONUNIVERSE_H

#include <iostream>
#include "Player.h"
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
Species Koikingu("Koikingu", "I'm a fish, meow", Skill("WaterSplash", 100, 5, vector<Element> {Water}));
Species Impostor("Impostor", "Sus!", Skill("Sabotage", 100, 5, vector<Element> {Ice}));
Species Bufumon("Bufumon", "", Skill("Bufu", 100, 5, vector<Element> {Ice}));
Species Rizadon("Rizadon", "", Skill("FireFang", 100, 5, vector<Element> {Fire}));
Species Diguda("Digoda", "Toransu!", Skill("SandAttack", 100, 5, vector<Element> {Ground}));


#endif