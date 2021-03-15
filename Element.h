#ifndef ELEMENT_H
#define ELEMENT_H

#include <iostream>
#include <string>
using namespace std;

class Element{
    protected:
        string elementName;
    public: 
        Element(); //ctor
        Element(string); //ctor with argument
        Element(const Element&); //cctor
        ~Element();
        
        //setter
        void setElementName(string);

        //getter
        string getElementName();

        //functions
        int elementToNumber(); //buat mempermudah akses ke array
        float elementAdvantage(Element);
};

#endif