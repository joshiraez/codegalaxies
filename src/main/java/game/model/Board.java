package game.model;

import game.GalaxyCard;

import java.util.List;

import static java.util.Arrays.asList;

public class Board {

    private final List<Player> players;
    private final List<GalaxyCard> galaxyCards;
    //    private ActionPanel actionPanel;

    public Board(final HumanPlayer initialHumanPlayer,
                 final CPUPlayer cpuPlayer,
                 final GalaxyCard galaxyCard1,
                 final GalaxyCard galaxyCard2,
                 final GalaxyCard galaxyCard3,
                 final GalaxyCard galaxyCard4) {
        players = asList(initialHumanPlayer, cpuPlayer);
        galaxyCards = asList(galaxyCard1, galaxyCard2, galaxyCard3, galaxyCard4);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<GalaxyCard> getCards() {
        return galaxyCards;
    }
}
