
package NumberGuessingGame;

import java.util.regex.Pattern;

public class Validations {
    public static String checkChoice(String choice){
        if(Pattern.matches("[1-3]", choice)){
            System.out.println(Messages.successfullChoice(choice));
            return choice;
        }
        System.out.println(Messages.badChoice());
        return null;
    }
    
    public static boolean checkGuessExpression(String guess){
        if(Pattern.matches("\\D+", guess)){
            System.out.println(Messages.isNotNumberGuess());
            return false;
        }
        if(!Pattern.matches("\\d{1,2}", guess)){
            System.out.println(Messages.outOfRangeGuess());
            return false;
        }
        return true;
    }
    
    public static boolean checkGuess(int guess, int lives, int ramNumber){
        if(guess != ramNumber){
            if(lives == 1)
                System.out.println(Messages.showGuessedNumber(ramNumber));
            else if(guess < ramNumber)
                System.out.println(Messages.isGreaterThan(guess));
            else if(guess > ramNumber)
                System.out.println(Messages.isLessThan(guess));
            return false;
        }
        return true;
    }
}
