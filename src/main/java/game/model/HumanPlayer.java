package game.model;

import game.ColonyEffect;
import game.GalaxyCard;

import java.util.List;

public class HumanPlayer implements Player {

    private final int level;
    private final int ships;
    private final int energy;
    private final int culture;
    private final List<ColonyEffect> colonyActions;
    private final List<GalaxyCard> capturedCards;

    public HumanPlayer(
            final int level,
            final int ships,
            final int energy,
            final int culture,
            final List<ColonyEffect> colonyActions,
            final List<GalaxyCard> capturedCards) {
        this.level = level;
        this.ships = ships;
        this.energy = energy;
        this.culture = culture;
        this.colonyActions = colonyActions;
        this.capturedCards = capturedCards;
    }

}
