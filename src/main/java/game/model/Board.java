package game.model;

import game.CPULevel;

import java.util.Arrays;
import java.util.List;

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
        return new Board(Arrays.asList(new Player(), CPUPlayer.ofLevel(level)));
    }

}
