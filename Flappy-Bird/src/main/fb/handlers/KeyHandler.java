package main.fb.handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.fb.main.FlappyBirdGame;

/**
 * A class describing the manipulation of keys to control the paddle
 */
public class KeyHandler implements KeyListener
{
    @Override
    public void keyTyped(final KeyEvent e) {
    }
    
    @Override
    public void keyPressed(final KeyEvent e) {
        if (e.getKeyCode() == 32) {
            FlappyBirdGame.bird.setVelY(-6.0f);
        }
    }
    
    @Override
    public void keyReleased(final KeyEvent e) {
    }
}