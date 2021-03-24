#include <iostream>
#include "Player.h"
#include "SupplementaryFunctions.h"
using namespace std;

int main(){
    string name;
    int input;
    //PEMBUATAN PETA
    vector<Cell> vsea;
    vector<Cell> vgrass;
    for (int i = 0; i < 100 ; i++){
        vsea.push_back(Cell("Sea"));
        vgrass.push_back(Cell("Grassland"));
    }
    map.generateMap(&vsea,&vgrass);

    //PEMBUATAN PLAYER
    cout<<"Enter name\t: ";
    cin>>name;
    //inventory
    Inventory<Skill> is(20);
    Inventory<Engimon> ie(20);
    cout<<"Choose engimon (by number) :"<<endl;
    cout<<"1. "<<JackFrost.getName()<<endl;
    cout<<"2. "<<Dababy.getName()<<endl;
    cout<<"3. "<<Waluigi.getName()<<endl;
    cin>>input;
    while(input<=0 || input>3){
        cout<<"Input not valid.\n"<<endl;
        cout<<"Choose engimon (by number) :"<<endl;
        cout<<"1. "<<JackFrost.getName()<<endl;
        cout<<"2. "<<Dababy.getName()<<endl;
        cout<<"3. "<<Waluigi.getName()<<endl;
    }
    if (input==1){
        cout<<"You've chosen Jack Frost!"<<endl;
        JackFrost.printDetail();
        ie.addItem(&JackFrost);
    }
    else if (input==2){
        cout<<"You've chosen Dababy! Less goo"<<endl;
        Dababy.printDetail();
        ie.addItem(&Dababy);
    }
        
    else{
        cout<<"You've chosen Waluigi!"<<endl;
        Waluigi.printDetail();
        ie.addItem(&Waluigi);
    }
    Player p(name, &is, &ie, ie.getItemById(0) ,0, 0);
    system("PAUSE");
    system("CLS");
    map.printMap(&p);
}