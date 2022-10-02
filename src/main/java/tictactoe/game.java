package tictactoe;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
* The Game class controls all game functions on a broad level
* such as handling inputs from the players, validating those inputs
* controlling turns, and maintaining the board.
* @author Jonathan Kocevar
*/
public class Game {
    private Player p1 = new Player();
    private Player p2 = new Player();
    private GridBoard board = new GridBoard();
    private int turnCount = 0;

    /**
     * Initializes the board for the game
     */
    public void initGame() {
        board.initBoard();
    }

    /**
     * Setter method for the variable turnCount, increments by 1
     */
    public void increaseTurnCount() {
        turnCount++;
    }

    /**
     * Getter method for the variable turnCount;
     * @return returns current turn count from private int
     */
    public int getTurnCount() {
        return turnCount;
    }

    /**
     * Pulls StringBuilder from GridBoard to print board to screen
     */
    public void printBoard() {
        System.out.print(board.formBoardString().toString());
    }

    /**
     * Exectues one player turn, handles player input and validity of the input, and edits the current game board
     */
    public void playTurn() {
        printBoard(); // Prints board to screen
        while(true) {
            int playerMove = inputMove(); // Grabs input from user
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

    /**
     * Checks if any of the winning endings are subsets of the players move history, verifying if they have won or not
     * @return true for if the player has won, false for if the player has lost
     */
    public boolean checkWinner() {
        
        // Below are all the different win conditions for tictactoe
        ArrayList<List<Integer>> winningEndings = new ArrayList<List<Integer>>();
        winningEndings.add(Arrays.asList(1, 2, 3));
        winningEndings.add(Arrays.asList(4, 5, 6));
        winningEndings.add(Arrays.asList(7, 8, 9));
        winningEndings.add(Arrays.asList(1, 4, 7));
        winningEndings.add(Arrays.asList(2, 5, 8));
        winningEndings.add(Arrays.asList(3, 6, 9));
        winningEndings.add(Arrays.asList(1, 5, 9));
        winningEndings.add(Arrays.asList(3, 5, 7));
        
        // Itterates through list to find if winningEndings is a subset of the players move history
        if(getCurrentPlayer().equals("Player 1")) {
            for(int i = 0; i < winningEndings.size(); i++) {
                if(p1.checkWinConditions(winningEndings.get(i))) {
                    return true; // P1 Win found
                }
            }
            return false; // P1 No win found
        } else {
            for(int i = 0; i < winningEndings.size(); i++) {
                if(p2.checkWinConditions(winningEndings.get(i))) {
                    return true; // P2 Win found
                }
            }
            return false; // P2 No win found
        }
    }

    /**
     * Uses a scanner on standard input to grab an integer from the user for his next move.
     * @return Returns -1 as a base case, otherwise returns players input from scanner.
     */
    public int inputMove() {
        System.out.println(getCurrentPlayer() + ", please input your move below (1-9):");
        Scanner input = new Scanner(System.in);
        String playerInput = input.nextLine();
        
        // Checks to make sure the input is accepted as an integer, not for example, a string
        if(playerInput != null && playerInput.matches("[0-9.]+")) {
            try {
                int castedPlayerInput = Integer.valueOf(playerInput);
                return castedPlayerInput;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        /*
         * If the input is not an integer, a minus one is returned, which is 
         * automatically out of scope, so a reinput will need to be done by the player
         */
        return -1; 
    }

    /**
     * Grabs the string for the current player based on turn count.
     * @return returns the String for the player, either "Player 1", "Player 2".
     */
    public String getCurrentPlayer() {
        String playerString = new String("Player 1");
        if(turnCount % 2 == 1) {
            playerString = "Player 2";
        }
        return playerString;
    }

    /**
     * Checks integer to see if it is in range of available cells on the gridboard.
     * @param input the users input
     * @return false for if the input falls outside 1-9, true if it falls within the bounds.
     */
    private boolean checkValidityOfInput(int input) {
        if(input > 9 || input < 1) {
            return false;
        }
        return true;
    }

    /**
     * Checks integer representing players move agains the history of both players previous moves.
     * @param move the users inputted move
     * @return true for if move passes both players move histories, false if the conditional does not pass.
     */
    private boolean checkAgainstGameHistory(int move) {
        return (p1.checkMoveAgainstPlayerHistory(move) && p2.checkMoveAgainstPlayerHistory(move));
    }

    public static boolean playNewGame() {
        System.out.println("Thanks for playing, Would you like to play another round? ('Y'/'N'):");
    
        while(true) {
            Scanner input = new Scanner(System.in);
            String playerInput = input.nextLine();
            
            // Checks to make sure the input is accepted as an integer, not for example, a string
            if(playerInput != null && playerInput.matches("^(?:Y|N)$")) {
                try {
                    return playerInput.equals("Y");
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("That is not a valid response, please indicate 'Y' or 'N', try again");
            }
        }
    }
}
