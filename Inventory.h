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
        //4 sekawan
        Inventory();
        Inventory(int);
        Inventory(const Inventory&);
        ~Inventory();

        //setter/adder
        void setMaxCap(int);
        void addItem(Engimon);

        //checking conditions
        bool doesItemExist(Engimon); //true / false
        bool isFull();

        //delete
        void deleteItem(int); //delete engimon berdasarkan id
        void deleteItem(Engimon); //delete engimon langsung menyebut object nya

        //getter
        int getItemIdx(Engimon);
        Engimon getItemByName(string); //jika tidak ketemu, maka keluarannya adalah Engimon() (default)
        Engimon getItemById(int); //jika tidak ketemu, maka keluarannya adalah Engimon() (default)
        void printItems(); //print informasi
};

template<>
class Inventory<Skill>{
    private:
        vector<Skill> items;
        vector<int> itemQty;
        int maxCapacity;
    public:
        //4 sekawan
        Inventory();
        Inventory(int);
        Inventory(const Inventory&);
        ~Inventory();

        //setter/adder
        void setMaxCap(int);
        void addItem(Skill);

        //getter
        Skill getItemByName(string);
        int getItemIdx(Skill); //Jika itemnya tidak ketemu, maka keluarannya adalah -1
        void printItems(); //print informasi

        //checking conditions
        bool doesItemExist(Skill); //mencari item skill berdasarkan objek
        bool doesItemExist(string); //mencari item skill berdasarkan nama
        bool isFull();

        //delete
        void deleteItem(string); //delete skill berdasarkan nama
        void deleteItem(Skill); //delete skill berdasarkan object langsung

        //functions
        void learn(Skill, Engimon*); //fungsi learn, refer ke spek 3.b.i.2.d.
};

#endif