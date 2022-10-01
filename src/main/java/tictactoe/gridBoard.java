package tictactoe;
import java.util.ArrayList;

public class gridBoard {

    private static ArrayList<ArrayList<Character>> board = new ArrayList<ArrayList<Character>>(3);

    private static void printBoard() {
        for(int i = 0; i < board.size(); i++)
        {
            for(int j = 0; j < board.get(i).size(); j++)
            {
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

    private static void initBoard() {
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

    public void playGame() {
        initBoard();
        printBoard();
    }
}
