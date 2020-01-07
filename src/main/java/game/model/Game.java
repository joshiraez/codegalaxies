package game.model;

import game.CPULevel;

public class Game {

    private final Board board;

    public Game(final Board board) {
        this.board = board;
    }

    public static Game ofCPULevel(CPULevel level) {

        return new Game(Board.newOfCPULevel(level));
    }

    public Board getBoard() {
        return board;
    }
}
