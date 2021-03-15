#ifndef ELEMENTADVTABLE_H
#define ELEMENTADVTABLE_H

#include <iostream>
#include <vector>
using namespace std;

extern float elmtAdvTable[5][5];

//fire
elmtAdvTable[0][0] = 1 //againts fire
elmtAdvTable[0][1] = 0 //againts water
elmtAdvTable[0][2] = 1 //againts electric
elmtAdvTable[0][3] = 0.5 //againts ground
elmtAdvTable[0][4] = 2 //againts ice
//water
elmtAdvTable[1][0] = 2
elmtAdvTable[1][1] = 1
elmtAdvTable[1][2] = 0
elmtAdvTable[1][3] = 1
elmtAdvTable[1][4] = 1
//electric
elmtAdvTable[2][0] = 1
elmtAdvTable[2][1] = 2
elmtAdvTable[2][2] = 1
elmtAdvTable[2][3] = 0
elmtAdvTable[2][4] = 1.5
//ground
elmtAdvTable[3][0] = 1.5
elmtAdvTable[3][1] = 1
elmtAdvTable[3][2] = 2
elmtAdvTable[3][3] = 1
elmtAdvTable[3][4] = 0
//ice
elmtAdvTable[4][0] = 0
elmtAdvTable[4][1] = 1
elmtAdvTable[4][2] = 0.5
elmtAdvTable[4][3] = 2
elmtAdvTable[4][4] = 1