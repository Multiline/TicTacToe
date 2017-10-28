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

    public void printBoard()
    {
        for(int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                System.out.printf(getMark(i, j) + " ");
            }
            System.out.printf("%n");
        }
    }

    public char getMark(int x, int y)
	{
    	char mark = board[x][y];

    	return mark;
    }

    public void markSpace(int x, int y)
    {
    	validateBoardIndex(x,y);

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

    public char getCurrentPlayer()
    {
    	return currentPlayer;
    }

    public void changePlayer()
    {
    	if(currentPlayer == 'x')
    	{
    		currentPlayer = 'o';
    	}
    	else if(currentPlayer == 'o')
    	{
    		currentPlayer = 'x';
    	}
    	else
    	{
    	}
    }
	
	public boolean isWinner()
	{
		if (horWin())
		{	
			return true;
		}
		
		if (verWin())
		{
			return true;
		}
		
		if (diaWin())
		{
			return true;
		}
		
		return false;
	}
	
	// Checks the - pattern.
	private boolean horWin()
	{
		for (int i = 0; i < boardSize; i++)
		{
			int counter = 0;
			
			for (int j = 0; j < boardSize; j++)
			{
				if (board[i][j] == currentPlayer)
				{
					counter++;
				}
			}
			if (counter == 3)
			{
				return true;
			}
			
		}
		return false;
	}

    public boolean isSpaceEmpty(int x, int y)
    {  
        validateBoardIndex(x,y);

        return (board[x][y] == '.');
    }
  
    public void validateBoardIndex(int x, int y)
    {
        boolean xIsInvalid = ((x < 0) || (x > boardSize - 1));
        boolean yIsInvalid = ((y < 0) || (y > boardSize - 1));

        if(xIsInvalid || yIsInvalid)
        {
            throw new IllegalArgumentException ("Error: Board index out of bounds");
        }
    }

	private boolean verWin()
	{
		for (int j = 0; j < boardSize; j++)
		{
			int counter = 0;
			
			// Checks the | pattern.
			
			for (int i = 0; i < boardSize; i++)
			{
				if (board[i][j] == currentPlayer)
				{
					counter++;
				}
			}
			if (counter == 3)
			{
				return true;
			}
			
		}
		return false;		
	}

	private boolean diaWin()
	{
		int counter = 0;
		
		// Checks the \ pattern.
		for (int i = 0; i < boardSize; i++)
		{
			if (board[i][i] == currentPlayer)
			{
				counter++;
			}
		}
							
		if (counter == 3)
		{
			return true;
		}
		
		
		counter = 0;
		
		// Checks the / pattern
		for (int i = 0; i < boardSize; i++)
		{
			if (board[i][boardSize - i - 1] == currentPlayer)
			{
				counter++;
			}
		}
		
		if (counter == 3)
		{
			return true;
		}
		
		return false;	
	}
}