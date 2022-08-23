package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл Онлайн2", "Аркады");
        Game game3 = store.publishGame("Нетология Баттл Онлайн3", "Аркады");

        assertTrue(store.containsGame(game3));
    }

    // другие ваши тесты

    @Test
    public void shouldNotFindNonExistentGame() {

        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = new Game("Нетология Баттл Онлайн 2", "Аркады", store);

        assertFalse(store.containsGame(game2));
    }

    @Test
    public void shouldAddPlayTimeFirstTime() {

        GameStore store = new GameStore();

        store.addPlayTime("Petr",  5);

        int expected = 5;
        int actual = store.getSumPlayedTime();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddPlayTimeSecondTime() {

        GameStore store = new GameStore();

        store.addPlayTime("Petr",  5);
        store.addPlayTime("Petr",  10);

        int expected = 15;
        int actual = store.getSumPlayedTime();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayer() {

        GameStore store = new GameStore();

        store.addPlayTime("Petr",  5);
        store.addPlayTime("Oleg",  10);

        String expected = "Oleg";
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayerIfPlayerHave1Hour() {

        GameStore store = new GameStore();

        store.addPlayTime("Oleg",  1);

        String expected = "Oleg";
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayerIfHoursEqual() {

        GameStore store = new GameStore();

        store.addPlayTime("Petr",  5);
        store.addPlayTime("Oleg",  5);

        String expected = "Petr";
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayerIfNoPlayers() {

        GameStore store = new GameStore();

        assertEquals(null, store.getMostPlayer());
    }

}
