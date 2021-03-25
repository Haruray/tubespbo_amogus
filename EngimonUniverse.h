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
//Skills
Skill WaterfallSkill("Waterfall", 80, 5, vector<Element> {Element("Water")});
Skill WaterSplash("WaterSplash", 100, 4, vector<Element> {Element("Water")});
Skill Sabotage("Sabotage", 20, 10, vector<Element> {Element("Electric")});
Skill Mandom("Mandom", 120, 3, vector<Element> {Element("Electric")});
Skill Crimson("Crimson", 200, 2, vector<Element> {Element("Fire")});
Skill FireFang("FireFang", 100, 5, vector<Element> {Element("Fire")});
Skill Bufu("Bufu", 120, 3, vector<Element> {Element("Ice")});
Skill WhiteAlbum("White Album", 100, 5, vector<Element> {Element("Ice")});
Skill Rock("Rock", 100, 4, vector<Element> {Element("Ground")});
Skill SandAttack("SandAttack", 150, 2, vector<Element> {Element("Ground")});
Skill HallowedSlash("HallowedSlash", 120, 5, vector<Element> {Element("Fire")});
Skill Rumbling("Rumbling",150, 5, vector<Element> {Element("Ground")});
Skill Freeze("Freeze!", 20 , 4, vector<Element> {Element("Ice")});
Skill BurstStream("BURST STREAM OF DESTRUCTION!", 150, 5, vector<Element> {Element("Fire"), Element("Electric")});
Skill InfernoFire("Inferno Fire Blast", 170, 4, vector<Element> {Element("Fire"), Element("Ground")});
Skill Pftz("pftzzz", 100, 6, vector<Element> {Element("Fire"), Element("Ice")});
Skill DualBreath("Dual Breath", 110, 6, vector<Element> {Element("Fire"), Element("Ice")});
Skill StinkyBreath("Stinky Breath", 110, 6, vector<Element> {Element("Water"), Element("Ground")});
Skill Zap("Zap!", 130, 6, vector<Element> {Element("Water"), Element("Electric")});
Skill Castle("Make a castle", 120, 7, vector<Element> {Element("Water"), Element("Ice")});
Skill NoVoltage("No Voltage", 100, 8, vector<Element> {Element("Electric"), Element("Ground")});
Skill Incest("Incest", 100, 6, vector<Element> {Element("Ground"), Element("Ice")});
Skill ZapRequiem("Zap Requiem", 130, 7, vector<Element> {Element("Electric"), Element("Ice")});
vector<Skill*> skillList = {&WaterfallSkill, &WaterSplash, &Sabotage, &Mandom, &Crimson, &FireFang, &Bufu, &WhiteAlbum, &Rock, &SandAttack, &HallowedSlash, &Rumbling, &Freeze, &BurstStream, &InfernoFire, &Pftz, &DualBreath, &StinkyBreath, &Zap, &Castle, &Castle, &NoVoltage, &Incest, &ZapRequiem};
//Species
Species Watortle("Watortle", "Waaaa!", WaterfallSkill);
Species Koikingu("Koikingu", "I'm a fish, meow", WaterSplash);
Species Impostor("Impostor", "Sus!", Sabotage);
Species Raishuu("Raishuu", "Rokubyou", Mandom);
Species Saider("Saider", "Apple Sauce", Crimson);
Species Rizadon("Rizadon", "420 Moyase!", FireFang);
Species Bufumon("Bufumon", "Hee Ho!", Bufu);
Species IceCube("IceCube", "I'm just an ice cube", WhiteAlbum);
Species Golem("Golem", "I'm the gaming golem", Rock);
Species Diguda("Diguda", "Toransu!", SandAttack);
Species Wyrm("Wyrm", "No cost too great", HallowedSlash);
Species Ymir("Ymir", "To you, 2000 years from now", Rumbling);
Species SuperSuit("SuperSuit","WHERE IS MY SUPER SUIT??", Freeze);

Species BlueEyes("Blue Eyes", "Kaiba is my b*tch, b*tch.", BurstStream);
Species RedEyes("Red Eyes", "I'm a plot armor.", InfernoFire);
Species GreenEyes("Green Eyes", "I'm not canon kekw", Pftz);
Species Jakiro("Jakiro", "from dota or warcraft, idk", DualBreath);
Species Schnozer("Schnozer", "nose.", StinkyBreath);
Species CyberDragon("Cyber Dragon", "Another yu-gi-oh reference..yay", Zap);
Species DisneyPrincess("Disney Princess", "Let it go... Let it go! (that gay disney song)", Castle);
Species Grounded("Grounded", "Get it? ahahahahAHHAHAHA", NoVoltage);
Species ACDC("ACDC", "You see, in JoJo part 2, ACDC controls heat. So, we made ACDC controls electric now", ZapRequiem);
Species Trump("Trump", "Make Americunt great again",Incest);
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
vector<Engimon*> engimons = {&JackFrost, &Raool, &Dababy, &Waluigi, &Ringo, &Raoq, &Hilarious, &Valentine, &Dio, &Mio, &Gaybon, &Eren, &Frozone};

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

Engimon* getRelatedEngimon(Enemy* e){
    for (int i = 0 ; i < engimons.size() ; i++){
        if (e->getId() == engimons[i]->getId()){
            return engimons[i];
        }
    }
    return nullptr;
}

Skill* getRelatedSkill(Skill s){
    for (int i = 0 ; i < skillList.size() ; i++){
        if (s.getSkillName() == skillList[i]->getSkillName()){
            return skillList[i];
        }
    }
    return nullptr;
}

vector<bool> enemyReserved;

#endif