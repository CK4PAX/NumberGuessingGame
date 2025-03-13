package NumberGuessingGame;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GuessTest {
    
    Guess guess = new Guess();
    public GuessTest() {
    }

    public void provideInput(String input){
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
    
    @Test
    public void testSetInput(){
        provideInput("56");
        assertDoesNotThrow(()->{guess.setInput();});
    }
    
    @Test
    public void testValidateInput(){
        guess.setInput("45");
        assertTrue(guess.validateInput());
    }
    
    @Test
    public void testValidateInputWithNotNumber(){
        guess.setInput("%&23");
        assertFalse(guess.validateInput());
    }
    
    @Test
    public void testValidateInputWithOutOfRange(){
        guess.setInput("150");
        assertFalse(guess.validateInput());
    }
}
