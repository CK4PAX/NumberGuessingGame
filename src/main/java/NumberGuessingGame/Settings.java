package NumberGuessingGame;

public class Settings {
    int chances;

    public int getChances() {
        return chances;
    }

    public void setChances(String opt) {
        switch (opt) {
            case "1" -> chances = 10;
            case "2" -> chances = 5;
            case "3" -> chances = 3;
        }
    }
}
