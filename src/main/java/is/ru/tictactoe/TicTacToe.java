package is.ru.tictactoe;

public class TicTacToe
{
	private int boardSize = 3;
    private char[][] board = new char[boardSize][boardSize];
    private char currentPlayer;

    public TicTacToe()
	{
    	reset();
    }

    public void printBoard()
    {
        for(int i = 0; i < boardSize; i++)
        {
            for (int j = 0; j < boardSize; j++)
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

    //Marks selected space with player's token
    //Returns true if space was empty and marking suceeded
    //Returns false if space was full already
    public boolean markSpace(int x, int y)
    {
    	validateBoardIndex(x,y);

        if(!isSpaceEmpty(x,y))
        {
            return false;
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

        return true;

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
			if (counter == boardSize)
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
			if (counter == boardSize)
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
							
		if (counter == boardSize)
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
		
		if (counter == boardSize)
		{
			return true;
		}
		
		return false;	
	}

    public boolean isDraw()
    {
        if(isWinner())
        {
            return false;
        }

        //Use counter to keep track of number of filled spaces
        int counter = 0;

        //Run through board
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board.length; j++)
            {
                //If space is not empty, increment counter
                if(!isSpaceEmpty(i,j))
                {
                    counter++;
                }
            }
        }

        //Check if number of filled spaces equals total number of board spaces
        if(counter == (boardSize*boardSize))
        {
            return true;
        }

        return false;
    }
  
	public void reset()
    {
        for (int i = 0; i < boardSize; i++)
        {
            for (int j = 0; j < boardSize; j++)
            {
                board[i][j] = '.';
            }
        }
        currentPlayer = 'x';
    }

}