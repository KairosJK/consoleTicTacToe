package tictactoe;

/**
 * The Main TicTacToe runner class
 * @author Jonathan Kocevar
 */
public class TicTacToe {
  public static void main(String[] args) {
    System.out.println("Welcome to 3x3 TicTacToe");

    // Wrapped in while for ability to play multiple games
    while(true) {
      Game currentGame = new Game(); // Create new game
      currentGame.initGame(); // initialize board

      while(true) {
        currentGame.playTurn(); // Play one turn
        // Check to see if turn made win condition
        if(currentGame.checkWinner()) {
          currentGame.printBoard(); // Print the current board
          System.out.println(currentGame.getCurrentPlayer() + " has won the game!"); // Give final message
          break;

        } else if (currentGame.getTurnCount() >= 8) {
          currentGame.printBoard();
          System.out.println("The game finished in a tie!");
          break;

        } else {
          currentGame.increaseTurnCount(); // increment the turn count by one
        }
      }
      // Check if players want next game
      if(!Game.playNewGame()) {
        break; // No, breaks loop and exits program
      }
      currentGame.clearBoard(); // Clears board for next game
    }
  }
}