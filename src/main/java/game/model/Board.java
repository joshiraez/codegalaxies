package game.model;

import game.CPULevel;

import java.util.List;

import static game.model.CPUPlayer.initialCPUPlayer;
import static game.model.HumanPlayer.initialHumanPlayer;
import static java.util.Arrays.asList;

public class Board {

    private List<Player> players;
//    private Planets planets;
//    private ActionPanel actionPanel;

    private Board(final List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    static Board newOfCPULevel(final CPULevel level) {
        return new Board(asList(initialHumanPlayer(), initialCPUPlayer(level)));
    }

}
