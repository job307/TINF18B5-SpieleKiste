package main.fb.supers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * A class loops through multiple images of one object so the movement looks more smooth
 */
public class Animation
{
    private int x;
    private int y;
    private int currentImage;
    private long delay;
    private long startTime;
    private boolean loop;
    private boolean running;
    private GameObject target;
    private BufferedImage[] images;
    
    /**
	 * Constructor - creating a new animation for a gameobject
	 * @param target - the gameobject to animate
	 * @param delay - the duration between switching images
	 * @param loop - if the images should run in a loop or only once
     * @param images - the images to loop through
	 * @see Animation#Animation(GameObject,long,boolean,BufferedImage[])
	 */
    public Animation(final GameObject target, final long delay, final boolean loop, final BufferedImage[] images) {
        this.x = target.getX();
        this.y = target.getY();
        this.currentImage = 0;
        this.delay = delay;
        this.startTime = 0L;
        this.loop = loop;
        this.setTarget(target);
        this.images = images;
    }
    
    /**
	 * Constructor - creating a new animation for a gameobject
	 * @param target - the gameobject to animate
     * @param x - move the animation in x-direction
     * @param y - move the animation in y-direction
	 * @param delay - the duration between switching images
	 * @param loop - if the images should run in a loop or only once
     * @param images - the images to loop through
	 * @see Animation#Animation(GameObject,int,int,long,boolean,BufferedImage[])
	 */
    public Animation(final GameObject target, final int x, final int y, final long delay, final boolean loop, final BufferedImage[] images) {
        this.x = target.getX() + x;
        this.y = target.getY() + y;
        this.currentImage = 0;
        this.delay = delay;
        this.startTime = 0L;
        this.loop = loop;
        this.setTarget(target);
        this.images = images;
    }
    
    /**
	 * Constructor - creating a new animation for a gameobject
     * @param x - set the animation to x-coordinate
     * @param y - set the animation to y-coordinate
	 * @param delay - the duration between switching images
	 * @param loop - if the images should run in a loop or only once
     * @param images - the images to loop through
	 * @see Animation#Animation(int,int,long,boolean,BufferedImage[])
	 */
    public Animation(final int x, final int y, final long delay, final boolean loop, final BufferedImage[] images) {
        this.x = x;
        this.y = y;
        this.currentImage = 0;
        this.delay = delay;
        this.startTime = 0L;
        this.loop = loop;
        this.setTarget(null);
        this.images = images;
    }
    
    public void render(final Graphics g) {
        if (this.target == null) {
            g.drawImage(this.images[this.currentImage], this.x, this.y, null);
        }
        else {
            g.drawImage(this.images[this.currentImage], this.target.x, this.target.y, null);
        }
    }
    
    public void tick() {
        final long pastTime = (System.nanoTime() - this.startTime) / 1000000L;
        if (pastTime >= this.delay && this.running) {
            ++this.currentImage;
            this.startTime = System.nanoTime();
        }
        if (this.currentImage == this.images.length) {
            this.currentImage = 0;
            if (!this.loop) {
                this.stop();
            }
        }
    }
    
    public void start() {
        this.running = true;
        this.currentImage = 0;
        this.startTime = 0L;
    }
    
    public void stop() {
        this.running = false;
        this.currentImage = 0;
        this.startTime = 0L;
    }
    
    public GameObject getTarget() {
        return this.target;
    }
    
    public void setTarget(final GameObject target) {
        this.target = target;
    }
    
    public int getX() {
        return this.x;
    }
    
    public void setX(final int x) {
        this.x = x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void setY(final int y) {
        this.y = y;
    }
    
    public int getCurrentImage() {
        return this.currentImage;
    }
    
    public void setCurrentImage(final int currentImage) {
        this.currentImage = currentImage;
    }
    
    public long getDelay() {
        return this.delay;
    }
    
    public void setDelay(final long delay) {
        this.delay = delay;
    }
    
    public boolean isLoop() {
        return this.loop;
    }
    
    public void setLoop(final boolean loop) {
        this.loop = loop;
    }
    
    public boolean isRunning() {
        return this.running;
    }
    
    public void setRunning(final boolean running) {
        this.running = running;
    }
    
    public BufferedImage[] getImages() {
        return this.images;
    }
    
    public void setImages(final BufferedImage[] images) {
        this.images = images;
    }
}