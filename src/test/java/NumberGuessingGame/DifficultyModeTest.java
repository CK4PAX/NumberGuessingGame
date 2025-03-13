package NumberGuessingGame;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DifficultyModeTest {
    
    public DifficultyModeTest() {
    }
    
    public void provideInput(String input){
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
    
    @Test
    public void testInput() {
        String input = "1";
        provideInput(input);
        assertEquals(input, DifficultyMode.input());
    }
    
    @Test
    public void testValidateInput() {
        String input = "1";
        assertEquals(input,DifficultyMode.validateInput(input));
    }
    
    @Test
    public void testValidateInputFail() {
        String input = "&/";
        assertNull(DifficultyMode.validateInput(input));
    }
    
    @Test
    public void testAskMode() {
        String input = "2";
        provideInput(input);
        assertEquals("2", DifficultyMode.askMode());
    }
    
}
