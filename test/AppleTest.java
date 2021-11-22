import org.junit.Test;
import pl.polsl.mateuszlawinski.snake.models.Apple;
import pl.polsl.mateuszlawinski.snake.models.GameConfig;

import static org.junit.jupiter.api.Assertions.fail;

public class AppleTest {
    GameConfig gameConfig = new GameConfig("1280","720","40","100");

    @Test
    public void testApple()
    {
        try{
            new Apple(gameConfig);
        }catch(Exception e){
            fail(e.getMessage());
        }
    }


}
