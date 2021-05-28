package main.fb.supers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * A class that describes the start button
 */
public class Button
{
    public int x;
    public int y;
    public int width;
    public int height;
    public boolean pressed;
    private BufferedImage image;
    
    /**
	 * Constructor - creating a new button
     * @param x - x position
     * @param y - y position
	 * @param width - the buttons width
	 * @param height - the buttons height
     * @param image - the buttons image
	 * @see Button#Button(int,int,int,int,BufferedImage)
	 */
    public Button(final int x, final int y, final int width, final int height, final BufferedImage image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
    }
    
    public static boolean checkCollision(final int mouseX, final int mouseY, final Button btn) {
        return mouseX >= btn.x && mouseX <= btn.x + btn.width && mouseY >= btn.y && mouseY <= btn.y + btn.height;
    }
    
    public void render(final Graphics g) {
        if (this.pressed) {
            g.drawImage(this.image, this.x + 1, this.y + 1, this.width - 2, this.height - 2, null);
        }
        else {
            g.drawImage(this.image, this.x, this.y, null);
        }
    }
}