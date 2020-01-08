package game.model;

import com.google.common.collect.Lists;
import game.CPULevel;
import game.ColonyEffect;

import static java.util.Arrays.asList;

public class PlayerFactory {
    public HumanPlayer getInitialHumanPlayer() {
        return new HumanPlayer(
                1,
                2,
                2,
                1,
                asList(ColonyEffect.LEVEL_UP_ONLY_ONE_RESOURCE),
                Lists.newArrayList()
        );
    }

    public CPUPlayer getInitialCPUPlayer(final CPULevel level) {
        return CPUPlayer.initialCPUPlayer(level);
    }
}
