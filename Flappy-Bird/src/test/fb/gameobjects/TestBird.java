package test.fb.gameobjects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import main.fb.gameobjects.Bird;

public class TestBird {
    
    @Test
    public void testTick(){
        Bird bird = Bird.getBird();
        bird.tick();

        assertEquals(0.3f, bird.gravity);
        assertEquals(12.0f, bird.maxSpeed);
        assertEquals(0.3f, bird.getVelY());
        assertEquals(50 + (int)0.3, bird.getY());
    }
}
