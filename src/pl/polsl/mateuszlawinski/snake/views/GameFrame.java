package pl.polsl.mateuszlawinski.snake.views;

import pl.polsl.mateuszlawinski.snake.controllers.GameController;
import pl.polsl.mateuszlawinski.snake.exceptions.ArgumentException;

import javax.swing.*;
import java.awt.*;

/**
 * Class is responsible for the main window of the game
 * @author Mateusz Lawinski
 * @version 1.0
 */
public class GameFrame extends JFrame {

    /**
     * Constructor of the main window
     * @param args  parameters entered by user
     * @throws ArgumentException    exception threw if entered parameters is valid
     */
    public GameFrame(String []args) throws ArgumentException {
        this.add(new GameController(args));
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.getContentPane().setBackground(Color.black);
    }
}