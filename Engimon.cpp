#include "Engimon.h"
//4 sekawan
int Engimon::totalEngimon = 0;
Engimon::Engimon() : id(totalEngimon+1){
    this->setName("None");
    this->setParent(nullptr,nullptr);
    this->setSpecies(Species());
    this->addSkill(Skill());
    this->addSkill(species.getUniqueSkill());
    this->addElement(Element());
    this->setLevel(0);
    this->setExp(0);
    this->setCumulativeExp(0);
    this->setExpLimit(0);
}

Engimon::Engimon(string name, Engimon* parent1, Engimon* parent2, Species species, vector<Skill> skills, vector<Element> elements, int level, int explimit) : id(totalEngimon+1){
    this->setName(name);
    this->setParent(parent1,parent2);
    this->setSpecies(species);
    this->addSkill(skills);
    this->addSkill(species.getUniqueSkill());
    this->addElement(elements);
    this->setLevel(level);
    this->setExp(0);
    this->setCumulativeExp(this->getLevel()*100);
    this->setExpLimit(explimit);
}

Engimon::Engimon(const Engimon& e) : id(e.id){
    this->setName(e.name);
    this->setParent(e.parents[0],e.parents[1]);
    this->setSpecies(e.species);
    this->addSkill(e.skills);
    this->addElement(e.elements);
    this->setLevel(level);
    this->setExp(0);
    this->setCumulativeExp(this->getLevel()*100);
    this->setExpLimit(e.explimit);
}

Engimon::~Engimon(){}

Engimon& Engimon::operator=(const Engimon& e){
    this->setName(e.name);
    this->setParent(e.parents[0],e.parents[1]);
    this->setSpecies(e.species);
    this->addSkill(e.skills);
    this->addElement(e.elements);
    this->setLevel(level);
    this->setExp(0);
    this->setCumulativeExp(this->getLevel()*100);
    this->setExpLimit(e.explimit);
    return *this;
}

//setter
void Engimon::setName(string name){
    this->name = name;
}
void Engimon::setParent(Engimon* e1, Engimon* e2){
    this->parents.push_back(e1);
    this->parents.push_back(e2);
}
void Engimon::setSpecies(Species s){
    this->species = s;
}
void Engimon::addSkill(Skill s){
    if (this->skills.size() < 4 ){
        if (this->hasSkill(s)==false){
            this->skills.push_back(s);
            sort(this->skills.begin(), this->skills.end());
            reverse(this->skills.begin(), this->skills.end());
        }
        else{
            //exception : sudah punya skill tsb
            //kayanya ngga usah diimplemen, biar simple
        }
    }
    else{
        //exception : skill slot full
        this->replaceSkill(s);
    }
}
void Engimon::addSkill(vector<Skill> vs){
    for (int i=0; i<vs.size();i++){
        this->addSkill(vs[i]);
    }
}
void Engimon::addElement(Element e){
    if (this->isElement(e) == false){
        this->elements.push_back(e);
    }
}
void Engimon::addElement(vector<Element> ve){
    for (int i=0; i<ve.size();i++){
        this->addElement(ve[i]);
    }
}
void Engimon::levelUp(){
    this->exp -= 100;
    this->level++;
}
void Engimon::setLevel(int lvl){
    this->level = lvl;
}
void Engimon::addExp(int exp){
    this->exp += exp;
    this->cumulativeExp +=exp;
    while (this->lvlUpEligibility()){
        this->levelUp();
    }
    if (this->isDead()){
        //idk, maybe some exception or something?
    }
}
void Engimon::setExp(int exp){
    this->exp = exp;
}
void Engimon::setCumulativeExp(int cumxp){
    this->cumulativeExp = cumxp;
}
void Engimon::setExpLimit(int explimit){
    this->explimit = explimit;
}

//getter
int Engimon::getId(){
    return this->id;
}
string Engimon::getName(){
    return this->name;
}
vector<Engimon*> Engimon::getParents(){
    return this->parents;
}
Species Engimon::getSpecies(){
    return this->species;
}
vector<Skill> Engimon::getSkills(){
    return this->skills;
}
vector<Element> Engimon::getElements(){
    return this->elements;
}
int Engimon::getLevel(){
    return this->level;
}
int Engimon::getExp(){
    return this->exp;
}
int Engimon::getCumulativeExp(){
    return this->cumulativeExp;
}
int Engimon::getCumExpLimit(){
    return this->explimit;
}

Skill Engimon::getHighestMasteryLevel(){
    Skill maxSkill = this->skills[0];
    int max = this->skills[0].getMasteryLevel();
    for (int i = 1; i < this->skills.size() ; i++){
        if (max < this->skills[i].getMasteryLevel()){
            max = this->skills[i].getMasteryLevel();
            maxSkill = this->skills[i];
        }
    }
    return maxSkill;
}

//get status
bool Engimon::lvlUpEligibility(){
    return this->exp>=100;
}
bool Engimon::isDead(){
    return (this->getCumulativeExp() >= this->getCumExpLimit());
}
bool Engimon::isElement(Element e){
    vector<Element> el = this->getElements();
    for (int i=0 ; i<el.size() ; i++){
        if (el[i].getElementName() == e.getElementName()){
            return true;
        }
    }
    return false;
}

bool Engimon::hasSkill(Skill s){
    for (int i = 0 ; i < this->skills.size() ; i++){
        if (this->skills[i].getSkillName() == s.getSkillName()){
            return true;
        }
    }
    return false;
}

//delete
void Engimon::replaceSkill(Skill s) {
    string input;
    int idx;
    cout << "Skill Engimon penuh, Apakah player ingin mengganti skill yang ada? (Y/N) : ";
    do {
        cin >> input;
    } while (input != "Y" && input != "N");
    if (input == "Y") {
        this->printSkill();
        cout << "Pilih skill yang akan diganti (By index) : ";
        do {
            cin >> idx;
        } while (idx < 1 || idx > this->skills.size());
        this->skills.erase(this->skills.begin() + (idx-1));
        this->addSkill(s);
        cout << "Skill telah diganti" << endl;
    }
}

//output func
void Engimon::printDetail(){
    cout<<"Nama Engimon"<<"\t: "<<this->getName()<<endl;
    if (this->getParents()[0] != nullptr && this->getParents()[1]!=nullptr){
        for (int i=0 ; i<2 ; i++){
            cout<<"Parent "<<i+1<<"\t: "<<this->getParents()[i]->getName()<<" ("<<this->getParents()[i]->getSpecies().getSpeciesName()<<")"<<endl;
        }
    }
    cout<<"Spesies"<<"\t\t: "<<this->getSpecies().getSpeciesName()<<endl;
    cout<<"Skill\t\t: ";
    for (int i=0;i<this->getSkills().size();i++){
        if (i<this->getSkills().size()-1){
            cout<<this->getSkills()[i].getSkillName()<<", ";
        }
        else{
            cout<<this->getSkills()[i].getSkillName()<<endl;
        }
        
    }
    cout<<"Element\t\t: ";
    for (int i=0;i<this->getElements().size();i++){
        if (i<this->getElements().size()-1){
            cout<<this->getElements()[i].getElementName()<<", ";
        }
        else{
            cout<<this->getElements()[i].getElementName()<<endl;
        }
        
    }
    cout<<"Level"<<"\t\t: "<<this->getLevel()<<endl;
    cout<<"Experience"<<"\t: "<<this->getExp()<<endl;
    cout<<"Cumulative Exp."<<"\t: "<<this->getCumulativeExp()<<endl;

}

void Engimon::printSkill() {
    cout << "Skill\t\t: " << endl;
    for (int i=0; i<this->getSkills().size(); i++){
        cout << (i+1) << ". " << this->getSkills()[i].getSkillName() << endl;
    }
}