package game.model;

import game.CPULevel;

public class PlayerFactory {
    public HumanPlayer getInitialHumanPlayer() {
        return new HumanPlayer(2, 2, 1);
    }

    public CPUPlayer getInitialCPUPlayer(final CPULevel level) {
        return CPUPlayer.initialCPUPlayer(level);
    }
}
