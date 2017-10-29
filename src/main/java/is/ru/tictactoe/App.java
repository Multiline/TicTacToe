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
            Scanner S = new Scanner(System.in);

            char answer = S.next().charAt(0);
            if(answer != '0' && answer != '1')
            {
                System.out.println("Illegal input");
                continue;
            }

            if (answer == 0) {
                break;
            }

            playGame();
        }
    }

    private static boolean makeMove(char player, TicTacToe ticTacToe) 
    {        
        System.out.println("Player " + player + ", pick a line: ");
        int line = moveInput();
        System.out.println("Player " + player + ", pick a column: ");
        int column = moveInput();
    
        return ticTacToe.markSpace(line, column);
    }

    private static int moveInput()
    {
        int input;
        while(true)
        {
            Scanner S = new Scanner(System.in);
            try {
                input = S.nextInt();
                return input;
            }
            catch(InputMismatchException e)
            {
                System.out.println("This is not a valid input, please try again");
            }
        }
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
        System.out.printf("%n");
        for(int i = 0; i < ticTacToe.getBoardSize(); i++)
        {
            for (int j = 0; j < ticTacToe.getBoardSize(); j++)
            {
                System.out.printf(ticTacToe.getMark(i, j) + " ");
            }
            System.out.printf("%n");
        }
        System.out.printf("%n");
    }
}
