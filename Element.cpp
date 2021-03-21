#include "Element.h"
#include "EngimonUniverse.h"

//4 sekawan
Element::Element(){
    this->setElementName("None");
}
Element::Element(string name){
    this->setElementName(name);
}
Element::Element(const Element& e){
    this->setElementName(e.elementName);
}
Element::~Element(){}

Element& Element::operator=(const Element& e){
    this->setElementName(e.elementName);
    return *this;
}
//setter
void Element::setElementName(string name){
    this->elementName = name;
}

//getter
string Element::getElementName(){
    return this->elementName;
}

//functions
int Element::elementToNumber(){
    if (this->getElementName()=="Fire"){
        return 0;
    }
    else if (this->getElementName()=="Water"){
        return 1;
    }
    else if (this->getElementName()=="Electric"){
        return 2;
    }
    else if (this->getElementName()=="Ground"){
        return 3;
    }
    else if (this->getElementName()=="Ice"){
        return 4;
    }
    return -1;
}

float Element::elementAdvantage(Element e){
    return elmtAdvTable[this->elementToNumber()][e.elementToNumber()];
}