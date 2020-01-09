package game.model;

public class Game {

    private final Board board;
    private final Deck deck;

    public Game(final Board board, final Deck deck) {
        this.board = board;
        this.deck = deck;
    }

    public Board getBoard() {
        return board;
    }

    public Deck getDeck() {
        return deck;
    }
}
