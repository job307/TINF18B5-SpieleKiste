package main.fb.main;

import java.awt.Graphics;
import java.awt.Component;
import java.awt.image.BufferStrategy;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.KeyListener;
import java.net.ServerSocket;

import javax.swing.JFrame;

import main.fb.gameobjects.Bird;
import main.fb.gameobjects.Ground;
import main.fb.handlers.KeyHandler;
import main.fb.handlers.MouseHandler;
import main.fb.handlers.ObjectHandler;
import main.fb.handlers.TubeHandler;
import main.fb.loaders.GraphicsLoader;
import main.fb.supers.Button;

import java.awt.image.BufferedImage;
import java.awt.Canvas;

/**
 * A class that describes the logic of the game
 */
public class FlappyBirdGame extends Canvas implements Runnable
{
    public static final int WIDTH = 432;
    public static final int HEIGHT = 768;
    public boolean running;
    public static boolean gameover;
    public static BufferedImage img_gameover;
    public static BufferedImage background;
    public static Ground ground;
    public static Bird bird;
    public static Button startButton;
    public static int score;
    Thread thread;
    ServerSocket serverSocket;
    
    public static void main(final String[] args) {
        FlappyBirdGame game = new FlappyBirdGame();
        JFrame jf = new JFrame();
        try {
            game.serverSocket = new ServerSocket(9999);
        }
        catch (Exception e) {
            System.out.println("Spiel bereits gestartet!");
            System.exit(0);
        }
        jf.setTitle("FlappyBird [Springen mit Leertaste]");
        jf.pack();
        jf.setSize(WIDTH + jf.getInsets().left + jf.getInsets().right, HEIGHT + jf.getInsets().top + jf.getInsets().bottom);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(3);
        jf.setVisible(true);
        jf.add((Component)game);
        game.start();
    }
    
    public synchronized void start() {
        this.running = true;
        (this.thread = new Thread()).start();
        this.run();
    }
    
    public void init() {
        this.addKeyListener((KeyListener)new KeyHandler());
        this.addMouseListener((MouseListener)new MouseHandler());
        FlappyBirdGame.img_gameover = GraphicsLoader.loadGraphics("gameover.png");
        FlappyBirdGame.background = GraphicsLoader.loadGraphics("background.png");
        FlappyBirdGame.ground = new Ground();
        FlappyBirdGame.bird = Bird.getBird();
        FlappyBirdGame.startButton = new Button(138, 200, 156, 87, GraphicsLoader.loadGraphics("playbutton.png"));
    }
    
    public void tick() {
        if (!FlappyBirdGame.gameover) {
            ObjectHandler.tick();
            FlappyBirdGame.ground.tick();
        }
    }
    
    public void render() {
        final BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        final Graphics g = bs.getDrawGraphics();
        g.drawImage(FlappyBirdGame.background, 0, 0, null);
        FlappyBirdGame.ground.render(g);
        ObjectHandler.render(g);
        if (FlappyBirdGame.gameover) {
            g.drawImage(FlappyBirdGame.img_gameover, 72, 130, null);
            FlappyBirdGame.startButton.render(g);
        }
        g.setFont(new Font("Arial", 1, 48));
        g.setColor(Color.WHITE);
        final String s = Integer.toString(FlappyBirdGame.score);
        final int textWidth = g.getFontMetrics().stringWidth(s);
        g.drawString(s, 216 - textWidth / 2, 40);
        g.dispose();
        bs.show();
    }
    
    @Override
    public void run() {
        this.init();
        this.requestFocus();
        long pastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        final double ns = 1.0E9 / amountOfTicks;
        double delta = 0.0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        while (this.running) {
            final long now = System.nanoTime();
            delta += (now - pastTime) / ns;
            pastTime = now;
            while (delta > 0.0) {
                this.tick();
                ++updates;
                this.render();
                ++frames;
                --delta;
            }
            if (System.currentTimeMillis() - timer > 1000L) {
                timer += 1000L;
                System.out.println("FPS: " + frames + " | TICKS: " + updates);
                TubeHandler.tick();
                updates = 0;
                frames = 0;
            }
        }
    }
}
