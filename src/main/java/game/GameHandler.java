package game;

import game.model.Board;
import game.model.CPUPlayer;
import game.model.Deck;
import game.model.Game;
import game.model.HumanPlayer;
import game.model.PlayerFactory;

public class GameHandler {

    private final PlayerFactory playerFactory;
    private final DeckFactory deckFactory;

    public GameHandler(final PlayerFactory playerFactory, final DeckFactory deckFactory) {

        this.playerFactory = playerFactory;
        this.deckFactory = deckFactory;
    }

    public Game createGameCPU(CPULevel level) {
        final HumanPlayer initialHumanPlayer = playerFactory.getInitialHumanPlayer();
        final CPUPlayer cpuPlayer = playerFactory.getInitialCPUPlayer(level);
        final Deck deck = deckFactory.getGalaxyDeck();
        deck.shuffle();
        final Board board = new Board(initialHumanPlayer, cpuPlayer,
                deck.draw(), deck.draw(), deck.draw(), deck.draw());
        return new Game(board, deck);
    }
}
