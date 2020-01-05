package game.model;

import game.CPULevel;

import java.util.Arrays;
import java.util.List;

public class Board {

    private List<Player> players;
//    private Planets planets;
//    private ActionPanel actionPanel;

    public List<Player> getPlayers() {
        return players;
    }

    public static Board newOfCPULevel(CPULevel level) {
        Board newBoard = new Board();

        newBoard.players = Arrays.asList(new Player(), new Player());

        return newBoard;
    }

}
