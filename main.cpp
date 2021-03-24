#include <iostream>
#include "Player.h"
#include "SupplementaryFunctions.h"
using namespace std;

//Help Command
void Help() {
    cout << "Player Commands :" << endl << endl;
    cout << "o Move (W,A,S,D)" << endl;
    cout << "o ShowEngimon" << endl;
    cout << "o ShowEngimonStat" << endl;
    cout << "o SwapEngimon" << endl;
    cout << "o ShowSkillItem" << endl;
    cout << "o UseSkillItem" << endl;
    cout << "o Breed" << endl;
    cout << "o Battle" << endl;
    cout << "o q" << endl;
}

int main(){
    string input;
    string name;
    int starterEngimon;
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
    cin>>starterEngimon;
    while(starterEngimon<=0 || starterEngimon>3){
        cout<<"starterEngimon not valid.\n"<<endl;
        cout<<"Choose engimon (by number) :"<<endl;
        cout<<"1. "<<JackFrost.getName()<<endl;
        cout<<"2. "<<Dababy.getName()<<endl;
        cout<<"3. "<<Waluigi.getName()<<endl;
    }
    if (starterEngimon==1){
        cout<<"You've chosen Jack Frost!"<<endl;
        JackFrost.printDetail();
        ie.addItem(&JackFrost);
    }
    else if (starterEngimon==2){
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

    cout << "Let us commence forth!" << endl;
    cout << "To show available commands, Type : 'Help!'" << endl;

    while (1) {
        cout << "Command: ";
        cin >> input;

        if (input == "w" || input == "a" || input == "s" || input == "d") {
            if (input == "w") {
                p.moveUp();
            } else if (input == "a") {
                p.moveLeft();
            } else if (input == "s") {
                p.moveDown();
            } else if (input == "d") {
                p.moveRight();
            }
            map.printMap(&p);
            map.randoEnemy();

        }
        else if (input == "Help!") {
            Help();

        } else if (input == "ShowEngimon") {
            p.showEngimonList();

        } else if (input == "ShowEngimonStat") {
            p.showEngimonData(*p.getActiveEngimon());

        } else if (input == "SwapEngimon") {
            p.swapActiveEngimon();

        } else if (input == "ShowSkillItem") {
            p.showSkillList();

        } else if (input == "UseSkillItem") {
            int skillIdx, engimonIdx;
            p.showSkillList();
            cout << "Choose which skill item to use : ";
            do {
                cin >> skillIdx;
            } while (skillIdx < 1 || skillIdx > p.getInventorySkill()->getSize());
            do {
                cin >> engimonIdx;
            } while (engimonIdx < 1 || engimonIdx > p.getInventoryEngimon()->getSize());
            p.useSkillItem(p.getInventorySkill()->getItemById(skillIdx-1), p.getInventoryEngimon()->getItemById(engimonIdx-1));

        } else if (input == "Breed") {
            int eng1, eng2;
            do {
                do {
                    cin >> eng1;
                } while (eng1 < 1 || eng1 > p.getInventoryEngimon()->getSize());
                do {
                    cin >> eng2;
                } while (eng2 < 1 || eng2 > p.getInventoryEngimon()->getSize());
            } while (eng1 == eng2);
            p.breeding(p.getInventoryEngimon()->getItemById(eng1-1), p.getInventoryEngimon()->getItemById(eng2-1));

        } else if (input == "Battle") {
            // insert battle

        } else if (input == "q") {
            cout << "Quitting . . . " << endl;
            break;

        } else {
            cout << "Invalid command!" << endl;
        }

    }

}