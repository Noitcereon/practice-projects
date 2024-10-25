package me.noitcereon;

/**
 * Represents the snake, which the player controls.
 */
public class Player {
    private int snakeLength;
    private boolean isAlive;

    public Player(){
       isAlive = false;
    }
    public int getSnakeLength() {
        return snakeLength;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setSnakeLength(int snakeLength) {
        this.snakeLength = snakeLength;
    }

    public void die() {
        isAlive = false;
    }
}
