package NumberGuessingGame;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class HightScores {
    JSONArray hscores;
    File file;
    static final int SCORELIMIT = 5;
    
    public HightScores(){
        file = new File("hscores.json");
        init();
    }
    
    public HightScores(String uri){
        file = new File(uri);
        init();
    }
    
    public final void init(){
        String data = file.read();
        if(!data.isEmpty())
            hscores = new JSONArray(data);
        else
            hscores = new JSONArray();
    }
    
    public void showScores(){
        System.out.println("\n"+"*".repeat(7)+"HIGH SCORES"+"*".repeat(7));
        String columns = "Place"+" ".repeat(3) +
                        "Attemps" + " ".repeat(3) +
                         "Seconds";
        System.out.println(columns);
        System.out.println("-".repeat(columns.length()));
        
        for (int i = 0; i < hscores.length(); i++) {
            JSONObject score = hscores.getJSONObject(i);
            String seconds = String.valueOf(score.getFloat("seconds"));
            String attemps = String.valueOf(score.getInt("attemps"));
            String row =  " ".repeat(2) + String.valueOf(i + 1) +
                    " ".repeat(8) + attemps + " ".repeat(6) +
                    seconds +"s";
            System.out.println(row);
        }
        System.out.println("-".repeat(columns.length()));;
    }
    
    public void setPlace(int place, int attemps, float seconds){
        JSONObject applicant = new JSONObject();
        applicant.put("attemps", attemps);
        applicant.put("seconds", seconds);
        List list = hscores.toList();
        list.add(place, applicant);
        hscores = new JSONArray(list);
    }
    
    public int findPlace(int attemps, float seconds){
        int length = hscores.length();
        if(length == 0)
            return 0;

        for (int i = length - 1; i >= 0; i--) {
            JSONObject score = hscores.getJSONObject(i);
            int storedAttemps = score.getInt("attemps");
            if(attemps > storedAttemps){
                if(i != SCORELIMIT -1)
                    return i + 1;
                else
                    break;
            }
            else if(attemps == storedAttemps){
                float storedSeconds = score.getFloat("seconds");
                if(seconds >= storedSeconds)
                    return i + 1;
                else if(seconds < storedSeconds && i == 0)
                    return 0;
            }
            else if(attemps <  storedAttemps && i == 0)
                return 0;
        }
        return -1;
    }
    
    public int setNewEntry(int attemps, float seconds){
        int place = findPlace(attemps, seconds);
        if(place != -1){
            setPlace(place, attemps, seconds);
            if(hscores.length() > SCORELIMIT)
                hscores.remove(SCORELIMIT);
            file.write(hscores.toString());
        }
        return place;
    }
}
