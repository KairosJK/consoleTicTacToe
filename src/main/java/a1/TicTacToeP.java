package a1;

import java.util.Scanner;

public class TicTacToeP {
 
  private static char playerTurn = 'X'; 
  private static int depth = 0; 
  private static Scanner input = new Scanner(System.in);
  private static int position;
  private static char board[] = {'0','|','1','|','2','\n','-','+','-','+','-','\n','3','|','4','|','5','\n','-','+','-','+','-','\n','6','|','7','|','8','\n'};
  private static int PosToIndex[] = { 0, 2, 4, 12, 14, 16, 24, 26, 28 };


  public static void setTurn(char turn) {
    if (turn == 'X') {
      turn = 'O';
    } else {
      turn = 'X';
    }
    playerTurn = turn;
  }

  public static boolean checkBoard(int Position,char board[]) {
    if (
      board[PosToIndex[position]] == 'X' ||
      board[PosToIndex[position]] == 'O'
    ) {
      return true;
    }
    return false;
  }

  public static boolean winner(int depth,char board[]) {

    char winner = '?';
    for (int i = 0; i < 3; i++){
      if (board[PosToIndex[i]] == board[PosToIndex[i+3]] && board[PosToIndex[i+3]]== board[PosToIndex[i+6]]) {
        winner = board[PosToIndex[i]];
        break;
      }
    }
    if(winner == '?'){
      if (board[PosToIndex[0]] == board[PosToIndex[4]] && board[PosToIndex[4]] == board[PosToIndex[8]]) winner = board[PosToIndex[0]];
      if (board[PosToIndex[2]] == board[PosToIndex[4]] && board[PosToIndex[4]] == board[PosToIndex[6]]) winner = board[PosToIndex[2]];
    }

    if(winner == '?'){
      for (int i = 0; i <= 6; i+=3){
        if (board[PosToIndex[i]] == board[PosToIndex[i+1]] && board[PosToIndex[i+1]] == board[PosToIndex[i+2]]) {
          winner = board[PosToIndex[i]];
          break;
        }
      }
    }
    if (depth == 9) {
      System.out.println("The Game was a Tie!");
      System.exit(0);
    } else if (winner != '?'){
        System.out.println("The winner is " + winner);
        System.exit(0);
    } 
  return true;
}

public static void main(String[] args) {
  System.out.println(board);
  System.out.println("Turn = X");

  while (winner(depth,board)) {
    System.out.print("Enter Position between 1 and 9:\n");
    position = input.nextInt();

    if (position > board.length) {
      System.out.println("Error - Out of Bounds");
    } else {

      if (checkBoard(position,board)) {
        System.err.println("Illegal Move! Try Again");
        
      } else {
        depth++;
        board[PosToIndex[position]] = playerTurn;
        System.out.println(board);
        setTurn(playerTurn);
        if (depth != 9) {
          System.out.println("Turn = " + playerTurn);
        }
      }
    }
  } 
  setTurn(playerTurn);
  System.out.println("Winner = " + playerTurn); 
}
}
