package game.model;

import game.CPULevel;

public class Game {

    private Board board;

    private Game() {}

    public static Game ofCPULevel(CPULevel level) {
        Game game = new Game();

        game.board = new Board();

        return game;
    }

    public Board getBoard() {
        return board;
    }
}
