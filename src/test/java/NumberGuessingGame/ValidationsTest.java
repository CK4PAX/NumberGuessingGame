package NumberGuessingGame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidationsTest {
    
    public ValidationsTest() {
    }
    
    @Test
    public void testCheckChoice() {
        String choice = "2";
        assertEquals("2", Validations.checkChoice(choice));
    }
    
    @Test
    public void testCheckChoiceFail() {
        String choice = "15";
        assertEquals(null, Validations.checkChoice(choice));
    }
    
    @Test
    public void testCheckGuessExpression(){
        String guess = "67";
        assertTrue(Validations.checkGuessExpression(guess));
    }
    
    @Test
    public void testCheckGuessExpressionWithOutsideOfRange(){
        String guess = "150";
        assertFalse(Validations.checkGuessExpression(guess));
    }
    
    @Test
    public void testCheckGuessExpressionWithNoNumber(){
        String guess = "&%3$·8";
        assertFalse(Validations.checkGuessExpression(guess));
    }
    
    @Test
    public void testCheckGuess(){
        byte guess = 60;
        byte lives = 3;
        byte ramNumber = 65;
        assertFalse(Validations.checkGuess(guess,lives,ramNumber));
    }
    
    @Test
    public void testCheckGuessWithOneLive(){
        byte guess = 60;
        byte lives = 1;
        byte ramNumber = 65;
        assertFalse(Validations.checkGuess(guess,lives,ramNumber));
    }
    
    @Test
    public void testCheckGuessWithCorrectGuess(){
        byte guess = 65;
        byte lives = 1;
        byte ramNumber = 65;
        assertTrue(Validations.checkGuess(guess,lives,ramNumber));
    }
}
