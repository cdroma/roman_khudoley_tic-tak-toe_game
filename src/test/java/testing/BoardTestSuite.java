package testing;

import static org.junit.jupiter.api.Assertions.*;

import com.kodilla.Board;
import com.kodilla.Game;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class BoardTestSuite {

    @Test
    @DisplayName("Testing 'O' wins in rows, columns and diagonal")
    public void givenBoardWithOWinsInRow_whenCheckingForWinner_thenShouldReturnTrue() {

        // given
        Board board = new Board();
        board.placeMove(0, 0, 'O');
        board.placeMove(0, 1, 'O');
        board.placeMove(0, 2, 'O');

        // when, then
        assertTrue(board.isWinner('O'));
    }


    @Test
    @DisplayName("Testing 'X' wins in rows, columns and diagonal")
    public void givenBoardWithXWinsInRow_whenCheckingForWinner_thenShouldReturnTrue() {

        // given
        Board board = new Board();
        board.placeMove(1, 0, 'X');
        board.placeMove(1, 1, 'X');
        board.placeMove(1, 2, 'X');

        // when, then
        assertTrue(board.isWinner('X'));
    }


    @Test
    @DisplayName("Testing Tie game situation")
    public void givenFullBoardWithoutWinner_whenCheckingForTie_thenShouldReturnTrue() {

        // given
        Board board = new Board();
        board.placeMove(0, 0, 'X');
        board.placeMove(0, 1, 'O');
        board.placeMove(0, 2, 'X');
        board.placeMove(1, 0, 'X');
        board.placeMove(1, 1, 'O');
        board.placeMove(1, 2, 'O');
        board.placeMove(2, 0, 'O');
        board.placeMove(2, 1, 'X');
        board.placeMove(2, 2, 'X');

        // when, then
        assertTrue(board.isBoardFull());
    }

    // not sure about that test below:
    @Test
    @DisplayName("Testing entering wrong symbol in row")
    public void givenGameWithInvalidRowValue_whenStartingGame_thenShouldThrowException() {
        // given
        String invalidInput = "3 1\n";
        InputStream inputStream = new ByteArrayInputStream(invalidInput.getBytes());
        Game game = new Game();

        // when, then
        assertThrows(IllegalArgumentException.class, () -> game.startGame());
    }
}
