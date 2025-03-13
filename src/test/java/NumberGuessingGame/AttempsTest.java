package NumberGuessingGame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AttempsTest {
    
    Attemps attemps = new Attemps();
    public AttempsTest() {
    }

    @Test
    public void testDecrement() {
        this.attemps.setAttemps(5);
        this.attemps.decrement();
        assertEquals(4, this.attemps.getAttemps());
    }
    
    @Test
    public void testDecrementWithZeroAttemps() {
        this.attemps.setAttemps(0);
        this.attemps.decrement();
        assertEquals(0, this.attemps.getAttemps());
    }
    
    @Test
    public void testLastAttemp() {
        this.attemps.setAttemps(1);
        assertTrue(attemps.lastAttemp());
    }
    
    @Test
    public void testLastAttempWithSeveralAttemps() {
        this.attemps.setAttemps(8);
        assertFalse(attemps.lastAttemp());
    }
    
    @Test
    public void testHasAttempsWithZeroAttemps() {
        this.attemps.setAttemps(0);
        assertFalse(attemps.hasAttemps());
    }
    
    @Test
    public void testHasAttemps() {
        this.attemps.setAttemps(1);
        assertTrue(attemps.hasAttemps());
    }
    
}
