package tictactoe;

import java.util.ArrayList;
import java.util.List;

/**
* The Player class encapsulates methods pertaining to managing the players moves and past move history
* @author Jonathan Kocevar
*/
public class Player {
    
    private ArrayList<Integer> pastMoves = new ArrayList<Integer>();

    /**
     * Setter for the pastMoves ArrayList, adding a new move to the players move history
     * @param move the users inputted move
     */
    public void addToMoveHistory(int move) {
        pastMoves.add(move);
    }

    /**
     * Checks winCondition list for any successful win conditions for the player.
     * @param winConditions imports a list of winConditions for tictactoe
     * @return true for if winning endings are subsets of the players move history, false if it cannot find any subset.
     */
    public boolean checkWinConditions(List<Integer> winConditions) {
        if(pastMoves.containsAll(winConditions)) {
            return true;
        }
        return false;
    }

    /**
     * Loops through all of players move history to validate new move
     * @param move the users inputted move
     * @return true for if the move passes the player's move histories, false if the conditional does not pass.
     */
    public boolean checkMoveAgainstPlayerHistory(int move) {
        for(int i = 0; i < pastMoves.size(); i++) {
            if(pastMoves.get(i) == move) {
                return false;
            }
        }
        return true;
    }
}
