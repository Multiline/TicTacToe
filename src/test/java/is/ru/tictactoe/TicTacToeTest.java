package is.ru.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TicTacToeTest
{
    @Test
    public void testAdd()
    {
        assertEquals(2, TicTacToe.add(1, 1));
    }
}
