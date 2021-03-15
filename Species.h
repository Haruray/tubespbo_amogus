#ifndef SPECIES_H
#define SPECIES_H

#include <iostream>
#include "Skill.h"
using namespace std;

class Species{
    protected:
        string speciesName;
        string slogan; //refer to spek 3.c.iv
        Skill uniqueSkill;
    public:
        Species(); //ctor
        Species(string,string,Skill); //ctor with arguments
        Species(const Species&);
        ~Species();

        //setter
        void setSpeciesName(string);
        void setSlogan(string);
        void setUniqueSkill(Skill);

        //getter
        string getSpeciesName();
        string getSlogan();
        Skill getUniqueSkill();
};

#endif