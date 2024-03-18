package com.betrybe.rpg;

public class Main {

  public static void main(String[] args) {
    Warrior player1 = new Warrior();
    PlayableCharacter player2 = new Warrior();

    addInformation(player1);
    addInformation(player2);
  }

  public static void addInformation(PlayableCharacter player) {
      player.setName("Aragon");
      player.setRace("Humano");
  }
}
