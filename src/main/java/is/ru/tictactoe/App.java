package is.ru.tictactoe;

import java.util.*;
import static spark.Spark.*;

public class App
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to TicTacToe 2000!");

        while (true) {
            System.out.println("Do you want to play a game? (1 = yes, 0 = no)");
            Scanner S=new Scanner(System.in);
            int answer = S.nextInt();

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

        System.out.print("Player " + player + ", pick a column: ");
        int column = S.nextInt();

        return ticTacToe.markSpace(line, column);
    }

    private static boolean gameOver(char player, TicTacToe ticTacToe) {
        if (ticTacToe.isWinner()) {
            System.out.println("Player " + player + " wins.");
            return true;
        }

        if (ticTacToe.isDraw()) {
            System.out.println("No more legal moves. Game ends in a draw.");
            return true;
        }

        return false;
    }

    private static void playGame() {
        TicTacToe ticTacToe = new TicTacToe();
        boolean legalMove, isGameOver;

        while(true) {
            char player = ticTacToe.getCurrentPlayer();

            do {
                try {
                    legalMove = makeMove(player, ticTacToe);
                    if (!legalMove) {
                        System.out.println("Error: Illegal move, please try again.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage() + ", please try again.");
                    legalMove = false;
                }
            } while(!legalMove);

            if (gameOver(player, ticTacToe)) {
                printBoard(ticTacToe);
                ticTacToe.reset();
                break;
            }

            printBoard(ticTacToe);
            ticTacToe.changePlayer();
        }
    }

    public static void printBoard(TicTacToe ticTacToe)
    {
        for(int i = 0; i < ticTacToe.getBoardSize(); i++)
        {
            for (int j = 0; j < ticTacToe.getBoardSize(); j++)
            {
                System.out.printf(ticTacToe.getMark(i, j) + " ");
            }
            System.out.printf("%n");
        }
    }
}
