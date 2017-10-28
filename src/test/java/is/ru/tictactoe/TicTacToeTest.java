package is.ru.tictactoe;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TicTacToeTest
{
    @Test
    public void testCheckInitial()
    {
        TicTacToe tic = new TicTacToe();
        assertEquals('.', tic.getMark(1, 2));
    }
}
