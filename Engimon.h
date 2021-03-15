#ifndef ENGIMON_H
#define ENGIMON_H

#include <iostream>
#include <vector>
#include "Species.h"
#include "Skill.h"
#include "Element.h"
using namespace std;

class Engimon{
    protected:
        const int id;
        string name;
        const int parentId;
        string parentName;
        Species species;
        vector<Skill> skills;
        vector<Element> elements;
        int level;
        int exp;
        int cumulativeExp;
    public:
        Engimon(); //ctor
        Engimon(string, int, string, Species, vector<Skill>, vector<Element>); //ctor with arguments = name, parentId, parentName, species, skills, elements
        Engimon(const Engimon&); //cctor
        ~Engimon(); //dtor
        Engimon& operator=(const Engimon&); //operator =

        //setter / adder
        void setName(string);
        void addSkill(Skill);
        void addSkill(vector<Skill>);
        void addElement(Element);
        void addElement(vector<Element>);
        void setLevel(int);
        void addExp(int); //ini berpengaruh ke exp dan cumulative exp
        void setExp(int);
        void setCumulativeExp(int); //ini kurang perlu menurutku tapi jaga-jaga aja

        //getter
        string getName();
        int getParentId();
        string getParentName();
        Species getSpecies();
        vector<Skill> getSkills();
        vector<Element> getElements();
        int getLevel();
        int getExp();
        int getCumulativeExp();

        //get status
        bool lvlUpEligibility(); //refer to spek 1.c
        bool isDead(); //refer to spek 1.d

        //output function
        void printDetail();
};

#endif