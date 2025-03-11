package NumberGuessingGame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TimerTest {
    
    Timer timer = new Timer();
    public TimerTest() {
    }

    public void iterar(long x){
        for (long i = 0; i < x; i++); 
    }
    
    @Test
    public void getDuration() {
        timer.startTimer();
        iterar(2100000000);
        timer.endTimer();
        assertDoesNotThrow(()->{System.out.println(timer.getDuration());});
    }
    
}
