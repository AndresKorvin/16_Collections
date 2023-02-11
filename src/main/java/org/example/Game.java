package org.example;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> registeredPlayers = new ArrayList<>();

    protected ArrayList<Player> getRegisteredPlayers() {
        return registeredPlayers;
    }

    public void register(Player player) {
        registeredPlayers.add(player);
    }

    public Player findPlayerByName(String playerName) {
        for (Player player :
                registeredPlayers) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findPlayerByName(playerName1);
        Player player2 = findPlayerByName(playerName2);
        int winner;

        if (player1 == null) {
            throw new NotRegisteredException(
                    "Player with name: " + playerName1 + " not found"
            );
        } else if (player2 == null) {
            throw new NotRegisteredException(
                    "Player with name: " + playerName2 + " not found"
            );
        } else {
            if (player1.getStrength() > player2.getStrength()) {
                winner = 1;
            } else if (player1.getStrength() < player2.getStrength()) {
                winner = 2;
            } else {
                winner = 0;
            }
        }
        return winner;
    }

}
