/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NumberGuessingGame;

/**
 *
 * @author yumerth-mijail
 */
public class ComputedNumber {
    
    private byte number;
    static final byte MIN = 1;
    static final byte MAX = 100;
    
    public ComputedNumber(){
        generateRan();
    }
    
    public final void generateRan(){
        double t = Math.random()/ Math.nextDown(1);
        number = (byte)Math.round(MIN * (1 - t) + MAX * t);
    }
    
    public byte getNumber(){
        return number;
    }
    
}
