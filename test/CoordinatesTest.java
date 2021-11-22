import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pl.polsl.mateuszlawinski.snake.models.Apple;
import pl.polsl.mateuszlawinski.snake.models.Coordinates;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CoordinatesTest {

    @Test
    public void testCoordinates()
    {
        try{
            new Coordinates();
        }catch(Exception e){
            fail(e.getMessage());
        }
    }
    @ParameterizedTest
    @ValueSource(ints = {2, -3, 154, Integer.MAX_VALUE})
    public void testCoordinatesSetterGetterX(int n)
    {
        Coordinates coordinates = new Coordinates();
        coordinates.setX(n);
        assertEquals(n, coordinates.getX());
    }

    @ParameterizedTest
    @ValueSource(ints = {2, -3, 154, Integer.MAX_VALUE})
    public void testCoordinatesSetterGetterY(int n)
    {
        Coordinates coordinates = new Coordinates();
        coordinates.setY(n);
        assertEquals(n, coordinates.getY());
    }

}
