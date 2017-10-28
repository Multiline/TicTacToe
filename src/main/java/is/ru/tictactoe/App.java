package is.ru.tictactoe;

import java.util.*;
import java.util.Scanner;

public class App
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to TicTacToe 2000!");

        while (true) {
            System.out.println("Do you want to play a game? (1 = yes, 0 = no)");
            Scanner S=new Scanner(System.in);
            int answer = S.nextInt();
            S.nextLine();

            if (answer == 0) {
                break;
            }

            playGame();
        }
    }

    private static boolean makeMove(char player, TicTacToe ticTacToe) {
        System.out.print("Player " + player + ", pick a line: ");
        Scanner S = new Scanner(System.in);
        int line = S.nextInt();
        S.nextLine();

        System.out.print("Player " + player + ", pick a column: ");
        int column = S.nextInt();
        S.nextLine();

        return ticTacToe.markSpace(line, column);
    }

    private static boolean gameOver(char player, TicTacToe ticTacToe) {
        if (ticTacToe.isWinner()) {
            System.out.println("Player " + player + "wins.");
            ticTacToe.reset();
            return true;
        }

        if (ticTacToe.isDraw()) {
            System.out.println("No more legal moves. Game ends in a draw.");
            ticTacToe.reset();
            return true;
        }

        return false;
    }

    private static void playGame() {
        TicTacToe ticTacToe = new TicTacToe();
        boolean legalMove, isGameOver;

        //System.out.println(ticTacToe.getMark(1,2));
        while(true) {
            char player = ticTacToe.getCurrentPlayer();

            do {
              legalMove = makeMove(player, ticTacToe);
            } while(!legalMove);

            if (gameOver(player, ticTacToe)) {
                break;
            }

            ticTacToe.printBoard();
            ticTacToe.changePlayer();
        }
    }
}
