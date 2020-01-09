package game;

import game.model.Game;
import game.model.PlayerFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

final class GameHandlerShould {

    private PlayerFactory playerFactory = spy(new PlayerFactory());
    private DeckFactory deckFactory = spy(new DeckFactory());
    private GameHandler handler = new GameHandler(playerFactory, deckFactory);

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
    void thatNewGameCPUBoardHas4Cards(CPULevel level) {
        //When
        final Game gameCPU = handler.createGameCPU(level);
        //Then
        assertThat(gameCPU.getBoard().getCards().size())
                .as("CPU game %s level's board has 4 galaxy cards", level)
                .isEqualTo(4);
    }

    @ParameterizedTest
    @EnumSource(value = CPULevel.class)
    void thatNewGameHasADeckOfGalaxyCards(CPULevel level) {
        //When
        final Game gameCPU = handler.createGameCPU(level);
        //Then
        assertThat(gameCPU.getDeck())
                .as("CPU game %s level has a deck", level)
                .isNotNull();
    }

    @Test
    void thatGameHandlerDelegatesTheGenerationOfDeckToDeckFactory() {
        //When
        handler.createGameCPU(CPULevel.BEGINNER);
        //Then
        verify(deckFactory).getGalaxyDeck();
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
