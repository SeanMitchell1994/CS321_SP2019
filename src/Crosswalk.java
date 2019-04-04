// ========================================
// Crosswalk.java
// Main class for the crosswalk objects (subset of properties)
// ========================================

// Imports

import javax.swing.ImageIcon;

public class Crosswalk
{

    // Member variables read in from file
    private String name;
    private String location;
    private String price;
    private String rent1;
    private String rent2;
    private String rent3;
    private String rent4;
	
    // Member variables that are initialized in the game
    private String owner;
    private int currentRent; 
  
    // Author: Ansley Solomon
    // Constructor
    public Crosswalk(String cName, String cLocation, String cPrice, String cRent1, 
            String cRent2, String cRent3, String cRent4){
        name = cName;
        location = cLocation;
        price = cPrice;
        rent1 = cRent1;
        rent2 = cRent2;
        rent3 = cRent3;
        rent4 = cRent4;
    }
    
    // Author: Ansley Solomon
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
    
    public int getRent3(){
        int r = Integer.parseInt(rent3);
        return r;
    }
    
    public int getRent4(){
        int r = Integer.parseInt(rent4);
        return r;
    }
}
