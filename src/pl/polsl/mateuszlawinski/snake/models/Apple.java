package pl.polsl.mateuszlawinski.snake.models;

import java.util.Random;

/**
 * Class is responsible for store data of the apple
 * @author Mateusz Lawinski
 * @version 1.0
 */

public class Apple {
    /**
     * Coordinates stores position of the apple
     */
    private Coordinates position;

    /**
     * Constructor of the class, sets random position of the apple on the board
     * @param gameConfig the configuration of the game
     */
    public Apple(GameConfig gameConfig)
    {
        this.position = new Coordinates();
        Random random = new Random();
        this.position.setX(random.nextInt(gameConfig.getWidth()/gameConfig.getElementSize())*gameConfig.getElementSize());
        this.position.setY(random.nextInt(gameConfig.getHeight()/gameConfig.getElementSize())*gameConfig.getElementSize());
    }

    /**
     * Getter of the field position
     * @return position
     */
    public Coordinates getPosition()
    {
        return this.position;
    }

}
