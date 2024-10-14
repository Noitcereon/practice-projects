package me.noitcereon;

import javax.swing.*;

public class ApplicationEntryPoint {

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            ApplicationGui app = new ApplicationGui();
            app.setVisible(true);
        });
    }
}
