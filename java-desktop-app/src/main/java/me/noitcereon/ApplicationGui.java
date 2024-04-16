package me.noitcereon;

import javax.swing.*;
import javax.swing.text.JTextComponent;

public class ApplicationGui extends JFrame {

    private static final String APP_NAME = "My Java Desktop Application";
    public ApplicationGui(){
        super(APP_NAME);

        //2. Optional: What happens when the frame closes?
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Set size of window in pixels.
        setSize(600, 400);

        // Open in center of the screen
        setLocationRelativeTo(null);

        // There is no general layout. We must manually adjust all components.
        setLayout(null);

        // Prevent resizing of the application window.
        setResizable(false);

        addGuiComponents();
    }

    private void addGuiComponents() {
        JLabel welcomeComponent = new JLabel("Welcome to %s".formatted(APP_NAME));
        welcomeComponent.setBounds(15, 15, 300, 45);
        welcomeComponent.getPreferredSize();
        add(welcomeComponent);

        JButton button = new JButton("Click me!");

        add(button);
    }

}
