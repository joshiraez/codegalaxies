package game;

import game.model.Board;
import game.model.CPUPlayer;
import game.model.Deck;
import game.model.Game;
import game.model.HumanPlayer;
import game.model.PlayerFactory;

public class GameHandler {

    private final PlayerFactory playerFactory;

    public GameHandler(final PlayerFactory playerFactory) {

        this.playerFactory = playerFactory;
    }

    public Game createGameCPU(CPULevel level) {
        final HumanPlayer initialHumanPlayer = playerFactory.getInitialHumanPlayer();
        final CPUPlayer cpuPlayer = playerFactory.getInitialCPUPlayer(level);
        final Board board = new Board(initialHumanPlayer, cpuPlayer);
        final Deck deck = new Deck();
        return new Game(board, deck);
    }
}
