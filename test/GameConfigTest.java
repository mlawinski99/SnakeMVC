import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import pl.polsl.mateuszlawinski.snake.models.Apple;
import pl.polsl.mateuszlawinski.snake.models.GameConfig;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.fail;

public class GameConfigTest {

    @Test
    public void testGameConfig() {
        try{
        new GameConfig("1920", "1080", "40", "60");
        new GameConfig("1280", "720", "40", "100");
        }catch(Exception e){
            fail(e.getMessage());
        }
    }

    @Test
    public void testGameConfigIllegalValues() {
        try{
            new GameConfig("", "", "", "");
            fail("Exception was expected for blank input");
        }catch (IllegalArgumentException e){
        }
        try
        {
            new GameConfig("a", "s", "d", "c");
            fail("Exception was expected for non-number input");
        }catch(IllegalArgumentException e){
        }
        try {
            new GameConfig(null, null, null, null);
            fail("Exception was expected for null input");
        }catch (IllegalArgumentException e){
        }
        try {
            new GameConfig("1280.234", "720.234", "40.1", "100.223");
            fail("Exception was expected floating point input");
        }catch (IllegalArgumentException e){
        }
    }

    @Test
    public void testGetters()
    {
        GameConfig gameConfig= new GameConfig("1280","720","40","100");
        Assertions.assertEquals(1280, gameConfig.getWidth());
        Assertions.assertEquals(720, gameConfig.getHeight());
        Assertions.assertEquals(40, gameConfig.getElementSize());
        Assertions.assertEquals(100, gameConfig.getDelay());
    }

}
