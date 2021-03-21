#ifndef ENGIMONUNIVERSE_H
#define ENGIMONUNIVERSE_H

#include <iostream>
#include "Player.h"
using namespace std;

//ELEMENT ADVANTAGE
float elmtAdvTable[5][5]={{1,0,1,0.5,2},{2,1,0,1,1},{1,2,1,0,1.5},{1.5,1,2,1,0},{0,1,0.5,2,1}};
/*
//fire
elmtAdvTable[0][0] = 1; //againts fire
elmtAdvTable[0][1] = 0; //againts water
elmtAdvTable[0][2] = 1; //againts electric
elmtAdvTable[0][3] = 0.5; //againts ground
elmtAdvTable[0][4] = 2; //againts ice
//water index nya [1][x]
//electric index nya [2][x]
//ground index ya [3][x]
//ice index nya [4][x]
*/

//ELEMENTS
Element Fire("Fire");
Element Water("Water");
Element Electric("Electric");
Element Ground("Ground");
Element Ice("Ice");

//Species
Species Magicarp("Magicarp", "I'm a fish meow", Skill("WaterSplash",100, 5, vector<Element> {Water}));



#endif