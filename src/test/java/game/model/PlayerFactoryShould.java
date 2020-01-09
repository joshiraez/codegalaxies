package game.model;

import game.CPULevel;
import game.ColonyEffect;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.emptyList;

class PlayerFactoryShould {

    PlayerFactory factory = new PlayerFactory();

    @ParameterizedTest
    @EnumSource(value = CPULevel.class)
    void haveInitialCPUPlayerOfTheGivenLevel(CPULevel level) {
        //When
        Player cpuPlayer = factory.getInitialCPUPlayer(level);
        //Then
        assertThat(cpuPlayer)
                .as("CPU game %s level has cpu player of level %s", level, level)
                .isEqualToComparingFieldByFieldRecursively(CPUPlayer.initialCPUPlayer(level));
    }

    @Test
    void haveInitialHumanPlayerWithTheInitialResourcesForHumanPlayers() {
        //When
        Player humanPlayer = factory.getInitialHumanPlayer();
        //Then
        assertThat(humanPlayer)
                .as("CPU game %s level has player with starting resources")
                .isEqualToComparingFieldByFieldRecursively(
                        humanPlayerWithExpectedStartingResources()
                );
    }

    private HumanPlayer humanPlayerWithExpectedStartingResources() {
        return new HumanPlayer(
                1,
                2,
                4,
                2,
                1,
                asList(ColonyEffect.LEVEL_UP_ONLY_ONE_RESOURCE),
                emptyList()
        );
    }
}
