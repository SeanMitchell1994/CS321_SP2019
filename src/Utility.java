// ========================================
// Utilities.java
// Main class for the utilities objects (subset of properties)
// ========================================

// Imports

import javax.swing.ImageIcon;

public class Utility
{

    // Member variables read in from file
    private String name;
    private String location;
    private String price;
    private int rent1;
    private int rent2;
    private String mortgageValue;
	
    // Member variables that are initialized in the game
    private String owner;
    private int currentRent; 
  
    // Author: Ansley Solomon
    // Constructor
// Side note: I have no idea what is supposed to be the input in Dice_Roller, I just guessed
    public Utility(String uName, String uLocation, String uPrice, String uMV){
        Dice_Roller roller = new Dice_Roller(12);
        
        name = uName;
        location = uLocation;
        price = uPrice;
        rent1 = 4*roller.Roll();
        rent2 = 10*roller.Roll();
        mortgageValue = uMV;
    }
    
    // Accessor methods
    public String getName(){
        return name;
    }
        
    public int getLocation(){
        int lo = Integer.parseInt(location);	
        return lo;
    }

    public int getPrice(){
        int p = Integer.parseInt(price);
        return p;
    }
    
    public int getRent1(){
        return rent1;
    }
    
    public int getRent2(){
        return rent2;
    }
    
    public int getMortgageValue(){
        int mv = Integer.parseInt(mortgageValue);
        return mv;
    }
}
