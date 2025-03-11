package NumberGuessingGame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class HintSystemTest {
    
    public HintSystemTest() {
    }

    @Test
    public void testFindMultipleWithOneDigitRan() {
        int ran = 8;
        assertDoesNotThrow(()->{HintSystem.findMultiple(ran);});
    }
    
    @Test
    public void testFindMultipleWithOneDigidPrimeRan() {
        int ran = 9;
        assertDoesNotThrow(()->{HintSystem.findMultiple(ran);});
    }
    
    @Test
    public void testFindMultipleWithSquareRan() {
        int ran = 64;
        assertDoesNotThrow(()->{HintSystem.findMultiple(ran);});
    }
    
    @Test
    public void testFindMultipleWithTwoDigitRan() {
        int ran = 60;
        assertDoesNotThrow(()->{HintSystem.findMultiple(ran);});
    }
    
    @Test
    public void testProvideRangeWithRanLessThanfive() {
        int ran =  4;
        assertEquals(1, HintSystem.provideRange(ran));
    }
    
    @Test
    public void testProvideRangeWithRanGreaterThanNinetyFive() {
        int ran =  97;
        assertEquals(2, HintSystem.provideRange(ran));
    }
    
    @Test
    public void testProvideRangeWithRanBetweenFiveAndNinetyFive() {
        int ran =  65;
        assertEquals(0, HintSystem.provideRange(ran));
    }
    
    @Test
    public void testGetRan(){
        int min = 23, max = 78;
        for (int i = 0; i < 10; i++) {
            int ran = HintSystem.getRan(min, max);
            boolean test = ran >= min && ran <= max;
            assertTrue(test);
        }
    }
}
