package main.fb.loaders;

import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * A class that describes the loading of game resources
 */
public class GraphicsLoader
{
    public static BufferedImage loadGraphics(final String path) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(ResourceLoader.load("images/" + path));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}