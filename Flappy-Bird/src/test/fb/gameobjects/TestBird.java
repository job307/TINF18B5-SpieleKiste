package test.fb.gameobjects;

import main.fb.gameobjects.Bird;

public class TestBird {
    private Bird bird = new Bird(1, 1, 1, 1);

    private int testSum(){
        int res = bird.sum(1, 2);
        assertEquals(res, 3)
    }
}
