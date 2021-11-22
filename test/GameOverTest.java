import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pl.polsl.mateuszlawinski.snake.models.GameOver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class GameOverTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 0, 154, Integer.MAX_VALUE})
    public void testGameOver(int n) {
        try{
            new GameOver(n);
        }catch(Exception e){
            fail(e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {-2, -3, -100, Integer.MIN_VALUE})
    public void testGameOverIllegalValues(int n) {
        try{
            new GameOver(n);
        }catch(Exception e){
            fail(e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 5, 100, 124})
    public void testGameOverGetters(int n)
    {
        GameOver gameOver = new GameOver(n);
        assertEquals("SCORE: "+n,gameOver.getScore());
    }


}
