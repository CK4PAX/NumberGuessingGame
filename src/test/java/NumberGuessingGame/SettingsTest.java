package NumberGuessingGame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SettingsTest {
    
    Settings settings = new Settings();
    public SettingsTest() {
    }

    @Test
    public void testSetAttempsMedium() {
        String opt = "2";
        settings.setAttemps(opt);
        assertEquals(5, settings.getAttemps());
    }
    
    @Test
    public void testSetAttempsEasy() {
        String opt = "1";
        settings.setAttemps(opt);
        assertEquals(10, settings.getAttemps());
    }
    
    @Test
    public void testSetAttempsHard() {
        String opt = "3";
        settings.setAttemps(opt);
        assertEquals(3, settings.getAttemps());
    }
}
