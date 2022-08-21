package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
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

    // другие ваши тесты

    @Test
    public void shouldSumGenreIfNoGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл Онлайн 2", "Аркады 2");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 0;
        int actual = player.sumGenre(game2.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfTwoGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл Онлайн 2", "Аркады 2");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game2);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldPlaySumTime() { //

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 5;
        int actual = player.play(game, 2);
        assertEquals(expected, actual);


    }

    @Test
    public void shouldPlayIfException() { //

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");

        assertThrows(RuntimeException.class, () -> {
            player.play(game, 2);

        });
    }

    @Test
    public void shouldMostPlayerByGenre() {

        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн 1", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл Онлайн 2", "Аркады 2");
        Game game3 = store.publishGame("Нетология Баттл Онлайн 3", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);

        player.play(game1, 3);
        player.play(game3, 1);
        player.installGame(game1);   // повторно добавила игру, которая уже установлена, чтобы проверить метод installGame

        assertEquals(game1, player.mostPlayerByGenre("Аркады"));
    }

    @Test
    public void shouldMostPlayerByGenreIfNoGenre() {

        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн 1", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл Онлайн 2", "Аркады 2");
        Game game3 = store.publishGame("Нетология Баттл Онлайн 3", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);

        player.play(game1, 3);
        player.play(game3, 1);

        assertEquals(null, player.mostPlayerByGenre("Аркады 2"));
    }

}
