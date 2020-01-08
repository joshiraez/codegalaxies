package game.model;

import game.CPULevel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

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
                .isEqualToComparingFieldByFieldRecursively(new HumanPlayer(2, 2, 1));
    }
}
