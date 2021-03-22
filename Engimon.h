#ifndef ENGIMON_H
#define ENGIMON_H

#include <iostream>
#include <vector>
#include <iomanip>
#include <algorithm>
#include "Species.h"
#include "Skill.h"
#include "Element.h"
using namespace std;

class Engimon{
    protected:
        const int id;
        string name;
        vector<Engimon*> parents;
        Species species;
        vector<Skill> skills;
        vector<Element> elements;
        int level;
        int exp;
        int cumulativeExp;
        int explimit;

        static int totalEngimon;
    public:
        Engimon(); //ctor
        Engimon(string, Engimon*, Engimon*, Species, vector<Skill>, vector<Element>, int, int); //ctor with arguments = name, parent1, parent2, species, skills, elements, level, batas cumxp
        Engimon(const Engimon&); //cctor
        ~Engimon(); //dtor
        Engimon& operator=(const Engimon&); //operator =

        //setter / adder
        void setName(string);
        void setParent(Engimon*, Engimon*);
        void setSpecies(Species);
        void addSkill(Skill);
        void addSkill(vector<Skill>);
        void addElement(Element);
        void addElement(vector<Element>);
        void levelUp();
        void setLevel(int);
        void addExp(int); //ini berpengaruh ke exp dan cumulative exp
        void setExp(int);
        void setCumulativeExp(int); //ini kurang perlu menurutku tapi jaga-jaga aja
        void setExpLimit(int);

        //getter
        int getId();
        string getName();
        vector<Engimon*> getParents();
        Species getSpecies();
        vector<Skill> getSkills();
        vector<Element> getElements();
        int getLevel();
        int getExp();
        int getCumulativeExp();
        int getCumExpLimit();
        Skill getHighestMasteryLevel();

        //get status
        bool lvlUpEligibility(); //refer to spek 1.c
        bool isDead(); //refer to spek 1.d
        bool isElement(Element); //apakah engimon berelemen x 
        bool hasSkill(Skill); //apakah engimon punya skill x
        
        //delete
        void replaceSkill(Skill); //replace skill by index

        //output function
        void printDetail();
        void printSkill();
};

class EngimonExceptionSkillFull: public exception{
    public:
        const char* what() const throw(){
            return "Skill slot full";
        }
};

#endif