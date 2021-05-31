package test.fb.gameobjects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.fb.enums.TubeType;
import main.fb.gameobjects.Tube;

public class TestTube {
    
    @Test
    public void testTick() {
        Tube t = new Tube(500, 0, 78, 200, TubeType.BOTTOM);
        t.tick();

        assertEquals(497, t.getX());
    }
}
