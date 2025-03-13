package NumberGuessingGame;

public class Game {

    Settings settings = new Settings();
    HightScores hscores = new HightScores();

    public Game() {
        init();
    }

    public final void init() {
        initMessages();
        setDifficulty();
    }

    public void initMessages() {
        Messages.getInstructions();
        Messages.getSelectingDifficulty();
    }

    public void setDifficulty() {
        String difficulty = DifficultyMode.askMode();
        if (difficulty != null) {
            settings.setAttemps(difficulty);
        } else {
            Messages.finalMessage();
            System.exit(0);
        }
    }

    public void guessing() {
        new Guessing(this).cycle();
    }
    
    public boolean askContinue(){
        Messages.askContinuePlaying();
        return Reader.read().equalsIgnoreCase("c");
    }
    
    public void playing(){
        do {
            guessing();
        } while (askContinue());
    }
    
    public void endGame(){
        hscores.showScores();
        Messages.finalMessage();
    }

    public void start() {
        playing();
        endGame();
    }

    public static void main(String[] args) {
        new Game().start();
    }
}
