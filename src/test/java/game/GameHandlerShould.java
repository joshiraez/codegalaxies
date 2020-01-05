package game;

import game.model.Game;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

final class GameHandlerShould {

    private GameHandler handler = new GameHandler();

    @ParameterizedTest
    @EnumSource(value = CPULevel.class)
    void thatNewGameCPUBringsANewGameForEachCPULevel(CPULevel level) {
        Game newGame = handler.createGameCPU(level);

        assertThat(newGame)
                .as("Create CPU game %s level", level.name())
                .isNotNull();
    }

    @ParameterizedTest
    @EnumSource(value = CPULevel.class)
    void thatNewGameCPUHasABoard(CPULevel level) {
        Game newGame = handler.createGameCPU(level);

        assertThat(newGame.getBoard())
                .as("CPU game %s level has board", level.name())
                .isNotNull();
    }

    @ParameterizedTest
    @EnumSource(value = CPULevel.class)
    void thatNewGameCPUBoardHasTwoPlayers(CPULevel level) {
        Game newGame = handler.createGameCPU(level);

        assertThat(newGame.getBoard().getPlayers().size())
                .as("CPU game %s level's board has 2 players", level.name())
                .isEqualTo(2);
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
