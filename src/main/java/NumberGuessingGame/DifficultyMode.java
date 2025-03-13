package NumberGuessingGame;

import java.util.regex.Pattern;

public class DifficultyMode {

    static final int ATTEMPS = 3;

    public static String input() {
        Messages.askDifficulty();
        return Reader.read();
    }

    public static String validateInput(String input) {
        if(Pattern.matches("[1-3]", input)){
            Messages.selectedDifficulty(input);
            return input;
        }else{
            Messages.badChoice();
            return null;
        }
    }
    
    public static boolean checkModeAndAttemps(String mode, int i){
        return mode == null && i < ATTEMPS;
    }

    public static String askMode() {
        int i = 0;
        String mode = null;
        do {
            i++;
            mode = validateInput(input());
        } while (checkModeAndAttemps(mode, i));
        return mode;
    }
}
