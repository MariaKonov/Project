package ru.netology;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameStoreTest {
    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    // другие ваши тесты
}

