package main.fb.handlers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import main.fb.main.FlappyBirdGame;
import main.fb.supers.Button;
import main.fb.supers.GameObject;

/**
 * A class that describes how to manipulate the mouse to control buttons
 */
public class MouseHandler implements MouseListener
{
    @Override
    public void mouseClicked(final MouseEvent e) {
    }
    
    @Override
    public void mousePressed(final MouseEvent e) {
        if (Button.mouseOver(e.getX(), e.getY(), FlappyBirdGame.startButton) && FlappyBirdGame.gameover) {
            FlappyBirdGame.startButton.pressed = true;
            ObjectHandler.list.clear();
            ObjectHandler.addObject((GameObject)FlappyBirdGame.bird);
            FlappyBirdGame.gameover = false;
            FlappyBirdGame.score = 0;
            FlappyBirdGame.startButton.pressed = false;
        }
    }
    
    @Override
    public void mouseReleased(final MouseEvent e) {
    }
    
    @Override
    public void mouseEntered(final MouseEvent e) {
    }
    
    @Override
    public void mouseExited(final MouseEvent e) {
    }
}