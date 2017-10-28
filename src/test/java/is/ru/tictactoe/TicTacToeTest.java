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
    public void testChangePlayer()
    {
    	TicTacToe tic = new TicTacToe();
    	tic.changePlayer();
    	assertEquals('o', tic.getCurrentPlayer());
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
}
