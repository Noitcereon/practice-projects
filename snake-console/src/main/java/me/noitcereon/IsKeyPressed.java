package me.noitcereon;

import java.awt.*;
import java.awt.event.KeyEvent;

public class IsKeyPressed {
    private static volatile boolean wPressed = false;
    public static boolean isWPressed() {
        synchronized (IsKeyPressed.class) {
            return wPressed;
        }
    }

    public static void main(String[] args) {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(keyEvent -> {
            synchronized (IsKeyPressed.class) {
                switch (keyEvent.getID()) {
                    case KeyEvent.KEY_PRESSED:
                        if (keyEvent.getKeyCode() == KeyEvent.VK_W) {
                            wPressed = true;
                        }
                        break;

                    case KeyEvent.KEY_RELEASED:
                        if (keyEvent.getKeyCode() == KeyEvent.VK_W) {
                            wPressed = false;
                        }
                        break;
                }
                return false;
            }
        });
    }
}