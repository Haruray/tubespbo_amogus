#ifndef INVENTORY_H
#define INVENTORY_H

#include <iostream>
#include <algorithm>
#include "Engimon.h"

using namespace std;

template <class T>
class Inventory{
    protected:
        vector<T> items;
        int maxCapacity;
    public:
        Inventory();
        Inventory(int);
};

//specialization
template<>
class Inventory<Engimon>{
    private:
        vector<Engimon> items;
        int maxCapacity;
    public:
        Inventory();
        Inventory(int);
        Inventory(const Inventory&);
        ~Inventory();

        void setMaxCap(int);
        void addItem(Engimon);

        Engimon getItemByName(string);
        void printItems();
};

template<>
class Inventory<Skill>{
    private:
        vector<Skill> items;
        vector<int> itemQty;
        int maxCapacity;
    public:
        Inventory();
        Inventory(int);
        Inventory(const Inventory&);
        ~Inventory();

        void setMaxCap(int);
        void addItem(Skill);

        Skill getItemByName(string);
        int getItemIdx(Skill);
        void printItems();
};

#endif