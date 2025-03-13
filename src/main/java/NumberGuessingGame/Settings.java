package NumberGuessingGame;

public class Settings {
    private int attemps;

    public int getAttemps() {
        return attemps;
    }

    public void setAttemps(String opt) {
        switch (opt) {
            case "1" -> attemps = 10;
            case "2" -> attemps = 5;
            case "3" -> attemps = 3;
        }
    }
  
}
