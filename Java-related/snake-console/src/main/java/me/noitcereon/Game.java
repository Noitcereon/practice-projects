package me.noitcereon;

import java.util.logging.Logger;

public class Game {
    private long points;
    private Player player;

    public Game(){
        // Showing the implicit empty constructor.
        player = new Player();
    }

    private static final Logger LOG = Logger.getLogger(Game.class.getSimpleName());
    public void startGame(){
        LOG.info("Starting game");
        gameLoop();
    }
    private void gameLoop(){
        while(player.isAlive()){
            // TODO: Do stuff
        }
        showScoreScreen();
    }
    private void showScoreScreen(){
        System.out.println();
    }
}
