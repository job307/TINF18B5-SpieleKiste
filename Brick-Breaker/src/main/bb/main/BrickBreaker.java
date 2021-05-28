package main.bb.main;

import javax.swing.JFrame;
import java.awt.*;
import main.bb.loaders.ImageLoader;

/**
 * A class that describes the graphical interface
 */
public class BrickBreaker extends JFrame {
	public static int WIDTH = 700;
	public static int HEIGHT = 760;

	/**
	 * Constructor - create a new interface of the game
	 * @see BrickBreaker#BrickBreaker()
	 */
	public BrickBreaker() {
		setTitle("Brick Breaker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Image windowIcon = null;
		try {
			windowIcon = new ImageLoader("brickbreaker.png").getImage();
		} catch (Exception e) {
			e.printStackTrace();
		}

        setIconImage(windowIcon);
		setContentPane(new Controller());
		pack();
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BrickBreaker();
	}
}
