package NumberGuessingGame;

public class Messages {
    
    public  static String showRange(int start, int end){
        return String.format("The number is in "
                + "the range of [%d,%d].%n", start, end);
    }
    
    public static String isPrimeNumber(){
        return "The number is a prime.\n";
    }
    
    public static String showMultiple(int multiple){
        return String.format("The number is multiple of %d.%n", multiple);
    }
    
    public static String anotherGame(){
        return "Let's go to another game!\n";
    }
    
    public static String askContinuePlaying(){
        return """
               Enter 'c' key to play another game!
               To exit enter whatever key:""";
    }
    
    public static String showGuessedNumber(int ramNumber){
        return String.format("Incorrect! The guessed number is %d.\n"
                , ramNumber);
    }
    
    public static String isTheCorrectNumber(int chances, int lives){
        return String.format("Congratulations!"
                + " You guessed the correct number in %d attempts.\n"
                , chances - lives + 1);
    }
    
    public static String isGreaterThan(int guess){
        return String.format("Incorrect! The number is greater than %d.\n"
                , guess);
    }
    
    public static String isLessThan(int guess){
        return String.format("Incorrect! The number is less than %d.\n", guess);
    }
    
    public static String outOfRangeGuess(){
        return """
               Guess has to be into the range of [1-100].
               """;
    }
    
    public static String isNotNumberGuess(){
        return "Guess has to be a positive integer number.\n";
    }
    
    public static String getInstructions(){
        return """
               Welcome to the Number Guessing Game!
               I'm thinking of a number between 1 and 100.
               You have a number of chances to guess 
               the correct number.\n""";
    }
    
    public static String getSelectingDifficulty(){
        return """
               Please select the difficulty level:
               1. Easy (10 chances)
               2. Medium (5 chances)
               3. Hard (3 chances)\n""";
    }
    
    public static String askChoice(){
        return "Enter your choice: ";
    }
    
    public static String badChoice(){
        return "Choice has to be in the range of [1-3]\n";
    }
    
    public static String finalMessage(){
        return "\nThanks to playing GuessingNumberGame.";
    }
    
    public static String enterGuess(){
        return "Enter your guess: ";
    }
    
    
    public static String successfullChoice(String choice){
        String difficulty = null;
        switch (choice) {
            case "1" -> difficulty = "Easy";
            case "2" -> difficulty = "Medium";
            case "3" -> difficulty = "Hard";
        }
        return String.format("Great! You have selected"
                + " the %s difficulty level.\n" 
                + "Let's start the game!\n", difficulty);
    }
    
    public static void main(String[] args) {
        
    }
}
