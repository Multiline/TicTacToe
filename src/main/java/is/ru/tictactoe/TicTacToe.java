package is.ru.tictactoe;

public class TicTacToe
{
	private int boardSize = 3;
    private char[][] board = new char[boardSize][boardSize];
    private char currentPlayer = 'x';

    public TicTacToe()
	{
    	for (int i = 0; i < 3; i++)
		{
    		for (int j = 0; j < 3; j++)
			{
    			board[i][j] = '.';
    		}
    	}
    }

    public char getMark(int x, int y)
	{
    	char mark = board[x][y];

    	return mark;
    }

    public void markSpace(int x, int y)
    {

    	boolean xIsInvalid = ((x < 0) || (x > boardSize - 1));
    	boolean yIsInvalid = ((y < 0) || (y > boardSize - 1));

    	if(xIsInvalid || yIsInvalid)
    	{
    		throw new IllegalArgumentException ("Error: Board index out of bounds");
    	}

    	if(currentPlayer == 'x')
    	{
    		board[x][y] = 'x';
    	}
    	else if(currentPlayer == 'o')
    	{
    		board[x][y] = 'o';
    	}
    	else
    	{
    	}

    }


}
