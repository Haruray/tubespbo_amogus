#include "Enemy.h"
#include <iostream>
#include <stdlib.h>

void Enemy::setPosX(int x){
    this->position.x = x;
}
void Enemy::setPosY(int y){
    this->position.y = y;
}
int Enemy::getPosX(){
    return this->position.x;
}
int Enemy::getPosY(){
    return this->position.y;
}
string Enemy::getLogo(Player P){
    return "???";
}
void Enemy::moveUp(){
    this->position.y += 1;
}
void Enemy::moveDown(){
    this->position.y -= 1;
}
void Enemy::moveRight(){
    this->position.x += 1;
}
void Enemy::moveLeft(){
    this->position.x -= 1;
}
void Enemy::randomMove(){
    int x = rand();
    switch (x % 4)
    {
    case 0:
        moveUp();
        break;
    case 1:
        moveDown();
        break;
    case 2:
        moveRight();
        break;
    case 3:
        moveLeft();
        break;
    default:
        cout << "Fail";
        break;
    }
}