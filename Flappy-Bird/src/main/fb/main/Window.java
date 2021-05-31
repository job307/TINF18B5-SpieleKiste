package main.fb.main;

import java.awt.Component;
import java.io.IOException;
import java.net.ServerSocket;
import javax.swing.JFrame;

/**
 * A class that sets up the Frame and starts the game
 */
public class Window extends JFrame
{
    /**
     * Constructor - creating a new frame
     * @param width - the width of the frame
     * @param height - the height of the frame
     * @param title - the title that appears on the new window
     * @param game - the current game which is playing
     * @see Window#Window(int,int,String,Game)
     */
    public Window(final int width, final int height, final String title, final FlappyBirdGame game) {
        try {
            game.serverSocket = new ServerSocket(9999);
        }
        catch (IOException e) {
            System.out.println("Spiel bereits gestartet!");
            System.exit(0);
        }
        this.setTitle(title);
        this.pack();
        this.setSize(width + this.getInsets().left + this.getInsets().right, height + this.getInsets().top + this.getInsets().bottom);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
        this.add((Component)game);
        game.start();
    }
}