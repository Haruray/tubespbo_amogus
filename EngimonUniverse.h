#ifndef ENGIMONUNIVERSE_H
#define ENGIMONUNIVERSE_H

#include <iostream>
#include "Player.h"
#include "Engimon.h"
#include "Inventory.h"
#include "Map.h"
using namespace std;

//GLOBAL VARIABLE
int mapsize = 10;
Map map;
//ELEMENTS
Element Fire("Fire");
Element Water("Water");
Element Electric("Electric");
Element Ground("Ground");
Element Ice("Ice");

//Species
Species Watortle("Watortle", "Waaaa!", Skill("Waterfall", 80, 5, vector<Element> {Water}));
Species Koikingu("Koikingu", "I'm a fish, meow", Skill("WaterSplash", 100, 4, vector<Element> {Water}));
Species Impostor("Impostor", "Sus!", Skill("Sabotage", 20, 10, vector<Element> {Electric}));
Species Raishuu("Raishuu", "Rokubyou", Skill("Mandom", 120, 3, vector<Element> {Electric}));
Species Saider("Saider", "Apple Sauce", Skill("Crimson", 200, 2, vector<Element> {Fire}));
Species Rizadon("Rizadon", "420 Moyase!", Skill("FireFang", 100, 5, vector<Element> {Fire}));
Species Bufumon("Bufumon", "Hee Ho!", Skill("Bufu", 120, 3, vector<Element> {Ice}));
Species IceCube("IceCube", "I'm just an ice cube", Skill("White Album", 100, 5, vector<Element> {Ice}));
Species Golem("Golem", "I'm the gaming golem", Skill("Rock", 100, 4, vector<Element> {Ground}));
Species Diguda("Diguda", "Toransu!", Skill("SandAttack", 150, 2, vector<Element> {Ground}));
Species Wyrm("Wyrm", "No cost too great", Skill("HallowedSlash", 120, 5, vector<Element> {Fire}));
Species Ymir("Ymir", "To you, 2000 years from now", Skill("Rumbling",150, 5, vector<Element> {Ground}));
Species SuperSuit("SuperSuit","WHERE IS MY SUPER SUIT??", Skill("Freeze!", 20 , 4, vector<Element> {Ice}));

Species BlueEyes("Blue Eyes", "Kaiba is my b*tch, b*tch.", Skill("BURST STREAM OF DESTRUCTION!", 150, 5, vector<Element> {Fire, Electric}));
Species RedEyes("Red Eyes", "I'm a plot armor.", Skill("Inferno Fire Blast", 170, 4, vector<Element> {Fire, Ground}));
Species GreenEyes("Green Eyes", "I'm not canon kekw", Skill("pftzzz", 100, 6, vector<Element> {Fire, Ice}));
Species Jakiro("Jakiro", "from dota or warcraft, idk", Skill("Dual Breath", 110, 6, vector<Element> {Fire, Ice}));
Species Schnozer("Schnozer", "nose.", Skill("Stinky Breath", 110, 6, vector<Element> {Water, Ground}));
Species CyberDragon("Cyber Dragon", "Another yu-gi-oh reference..yay", Skill("Zap!", 130, 6, vector<Element> {Water, Electric}));
Species DisneyPrincess("Disney Princess", "Let it go... Let it go! (that gay disney song)", Skill("Make a castle", 120, 7, vector<Element> {Water, Ice}));
Species Grounded("Grounded", "Get it? ahahahahAHHAHAHA", Skill("No Voltage", 100, 8, vector<Element> {Electric, Ground}));
Species ACDC("ACDC", "You see, in JoJo part 2, ACDC controls heat. So, we made ACDC controls electric now", Skill("Zap Requiem", 130, 7, vector<Element> {Electric, Ice}));
Species Trump("Trump", "Make Americunt great again", Skill("Incest", 100, 6, vector<Element> {Ground, Ice}));
vector<Species*> multElementSpecies = {&BlueEyes, &RedEyes, &GreenEyes, &Jakiro, &Schnozer, &CyberDragon, &DisneyPrincess, &Grounded, &ACDC, &Trump};

//Engimon
vector<Skill> skills;
Engimon JackFrost("Jack Frost", nullptr, nullptr, Bufumon, skills, vector<Element> {Ice}, 1, 10000);
Engimon Raool("Raool", nullptr, nullptr, Saider, skills, vector<Element> {Fire}, 1, 10000);
Engimon Dababy("Dababy", nullptr, nullptr, Golem, skills, vector<Element> {Ground}, 1, 10000);
Engimon Waluigi("Waluigi", nullptr, nullptr, Watortle, skills, vector<Element> {Water}, 1, 10000);
Engimon Ringo("Ringo", nullptr, nullptr, Raishuu, skills, vector<Element> {Electric}, 1, 10000);
Engimon Raoq("Raoq", nullptr, nullptr, Wyrm, skills, vector<Element> {Fire}, 1, 10000);
Engimon Hilarious("Hilarious", nullptr, nullptr, Impostor, skills, vector<Element> {Electric}, 1, 10000);
Engimon Valentine("Valentine", nullptr, nullptr, Diguda, skills, vector<Element> {Ground}, 1, 10000);
Engimon Dio("Dio", nullptr, nullptr, IceCube, skills, vector<Element> {Ground}, 1, 10000);
Engimon Mio("Mio", nullptr, nullptr, Koikingu, skills, vector<Element> {Water}, 1, 10000);
Engimon Gaybon("Gaybon", nullptr, nullptr, Watortle, skills, vector<Element> {Water}, 1, 10000);
Engimon Eren("Eren", nullptr, nullptr, Ymir, skills, vector<Element> {Ground}, 1 , 10000);
Engimon Frozone("Frozone", nullptr, nullptr, SuperSuit, skills, vector<Element> {Ice}, 1, 10000);


//enemies
Enemy JackFrostE(JackFrost);
Enemy RaoolE(Raool);
Enemy DababyE(Dababy);
Enemy WaluigiE(Waluigi);
Enemy RingoE(Ringo);
Enemy RaoqE(Raoq);
Enemy HilariousE(Hilarious);
Enemy ValentineE(Valentine);
Enemy DioE(Dio);
Enemy MioE(Mio);
Enemy GaybonE(Gaybon);
Enemy ErenE(Eren);
Enemy FrozoneE(Frozone);
vector<Enemy*> enemies ={&JackFrostE, &RaoolE, &DababyE, &WaluigiE, &RingoE, &RaoqE, &HilariousE, &ValentineE, &DioE, &MioE, &GaybonE, &ErenE, &FrozoneE};

#endif