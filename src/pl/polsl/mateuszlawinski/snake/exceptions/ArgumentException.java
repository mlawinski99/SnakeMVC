package pl.polsl.mateuszlawinski.snake.exceptions;


/**
 * Class is responsible for throw an exception
 * @author Mateusz Lawinski
 * @version 1.0
 */
public class ArgumentException extends Exception{
    /**
     * Constructor of the class
     * @param message the message we want to throw with an exception
     */
    public ArgumentException(String message)
    {
        super(message);
    }
}
