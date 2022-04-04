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

        for(int row = 0; row<3; row++) {
            for(int column = 0; column<3 ;column++) {
	        gameModel.blocksData[row][column].setContents("");
		gameModel.blocksData[row][column].setIsLegalMove(true);
		gameView.updateBlock(gameModel,row,column);
            }
        }
    }

    /**
     * Moves the current player into the given block.
     *
     * @param block The block to be moved to by the current player
     */
    public void move(JButton block) {
		if(gameModel.movesLeft < 0){
			return;
		}
	gameModel.movesLeft--;
	if(gameModel.movesLeft%2 == 1) {
	    gameView.playerturn.setText("'X': Player 1");
	} else{
	    gameView.playerturn.setText("'O': Player 2");
	}
	
	if(gameModel.player.equals("1")) {
	    // Check whether player 1 won
	    if(block==gameView.blocks[0][0]) {
		gameModel.blocksData[0][0].setContents("X");
		gameView.updateBlock(gameModel,0,0);
		gameModel.player = "2";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[2][0].getContents())) ||
		       (gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][2].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(block==gameView.blocks[0][1]) {
		gameModel.blocksData[0][1].setContents("X");
		gameView.updateBlock(gameModel,0,1);
		gameModel.player = "2";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][1].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(block==gameView.blocks[0][2]) {
		gameModel.blocksData[0][2].setContents("X");
		gameView.updateBlock(gameModel,0,2);
		gameModel.player = "2";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents())) ||
		       (gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][2].getContents()) &&
			gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(block==gameView.blocks[1][0]) {
		gameModel.blocksData[1][0].setContents("X");
		gameView.updateBlock(gameModel,1,0);
		gameModel.player = "2";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][2].getContents())) ||
		       (gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(block==gameView.blocks[1][1]) {
		gameModel.blocksData[1][1].setContents("X");
		gameView.updateBlock(gameModel,1,1);
		gameModel.player = "2";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][2].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[2][1].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][2].getContents()) &&
			gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(block==gameView.blocks[1][2]) {
		gameModel.blocksData[1][2].setContents("X");
		gameView.updateBlock(gameModel,1,2);
		gameModel.player = "2";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[0][2].getContents()) &&
			gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][0].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(block==gameView.blocks[2][0]) {
		gameModel.blocksData[2][0].setContents("X");
		gameView.updateBlock(gameModel,2,0);
		gameModel.player = "2";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
			gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[0][0].getContents())) ||
		       (gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][2].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(block==gameView.blocks[2][1]) {
		gameModel.blocksData[2][1].setContents("X");
		gameView.updateBlock(gameModel,2,1);
		gameModel.player = "2";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents()) &&
			gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][1].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(block==gameView.blocks[2][2]) {
		gameModel.blocksData[2][2].setContents("X");
		gameView.updateBlock(gameModel,2,2);
		gameModel.player = "2";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
			gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents())) ||
		       (gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][2].getContents()) &&
			gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][0].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    }
	} else {
	    // Check whether player 2 won
	    if(block==gameView.blocks[0][0]) {
		gameModel.blocksData[0][0].setContents("O");
		gameView.updateBlock(gameModel,0,0);
		gameModel.player = "1";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[2][0].getContents())) ||
		       (gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][2].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(block==gameView.blocks[0][1]) {
		gameModel.blocksData[0][1].setContents("O");
		gameView.updateBlock(gameModel,0,1);
		gameModel.player = "1";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][1].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(block==gameView.blocks[0][2]) {
		gameModel.blocksData[0][2].setContents("O");
		gameView.updateBlock(gameModel,0,2);
		gameModel.player = "1";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents())) ||
		       (gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][2].getContents()) &&
			gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(block==gameView.blocks[1][0]) {
		gameModel.blocksData[1][0].setContents("O");
		gameView.updateBlock(gameModel,1,0);
		gameModel.player = "1";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][2].getContents())) ||
		       (gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(block==gameView.blocks[1][1]) {
		gameModel.blocksData[1][1].setContents("O");
		gameView.updateBlock(gameModel,1,1);
		gameModel.player = "1";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][2].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[2][1].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][2].getContents()) &&
			gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(block==gameView.blocks[1][2]) {
		gameModel.blocksData[1][2].setContents("O");
		gameView.updateBlock(gameModel,1,2);
		gameModel.player = "1";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[0][2].getContents()) &&
			gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][0].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(block==gameView.blocks[2][0]) {
		gameModel.blocksData[2][0].setContents("O");
		gameView.updateBlock(gameModel,2,0);
		gameModel.player = "1";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
			gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[0][0].getContents())) ||
		       (gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][2].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(block==gameView.blocks[2][1]) {
		gameModel.blocksData[2][1].setContents("O");
		gameView.updateBlock(gameModel,2,1);
		gameModel.player = "1";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents()) &&
			gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][1].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(block==gameView.blocks[2][2]) {
		gameModel.blocksData[2][2].setContents("O");
		gameView.updateBlock(gameModel,2,2);
		gameModel.player = "1";
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
			gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents())) ||
		       (gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][2].getContents()) &&
			gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][0].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    }
	}
    }

	/**
	 * Checks to see if anyone has won the game.
	 */

	 public void checkWin(){
		 //Check Rows and Columns
		 for(int x = 0; x < 3; x++){
			 if(!gameModel.blocksData[x][0].getContents().equals("")){
				String temp0 = gameModel.blocksData[x][0].getContents();
				String temp1 = gameModel.blocksData[x][1].getContents();
				String temp2 = gameModel.blocksData[x][2].getContents();
				if(temp0.equals(temp1) && temp0.equals(temp2)){
					endGame();
					gameModel.setFinalResult(getWinningPlayer(center));
				}
			 }
			 if(!gameModel.blocksData[0][x].getContents().equals("")){
				String temp0 = gameModel.blocksData[0][x].getContents();
				String temp1 = gameModel.blocksData[1][x].getContents();
				String temp2 = gameModel.blocksData[2][x].getContents();
				if(temp0.equals(temp1) && temp0.equals(temp2)){
					endGame();
					gameModel.setFinalResult(getWinningPlayer(center));
				}
			 }
		 }

		 //Check Diagonals
		 String udl = gameModel.blocksData[0][0].getContents();
		 String udr = gameModel.blocksData[0][2].getContents();
		 String ldl = gameModel.blocksData[2][0].getContents();
		 String ldr = gameModel.blocksData[2][2].getContents();
		 String center = gameModel.blocksData[1][1].getContents();

		 if(!center.equals("")){
			if(udl.equals(center) && ldr.equals(ldr)){
				endGame();
				gameModel.setFinalResult(getWinningPlayer(center));
			}else if(udr.equals(center) && ldl.equals(ldr)){
				endGame();
				gameModel.setFinalResult(getWinningPlayer(center));
			}
		}

		//Check for a Tie
		String toCheck = "";
		for(RowBlockModel r : gameModel.blocksData){
			toCheck += r.getContents();
		}

		if(toCheck.length() == 0){
			endGame();
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		}
	 }

	 private String getWinningPlayer(String s){
		if(s.toLowerCase().equals("o")){
			return playerTwoWinPhrase;
		}else{
			return playerOneWinPhrase;
		}
	 }



    /**
     * Ends the game disallowing further player turns.
     */
    public void endGame() {
	for(int row = 0;row<3;row++) {
	    for(int column = 0;column<3;column++) {
		gameView.blocks[row][column].setEnabled(false);
	    }
	}
    }

    /**
     * Resets the game to be able to start playing again.
     */
    public void resetGame() {
        for(int row = 0;row<3;row++) {
            for(int column = 0;column<3;column++) {
                gameModel.blocksData[row][column].reset();
		gameModel.blocksData[row][column].setIsLegalMove(true);
		gameView.updateBlock(gameModel,row,column);
            }
        }
        gameModel.player = "1";
        gameModel.movesLeft = 9;
	gameModel.setFinalResult(null);
        gameView.playerturn.setText("Player 1 to play 'X'");
    }
}
