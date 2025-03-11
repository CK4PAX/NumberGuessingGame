package NumberGuessingGame;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HightScoresTest {
    
    HightScores hs = new HightScores("test.json");
    
    public HightScoresTest() {
    }

    /*@Test
    public void testInit() {
        assertDoesNotThrow(()->{hs.init();});
    }*/
    
    @Test
    public void testFindPlace(){
        hs.hscores.clear();
        int attemps = 3;
        float seconds = 29.3f;
        assertEquals(0, hs.findPlace(attemps, seconds));
    }
    
    @Test
    public void setPlace(){
        hs.hscores.clear();
        int attemps = 3;
        float seconds = 29.3f;
        int place = hs.findPlace(attemps, seconds);
        hs.setPlace(place,attemps,seconds);
        JSONObject object = hs.hscores.getJSONObject(place);
        assertEquals(3, object.getInt("attemps"));
        assertEquals(29.3f, object.getFloat("seconds"));
    }
    
    @Test
    public void testSetNewEntryWithEmptyArray(){
        hs.hscores.clear();
        int attemps = 3;
        float seconds = 45f;
        int place = hs.setNewEntry(attemps, seconds);
        JSONObject object = hs.hscores.getJSONObject(place);
        assertEquals(3, object.getInt("attemps"));
        assertEquals(45f, object.getFloat("seconds"));
    }
    
    @Test
    public void testSetNewEntryWithNotFullArray(){
        hs.hscores.clear();
        int[] attemps = {2,4,5,3};
        float[] seconds = {23,43,11,50};
        for (int i = 0; i < attemps.length - 1; i++) {
            hs.setNewEntry(attemps[i], seconds[i]);
        }
        int place = hs.setNewEntry(attemps[3], seconds[3]);
        assertEquals(1, place);
    }
    
    @Test
    public void testSetNewEntryWithFullArray(){
        hs.hscores.clear();
        int[] attemps = {2,4,6,3,1,5};
        float[] seconds = {23,43,11,50,45,23};
        for (int i = 0; i < attemps.length - 1; i++)
            hs.setNewEntry(attemps[i], seconds[i]);
        int place = hs.setNewEntry(attemps[5], seconds[5]);
        assertEquals(4, place);
    }
    
    @Test
    public void testSetNewEntryWithFullArrayAndRepeatedChances(){
        hs.hscores.clear();
        int[] attemps = {2,3,3,3,3};
        float[] seconds = {23,43,11,23,5};
        for (int i = 0; i < attemps.length - 1; i++)
            hs.setNewEntry(attemps[i], seconds[i]);
        int place = hs.setNewEntry(attemps[4], seconds[4]);
        assertEquals(1, place);
    }
    
    @Test
    public void testSetNewEntryWithFullArrayAndRepeatedChancesTwo(){
        hs.hscores.clear();
        int[] attemps = {2,2,3,3,2};
        float[] seconds = {23,43,11,23,5};
        for (int i = 0; i < attemps.length - 1; i++)
            hs.setNewEntry(attemps[i], seconds[i]);
        int place = hs.setNewEntry(attemps[4], seconds[4]);
        assertEquals(0, place);
    }
    
    @Test
    public void testSetNewEntryWithFullArrayAndRepeatedChancesThree(){
        hs.hscores.clear();
        int[] attemps = {2,2,3,3,2};
        float[] seconds = {23,43,11,23,24};
        for (int i = 0; i < attemps.length - 1; i++)
            hs.setNewEntry(attemps[i], seconds[i]);
        int place = hs.setNewEntry(attemps[4], seconds[4]);
        assertEquals(1, place);
    }
    
    @Test
    public void testSetNewEntryRemovingExtraScore(){
        hs.hscores.clear();
        int[] attemps = {2,4,8,1,7,3};
        float[] seconds = {23,43,11,23,5,65.4f};
        for (int i = 0; i < attemps.length - 1; i++)
            hs.setNewEntry(attemps[i], seconds[i]);
        assertEquals(5, hs.hscores.length());
    }
    
    @Test
    public void testShowHighScores(){
        assertDoesNotThrow(()->{hs.showScores();});
    }
}
