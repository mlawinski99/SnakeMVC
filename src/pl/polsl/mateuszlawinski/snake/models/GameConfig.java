package pl.polsl.mateuszlawinski.snake.models;

/**
 * Class is responsible for store configuration of the game screen
 * @author Mateusz Lawinski
 * @version 1.0
 */
public class GameConfig {
    /**
     * Int stores width of the window
     */
    private int width;
    /**
     * Int stores height of the window
     */
    private int height;
    /**
     * Int stores size of each element on the board
     */
    private  int elementSize;
    /**
     * Int stores delay of the game
     */
    private int delay;

    /**
     * Constructor of the class
     * @param width width of the screen
     * @param height height of the screen
     * @param elementSize size of the element on the screen
     * @param delay delay of the game
     */
    public GameConfig(String width, String height, String elementSize, String delay)
    {
        this.width = Integer.parseInt(width);
        this.height = Integer.parseInt(height);
        this.elementSize = Integer.parseInt(elementSize);
        this.delay = Integer.parseInt(delay);
    }
    /**
     * Getter of the width field
     * @return width of the window
     */
    public int getWidth()
    {
        return this.width;
    }
    /**
     * Getter of the height field
     * @return height of the window
     */
    public int getHeight()
    {
        return this.height;
    }
    /**
     * Getter of the elementSize field
     * @return elementSize in the game
     */
    public int getElementSize()
    {
        return this.elementSize;
    }
    /**
     * Getter of the delay field
     * @return delay of the game
     */
    public int getDelay()
    {
        return this.delay;
    }



}
