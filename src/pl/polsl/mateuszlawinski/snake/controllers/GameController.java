package pl.polsl.mateuszlawinski.snake.controllers;

import pl.polsl.mateuszlawinski.snake.exceptions.ArgumentException;
import pl.polsl.mateuszlawinski.snake.models.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Class is responsible for all game processes
 * @author Mateusz Lawinski
 * @version 1.0
 */

public class GameController extends JPanel implements ActionListener{
    /**
     * Field stores snake
     */
    private Snake snake;
    /**
     * Field stores apple
     */
    private Apple apple;
    /**
     * Field stores configuration of the game
     */
    private GameConfig gameConfig;
    /**
     * Field stores true if game is started or false if game ends
     */
    private boolean running = false;
    /**
     * Field stores timer of the game
     */
    private Timer timer;
    /**
     * Field stores data we want to show after the end of the game
     */
    private GameOver gameOver;

    /**
     * Constructor
     * @param args parameters entered by user
     * @throws ArgumentException exception we want to throw
     */
    public GameController(String []args) throws ArgumentException {
        ArrayList<String> arr = run(args);
        if(checkInput(arr) == true)
            this.gameConfig = new GameConfig(arr.get(0),arr.get(1),arr.get(2),arr.get(3));
        Random random = new Random();
        this.setPreferredSize(new Dimension(gameConfig.getWidth(),gameConfig.getHeight()));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        this.startGame();
    }

    /**
     * Method loads parameters to array and call checkInput to check them
     * @param args parameters entered by user
     * @return ArrayList included parameters entered by user
     * @throws ArgumentException exception if parameters are not correct
     */
    private ArrayList<String> run(String []args) throws ArgumentException {
        ArrayList<String> arr = new ArrayList<String>();
        for (int i=0;i<args.length;i++) {
            arr.add(args[i]);
        }
        checkInput(arr);
        return arr;
    }

    /**
     * Method closes the game
     * @param e event which indicates that a keystroke occurred in a component
     */
    private void exitGame(KeyEvent e) {
        JComponent comp = (JComponent) e.getSource();
        Window win = SwingUtilities.getWindowAncestor(comp);
        win.dispose();
    }

    /**
     * Method stars the game
     */
    private void startGame() {
        this.gameOver = null;
        this.snake = new Snake(gameConfig);
        this.apple = new Apple(gameConfig);
        this.running = true;
        this.timer = new Timer(gameConfig.getDelay(),this);
        this.timer.start();
    }
    /**
     * Method adds a new part of snake to the ArrayList
     */
    private void addSnakeElement() {
        Coordinates NewElement = new Coordinates();
        NewElement.setX(snake.getArrayList().get(snake.getArrayList().size()-1).getX());
        NewElement.setY(snake.getArrayList().get(snake.getArrayList().size()-1).getY());
        this.snake.getArrayList().add(NewElement);
    }

    /**
     * Method checks if an apple is eaten by snake. If it is true new apple is created and addSnakeElement() is called
     */
    private void eatApple() {
        if(apple.getPosition().getX() == snake.getArrayList().get(0).getX()
                && apple.getPosition().getY() == snake.getArrayList().get(0).getY()) {
            this.apple = null;
            this.apple = new Apple(gameConfig);
            addSnakeElement();
        }
    }

    /**
     * Method called if game is done
     */
    private void gameOver() {
        running = false;
        this.gameOver = new GameOver(snake.getArrayList().size()-3);
        this.snake = null;
        this.apple = null;
        timer.stop();
    }
    /**
     * Method is responsible for checking position of the snake. If snake is out of the board or snake eats his tail gameOver() is called
     */
    private void checkSnakePosition() {
        if(eatTail() == true || snakeOutside() == true)
            gameOver();
    }

    /**
     * Method checks position of snake's head
     * @return true if snake's head is out of the board or false if it is not
     */
    private boolean snakeOutside() {
        if(     snake.getArrayList().get(0).getX() >= gameConfig.getWidth() ||
                snake.getArrayList().get(0).getX() < 0 ||
                snake.getArrayList().get(0).getY() >= gameConfig.getHeight() ||
                snake.getArrayList().get(0).getY() < 0)
            return true;
        return false;
    }

    /**
     * Method checks position of snake's head and the elements of his body
     * @return true if snake's head and one of elements of snake's body are on the same place false if they are not
     */
    private boolean eatTail() {
        for(int i = 4; i<snake.getArrayList().size(); i++) {
            if(snake.getArrayList().get(0).getX() == snake.getArrayList().get(i).getX() && snake.getArrayList().get(0).getY() == snake.getArrayList().get(i).getY())
                return true; //
        }
        return false;
    }
    /**
     * Method is responsible for paint graphics
     */
    public void paint(Graphics g) {
        super.paint(g);
        draw(g);
    }
    /**
     * Method is responsible for draw elements of our game in the window
     * @param g graphic
     */
    void draw(Graphics g) {

        if(running) {
            g.setColor(Color.red);
            g.fillOval(apple.getPosition().getX(), apple.getPosition().getY(), gameConfig.getElementSize(), gameConfig.getElementSize()); //drawing apple

            for (int i = 0; i < snake.getArrayList().size(); i++) { //drawing snake
                g.setColor(Color.green); //setting color to our snakee
                g.fillRect(snake.getArrayList().get(i).getX(), snake.getArrayList().get(i).getY(), gameConfig.getElementSize(), gameConfig.getElementSize()); //drawing every part of snake on screen
            }
        }
        else {
            g.setColor(Color.red);
            g.setFont(gameOver.getFontBigger());
            FontMetrics fm = g.getFontMetrics();
            g.drawString(gameOver.getStrGameOver(), (getWidth() - fm.stringWidth(gameOver.getStrGameOver()) )/ 2, (getHeight() - fm.getHeight()) / 3 + fm.getAscent());
            g.setFont(gameOver.getFontSmaller());
            fm = g.getFontMetrics();
            g.drawString(gameOver.getScore(), (getWidth() - fm.stringWidth(gameOver.getScore()) )/ 2, (getHeight() - fm.getHeight()) / 2 + fm.getAscent());
            g.drawString(gameOver.getStrInfo(), (getWidth() - fm.stringWidth(gameOver.getStrInfo()) )/ 2, (getHeight() - fm.getHeight()) / 1 + fm.getAscent()-50);
        }
    }

    /**
     * Method moves the snake on the board
     */
    private void moveSnake(){
        for (int i = snake.getArrayList().size()-1; i > 0; i--) {
            snake.getArrayList().get(i).setX(snake.getArrayList().get(i-1).getX());
            snake.getArrayList().get(i).setY(snake.getArrayList().get(i-1).getY());
        }
        if (snake.getDirection() == 'N')
            snake.getArrayList().get(0).setY(snake.getArrayList().get(0).getY()-gameConfig.getElementSize());
        else if (snake.getDirection() == 'S')
            snake.getArrayList().get(0).setY(snake.getArrayList().get(0).getY()+gameConfig.getElementSize());
        else if (snake.getDirection() == 'W')
            snake.getArrayList().get(0).setX(snake.getArrayList().get(0).getX()-gameConfig.getElementSize());
        else if (snake.getDirection() == 'E')
            snake.getArrayList().get(0).setX(snake.getArrayList().get(0).getX()+gameConfig.getElementSize());
    }

    /**
     * Method checks correctness of the parameters on input
     * @param array stores parameters from input
     * @return true if parameters are correct
     * @throws ArgumentException if parameters are not integer
     */
    private boolean checkInput(ArrayList<String> array) throws ArgumentException {
        if(array.size() != 4) {
            System.out.println("Invalid number of arguments! Program will load 4 arguments now!");
            Scanner scanner = new Scanner(System.in);
            array.clear();
            int i=0;
            System.out.println("Please enter 4 arguments:");
            while(i<4 && scanner.hasNextInt()) {
                int input = scanner.nextInt();
                array.add(String.valueOf(input));
                i++;
            }
            this.checkInput(array);
        }
        try {//if parameters are not numbers or parameters are equal or less than 0 we will throw exception
            int number;
            for (int i = 0; i < array.size(); i++) {
                number = Integer.parseInt(array.get(i)); // checking correctness of arguments
                if(number<=0)
                    throw new ArgumentException("Parameters can not be equal or less than 0!");
            }
        } //
        catch (NumberFormatException e) {
            throw new ArgumentException("One or more of the parameters is not a number!");
            //Scanner scanner = new Scanner(System.in);
        }
        return true;
    }
    /**
     * Method is responsible for updating game data if game is running and repaint elements on the screen
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(running) { // if game is running
            moveSnake();
            eatApple();
            checkSnakePosition();
        }
        repaint();
    }
    /**
     * Class takes care for control snake and control on the end game screen
     */
    private class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()== KeyEvent.VK_RIGHT && running == true && snake.getDirection() != 'W')
                snake.setDirection('E');
            else if(e.getKeyCode()== KeyEvent.VK_LEFT && running == true && snake.getDirection() != 'E')
                snake.setDirection('W');
            else if(e.getKeyCode()== KeyEvent.VK_DOWN && running == true && snake.getDirection() != 'N')
                snake.setDirection('S');
            else if(e.getKeyCode()== KeyEvent.VK_UP && running == true && snake.getDirection() != 'S')
                snake.setDirection('N');
            else if(e.getKeyCode()== KeyEvent.VK_SPACE && running == false)
                startGame();
            else if(e.getKeyCode()== KeyEvent.VK_ESCAPE && running == false)
                exitGame(e);
        }
    }
}

