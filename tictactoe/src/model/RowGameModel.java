package model;


public class RowGameModel 
{
    public static final String GAME_END_NOWINNER = "Game ends in a draw";

    public RowBlockModel[][] blocksData = new RowBlockModel[3][3];

    /**
     * The current player taking their turn
     */
    private boolean isPlayerOneTurn = false;
    public int movesLeft = 9;

    private String finalResult = null;


    public RowGameModel() {
	super();

	for (int row = 0; row < 3; row++) {
	    for (int col = 0; col < 3; col++) {
		blocksData[row][col] = new RowBlockModel(this);
	    } // end for col
	} // end for row
    }

    public String getFinalResult() {
	return this.finalResult;
    }

    public void setFinalResult(String finalResult) {
	this.finalResult = finalResult;
    }

    public boolean isPlayerOneTurn(){
        return this.isPlayerOneTurn;
    }

    public void switchPlayers(){
        this.isPlayerOneTurn = !(this.isPlayerOneTurn);
    }

    public void setIsPlayerOneTurn(boolean isTurn){
        this.isPlayerOneTurn = isTurn;
    }
}
