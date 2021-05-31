package test.bb.gameobjects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.bb.gameobjects.Ball;

public class TestBall {
    
    @Test
    public void testSetOnFire() {
        Ball b = new Ball(100, 100, false);
        b.setOnFire(5);

        assertEquals(5, b.getFireSec());
        assertEquals(true, b.getOnFire());
    }
}
