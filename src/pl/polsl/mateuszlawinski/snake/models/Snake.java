package pl.polsl.mateuszlawinski.snake.models;

import java.util.ArrayList;
/**
 * Class is responsible for store data of our snake
 * @author Mateusz Lawinski
 * @version 1.0
 */
public class Snake {
    /**
     * ArrayList stores every part of the snake
     */
    private ArrayList<Coordinates> arrayList;
    /**
     * Char stores direction of the snake
     */
    private char direction;
    /**
     * Constructor of the snake, creates 3 elements snake at the start of the game
     * @param gameConfig the configuration of the game
     */
    public Snake(GameConfig gameConfig) {
        arrayList = new ArrayList<>();
        direction = 'E';
        Coordinates head = new Coordinates();
        head.setX(gameConfig.getElementSize()*3);
        head.setY(gameConfig.getElementSize());
        arrayList.add(head);

        Coordinates body1 = new Coordinates();
        body1.setX(gameConfig.getElementSize()*2);
        body1.setY(gameConfig.getElementSize());
        arrayList.add(body1);

        Coordinates body2 = new Coordinates();
        body2.setX(gameConfig.getElementSize()*1);
        body2.setY(gameConfig.getElementSize());
        arrayList.add(body2);
    }
    /**
     * Getter of the ArrayList field
     * @return ArrayList
     */
    public ArrayList<Coordinates> getArrayList()
    {
        return this.arrayList;
    }
    /**
     * Getter of the direction field
     * @return direction of the snake
     */
    public char getDirection() {
        return this.direction;
    }
    /**
     * Setter of the direction field
     * @param c direction of the snake
     */
    public void setDirection(char c)
    {
        this.direction = c;
    }




}
