package NumberGuessingGame;

import java.util.ArrayList;
import java.util.List;

public class HintSystem {
    
    public static int getRan(int min, int max){
        double r = Math.random()/Math.nextDown(1);
        int ran = (int)Math.round(min * r + max * (1 - r));
        return ran;
    }
    
    public static void findMultiple(int ran){
        if(ran == 1)
            return;

        List<Integer> multiples = new ArrayList<>();
        
        for (int i = 2; i <= Math.sqrt((double)ran); i++){
            if(ran % i == 0 && !multiples.contains(i)){
                multiples.add(i);
                if(i != ran/i)
                    multiples.add(ran/i);
            }
        }
        multiples.add(ran);
        int quantity = multiples.size();

        if(quantity != 1){
            int ranIndx = getRan(1, quantity) - 1;
            Messages.showMultiple(multiples.get(ranIndx));
        }
        else{
            Messages.isPrimeNumber();
        }
    }
    
    public static int provideRange(int ran){
        if(ran < 5){
            Messages.showRange(1, 5);
            return 1;
        }
        if(ran >95){
            Messages.showRange(95, 100);
            return 2;
        }
        int indx = getRan(1, 5) - 1;
        int min = ran - indx;
        int max = ran + (4 - indx);
        Messages.showRange(min, max);
        return 0;
    }
}
