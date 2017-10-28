package is.ru.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import org.junit.Test;

public class TicTacToeTest
{
    @Test
    public void testCheckInitial()
    {
        TicTacToe tic = new TicTacToe();
        assertEquals('.', tic.getMark(1, 2));
    }

    @Test
    public void testMarkSpace()
    {
    	TicTacToe tic = new TicTacToe();
    	tic.markSpace(1, 1);
    	assertEquals('x', tic.getMark(1, 1));
    }

    @Test
    public void testMarkSpaceInvalidIndex()
    {
    	try
    	{
    		TicTacToe tic = new TicTacToe();
    		tic.markSpace(3,3);
    		Assert.fail();
    	}
    	catch (Exception e)
    	{
    		String messageExpected  = "Error: Board index out of bounds";
    		assertEquals(messageExpected, e.getMessage());
    	}

    	try
    	{
			TicTacToe tic = new TicTacToe();
    		tic.markSpace(-1,0);
    		Assert.fail();
    	}
    	catch (Exception e)
    	{
			String messageExpected  = "Error: Board index out of bounds";
    		assertEquals(messageExpected, e.getMessage());
    	}
    	
    }

    @Test
    public void testMarkSpaceFullAlready()
    {
        TicTacToe tic = new TicTacToe();
        tic.markSpace(0,1);
        assertEquals(false, tic.markSpace(0,1));
    }

    @Test
    public void testChangePlayer()
    {
    	TicTacToe tic = new TicTacToe();
    	tic.changePlayer();
    	assertEquals('o', tic.getCurrentPlayer());
    }
  
	@Test
	public void testHorWinner()
	{
    	TicTacToe tic = new TicTacToe();
		tic.markSpace(0,0);
		tic.markSpace(0,1);
		tic.markSpace(0,2);
		assertEquals(true, tic.isWinner()); 
	}
	
	@Test
	public void testVerWinner()
	{
    	TicTacToe tic = new TicTacToe();
		tic.markSpace(0,0);
		tic.markSpace(1,0);
		tic.markSpace(2,0);
		assertEquals(true, tic.isWinner()); 
	}	
	
	@Test
	public void testDiaWinner()
	{
    	TicTacToe tic = new TicTacToe();
		tic.markSpace(0,0);
		tic.markSpace(1,1);
		tic.markSpace(2,2);
		assertEquals(true, tic.isWinner()); 
	}		

    @Test
    public void testIsEmptySpaceEmpty()
    {
        TicTacToe tic = new TicTacToe();
        assertEquals(true, tic.isSpaceEmpty(2, 1));
    }

    @Test
    public void testIsFullSpaceEmpty()
    {
        TicTacToe tic = new TicTacToe();
        tic.markSpace(1,1);
        assertEquals(false, tic.isSpaceEmpty(1,1));
    }

    @Test 
    public void testIsSpaceEmptyInvalidIndex()
    {
        try
        {
            TicTacToe tic = new TicTacToe();
            tic.isSpaceEmpty(3,3);
            Assert.fail();
        }
        catch (Exception e)
        {
            String messageExpected  = "Error: Board index out of bounds";
            assertEquals(messageExpected, e.getMessage());
        }

        try
        {
            TicTacToe tic = new TicTacToe();
            tic.isSpaceEmpty(-2,0);
            Assert.fail();
        }
        catch (Exception e)
        {
            String messageExpected  = "Error: Board index out of bounds";
            assertEquals(messageExpected, e.getMessage());
        }
    }

    @Test
    public void testValidateBoardIndex()
    {
        TicTacToe tic = new TicTacToe();

        try
        {
            tic.validateBoardIndex(1,2);
        }
        catch (Exception e)
        {
            String messageExpected  = "Error: Board index out of bounds";
            assertEquals(messageExpected, e.getMessage());
        }

        try
        {
            tic.validateBoardIndex(-1,0);
            Assert.fail();
        }
        catch(Exception e)
        {
            String messageExpected  = "Error: Board index out of bounds";
            assertEquals(messageExpected, e.getMessage());
        }

        try
        {
            tic.validateBoardIndex(2,5);
            Assert.fail();
        }
        catch(Exception e)
        {
            String messageExpected  = "Error: Board index out of bounds";
            assertEquals(messageExpected, e.getMessage());
        }
    }

    @Test
    public void testDraw()
    {
        TicTacToe tic = new TicTacToe();

        //Fill board so no one wins
        tic.markSpace(0,0);
        tic.changePlayer();
        tic.markSpace(0,1);
        tic.changePlayer();
        tic.markSpace(0,2);
        tic.changePlayer();
        tic.markSpace(1,0);
        tic.changePlayer();
        tic.markSpace(2,0);
        tic.changePlayer();
        tic.markSpace(1,1);
        tic.changePlayer();
        tic.markSpace(1,2);
        tic.changePlayer();
        tic.markSpace(2,2);
        tic.changePlayer();
        tic.markSpace(2,1);

        assertEquals(true, tic.isDraw());
    }

    @Test
    public void testDrawWhenWin()
    {
        TicTacToe tic = new TicTacToe();

        //Fill in board so x wins
        tic.markSpace(0,0);
        tic.changePlayer();
        tic.markSpace(0,1);
        tic.changePlayer();
        tic.markSpace(0,2);
        tic.changePlayer();
        tic.markSpace(1,0);
        tic.changePlayer();
        tic.markSpace(1,1);
        tic.changePlayer();
        tic.markSpace(1,2);
        tic.changePlayer();
        tic.markSpace(2,2);

        assertEquals(false, tic.isDraw());
    }

    public void testReset()
    {
        TicTacToe tic = new TicTacToe();
        //puting an 'x' in space 1, 1
        tic.markSpace(1, 1);
        //resetting the board
        tic.reset();
        //checking that the board has reset by checking that space 1,1 is '.' not'x'
        assertEquals('.', tic.getMark(1, 2));
        //checking that the player reset back to x
        assertEquals('x', tic.getCurrentPlayer());
    }
}
