package pl.polsl.mateuszlawinski.snake.models;

import java.awt.*;

/**
 * Class is responsible for store data of the end game screen
 * @author Mateusz Lawinski
 * @version 1.0
 */
public class GameOver {
    /**
     * String stores data to display on the end screen
     */
    private String strGameOver;
    /**
     * String stores data to display on the end screen
     */
    private String strInfo;

    /**
     * Field stores font which are used to render text in a visible way.
     */
    private Font fontBigger;
    /**
     * Field stores font which are used to render text in a visible way
     */
    private Font fontSmaller;

    /**
     * String stores number of points which player got in game
     */
    private String score; //

    /**
     * Constructor of the class
     * @param score number of points user has earned
     */
    public GameOver(int score) {
        this.strGameOver = "GAME OVER";
        this.strInfo = "PRESS SPACE TO RESTART GAME OR ESCAPE TO EXIT";
        this.fontBigger = new Font("Arial", Font.BOLD, 72);
        this.fontSmaller = new Font("Arial", Font.BOLD, 36);
        this.score = "SCORE: "+String.valueOf(score);
    }

    /**
     * Getter to the String field
     * @return strGameOver
     */
    public String getStrGameOver()
    {
        return this.strGameOver;
    }
    /**
     * Getter to the String field
     * @return strInfo
     */
    public String getStrInfo()
    {
        return this.strInfo;
    }
    /**
     * Getter to the Font field
     * @return fontBigger
     */
    public Font getFontBigger()
    {
        return this.fontBigger;
    }
    /**
     * Getter to the Font field
     * @return fontBigger
     */
    public Font getFontSmaller()
    {
        return this.fontSmaller;
    }
    /**
     * Getter to the String field
     * @return score
     */
    public String getScore()
    {
        return this.score;
    }


}
