package main.fb.gameobjects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.fb.handlers.ObjectHandler;
import main.fb.loaders.GraphicsLoader;
import main.fb.main.FlappyBirdGame;
import main.fb.supers.Animation;
import main.fb.supers.GameObject;

/**
 * A class that describes the behavior of the bird
 */
public class Bird extends GameObject
{
    private static Bird bird;
    Animation animation;
    public float gravity;
    public float maxSpeed;
    
    /**
	 * Constructor - creating a new bird
	 * @param x - X coordinate
	 * @param y - Y coordinate
	 * @param width - the width of the bird
     * @param height - the height of the bird
	 * @see Bird#Bird(int,int,int,int)
	 */
    private Bird(final int x, final int y, final int width, final int height) {
        super(x, y, width, height);
        this.gravity = 0.3f;
        this.maxSpeed = 12.0f;
        final BufferedImage[] images = new BufferedImage[3];
        for (int i = 0; i < images.length; ++i) {
            images[i] = GraphicsLoader.loadGraphics("bird" + i + ".png");
        }
        (this.animation = new Animation(this, 100L, true, images)).start();
        ObjectHandler.addObject((GameObject)this);
    }

    public static Bird getBird() {
        if(bird == null) {
            bird = new Bird(50, 50, 51, 36);
        }
        return bird;
    }
    
    @Override
    public void tick() {
        this.velY += this.gravity;
        this.y += (int)this.velY;
        if (this.velY > this.maxSpeed) {
            this.velY = this.maxSpeed;
        }
        if (this.y + this.height > 602) {
            this.y = 602 - this.height;
            this.setVelY(0.0f);
        }
        if (this.y < 0) {
            this.y = 0;
            this.setVelY(0.0f);
        }
        GameObject temp = null;
        for (int i = 0; i < ObjectHandler.list.size(); ++i) {
            temp = ObjectHandler.list.get(i);
            if (temp instanceof Tube && this.getBounds().intersects(temp.getBounds())) {
                FlappyBirdGame.gameover = true;
            }
        }
        this.animation.tick();
    }
    
    @Override
    public void render(final Graphics g) {
        this.animation.render(g);
    }
}