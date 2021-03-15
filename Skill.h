#ifndef SKILL_H
#define SKILL_H

#include <iostream>
using namespace std;

class Skill{
    protected:
        string skillName;
        int basePower;
        int masteryLevel;
    public:
        Skill(); //ctor
        Skill(string, int,int); //ctor with arguments
        Skill(const Skill&);
        ~Skill();

        //setter
        void setSkillName(string);
        void setBasePower(int);
        void setMasteryLevel(int);

        //getter
        string getSkillName();
        int getBasePower();
        int getMasteryLevel();
};

#endif