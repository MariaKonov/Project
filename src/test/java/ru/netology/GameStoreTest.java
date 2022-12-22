package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("The Sims", "Social simulation game");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldCheckAvailability(){
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("The Sims", "Social simulation game");

        store.containsGame(game);
        store.containsGame(game1);

        boolean expected = true;
        boolean actual = store.containsGame(game);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldShowFalseIfThereIsNoMatches() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        GameStore store1 = new GameStore();
        Game game1 = store1.publishGame("The Sims", "Social simulation game");

        store.containsGame(game);

        assertFalse(store.containsGame(game1));

    }

    @Test
    public void shouldSumPlayedTime() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        Player player1 = new Player("Stepan");

        store.addPlayTime("Petya", 3);
        store.addPlayTime("Stepan", 2);

        int expected = 5;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldAddTimeForOnePlayer() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");

        store.addPlayTime("Petya", 3);
        store.addPlayTime("Petya", 2);

        int expected = 5;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldReturnBestPlayer() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        Player player1 = new Player("Stepan");

        store.addPlayTime("Petya", 0);
        store.addPlayTime("Stepan", 1);

        String expected = ("Stepan");
        String actual = store.getMostPlayer();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNull() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        String expected = null;
        String actual = store.getMostPlayer();
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldBestPlayerFromThree() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        Player player1 = new Player("Stepan");
        Player player2 = new Player("David");
        store.addPlayTime("David", 5);
        store.addPlayTime("Petya", 1);
        store.addPlayTime("Stepan", 3);


        String expected = ("David");
        String actual = store.getMostPlayer();
        Assertions.assertEquals(expected, actual);

    }

}