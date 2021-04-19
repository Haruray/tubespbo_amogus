package java;

public class Element {
    String elementName;
    Element(){
        setElementName("None");
    }
    Element(String name){
        setElementName(name);
    }
    void setElementName(String name){
        this.elementName = name;
    }
    String getElementName(){
        return this.elementName;
    }
    int elementToNumber(){
        switch (this.elementName) {
            case "Fire":
                return 0;
                break;
            case "Water":
                return 1;
                break;
            case "Electric":
                return 2;
                break;
            case "Ground":
                return 3;
                break;
            case "Ice":
                return 4;
                break;
            default:
                return -1;
                break;
        }
    }
    float elementAdvantage(Element E){

    }
}
