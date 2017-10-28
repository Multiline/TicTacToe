package is.ru.tictactoe;

public class TicTacToe
{
    private char[][] board = new char[3][3];
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
}
