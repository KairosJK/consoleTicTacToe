package tictactoe;

public class tictactoe {
  public static void main(String[] args) {
    System.out.println("Welcome to 3x3 TicTacToe");
    game currentGame = new game();
    currentGame.initGame();

    while(true) {
      currentGame.playTurn();
      if(currentGame.checkWinner() == true) {
        currentGame.printBoard();
        System.out.println(currentGame.getCurrentPlayer() + " has won the game!");
        break;
      } else if (currentGame.getTurnCount() >= 8) {
        currentGame.printBoard();
        System.out.println("The game finished in a tie!");
        break;
      } else {
        currentGame.increaseTurnCount();
      }
    }
  }
}