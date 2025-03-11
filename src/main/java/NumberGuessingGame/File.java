package NumberGuessingGame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class File {
    Path path;
    public File(String uri){
        path = Path.of(uri);
        init();
    }
    
    public final int init(){
        try {
            if(!Files.exists(path))
                Files.createFile(path);
            return 0;
        } catch (IOException e) {
            System.out.println("High Points file can not be created");
            return -1;
        }
    }
    
    public String read(){
        try {
            String data = Files.readString(path);
            return data;
        } catch (IOException e) {
            System.out.println("High Points file can not be readed");
            return null;
        }
    }
    
    public int write(String data){
        try {
            Files.writeString(path, data);
            return 0;
        } catch (IOException e) {
            System.out.println("High Points file can not be written");
            return 1;
        }
    }
}
