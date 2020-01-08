package game.model;

public class Game {

    private final Board board;

    public Game(final Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }
}
