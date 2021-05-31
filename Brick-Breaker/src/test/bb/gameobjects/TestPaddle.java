package test.bb.gameobjects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.bb.gameobjects.Paddle;
import main.bb.gameobjects.Powerup;
import java.awt.*;

public class TestPaddle {

    Paddle p = new Paddle(100, 100);
    Paddle p2 = new Paddle(100, 100);
    Powerup pow = new Powerup(100, 100, 2);
    Rectangle left = new Rectangle(90, 100, 100, 30);
    Rectangle right = new Rectangle(110, 100, 100, 30);

    @Test
    public void testIsColliding() {
        assertEquals(true, p.isColliding(pow));
    }

    @Test
    public void testMoveLeft() {
        p.moveLeft();
        assertEquals(left, p.bounds);
    }
    
    @Test
    public void testMoveRight() {
        p2.moveRight();
        assertEquals(right, p2.bounds);
    }
}
