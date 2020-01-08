package game;

import game.model.CPUPlayer;
import game.model.Game;
import game.model.HumanPlayer;
import game.model.PlayerFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

final class GameHandlerShould {

    private PlayerFactory playerFactory = spy(new PlayerFactory());
    private GameHandler handler = new GameHandler(playerFactory);

    @ParameterizedTest
    @EnumSource(value = CPULevel.class)
    void thatNewGameCPUBringsANewGameForEachCPULevel(CPULevel level) {
        Game newGame = handler.createGameCPU(level);

        assertThat(newGame)
                .as("Create CPU game %s level", level)
                .isNotNull();
    }

    @Test
    void delegateConstructionOfHumanPlayerToPlayerFactory() {
        //When
        handler.createGameCPU(CPULevel.BEGINNER);
        //Then
        verify(playerFactory).getInitialHumanPlayer();
    }

    @ParameterizedTest
    @EnumSource(value = CPULevel.class)
    void delegateConstructionOfCPUPlayerToPlayerFactory(CPULevel level) {
        //When
        handler.createGameCPU(level);
        //Then
        verify(playerFactory).getInitialCPUPlayer(level);
    }

    @ParameterizedTest
    @EnumSource(value = CPULevel.class)
    void thatNewGameCPUHasABoard(CPULevel level) {
        Game newGame = handler.createGameCPU(level);

        assertThat(newGame.getBoard())
                .as("CPU game %s level has board", level)
                .isNotNull();
    }

    @ParameterizedTest
    @EnumSource(value = CPULevel.class)
    void thatNewGameCPUBoardHasTwoPlayers(CPULevel level) {
        Game newGame = handler.createGameCPU(level);

        assertThat(newGame.getBoard().getPlayers().size())
                .as("CPU game %s level's board has 2 players", level)
                .isEqualTo(2);
    }

    @ParameterizedTest
    @EnumSource(value = CPULevel.class)
    void thatNewGameCPUPlayer2IsACPUPlayerOfTheGivenLevel(CPULevel level) {
        Game newGame = handler.createGameCPU(level);

        assertThat(newGame.getBoard().getPlayers().get(1))
                .as("CPU game %s level has cpu player of level %s", level, level)
                .isEqualToComparingFieldByFieldRecursively(CPUPlayer.initialCPUPlayer(level));
    }

    @ParameterizedTest
    @EnumSource(value = CPULevel.class)
    void thatNewGameCPUPlayer1IsAPlayerWithTheStartingResources(CPULevel level) {
        Game newGame = handler.createGameCPU(level);

        assertThat(newGame.getBoard().getPlayers().get(0))
                .as("CPU game %s level has player with starting resources")
                .isEqualToComparingFieldByFieldRecursively(new HumanPlayer(2, 2, 1));
    }


//    @ParameterizedTest
//    @EnumSource(value = CPULevel.class)
//    void thatNewGameCPUHasABoard(CPULevel level) {
//        Game newGame = handler.createGameCPU(level);
//
//        assertThat(newGame).has(boardOf(level));
//    }
//
//
//    private static Condition<Game> boardOf (CPULevel level) {
//        Predicate<Game> condition = (Game game) -> game.getBoard() != null;
//
//        return new Condition(condition, "CPU game %s level has board", level);
//    }
}
