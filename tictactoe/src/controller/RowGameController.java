package controller;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

import model.RowBlockModel;
import model.RowGameModel;
import view.RowGameGUI;

public class RowGameController {
	public RowGameModel gameModel;
	public RowGameGUI gameView;

	private String playerTwoWinPhrase = "Player 2 wins!";
	private String playerOneWinPhrase = "Player 1 wins!";

	/**
	 * Creates a new game initializing the GUI.
	 */
	public RowGameController() {
		gameModel = new RowGameModel();
		gameView = new RowGameGUI(this);

		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 3; column++) {
				gameModel.blocksData[row][column].setContents("");
				gameModel.blocksData[row][column].setIsLegalMove(true);
				gameView.updateBlock(gameModel, row, column);
			}
		}
	}

	/**
	 * Moves the current player into the given block.
	 *
	 * @param block The block to be moved to by the current player
	 */
	public void move(JButton block) {
		int[] arrVals = getCorrectArrValues(block);
		int x = arrVals[0];
		int y = arrVals[1];

		if (gameModel.blocksData[x][y].getContents().equals("")) {
			gameModel.blocksData[x][y].setContents(getPlayerSymbol(gameModel.isPlayerOneTurn()));
			gameView.updateBlock(gameModel, x, y);
			gameModel.movesLeft--;

			adjustPlayerIndicator();
			checkWin();

			gameModel.switchPlayers();
		}
	}

	private void adjustPlayerIndicator() {
		if (gameModel.movesLeft % 2 == 1) {
			gameView.playerturn.setText("'X': Player 1");
		} else {
			gameView.playerturn.setText("'O': Player 2");
		}
	}

	private String getPlayerSymbol(boolean s) {
		return s ? "X" : "O";
	}

	/**
	 * Finds the correct button/block in the array
	 */

	private int[] getCorrectArrValues(JButton block) {
		int[] toReturn = { -1, -1 };
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if (block == gameView.blocks[x][y]) {
					toReturn[0] = x;
					toReturn[1] = y;
					return toReturn;
				}
			}
		}
		return toReturn;
	}

	/**
	 * Checks to see if anyone has won the game.
	 */

	public void checkWin() {
		// Check Rows and Columns
		for (int x = 0; x < 3; x++) {
			if (!gameModel.blocksData[x][0].getContents().equals("")) {
				String temp0 = gameModel.blocksData[x][0].getContents();
				String temp1 = gameModel.blocksData[x][1].getContents();
				String temp2 = gameModel.blocksData[x][2].getContents();
				if (temp0.equals(temp1) && temp0.equals(temp2)) {
					endGame();
					gameModel.setFinalResult(getWinningPlayer(temp2));
					gameView.playerturn.setText(gameModel.getFinalResult());
					return;
				}
			}
			if (!gameModel.blocksData[0][x].getContents().equals("")) {
				String temp0 = gameModel.blocksData[0][x].getContents();
				String temp1 = gameModel.blocksData[1][x].getContents();
				String temp2 = gameModel.blocksData[2][x].getContents();
				if (temp0.equals(temp1) && temp0.equals(temp2)) {
					endGame();
					gameModel.setFinalResult(getWinningPlayer(temp2));
					gameView.playerturn.setText(gameModel.getFinalResult());
					return;
				}
			}
		}

		// Check Diagonals
		String udl = gameModel.blocksData[0][0].getContents();
		String udr = gameModel.blocksData[0][2].getContents();
		String ldl = gameModel.blocksData[2][0].getContents();
		String ldr = gameModel.blocksData[2][2].getContents();
		String cnt = gameModel.blocksData[1][1].getContents();

		if (!cnt.equals("")) {
			if (udl.equals(cnt) && ldr.equals(cnt)) {
				endGame();
				gameModel.setFinalResult(getWinningPlayer(cnt));
				gameView.playerturn.setText(gameModel.getFinalResult());
				return;
			} else if (udr.equals(cnt) && ldl.equals(cnt)) {
				endGame();
				gameModel.setFinalResult(getWinningPlayer(cnt));
				gameView.playerturn.setText(gameModel.getFinalResult());
				return;
			}
		}

		// Check for a Tie
		String toCheck = "";
		for (RowBlockModel[] rr : gameModel.blocksData) {
			for (RowBlockModel r : rr) {
				toCheck += r.getContents();
			}
		}

		if (toCheck.length() == 9) {
			endGame();
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
			gameView.playerturn.setText(gameModel.getFinalResult());
			return;
		}
	}

	private String getWinningPlayer(String s) {
		if (s.toLowerCase().equals("o")) {
			return playerTwoWinPhrase;
		} else {
			return playerOneWinPhrase;
		}
	}

	/**
	 * Ends the game disallowing further player turns.
	 */
	public void endGame() {
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 3; column++) {
				gameView.blocks[row][column].setEnabled(false);
			}
		}
	}

	/**
	 * Resets the game to be able to start playing again.
	 */
	public void resetGame() {
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 3; column++) {
				gameModel.blocksData[row][column].reset();
				gameModel.blocksData[row][column].setIsLegalMove(true);
				gameView.updateBlock(gameModel, row, column);
			}
		}
		gameModel.setIsPlayerOneTurn(true);
		gameModel.movesLeft = 9;
		gameModel.setFinalResult(null);
		gameView.playerturn.setText("Player 1 to play 'X'");
	}
}
