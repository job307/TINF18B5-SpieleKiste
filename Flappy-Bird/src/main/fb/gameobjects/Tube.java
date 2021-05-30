package main.fb.gameobjects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.fb.enums.TubeType;
import main.fb.handlers.ObjectHandler;
import main.fb.loaders.GraphicsLoader;
import main.fb.main.FlappyBirdGame;
import main.fb.supers.GameObject;


/**
 * A class that describes the behavior of the tube
 */
public class Tube extends GameObject
{
    TubeType type;
    BufferedImage tubeBlock;
    BufferedImage tube;
    
    /**
	 * Constructor - creating a new tube
	 * @param x - X coordinate
	 * @param y - Y coordinate
	 * @param width - the width of the tube
     * @param height - the height of the tube
     * @param type - the tube type
	 * @see Tube#Tube(int,int,int,int,TubeType)
	 */
    public Tube(final int x, final int y, final int width, final int height, final TubeType type) {
        super(x, y, width, height);
        this.type = type;
        this.velX = 3.0f;
        this.tube = GraphicsLoader.loadGraphics("tube.png");
        if (type == TubeType.BOTTOM) {
            this.tubeBlock = GraphicsLoader.loadGraphics("tubebottomdown.png");
        }
        else if (type == TubeType.TOP) {
            this.tubeBlock = GraphicsLoader.loadGraphics("tubebottomtop.png");
        }
    }
    
    @Override
    public void tick() {
        this.x -= (int)this.velX;
        if (this.x + this.width < 0) {
            ObjectHandler.removeObject((GameObject)this);
            if (this.type == TubeType.TOP) {
                ++FlappyBirdGame.score;
            }
        }
    }
    
    @Override
    public void render(final Graphics g) {
        if (this.type == TubeType.BOTTOM) {
            g.drawImage(this.tube, this.x, this.y, 72, this.height, null);
            g.drawImage(this.tubeBlock, this.x - 3, this.y, null);
        }
        else if (this.type == TubeType.TOP) {
            g.drawImage(this.tube, this.x, this.y, 72, this.height, null);
            g.drawImage(this.tubeBlock, this.x - 3, this.y + this.height - 36, null);
        }
    }
}