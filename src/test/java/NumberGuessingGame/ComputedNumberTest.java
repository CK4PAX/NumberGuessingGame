package NumberGuessingGame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComputedNumberTest {
    
    ComputedNumber cn = new ComputedNumber();
    public ComputedNumberTest() {
    }

    @Test
    public void testGenerateNumber() {
        assertDoesNotThrow(()->{cn.generateRan();});
    }
    
}
