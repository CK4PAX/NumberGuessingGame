package NumberGuessingGame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessagesTest {
    
    public MessagesTest() {
    }

    @Test
    public void testSomeMethod() {
    }
    
    @Test
    public void testGetInstructions() {
        assertDoesNotThrow(()->{Messages.getInstructions();});
    }
    
    @Test
    public void testGetSelectingDifficulty() {
        assertDoesNotThrow(()->{Messages.getSelectingDifficulty();});
    }
    
}
