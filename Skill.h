#ifndef SKILL_H
#define SKILL_H

#include <iostream>
#include <vector>
#include "Element.h"
using namespace std;

class Skill{
    protected:
        string skillName;
        int basePower;
        int masteryLevel;
        vector<Element> elmtReq;
    public:
        Skill(); //ctor
        Skill(string, int,int, vector<Element>); //ctor with arguments
        Skill(const Skill&);
        ~Skill();

        //operator overload
        bool operator<(const Skill&) const;
        bool operator>(const Skill&) const;

        //setter
        void setSkillName(string);
        void setBasePower(int);
        void setMasteryLevel(int);
        void setElmtReq(vector<Element>);

        //getter
        string getSkillName();
        int getBasePower();
        int getMasteryLevel();
        vector<Element> getElmtReq();

        void printSkillDetail();
};

#endif