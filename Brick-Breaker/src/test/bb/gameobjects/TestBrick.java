package test.bb.gameobjects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.bb.gameobjects.Brick;

public class TestBrick {
    
    Brick br = new Brick(2, 2, 4);

    @Test
    public void testHasCollided() {
        br.hasCollided();

        assertEquals(3, br.level);
        assertEquals(false, br.hasDied);
    }

    @Test
    public void testDestroyed() {
        br.destroyed();

        assertEquals(0, br.level);
        assertEquals(true, br.hasDied);
    }
}
