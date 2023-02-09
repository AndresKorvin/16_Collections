package org.example;

import java.util.HashMap;

public class Game {
    private HashMap<String, Player> regPlayers = new HashMap<>();

    protected HashMap<String, Player> getRegPlayers() {
        return regPlayers;
    }

    public void register (Player player) {
        regPlayers.put(player.getName(), player);
    }

    public Player findPlayerByName (String playerName) {
        for (String key :
                regPlayers.keySet()) {
            if (key.equals(playerName)) {
                return regPlayers.get(key);
            }
        }
        return null;
    }

    public int round (String playerName1, String playerName2) {
        Player player1 = findPlayerByName(playerName1);
        Player player2 = findPlayerByName(playerName2);
        int winner;

        if ( player1 == null ) {
            throw new NotRegisteredException (
                    "Player with name: " + playerName1 + " not found"
            );
        } else if ( player2 == null ) {
            throw new NotRegisteredException (
                    "Player with name: " + playerName2 + " not found"
                    );
        } else {
            if (player1.getStrength() > player2.getStrength()) winner = 1;
            else if (player1.getStrength() < player2.getStrength()) winner = 2;
            else winner = 0;
        }
        return winner;
    }

}
