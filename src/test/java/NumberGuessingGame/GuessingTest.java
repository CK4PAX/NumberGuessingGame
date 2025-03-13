package NumberGuessingGame;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GuessingTest {
    Game game;
    Guessing guessing;
    
    public GuessingTest() {
        provideInput("3");
        game = new Game();
        guessing = new Guessing(game);
        guessing.hscores = new HightScores("test.json");
    }
    
    public static void provideInput(String input){
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
    
    public void provideBadGuess(){
        int ran = guessing.cn.getRandom();
        String test = String.valueOf((ran + 1 > 100)? ran -1: ran + 1);
        provideInput(test);
    }
    
    public void provideCorrectGuess(){
        int ran = guessing.cn.getRandom();
        provideInput(String.valueOf(ran));
    }
    
    @Test
    public void testCompareNotEqual() {
        provideBadGuess();
        assertDoesNotThrow(()->{guessing.setGuess();});
    }
    
    @Test
    public void testCompareEqual() {
        guessing.timer.startTimer();
        provideCorrectGuess();
        assertDoesNotThrow(()->{guessing.setGuess();});
    }
    
    @Test
    public void testSetGuessWithInvalidData(){
        provideInput("14.5");
        assertDoesNotThrow(()->{guessing.setGuess();});
    }
    
    @Test
    public void testSetOnFailWithAttemps(){
        guessing.attemps.setAttemps(4);
        provideBadGuess();
        assertDoesNotThrow(()->{guessing.setGuess();});
    }
    
    @Test
    public void testSetOnFailWithoutAttemps(){
        guessing.attemps.setAttemps(0);
        provideBadGuess();
        assertDoesNotThrow(()->{guessing.setGuess();});
    }
    
    @Test
    public void testCheckLastAttemp(){
        guessing.attemps.setAttemps(1);
        provideBadGuess();
        assertDoesNotThrow(()->{guessing.setGuess();});
    }
    
    @Test
    public void testProvideHint(){
        assertDoesNotThrow(()->{guessing.provideHint(30);});
    }
    
    @Test
    public void testCheckContinueWithBadGuess(){
        guessing.attemps.setAttemps(1);
        provideBadGuess();
        assertTrue(guessing.checkContinue());
    }
    
    @Test
    public void testCheckContinueWithCorrectGuess(){
        guessing.attemps.setAttemps(1);
        provideCorrectGuess();
        guessing.setGuess();
        assertFalse(guessing.checkContinue());
    }
    
    @Test
    public void testCheckContinueWithoutAttemps(){
        guessing.attemps.setAttemps(0);
        provideCorrectGuess();
        guessing.setGuess();
        assertFalse(guessing.checkContinue());
    }
    
    @Test
    public void testIsLessOrGreaterForLess(){
        int ranNum = guessing.cn.getRandom();
        guessing.guess.setGuess(ranNum + 1);
        assertDoesNotThrow(()->{guessing.isLessOrGreater();});
    }
    
    @Test
    public void testIsLessOrGreaterForGreater(){
        int ranNum = guessing.cn.getRandom();
        guessing.guess.setGuess(ranNum - 1);
        assertDoesNotThrow(()->{guessing.isLessOrGreater();});
    }
}
