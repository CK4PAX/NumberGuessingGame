package NumberGuessingGame;

public class Attemps {
    private int attemps;
    
    public Attemps(int attemps){
        this.attemps = attemps;
    }
    
    public Attemps(){
    }

    public int getAttemps() {
        return attemps;
    }

    public void setAttemps(int attemps) {
        this.attemps = attemps;
    }

    public void decrement(){
        if(this.attemps > 0)
            this.attemps -= 1;
    }
    
    public boolean lastAttemp(){
        return attemps ==  1;
    }
    
    public boolean hasAttemps(){
        return this.attemps > 0;
    }
}
