package NumberGuessingGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
    
    public static String read(){
        BufferedReader reader = 
            new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            System.out.println("Input can not be read");
            return null;
        }
    }
}
