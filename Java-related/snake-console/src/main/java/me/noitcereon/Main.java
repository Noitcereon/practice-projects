package me.noitcereon;

import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World!");
        System.out.println(StartMenu.createMenuText());
        try{
            do {
                if (Keyboard.isKeyPressed(KeyEvent.VK_W)) System.out.println("W is pressed!");
            } while (!Keyboard.isKeyPressed(KeyEvent.VK_ESCAPE));
            System.out.println("1 was pressed.");
        }
       catch (Exception e){
           e.printStackTrace();
           int seconds = 10 * 1000;
           Thread.sleep(seconds);
           System.exit(1);
       }

        // Wait for input
//        int input = System.in.read();
//
//        StartMenuOption startMenuOption = StartMenuOption.getFromUserInput(input);
//
//        switch (startMenuOption){
//            case Start:
//                Game game = new Game();
//                game.startGame();
//                break;
//            case Options:
//                System.out.println("Options not implemented.");
//                break;
//            case GameHistory:
//                System.out.println("Game history not implemented.");
//                break;
//            default:
//                System.out.println("That menu option does not exist. Try 1, 2 or 3.");
//                break;
//        }
    }
}