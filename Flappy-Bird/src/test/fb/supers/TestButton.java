package test.fb.supers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.fb.supers.Button;

public class TestButton {
    
    @Test
    public void testMouseOver() {
        Button btn = new Button(10, 10, 100, 100, null);
        boolean result1 = Button.mouseOver(10, 10, btn);
        boolean result2 = Button.mouseOver(2, 2, btn);

        assertEquals(result1, true);
        assertEquals(result2, false);
    }
}
