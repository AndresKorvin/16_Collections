package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

class GameTest {
    Player player1 = new Player(1,"Михаил Архистратиг", 90);
    Player player2 = new Player(2,"Гавриил", 80);
    Player player3 = new Player(3,"Рафаил", 60);
    Player player4 = new Player( 4,"Уриил", 60);
    Player player5 = new Player( 5,"Селафиил", 50);
    Player player6 = new Player( 6,"Иеремиил", 40);
    Player [] expected = { player1, player6, player2, player5 };
    Game game = new Game();


    @Test
    void register() {

        game.register(player1);
        game.register(player6);
        game.register(player2);
        game.register(player5);

        Player [] actual = game.getRegPlayers().values().toArray(new Player[0]);

        Arrays.sort(actual);
        Arrays.sort(expected);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void findPlayerByName() {

        game.register(player1);
        game.register(player6);
        game.register(player2);
        game.register(player5);

        Player player = game.findPlayerByName("Гавр");

        Assertions.assertEquals(player, null);
    }

    @ParameterizedTest
    @CsvSource({
            "Михаил Архистратиг, Селафиил, 1",
            "Иеремиил, Гавриил, 2",
            "Рафаил, Уриил, 0"
    })

    void round(String playerName1, String playerName2, int expected) {

        game.register(player1);
        game.register(player6);
        game.register(player2);
        game.register(player5);
        game.register(player3);
        game.register(player4);

        int actual = game.round( playerName1, playerName2 );

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "Уриил, Вася",
            "Толик, Селафиил"
    })

    void Exception(String playerName1, String playerName2) {

        game.register(player1);
        game.register(player6);
        game.register(player2);
        game.register(player5);
        game.register(player3);
        game.register(player4);

        Assertions.assertThrows(NotRegisteredException.class,() ->{
            game.round(playerName1, playerName2);
        });
    }

    @Test
    void findByIde() {

        game.register(player1);
        game.register(player6);
        game.register(player2);
        game.register(player5);

        int expected = 1;
        int actual = player1.getId();

        Assertions.assertEquals(expected, actual);
    }
}