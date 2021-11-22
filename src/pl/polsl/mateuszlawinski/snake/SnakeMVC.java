package pl.polsl.mateuszlawinski.snake;

import pl.polsl.mateuszlawinski.snake.exceptions.ArgumentException;
import pl.polsl.mateuszlawinski.snake.views.GameFrame;

/**
 * Main class of the program
 * @author Mateusz Lawinski
 * @version 1.0
 */

public class SnakeMVC {
    /**
     * Main method, Program starts and ends here.
     * @param args parameters entered by user
     * @throws ArgumentException if parameters are not correct
     * User needs to enter 4 parameters at start: width of the game window, height of the game window, elementSize in the game, and delay of the game
     * Order of the parameters: width height elementSize delay
     */
    public static void main(String[] args) throws ArgumentException {
        new GameFrame(args);
    }
}
