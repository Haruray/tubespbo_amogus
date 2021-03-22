#ifndef ENGIMONUNIVERSE_H
#define ENGIMONUNIVERSE_H

#include <iostream>
#include "Player.h"
#include "Inventory.h"
using namespace std;

//GLOBAL VARIABLE

//ELEMENTS
Element Fire("Fire");
Element Water("Water");
Element Electric("Electric");
Element Ground("Ground");
Element Ice("Ice");

//Species
Species Magicarp("Magicarp", "I'm a fish meow", Skill("WaterSplash",100, 5, vector<Element> {Water}));



#endif