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
    private String rent1;
    private String rent2;
    private String mortgageValue;
	
    // Member variables that are initialized in the game
    private String owner;
    private int currentRent; 
  
    // Author: Ansley Solomon
    // Constructor
    public Utility(String uName, String uLocation, String uPrice, String uRent1, String uRent2, String uMV){
        name = uName;
        location = uLocation;
        price = uPrice;
        rent1 = uRent1;
        rent2 = uRent2;
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
        int r = Integer.parseInt(rent1);
        return r;
    }
    
    public int getRent2(){
        int r = Integer.parseInt(rent2);
        return r;
    }
    
    public int getMortgageValue(){
        int mv = Integer.parseInt(mortgageValue);
        return mv;
    }
}
