
# Design Report: Tic Tac Toe
*SC-T-303-HUGB  
Late-term Assignment  
Fall semester 2017*


## Introduction
This document is the design report for the game Tic Tac Toe, made by students of Reykjavik University for the late-term assignment in Software Engineering (Hugbúnaðarfræði). The assignment will be coded in Java and completed using test driven development. 

## Game Description
Tic Tac Toe is played on a 3x3 grid by two players. Each player is assigned the mark 'x' or 'o'. The player with the mark 'x' goes first, followed by the player with the mark 'o'. The first player to fill a diagonal line, a row or a column with its mark, wins the game. If the board fills up before either player wins, a tie is declared. 

## Programming Rules
Names of classes should begin with an uppercase letter. Variable and method names should begin with a lowercase letter and be in camel casing. All code should be properly indented. 

## Environment
Sublime Text will be used to code the game and GitHub will be used for source control. The group will use Gradle to test, build and run the program. Travis CI will be used to facilitate continuous integration and Heroku will be used to create and deploy the web app. 

## Classes and Functions
The console program will be implemented using two classes, `TicTacToe`, and `App`. `TicTacToe` implements all logic, while `App` handles interactions with the user. 

#### `TicTacToe` has at least the following functions:
```
public TicTacToe()  
public void printBoard()
public void reset()
public char getCurrentPlayer()
public char getMark(int x, int y)
public boolean markSpace(int x, int y)
public void validateBoardIndex(int x, int y)
public boolean isWinner()
public boolean isDraw()
public void changePlayer()
```

#### `App` has at least the following functions:
```
private void playGame() 
private boolean makeMove(char player, TicTacToe ticTacToe) 
private boolean gameOver(char player, TicTacToe ticTacToe)
```


## Class Diagram
The following is the initial class diagram for the potential structure of the console app. 

<img src="https://github.com/Multiline/TicTacToe/blob/master/docs/classDiagram.png?raw=true" width=330>



