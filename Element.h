#ifndef ELEMENT_H
#define ELEMENT_H

#include <iostream>
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
        float elementAdvantage(Element);
};

#endif