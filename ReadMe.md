# TicTacToe

A 2-player replication of the game TicTacToe based off of [Wikipedias ruleset](https://en.wikipedia.org/wiki/Tic-tac-toe), played in the console. 

## Description

TicTacToe is a 2 player game in which players take turns, over the console interface, choosing positions trying to get 3 of their symbols in a row. After one player is able to match 3 symbols, they win the game. The program allows for multiple games to be played in a row, and features player coloring for easier UI readability.

## Getting Started

### Dependencies

* This software has been designed in Linux for use in Linux, there is no guarantee of functionality in Windows or Mac.
* Must have a terminal application to run the executable
* openjdk 11 and gradle are also needed

### Executing program

First, Clone the repo and enter the `A1` folder.

The project can then be built below by running the command :
```
gradle build
```
Followed by running the Java executable with the command: 
```
java -cp build/classes/java/main tictactoe.TicTacToe
```
Alternitively, both can be done in one command using: 
```
gradle run
```
Enjoy.

## Limitations

There are no errors to game functionality, it works as intended.

One limitation to improve in further development is the addition of a cell class to increase encapsulation in the main board array object, added with a constructor, accessor, and mutator for individual cells. The possibility of adding a rule class to organize checking win conditions, checking validity of movements, and move history could also be good for code maintanance.

## Author Information

**Author Name:** Jonathan Kocevar

**Author Email:** jkocevar@uoguelph.ca

## Development History

* 0.1
    * Initial Release