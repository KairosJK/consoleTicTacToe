package tictactoe;
import java.util.ArrayList;

public class GridBoard {

    private static ArrayList<ArrayList<Character>> board = new ArrayList<ArrayList<Character>>(3);

    public void printBoard() {
        for(int i = 0; i < board.size(); i++) {
            for(int j = 0; j < board.get(i).size(); j++) {
                System.out.print(" " + (board.get(i).get(j)) + " ");
                if(j != (board.get(i).size() - 1)) {
                    System.out.print("|");
                }
            }
            System.out.println("");
            if(i != (board.size() - 1)) {
                System.out.println("---+---+---");
            }
        }
    }

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
