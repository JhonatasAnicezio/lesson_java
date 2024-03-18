package com.betrybe.rpg;

public class Main {

  public static void main(String[] args) {
//    Warrior warrior = new Warrior();
//    Cleric cleric = new Cleric();
//    Barbarian barbarian = new Barbarian();
//
//    moveAndAttack(warrior);
//    moveAndAttack(cleric);
//    moveAndAttack(barbarian);

    Cleric cleric = new Cleric();
    cleric.heal();
    cleric.heal("Porção de vida");
    cleric.heal("Feitiço de luz", 7);
  }

//  public static void moveAndAttack(PlayableCharacter player) {
//    player.move();
//    player.attack();
//  }
}
