package NumberGuessingGame;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReaderTest {
    
    public ReaderTest() {
    }
    
    public void provideInput(String input){
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
    
    @Test
    public void testRead() {
        String input = "rosas";
        provideInput(input);
        assertEquals(input, Reader.read());
    }
    
    @Test
    public void testReadMultiple() {
        String[] inputs = {"rosas","books","children"};
        for (String input : inputs) {
            provideInput(input);
            assertEquals(input, Reader.read());
        }
        
    }
    
}
