package NumberGuessingGame;

public class ComputedNumber {
    private int random;
    static final int MIN = 1;
    static final int MAX = 100;
    
    public ComputedNumber() {
        generateRan();
    }
    
    public final void generateRan(){
        double t = Math.random()/ Math.nextDown(1);
        random = (int)Math.round(MIN * (1 - t) + MAX * t);
    }

    public int getRandom() {
        return random;
    }
}
