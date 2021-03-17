#include "Player.h"

Player::Player(){
    this->setPlayerName("None");
    this->setInventoryEngimon(nullptr);
    this->setInventorySkill(nullptr);
    this->setActiveEngimon(nullptr);
    this->setPosition(0,0);
}
Player::Player(string name, Inventory<Skill>* is, Inventory<Engimon>* ie, Engimon* e, int x, int y){
    this->setPlayerName(name);
    this->setInventorySkill(is);
    this->setInventoryEngimon(ie);
    this->setActiveEngimon(e);
    this->setPosition(x,y); //starting position nanti bisa dirubah
}
Player::Player(const Player& p){
    this->setPlayerName(p.playerName);
    this->setInventorySkill(p.skillList);
    this->setInventoryEngimon(p.engimonList);
    this->setActiveEngimon(p.activeEngimon);
    this->setPosition(p.position.x,p.position.y);
}
Player::~Player(){}

//setter
void Player::setPlayerName(string name){
    this->playerName = name;
}
void Player::setInventorySkill(Inventory<Skill>* is){
    this->skillList = is;
}
void Player::setInventoryEngimon(Inventory<Engimon>* ie){
    this->engimonList = ie;
}
void Player::setActiveEngimon(Engimon* e){
    if (this->getInventoryEngimon()->doesItemExist(e)){
        this->activeEngimon = e;
    }
    else{
        //exception : engimon doesnt exist in inventory
    }
}
void Player::setPosition(int x, int y){
    this->position.x = x;
    this->position.y = y;
}

//getter
string Player::getPlayerName(){
    return this->playerName;
}
Inventory<Skill>* Player::getInventorySkill(){
    return this->skillList;
}
Inventory<Engimon>* Player::getInventoryEngimon(){
    return this->engimonList;
}
Engimon* Player::getActiveEngimon(){
    return this->activeEngimon;
}
int Player::getPosX(){
    return this->position.x;
}
int Player::getPosY(){
    return this->position.y;
}

//functions
void Player::moveUp(){
    this->setPosition(this->getPosX(), this->getPosY()+1);
}
void Player::moveLeft(){
    this->setPosition(this->getPosX()-1, this->getPosY());
}
void Player::moveRight(){
    this->setPosition(this->getPosX()+1, this->getPosY());
}
void Player::moveDown(){
    this->setPosition(this->getPosX(), this->getPosY()-1);
}

void Player::showEngimonList(){
    this->getInventoryEngimon()->printItems();
}
void Player::showEngimonData(Engimon e){
    if (this->getInventoryEngimon()->doesItemExist(&e)){
        e.printDetail();
    }
    else{
        //exception : engimon doesnt exist in inventory
    }
}

void Player::showSkillList(){
    this->getInventorySkill()->printItems();
}
void Player::useSkillItem(Skill s, Engimon* e){
    if (this->getInventorySkill()->doesItemExist(s) && this->getInventoryEngimon()->doesItemExist(e)){
        this->getInventorySkill()->learn(s,e);
    }
    else{
        //exception : skill or engimon doesnt exist
    }
}

bool doesSkillExistInVector(string name, vector<Skill> vs){
    for (int i = 0 ; i < vs.size() ; i++){
        if (vs[i].getSkillName() == name){
            return true;
        }
    }
    return false;
}

void Player::skillSelection(Engimon* e1, Engimon* e2, vector<Skill>* newSkill, vector<Skill>* skillList){
    //BAD, CHANGE THIS
    for (int i = 0; i < e1->getSkills().size() ; i++){
        if (e1->getSkills()[i].getMasteryLevel() >= e2->getSkills()[i].getMasteryLevel()){ //mastery skill parent 1 paling besar
            if (e1->getSkills()[i].getSkillName() == e2->getSkills()[i].getSkillName() && e1->getSkills()[i].getMasteryLevel() == e2->getSkills()[i].getMasteryLevel()){
                //jika punya skill sama dan mastery level sama, maka mastery level anaknya adalah mastery level parent 1 +1
                newSkill->push_back(Skill(e1->getSkills()[i].getSkillName(), e1->getSkills()[i].getBasePower(), e1->getSkills()[i].getMasteryLevel()+1, e1->getSkills()[i].getElmtReq()));
            }
            else if (e1->getSkills()[i].getSkillName() == e2->getSkills()[i].getSkillName() && e1->getSkills()[i].getMasteryLevel() != e2->getSkills()[i].getMasteryLevel()){
                //jika skill sama tapi mastery level berbeda, maka diambil mastery level yg terbesar
                newSkill->push_back(Skill(e1->getSkills()[i].getSkillName(), e1->getSkills()[i].getBasePower(), max(e1->getSkills()[i].getMasteryLevel(), e2->getSkills()[i].getMasteryLevel()), e1->getSkills()[i].getElmtReq()));
            }
            else{
                //jika skill nya tidak sama tapi mastery level parent 1 lebih besar, maka masukin aja
                newSkill->push_back(e1->getSkills()[i]);
            }
        }
        else{//parent 2 punya skill mastery level lebih besar
            newSkill->push_back(e2->getSkills()[i]);
        }
    }
    //edge case : karena pengambilan skill sebelumnya belum menjamin skill hasil breeding sudah penuh, maka dilakukan pengecekan lagi dan ditambahkan yg belum
    int j=0;
    while (newSkill->size() < 4 && j < skillList->size()){
        if (!doesSkillExistInVector(skillList->at(j).getSkillName(), *newSkill)){
            //kalau skill belum diambil dari skillList, maka langsung masukin aja, idk
            newSkill->push_back(skillList->at(j));
        }
        j++;
    }
}

Element getMostAdvantageousElmt(Element e, vector<Element> elist){
    Element eMax;
    float advMax1;
    float advMax2;
    for (int i = 0 ; i < elist.size() ; i++){
        advMax1 = e.elementAdvantage(elist[i]);
        advMax2 = elist[i].elementAdvantage(e);
        if (advMax1 > advMax2){
            eMax = e;
        }
        else{
            eMax = elist[0];
        }
    }
    return eMax;
    
}

void Player::breeding(Engimon* e1, Engimon* e2){
    if (this->getInventoryEngimon()->doesItemExist(e1) && this->getInventoryEngimon()->doesItemExist(e2)){
        if (e1->getLevel() >= 30 && e2->getLevel() >= 30){
            string newname;
            vector<Skill> newSkill;
            vector<Element> newElement;
            Species newSpecies;
            vector<Skill> skillList;
            //skillList adalah gabungan skill-skill dari e1,e2 / parent1, parent2;
            for (int i = 0; i < e1->getSkills().size() ; i++){
                skillList.push_back(e1->getSkills()[i]);
            }
            for (int i = 0; i < e2->getSkills().size() ; i++){
                skillList.push_back(e2->getSkills()[i]);
            }
            cout<<"Beri engimon baru sebuah nama : ";
            cin>>newname;
            //sorting skill based on mastery skill
            /*
            sort(e1->getSkills().begin(), e1->getSkills().end(), [](Skill& s1, Skill& s2){
                return s1.getMasteryLevel() > s2.getMasteryLevel();
            });
            sort(e2->getSkills().begin(), e2->getSkills().end(), [](Skill& s1, Skill& s2){
                return s1.getMasteryLevel() > s2.getMasteryLevel();
            });
            //sorting skillList
            sort(skillList.begin(), skillList.end(), [](Skill& s1, Skill& s2){
                return s1.getMasteryLevel() > s2.getMasteryLevel();
            });
            */
            // sort(e1->getSkills().begin(), e1->getSkills().end());
            // sort(e2->getSkills().begin(), e2->getSkills().end());
            sort(skillList.begin(), skillList.end(), greater<Skill>());

            //perbandingan skill mastery level buat dimasukin ke engimon baru
            if (e1->getSkills().size() <= e2->getSkills().size()){
                //kalau jumlah skill e1 lebih kecil sama dengan jumlah skill e2, maka loop dibawah ini dilakukan
                this->skillSelection(e1,e2,&newSkill,&skillList);
            }
            else{
                //kalau jumlah skill e2 jauh lebih kecil, maka dilakukan sebaliknya
                this->skillSelection(e2,e1,&newSkill,&skillList);
            }
            
            //Hasil spesies dan element
            //pertama, mengecek apakah kedua engimon parent memiliki elemen yg sama.
            //asumsi kedua parent merupakan multielemen. Maka, diambil elemen yg sama terlebih dahulu
            //kalau elemen berbeda, maka dicek elmt advantage nya lebih besar yg mana

            //loop, dengan asumsi jumlah element e1 <= jumlah elemen e2
            int e1Cenderung = 0 ;
            int e2Cenderung = 0 ;
            Element eNew;
            for (int i = 0; i < e1->getElements().size() ; i++){
                if (e2->isElement(e1->getElements()[i])){ //jika berelemen true, maka elemen kedua parents sama
                    newElement.push_back(e1->getElements()[i]);
                }
                else{ //jika elemen berbeda
                    eNew = getMostAdvantageousElmt(e1->getElements()[i], e2->getElements());
                    if (e1->isElement(eNew)){
                        e1Cenderung++;
                    }
                    else{
                        e2Cenderung++;
                    }
                    newElement.push_back(eNew);
                }
            }
            //NOTE : KALAU ELMT ADVANTAGE NYA SAMA BELUM DI CEK
            
            //Set spesies, berdasarkan kecendeerungan
            if (e1Cenderung >= e2Cenderung){
                newSpecies = e1->getSpecies();
            }
            else{
                newSpecies = e2->getSpecies();
            }
            //Pembuatan engimon dan dimasukkan ke inventory
            Engimon* newEngimon = new Engimon(newname, e1, e2, newSpecies, newSkill, newElement, 1, 1000); //Subject to change untuk maximum cumulative exp
            this->getInventoryEngimon()->addItem(newEngimon);
            //For testing purpose, newengimon jadi active engimon
            this->setActiveEngimon(newEngimon);
        }
        else{
            //exception : parents not eligible for breeding
        }
    }
    else{
        //exception : engimons doesnt exist in inventory
    }
}

void Player::interactWithActiveEngimon(){
    cout<<"["<<this->getActiveEngimon()->getName()<<"] : "<<this->getActiveEngimon()->getSpecies().getSlogan()<<endl;
}