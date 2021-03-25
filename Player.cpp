#include "Player.h"

Player::Player(){
    this->setPlayerName("None");
    this->setInventoryEngimon(nullptr);
    this->setInventorySkill(nullptr);
    this->setActiveEngimon(nullptr);
    this->setPosition(1,1);
    this->positionActiveEngimon.x = 1;
    this->positionActiveEngimon.y = 0;
}
Player::Player(string name, Inventory<Skill>* is, Inventory<Engimon>* ie, Engimon* e, int x, int y){
    this->setPlayerName(name);
    this->setInventorySkill(is);
    this->setInventoryEngimon(ie);
    this->setActiveEngimon(e);
    this->setPosition(x,y); //starting position nanti bisa dirubah
    this->positionActiveEngimon.x = 1;
    this->positionActiveEngimon.y = 0;
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
        throw EngimonInvException();
    }
}
void Player::setPosition(int x, int y){
    this->position.x = x;
    this->position.y = y;
}
void Player::setActiveEngPos(int x, int y){
    this->positionActiveEngimon.x = x;
    this->positionActiveEngimon.y = y;
}
void Player::ActiveEngimonFollow(){
    this->positionActiveEngimon.x = getPosX();
    this->positionActiveEngimon.y = getPosY();
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

int Player::ActiveX(){
    return this->positionActiveEngimon.x;
}
int Player::ActiveY(){
    return this->positionActiveEngimon.y;
}

//functions
void Player::moveUp(){
    ActiveEngimonFollow();
    this->setPosition(this->getPosX()-1, this->getPosY());
}
void Player::moveLeft(){
    ActiveEngimonFollow();
    this->setPosition(this->getPosX(), this->getPosY()-1);
}
void Player::moveRight(){
    ActiveEngimonFollow();
    this->setPosition(this->getPosX(), this->getPosY()+1);
}
void Player::moveDown(){
    ActiveEngimonFollow();
    this->setPosition(this->getPosX()+1, this->getPosY());
}

void Player::showEngimonList(){
    this->getInventoryEngimon()->printItems();
}
void Player::showEngimonData(Engimon e){
    if (this->getInventoryEngimon()->doesItemExist(&e)){
        e.printDetail();
    }
    else{
        throw EngimonInvException();
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
        throw UseException();
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
/*
vector<Element> combineElement(vector<Element> elist1, vector<Element> elist2){
    vector<Element> elist3;
    //menghapus duplikat pada salah satu vector
    int elist1_size = elist1.size();
    for (int i = 0; i < elist1.size() ; i++){
        for (int j = 0 ; j < elist2.size() ; j++){
            if (elist1[i].getElementName() == elist2[j].getElementName()){
                elist1.erase(elist1.begin() + i);
                elist1_size -= 1;
                break;
            }
        }
    }
    //gabung dua vector
    elist3.reserve(elist1.size() + elist2.size());
    elist3.insert(elist3.end(), elist1.begin(), elist1.end());
    elist3.insert(elist3.end(), elist2.begin(), elist2.end());
    if (elist3.size() > 2){
        //kalau lebih dari 2, cari element yg adv nya paling tinggi
    }
    return elist3;
}
*/
bool compareVectorOfElements(vector<Element> elist1, vector<Element> elist2){
    if (elist1.size() > elist2.size()){
        for (int i = 0; i < elist1.size() ; i++){
            for (int j = 0 ; j < elist2.size() ; j++){
                if (elist1[i].getElementName() != elist2[j].getElementName()){
                    return false;
                }
            }
        }
        return true;
    }
    else{
        for (int i = 0; i < elist2.size() ; i++){
            for (int j = 0 ; j < elist1.size() ; j++){
                if (elist2[i].getElementName() != elist1[j].getElementName()){
                    return false;
                }
            }
        }
        return true;
    }
    
}

vector<Element> getMostAdvantageousElmt(vector<Element> elist1, vector<Element> elist2){
    //Mencari himpunan elmt dengan adv terbesar. Metode nya adalah : penjumlahan
    //selain itu, dicatat per elist element mana yg nilai advantage nya yg paling besar ; e1max untuk elist1 dan e2max untuk elist2
    Element e1max = elist1[0];
    float e1maxf = elist1[0].elementAdvantage(elist2[0]);
    Element e2max = elist2[0];
    float e2maxf = elist2[0].elementAdvantage(elist1[0]);

    float adv1=0;
    float adv2=0;
    for (int i=0; i < elist1.size() ; i++){
        for (int j=0 ; j < elist2.size() ; j++){
            adv1 += elist1[i].elementAdvantage(elist2[j]);
            if (elist1[i].elementAdvantage(elist2[j]) > e1maxf){
                e1maxf = elist1[i].elementAdvantage(elist2[j]);
                e1max = elist1[i];
            }
        }
    }
    for (int i=0; i < elist2.size() ; i++){
        for (int j=0 ; j < elist1.size() ; j++){
            adv2 += elist2[i].elementAdvantage(elist1[j]);
            if (elist2[i].elementAdvantage(elist1[j]) > e2maxf){
                e2maxf = elist2[i].elementAdvantage(elist1[j]);
                e2max = elist2[i];
            }
        }
    }
    if (adv1 > adv2){
        return elist1;
    }
    else if (adv1 < adv2){
        return elist2;
    }
    else{ //kalau elemen sama, maka digabungkan e1max dan e2max
        return vector<Element> {e1max,e2max};
    }
}

void Player::breeding(Engimon* e1, Engimon* e2, vector<Species*>* splist){
    if (this->getInventoryEngimon()->doesItemExist(e1) && this->getInventoryEngimon()->doesItemExist(e2)){
        if (e1->getLevel() > 30 && e2->getLevel() > 30){
            //Mengurangi level parents
            e1->setLevel(e1->getLevel()-30);
            e2->setLevel(e2->getLevel()-30);
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

            newElement = getMostAdvantageousElmt(e1->getElements(), e2->getElements());
            if (compareVectorOfElements(newElement, e1->getElements())){
                newSpecies = e1->getSpecies();
            }
            else if (compareVectorOfElements(newElement, e2->getElements())){ 
                newSpecies = e2->getSpecies();
            }
            else{//kalau berbeda dari keduanya, maka speciesnya random
                for (int j = 0 ; j < splist->size() ; j++){
                    Element splisEl1 = splist->at(j)->getUniqueSkill().getElmtReq()[0];
                    Element splisEl2 = splist->at(j)->getUniqueSkill().getElmtReq()[1];
                    if ((splisEl1.getElementName() == newElement[0].getElementName() || splisEl1.getElementName() == newElement[1].getElementName()) && (splisEl2.getElementName() == newElement[0].getElementName() || splisEl2.getElementName() == newElement[1].getElementName())){
                        newSpecies = *splist->at(j);
                    }
                }
            }
            //Pembuatan engimon dan dimasukkan ke inventory
            Engimon* newEngimon = new Engimon(newname, e1, e2, newSpecies, newSkill, newElement, 1, 1000); //Subject to change untuk maximum cumulative exp
            this->getInventoryEngimon()->addItem(newEngimon);
            //For testing purpose, newengimon jadi active engimon
        }
        else{
            //exception : parents not eligible for breeding
            throw BreedParentException();
        }
    }
    else{
        //exception : engimons doesnt exist in inventory
        throw BreedEngimonException();
    }
}

void Player::swapActiveEngimon() {
    int idx;
    this->getInventoryEngimon()->printItems();
    cout << "Pilih Engimon (by index) : ";
    do {
        cin >> idx;
    } while (idx < 1 || idx > this->getInventoryEngimon()->getSize());
    this->setActiveEngimon(this->getInventoryEngimon()->getItemById(idx-1));
}

void Player::interactWithActiveEngimon(){
    cout<<"["<<this->getActiveEngimon()->getName()<<"] : "<<this->getActiveEngimon()->getSpecies().getSlogan()<<endl;
}