package NumberGuessingGame;

public class Guessing {
    Attemps attemps;
    ComputedNumber cn;
    Guess guess;
    Timer timer;
    Settings settings;
    HightScores hscores;

    public Guessing(Game game) {
        settings = game.settings;
        attemps = new Attemps(settings.getAttemps());
        cn = new ComputedNumber();
        timer = new Timer();
        hscores = game.hscores;
        guess = new Guess();
    }

    public boolean checkContinue() {
        return attemps.hasAttemps() && guess.getGuess() != cn.getRandom();
    }

    public int getDoneAttemps(int attemps) {
        return settings.getAttemps() - attemps;
    }

    public double getRanNumber() {
        return Math.random() / Math.nextDown(1);
    }

    public void provideHint(int ranNumber) {
        double ranDisplay = getRanNumber();
        if (ranDisplay > 0.6) {
            double type = getRanNumber();
            if (type > 0.3) {
                HintSystem.findMultiple(ranNumber);
            } else {
                HintSystem.provideRange(ranNumber);
            }
        }
    }

    public void setOnSuccess() {
        timer.endTimer();
        Messages.isTheCorrectNumber(getDoneAttemps(attemps.getAttemps()));
        hscores.setNewEntry(getDoneAttemps(attemps.getAttemps()), timer.getDuration());
    }

    public void checkLastAttemp() {
        if (attemps.lastAttemp()) {
            provideHint(cn.getRandom());
        }
    }
    
    public void isLessOrGreater(){
        if(guess.getGuess() < cn.getRandom())
            Messages.isGreaterThan(guess.getGuess());
        else
            Messages.isLessThan(guess.getGuess());
    }

    public void setOnFail() {
        if (attemps.hasAttemps()) {
            isLessOrGreater();
            checkLastAttemp();
        }else{
            timer.endTimer();
            Messages.showGuessedNumber(cn.getRandom());
        }
    }

    public void compare() {
        if (guess.getGuess() == cn.getRandom()) {
            setOnSuccess();
        } else {
            setOnFail();
        }
    }

    public void setGuess() {
        guess.setInput();
        if (guess.validateInput()) {
            guess.setGuess();
            compare();
        }
    }

    public void cycle() {
        timer.startTimer();
        do{
            attemps.decrement();
            setGuess();
        }while (checkContinue());
    }
}
