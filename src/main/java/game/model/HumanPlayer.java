package game.model;

public class HumanPlayer implements Player {
    private final int ships;
    private final int energy;
    private final int culture;

    public HumanPlayer(final int ships, final int energy, final int culture) {

        this.ships = ships;
        this.energy = energy;
        this.culture = culture;
    }

    static HumanPlayer initialHumanPlayer() {
        return new HumanPlayer(2, 2, 1);
    }
}
