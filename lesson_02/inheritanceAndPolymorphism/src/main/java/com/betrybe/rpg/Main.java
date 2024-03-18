package com.betrybe.rpg;

public class Main {

  public static void main(String[] args) {
    Warrior warrior = new Warrior();
    warrior.move();
    warrior.attack();

    Mage mage = new Mage();
    mage.move();
    mage.attack();
  }

  public void moveAndAttack(PlayableCharacter player) {
    player.move();
    player.attack();
  }
}
