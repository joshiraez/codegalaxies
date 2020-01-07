package game.model;

import game.CPULevel;

public class CPUPlayer implements Player {

    private final CPULevel level;

    private CPUPlayer(final CPULevel level) {
        this.level = level;
    }

    public static CPUPlayer initialCPUPlayer(final CPULevel level) {
        return new CPUPlayer(level);
    }
}
