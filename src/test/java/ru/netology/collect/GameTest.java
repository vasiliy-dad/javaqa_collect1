package ru.netology.collect;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void shouldWhenPlayerOneWinner() {
        Player andrey = new Player(12, "andrey45", 6);
        Player misha = new Player(15, "Miha24", 5);
        Game game = new Game();

        game.register(andrey);
        game.register(misha);

        int expected = 1;
        int actual = game.round("andrey45", "Miha24");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWhenPlayerTwoWinner() {
        Player andrey = new Player(12, "andrey45", 5);
        Player misha = new Player(15, "Miha24", 6);
        Game game = new Game();

        game.register(andrey);
        game.register(misha);

        int expected = 2;
        int actual = game.round("andrey45", "Miha24");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWhenBothPlayersEquals() {
        Player andrey = new Player(12, "andrey45", 5);
        Player misha = new Player(15, "Miha24", 5);
        Game game = new Game();

        game.register(andrey);
        game.register(misha);

        int expected = 0;
        int actual = game.round("andrey45", "Miha24");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWhenPlayerOneNotRegistered() {
        Player andrey = new Player(12, "andrey45", 5);
        Game game = new Game();

        game.register(andrey);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("petya16", "andrey45")
        );
    }

    @Test
    public void shouldWhenPlayerTwoNotRegistered() {
        Player andrey = new Player(12, "andrey45", 5);
        Game game = new Game();

        game.register(andrey);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("andrey45", "petya16")
        );
    }
}
