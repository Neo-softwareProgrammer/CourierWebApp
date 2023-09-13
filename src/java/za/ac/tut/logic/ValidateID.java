/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.logic;

/**
 *
 * @author Eddie Shubane
 */
public class ValidateID {

    public ValidateID() {
    }
    public boolean validateID(String id){
        boolean valid=false;
        if(id.length()==13){
            int counterNumber=13;
            for (int i = 0; i < 13; i++) {
                char getChar=id.charAt(i);
                if(!Character.isDigit(getChar)){
                    counterNumber++;
                }
            }
            
            if(counterNumber==13){
                valid=true;
            }
        }
        
        
        return valid;
    }
    
}
