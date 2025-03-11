package NumberGuessingGame;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    
    Game game;
    Settings settings;
    
    public GameTest() {
        provideInput("1");
        game = new Game();
        settings = game.settings;
    }

    public void provideInput(String input){
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
    
    @Test
    public void testInit(){
        provideInput("1");
        assertDoesNotThrow(()->{game.init();});
    }
    
    @Test
    public void testAskChoiceWith(){
        provideInput("2");
        assertEquals("2", game.askChoice());
    }
    
    @Test
    public void testGetGuess(){
        provideInput("50");
        assertEquals("50", game.getGuess());
    }
    
    @Test
    public void testCheckGuess(){
        int lives = 3;
        int ramNumber = 99;
        String guess = "99";
        assertTrue(game.checkGuess(guess, lives, ramNumber));
    }
    
    @Test
    public void testCheckGuessWithOutOfRange(){
        int lives = 5;
        int ramNumber = 99;
        String guess = "150";
        assertFalse(game.checkGuess(guess, lives, ramNumber));
    }
    
    @Test
    public void testCheckGuessWithNotNumber(){
        int lives = 5;
        int ramNumber = 99;
        String guess = "jfh.)";
        assertFalse(game.checkGuess(guess, lives, ramNumber));
    }
    
    @Test
    public void testCheckGuessFailWithOneLive(){
        int lives = 1;
        int ramNumber = 99;
        String guess = "56";
        assertFalse(game.checkGuess(guess, lives, ramNumber));
    }
    
    @Test
    public void testCheckGuessFail(){
        int lives = 3;
        int ramNumber = 99;
        String guess = "56";
        assertFalse(game.checkGuess(guess, lives, ramNumber));
    }
    
    @Test
    public void testProvideHint(){
        int ran = 69;
        assertDoesNotThrow(()->{game.provideHint(ran);});
    }
    
    /*@Test
    public void testGuessingCycle(){
        for (int i = 0; i < settings.getChances(); i++) {
            provideInput("50");
            assertDoesNotThrow(()->{game.guessingCycle();});
        }
    }*/
}
