package tictactoe;

import java.util.*;

public class player {
    
    private ArrayList<Integer> pastMoves = new ArrayList<Integer>();

    public void addToMoveHistory(int move) {
        pastMoves.add(move);
    }

    public boolean checkWinConditions(List<Integer> winConditions) {
        if(pastMoves.containsAll(winConditions)) {
            return true;
        }
        return false;
    }

    public void printData() {
        System.out.print(pastMoves);
    }

    public boolean checkMoveAgainstPlayerHistory(int move) {
        for(int i = 0; i < pastMoves.size(); i++) {
            if(pastMoves.get(i) == move)
            {
                return false;
            }
        }
        return true;
    }
}
