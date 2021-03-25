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
    cout<<"Enter your name : ";
    cin>>name;
    //inventory
    Inventory<Skill> is(30);
    Inventory<Engimon> ie(30);
    cout<<"1. "<<JackFrost.getName()<<endl;
    cout<<"2. "<<Dababy.getName()<<endl;
    cout<<"3. "<<Waluigi.getName()<<endl;
    cout<<"Choose engimon (by number) : ";
    cin>>starterEngimon;
    while(starterEngimon<=0 || starterEngimon>3){
        cout<<"starterEngimon not valid.\n"<<endl;
        cout<<"1. "<<JackFrost.getName()<<endl;
        cout<<"2. "<<Dababy.getName()<<endl;
        cout<<"3. "<<Waluigi.getName()<<endl;
        cout<<"Choose engimon (by number) : ";
    }
    if (starterEngimon==1){
        cout<<"You've chosen Jack Frost!"<<endl;
        JackFrost.setLevel(2); //starting level
        JackFrost.printDetail();
        ie.addItem(&JackFrost);
    }
    else if (starterEngimon==2){
        cout<<"You've chosen Dababy! Less goo"<<endl;
        Dababy.setLevel(2); //starting level
        Dababy.printDetail();
        ie.addItem(&Dababy);
    }
        
    else{
        cout<<"You've chosen Waluigi!"<<endl;
        Waluigi.setLevel(2); //starting level
        Waluigi.printDetail();
        ie.addItem(&Waluigi);
    }
    Player p(name, &is, &ie, ie.getItemById(0) ,0, 0);
    system("PAUSE");
    // system("CLS");
    mapRandomizer(&map);
    map.printMap(&p);
    
    cout << endl;
    cout << "Let us commence forth!" << endl;
    cout << "To show available commands, Type : 'Help!'" << endl;

    while (1) {
        cout << "Command: ";
        cin >> input;

        if (input == "w" || input == "a" || input == "s" || input == "d") {
            if (input == "w") {
                playerMove(&p,&map, "w");
            } else if (input == "a") {
                playerMove(&p,&map, "a");
            } else if (input == "s") {
                playerMove(&p,&map, "s");
            } else if (input == "d") {
                playerMove(&p,&map, "d");
            }
            map.printMap(&p);

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
            do {
                cout << "Choose which skill item to use : ";
                cin >> skillIdx;
            } while (skillIdx < 1 || skillIdx > p.getInventorySkill()->getSize());

            p.showEngimonList();
            do {
                cout << "Choose which engimon to inherit the skill : ";
                cin >> engimonIdx;
            } while (engimonIdx < 1 || engimonIdx > p.getInventoryEngimon()->getSize());

            try {
                p.useSkillItem(p.getInventorySkill()->getItemById(skillIdx-1), p.getInventoryEngimon()->getItemById(engimonIdx-1));
            } catch (exception& e) {
                cout << e.what() << endl; //engimon is incompatible
            }

        } else if (input == "Breed") {
            int eng1, eng2;
            p.getInventoryEngimon()->printItems();
            do {
                do {
                    cout << "Choose parent 1 : ";
                    cin >> eng1;
                } while (eng1 < 1 || eng1 > p.getInventoryEngimon()->getSize());
                do {
                    cout << "Choose parent 2 : ";
                    cin >> eng2;
                } while (eng2 < 1 || eng2 > p.getInventoryEngimon()->getSize());
            } while (eng1 == eng2);
            
            try {
                p.breeding(p.getInventoryEngimon()->getItemById(eng1-1), p.getInventoryEngimon()->getItemById(eng2-1), &multElementSpecies);
            } catch (exception& e) {
                cout << e.what() << endl; // exception : ineligible for breeding
            }

        } else if (input == "Battle") {
            // insert battle
            // Tip : buat nyari musuh di adjacent tile, pakai fungsi checkEnemiesOnAdjacentTiles(Map* map, int x, int y), keluarnnya vector of enemy
            // buat battle, pakai fungsi battle(Engimon ourEngimon, Enemy enemyEngimon), true kalau menang dan false kalau kalah
            // kalau menang, tambahin fungsi deleteEnemy(Map* map, Enemy* e) buat ngedelete enemy dari map
            
            vector<Enemy*> adjEnemy = checkEnemiesOnAdjacentTiles(&map, p.getPosX(), p.getPosY());
            if (adjEnemy.empty()) {
                cout << "There are no enemies nearby . . . " << endl;
            } else {
                int i = 1, idx;
                bool battleResult;

                for (Enemy* e : adjEnemy) {
                    cout << "Enemy " << i << endl;
                    e->printDetail();
                    cout << endl;
                    i++;
                }
                do {
                    cout << "Select the enemy that you want to fight (enter a number) : ";
                    cin >> idx;
                } while (idx < 1 || idx > adjEnemy.size());

                Enemy* selectedEnemy = adjEnemy[idx-1];
                battleResult = battle(p.getActiveEngimon(), selectedEnemy);
                if (battleResult) {
                    p.getInventorySkill()->addItem(selectedEnemy->getSkills()[0]);
                    winReward(&p, *selectedEnemy);
                    deleteEnemy(&map, selectedEnemy);
                } else {
                    p.getInventoryEngimon()->deleteItem(p.getActiveEngimon());
                    lose(&p);
                }
            }
            

        } else if (input == "q") {
            cout << "Quitting . . . " << endl;
            break;

        } else {
            cout << "Invalid command!" << endl;
        }
        cout << endl;
    }

}