package NumberGuessingGame;

import java.util.regex.Pattern;

public class Guess {
    private int guess;
    private String input;
    
    public Guess(){
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public void setGuess(){
        this.guess = Integer.parseInt(input);
    }
    
    public void setInput(String input) {
        this.input = input;
    }

    public void setInput(){
        Messages.enterGuess();
        this.input = Reader.read();
    }
    
    public int getGuess(){
        return guess;
    }
    
    public boolean validateInput(){
        if(Pattern.matches("\\D+", input)){
            Messages.isNotNumberGuess();
            return false;
        }
        if(!Pattern.matches("\\d{1,2}", input) && !input.equals("100")){
            Messages.outOfRangeGuess();
            return false;
        }
        return true;
    }
}
