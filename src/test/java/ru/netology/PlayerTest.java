package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void NameTest() {
        Player player = new Player("Petya");
        player.getName();

        Assertions.assertEquals("Petya", player.getName());
    }

    @Test
    public void CheckingPlaybackWithoutInstallation() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Баттл", "Аркады");

        Player player = new Player("Alex");

        assertThrows(RuntimeException.class, () -> player.play(game, 2));
    }

    @Test
    public void thePlaybackCheckIsZero() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Баттл", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game1);
        player.play(game, 0);
        player.play(game1, 0);

        int expected = 0;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void checkingAGameOfTheSameGenreForTheSumOfHours() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Баттл", "Аркады");

        Player player = new Player("Alex");
        player.installGame(game);
        player.installGame(game1);
        player.play(game, 2);
        player.play(game1, 3);

        int expected = 5;
        int actual = player.sumGenre("Аркады");
        assertEquals(expected, actual);
    }

    @Test
    public void checkingAGameOfTheSameGenreForTheSumOfHours2() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Баттл", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game1);
        player.play(game, 0);
        player.play(game1, 1);

        int expected = 1;
        int actual = player.sumGenre("Аркады");
        assertEquals(expected, actual);
    }

    @Test
    public void checkingAGameOfTheSameGenreForTheSumOfHours5() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("ММММММ", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, -1);

        String expected = null;
        Game actual = player.mostPlayerByGenre("Аркады");
        assertEquals(expected, actual);
    }
}
