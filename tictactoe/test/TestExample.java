import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.beans.Transient;
import java.util.Random;

import model.RowBlockModel;
import controller.RowGameController;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * An example test class, which merely shows how to write JUnit tests.
 */
public class TestExample {
    private RowGameController game;
    private String playerTwoWinPhrase = "Player 2 wins!";
    private String playerOneWinPhrase = "Player 1 wins!";

    @Before
    public void setUp() {
        game = new RowGameController();
    }

    @After
    public void tearDown() {
        game = null;
    }

    @Test
    public void testNewGame() {
        assertEquals(true, game.gameModel.isPlayerOneTurn());
        assertEquals(9, game.gameModel.movesLeft);

        for (RowBlockModel[] rr : game.gameModel.blocksData) {
            for (RowBlockModel r : rr) {
                assertEquals("", r.getContents());
            }
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewBlockViolatesPrecondition() {
        RowBlockModel block = new RowBlockModel(null);
    }

    @Test
    public void testLegalMove() {
        int[][] arr = { { 0, 0 } };
        setBlocks(arr, "X");
        assertEquals("X", game.gameModel.blocksData[0][0].getContents());
    }

    @Test
    public void testIllegalMove() {
        game.move(game.gameView.blocks[0][0]);
        game.move(game.gameView.blocks[0][0]);
        assertEquals("X", game.gameModel.blocksData[0][0].getContents());
    }

    @Test
    public void testXWin() {
        int[][] arr = { { 0, 0 }, { 0, 1 }, { 0, 2 } };
        setBlocks(arr, "X");
        game.checkWin();
        assertEquals(this.playerOneWinPhrase, game.gameModel.getFinalResult());
    }

    @Test
    public void testOWin() {
        int[][] arr = { { 0, 0 }, { 0, 1 }, { 0, 2 } };
        setBlocks(arr, "O");
        game.checkWin();
        assertEquals(this.playerTwoWinPhrase, game.gameModel.getFinalResult());
    }

    @Test
    public void testTie() {
        int[][] xMoves = { { 0, 0 }, { 2, 0 }, { 0, 2 }, { 1, 2 }, { 2, 1 } };
        int[][] yMoves = { { 1, 0 }, { 0, 1 }, { 1, 1 }, { 2, 2 } };
        setBlocks(xMoves, "X");
        setBlocks(yMoves, "O");
        game.checkWin();
        assertEquals(game.gameModel.GAME_END_NOWINNER, game.gameModel.getFinalResult());
    }

    @Test
    public void testReset() {
        addGarbageData();
        game.resetGame();

        assertEquals(true, game.gameModel.isPlayerOneTurn());
        assertEquals(9, game.gameModel.movesLeft);

        for (RowBlockModel[] rr : game.gameModel.blocksData) {
            for (RowBlockModel r : rr) {
                assertEquals("", r.getContents());
            }
        }
    }

    @Test
    public void testSwitchPlayers() {
        assertEquals(true, game.gameModel.isPlayerOneTurn());
        game.move(game.gameView.blocks[0][0]);
        assertEquals(false, game.gameModel.isPlayerOneTurn());
    }

    @Test
    public void testMovesLeftDecrement() {
        assertEquals(9, game.gameModel.movesLeft);
        game.move(game.gameView.blocks[0][0]);
        assertEquals(8, game.gameModel.movesLeft);
    }

    @Test
    public void testPlayerIndicatorMatchesPlayer() {
        game.move(game.gameView.blocks[0][0]);
        assertEquals("'O': Player 2", game.gameView.playerturn.getText());
        game.move(game.gameView.blocks[0][1]);
        assertEquals("'X': Player 1", game.gameView.playerturn.getText());
    }

    @Test
    public void testEndGameDisablesAllButtons() {
        game.endGame();

        for (JButton[] bb : game.gameView.blocks) {
            for (JButton b : bb) {
                assertEquals(false, b.isEnabled());
            }
        }
    }

    private void addGarbageData() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                game.gameModel.blocksData[x][y].setContents(getRandomVariable());
            }
        }
    }

    private String getRandomVariable() {
        Random r = new Random();
        return r.nextInt(2) == 1 ? "O" : "X";
    }

    private void setBlocks(int[][] arr, String s) {
        for (int x = 0; x < arr.length; x++) {
            game.gameModel.blocksData[arr[x][0]][arr[x][1]].setContents(s);
        }
    }

}
