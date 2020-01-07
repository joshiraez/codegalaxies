package game.model;

import game.CPULevel;

public class CPUPlayer extends Player {

    private final CPULevel level;

    private CPUPlayer(final CPULevel level) {
        this.level = level;
    }

    public static CPUPlayer ofLevel(final CPULevel level) {
        return new CPUPlayer(level);
    }
}
