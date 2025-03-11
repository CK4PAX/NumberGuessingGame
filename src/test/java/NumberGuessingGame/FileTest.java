package NumberGuessingGame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FileTest {
    
    File file = new File("test.json");
    public FileTest() {
    }
    
    @Test
    public void testRead(){
        assertNotNull(file.read());
    }
    
    @Test
    public void testWrite(){
        String string = "[]";
        assertEquals(0,file.write(string));
    }
}
