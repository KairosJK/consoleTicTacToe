package tictactoe;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private Player p1 = new Player();
    private Player p2 = new Player();
    private GridBoard board = new GridBoard();
    private int turnCount = 0;

    public void initGame() {
        board.initBoard();
    }

    public void increaseTurnCount() {
        turnCount++;
    }

    public int getTurnCount() {
        return turnCount;
    }

    public void printBoard() {
        board.printBoard();
    }

    public void playTurn() {
        board.printBoard();
        while(true) {
            int playerMove = inputMove();
            if(checkValidityOfInput(playerMove)) {
                if(checkAgainstGameHistory(playerMove)) {
                    board.editBoard(playerMove, getCurrentPlayer());
                    if(getCurrentPlayer().equals("Player 1")) {
                        p1.addToMoveHistory(playerMove);
                    } else {
                        p2.addToMoveHistory(playerMove);
                    }
                    break;
                } else {
                    System.out.println("That cell has already been occupied in play, please select another.");
                }
            } else {
                System.out.println("Value entered is not a valid input, please only input another integer from 1-9.");
            }
        }
    }

    public boolean checkWinner() {
        
        ArrayList<List<Integer>> winningEndings = new ArrayList<List<Integer>>();
        winningEndings.add(Arrays.asList(1, 2, 3));
        winningEndings.add(Arrays.asList(4, 5, 6));
        winningEndings.add(Arrays.asList(7, 8, 9));
        winningEndings.add(Arrays.asList(1, 4, 7));
        winningEndings.add(Arrays.asList(2, 5, 8));
        winningEndings.add(Arrays.asList(3, 6, 9));
        winningEndings.add(Arrays.asList(1, 5, 9));
        winningEndings.add(Arrays.asList(3, 5, 7));
        
        if(getCurrentPlayer().equals("Player 1")) {
            for(int i = 0; i < winningEndings.size(); i++) {
                if(p1.checkWinConditions(winningEndings.get(i))) {
                    return true;
                }
            }
            return false;
        } else {
            for(int i = 0; i < winningEndings.size(); i++) {
                if(p2.checkWinConditions(winningEndings.get(i))) {
                    return true;
                }
            }
            return false;
        }
    }

    public int inputMove() {
        System.out.println(getCurrentPlayer() + ", please input your move below (1-9):");
        Scanner input = new Scanner(System.in);
        String playerInput = input.nextLine();
        //input.close();
        if(playerInput != null && playerInput.matches("[0-9.]+")) {
            try {
                int castedPlayerInput = Integer.valueOf(playerInput);
                return castedPlayerInput;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public String getCurrentPlayer() {
        String playerString = new String("Player 1");
        if(turnCount % 2 == 1) {
            playerString = "Player 2";
        }
        return playerString;
    }

    private boolean checkValidityOfInput(int input) {
        if(input > 9 || input < 1) {
            return false;
        }
        return true;
    }

    private boolean checkAgainstGameHistory(int move) {
        return (p1.checkMoveAgainstPlayerHistory(move) && p2.checkMoveAgainstPlayerHistory(move));
    }
}
