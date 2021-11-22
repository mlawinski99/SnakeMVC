package pl.polsl.mateuszlawinski.snake.models;

/**
 * Class is responsible for store coordinates of each element on the board
 * @author Mateusz Lawinski
 * @version 1.0
 */
public class Coordinates {

    /**
     * Ints store coordinates of each element on the board
     */
    private int x, y;

    /**
     * Constructor
     */
    public Coordinates() {}
    /**
     * Getter of the x field
     * @return x-coordinate
     */
    public int getX()
    {
        return this.x;
    }
    /**
     * Setter of the x field
     * @param x x-coordinate
     */
    public void setX(int x)
    {
        this.x = x;
    }
    /**
     * Getter of the y field
     * @return y-coordinate
     */
    public int getY()
    {
        return this.y;
    }
    /**
     * Setter of the y field
     * @param y y-coordinate
     */
    public void setY(int y)
    {
        this.y = y;
    }



}
