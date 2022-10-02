package tictactoe;
import java.util.ArrayList;

/**
 * The GridBoard class contains methods pertaining 
 * to construction of the board, managment of the board, 
 * and construction of the board string for printing
 * @author Jonathan Kocevar
 */
public class GridBoard {

    // Holds 3x3 board after boardInit()
    private static ArrayList<ArrayList<Character>> board = new ArrayList<ArrayList<Character>>(3); 

    // Holds board string for printing
    private static StringBuilder boardString = new StringBuilder(); 

    public static final String C_RED = "\033[0;31m";    // Ascii Red color
    public static final String C_CYAN = "\033[0;36m";   // Ascii Cyan color
    private static final String C_RESET = "\033[0m";    // Ascii color reset

    /**
     * Builds string for printing off of current game board positions
     * @return StringBuilder Object containing string to print board on console
     */
    public StringBuilder formBoardString() {
        boardString.setLength(0); // Reset String
        // Outer loop cycles through first index of the ArrayList
        for(int i = 0; i < board.size(); i++) {
            // Inner loop cycles through the inner character Arraylist
            for(int j = 0; j < board.get(i).size(); j++) {
                boardString.append(getColor(i, j)); // Add Color to Cell
                boardString.append(" ").append((board.get(i).get(j))).append(" "); // Add data to cell.
                boardString.append(C_RESET); // End Color application
                if(j != (board.get(i).size() - 1)) {
                    boardString.append("|"); // Adds verticle dividing lines in grid
                }
            }
            boardString.append("\n");
            if(i != (board.size() - 1)) {
                boardString.append("---+---+---\n"); // Adds horizontal lines in grid
            }
        }
        return boardString; // Returns string to print method in Game class
    }

    /**
     * Gets color for player symbols for the StringBuilder string
     * @param i first index in 2d array
     * @param j second index in 2d array
     * @return Ascii color code based on player number
     */
    private String getColor(int i, int j) {
        if(board.get(i).get(j) == 'X') {
            return C_RED; // Changes to Red for 'X'
        } else if(board.get(i).get(j) == 'O') {
            return C_CYAN; // Changes to Cyan for 'O'
        } else {
            return ""; // Nothing for any other input
        }
    }

    /**
     * Setter method for the board
     */
    public void initBoard() {
        for(int i = 0; i < 3; i++) {
            board.add(new ArrayList<Character>(3));
        }
        int countCell = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                countCell++;
                board.get(i).add((char)(countCell+'0'));
            }
        }
    }

    /**
     * Edits the board with new character based on the player and player index
     * @param index the users input
     * @param player string indicating current player ("Player 1" or "Player 2")
     */
    public void editBoard(int index, String player) {
        char symbol = 'X';
        if(player.equals("Player 2")) {
            symbol = 'O';
        }
        switch(index) {
            case 1:
                board.get(0).set(0, symbol); // Array pos [0][0]
                break;
            case 2:
                board.get(0).set(1, symbol); // Array pos [0][1]
                break;
            case 3:
                board.get(0).set(2, symbol); // Array pos [0][2]
                break;
            case 4:
                board.get(1).set(0, symbol); // Array pos [1][0]
                break;
            case 5:
                board.get(1).set(1, symbol); // Array pos [1][1]
                break;
            case 6:
                board.get(1).set(2, symbol); // Array pos [1][2]
                break;
            case 7:
                board.get(2).set(0, symbol); // Array pos [2][0]
                break;
            case 8:
                board.get(2).set(1, symbol); // Array pos [2][1]
                break;
            case 9:
                board.get(2).set(2, symbol); // Array pos [2][2]
                break;
            default:
                break;
        }
    }
}
