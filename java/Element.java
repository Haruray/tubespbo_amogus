package willywangkyjava;

public class Element {
    final float[][] elmtAdvTable  = {{1,0,1,0.5f,2},{2,1,0,1,1},{1,2,1,0,1.5f},{1.5f,1,2,1,0},{0,1,0.5f,2,1}};
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
            case "Water":
                return 1;
            case "Electric":
                return 2;
            case "Ground":
                return 3;
            case "Ice":
                return 4;
            default:
                return -1;
        }
    }
    float elementAdvantage(Element E){
        return elmtAdvTable[elementToNumber()][E.elementToNumber()];
    }
}
