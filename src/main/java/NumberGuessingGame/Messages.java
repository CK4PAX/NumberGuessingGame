package NumberGuessingGame;

public class Messages {
    
    public  static void showRange(int start, int end){
        System.out.printf("The number is in "
                + "the range of [%d,%d].%n", start, end);
    }
    
    public static void isPrimeNumber(){
        System.out.println("The number is a prime.\n");
    }
    
    public static void showMultiple(int multiple){
        System.out.printf("The number is multiple of %d.%n", multiple);
    }
    
    public static void askContinuePlaying(){
        System.out.println("""
               \nEnter 'c' key to play another game!
               To exit enter whatever key:""");
    }
    
    public static void showGuessedNumber(int ramNumber){
        System.out.printf("Incorrect! The guessed number is %d.\n"
                , ramNumber);
    }
    
    public static void isTheCorrectNumber(int attemps){
        System.out.printf("Congratulations!"
                + " You guessed the correct number in %d attempts.\n"
                , attemps);
    }
    
    public static void isGreaterThan(int guess){
        System.out.printf("Incorrect! The number is greater than %d.\n\n"
                , guess);
    }
    
    public static void isLessThan(int guess){
        System.out.printf("Incorrect! The number is less than %d.\n\n", guess);
    }
    
    public static void outOfRangeGuess(){
        System.out.println("""
               Guess has to be an integer that is into the range of [1-100].
               """);
    }
    
    public static void isNotNumberGuess(){
        System.out.println("Guess has to be a positive integer number.\n");
    }
    
    public static void getInstructions(){
        System.out.println("""
               Welcome to the Number Guessing Game!
               I'm thinking of a number between 1 and 100.
               You have a number of chances to guess 
               the correct number.\n""");
    }
    
    public static void getSelectingDifficulty(){
        System.out.println("""
               Please select the difficulty level:
               1. Easy (10 chances)
               2. Medium (5 chances)
               3. Hard (3 chances)\n""");
    }
    
    public static void askDifficulty(){
        System.out.print("Enter your choice: ");
    }
    
    public static void badChoice(){
        System.out.println("Choice has to be in the range of [1-3].\n");
    }
    
    public static void finalMessage(){
        System.out.println("Thanks to playing GuessingNumberGame.");
    }
    
    public static void enterGuess(){
        System.out.print("Enter your guess: ");
    }
    
    
    public static void selectedDifficulty(String choice){
        String difficulty = null;
        switch (choice) {
            case "1" -> difficulty = "Easy";
            case "2" -> difficulty = "Medium";
            case "3" -> difficulty = "Hard";
        }
        System.out.printf("""
                          \nGreat! You have selected the %s difficulty level.
                          Let's start the game!\n
                          """, difficulty);
    }
}
