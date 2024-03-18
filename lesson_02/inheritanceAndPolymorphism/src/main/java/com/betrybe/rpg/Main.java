package com.betrybe.rpg;

public class Main {

  public static void main(String[] args) {
    Warrior warrior = new Warrior();
    Cleric cleric = new Cleric();

    moveAndAttack(warrior);
    moveAndAttack(cleric);
  }

  public static void moveAndAttack(PlayableCharacter player) {
    player.move();
    player.attack();
  }
}
