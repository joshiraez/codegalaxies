package game.model;

import java.util.List;

import static java.util.Arrays.asList;

public class Board {

    private List<Player> players;
//    private Planets planets;
//    private ActionPanel actionPanel;

    public Board(final HumanPlayer initialHumanPlayer, final CPUPlayer cpuPlayer) {
        players = asList(initialHumanPlayer, cpuPlayer);
    }

    public List<Player> getPlayers() {
        return players;
    }
}
