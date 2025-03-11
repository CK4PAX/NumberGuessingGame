package NumberGuessingGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {

    Settings settings = new Settings();
    BufferedReader reader;
    Timer timer = new Timer();
    HightScores hscores = new HightScores();

    public Game() {
        init();
    }

    public final void init() {
        System.out.println(Messages.getInstructions());
        System.out.println(Messages.getSelectingDifficulty());
        String choice = askChoice();
        if (choice == null) {
            System.out.println(Messages.finalMessage());
            System.exit(0);
        }
        settings.setChances(choice);
    }

    public final String askChoice() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            int i = 0;
            String choice = null;
            while (choice == null && i < 3) {
                System.out.print(Messages.askChoice());
                choice = Validations.checkChoice(reader.readLine());
                i++;
            }
            return choice;
        } catch (IOException e) {
            System.out.println("Input can not be readed");
            return null;
        }
    }

    public String getGuess() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(Messages.enterGuess());
            return reader.readLine();
        } catch (IOException e) {
            System.out.println("Input can not be readed");
            return null;
        }
    }

    public boolean checkGuess(String guess, int lives, int ranNumber) {
        if (!Validations.checkGuessExpression(guess)) {
            return false;
        }
        int parsedGuess = Byte.parseByte(guess);
        return Validations.checkGuess(parsedGuess, lives, ranNumber);
    }

    public void provideHint(int ranNumber) {
        double ranDisplay = Math.random() / Math.nextDown(1);
        if (ranDisplay > 0.6) {
            double type = Math.random() / Math.nextDown(1);
            if (type > 0.3) {
                HintSystem.findMultiple(ranNumber);
            } else {
                HintSystem.provideRange(ranNumber);
            }
        }
    }

    public void guessingCycle() {
        int chances = settings.getChances();
        int lives = chances;
        ComputedNumber cn = new ComputedNumber();
        int ranNumber = cn.getNumber();
        String guess;
        timer.startTimer();

        while (lives > 0) {
            guess = getGuess();
            if (checkGuess(guess, lives, ranNumber)) {
                System.out.println(Messages.isTheCorrectNumber(chances, lives));
                timer.endTimer();
                hscores.setNewEntry(chances - lives + 1, timer.getDuration());
                break;
            } else {
                lives--;
            }

            if (lives == 1) {
                provideHint(ranNumber);
            }
        }
        timer.endTimer();
    }

    public void start() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        boolean another;
        try {
            do {
                guessingCycle();
                System.out.println(Messages.askContinuePlaying());
                another = reader.readLine().equalsIgnoreCase("c");
                if (another) {
                    System.out.println(Messages.anotherGame());
                }
            } while (another);
        } catch (IOException e) {
            System.out.println("Error while key was enter");
        }
        hscores.showScores();
        System.out.println(Messages.finalMessage());
    }
}
