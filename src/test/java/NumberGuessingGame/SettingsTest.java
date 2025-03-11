package NumberGuessingGame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SettingsTest {
    
    Settings settings = new Settings();
    public SettingsTest() {
    }

    @Test
    public void testSetChances() {
        String opt = "2";
        settings.setChances(opt);
        assertEquals(5, settings.getChances());
    }
    
}
