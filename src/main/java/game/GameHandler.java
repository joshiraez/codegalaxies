package game;

import game.model.Game;

public class GameHandler {

    public Game createGameCPU(CPULevel level) {
        return Game.ofCPULevel(level);
    }

}
