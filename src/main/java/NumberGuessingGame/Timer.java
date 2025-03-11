package NumberGuessingGame;

public class Timer {
    long start;
    long end;
    
    public void startTimer(){
        start = System.currentTimeMillis();
    }
    
    public void endTimer(){
        end = System.currentTimeMillis();
    }
    
    public float getDuration(){
        return ((float)(end - start))/1000;
    }
}
