package monopolydriver;

/**
 * Main class for the Utility objects
 * @author Ansley Solomon
 */

public class Utility
{
    // Variables
    private String name;
    private String location;
    private String price;
    private int rent1;
    private int rent2;
    private String mortgageValue;
    
    private String owner;
    private int currentRent; 
    
    
    // Author: Ansley Solomon
    // Constructor
// Side note: I have no idea what is supposed to be the input in Dice_Roller, I just guessed

    
    /**
     * Default constructor
     * @author Ansley Solomon
     * @param uName         The name of the Utility
     * @param uLocation     The Utility's location on the Board
     * @param uPrice        The Utility's price
     * @param uMV           The Utility's price when owner owns all Utilities
     */
    public Utility(String uName, String uLocation, String uPrice, String uMV){
        Dice_Roller roller = new Dice_Roller(12);
        name = uName;
        location = uLocation;
        price = uPrice;
        rent1 = 4*roller.Roll();
        rent2 = 10*roller.Roll();
        mortgageValue = uMV;
    }

    /**
     * Returns the Utility's name
     * @author Ansley Solomon
     * @return String name
     */
    public String getName(){
        return name;
    }

    /**
     * Returns the Utility's location on the Board
     * @author Ansley Solomon
     * @return int location
     */
    public int getLocation(){
        int lo = Integer.parseInt(location);	
        return lo;
    }
    
    /**
     * Returns the Utility's price
     * @author Ansley Solomon
     * @return int price
     */
    public int getPrice(){
        int p = Integer.parseInt(price);
        return p;
    }

    /**
     * Returns the Utility's rent when only one Utility is owned
     * @author Ansley Solomon
     * @return int rent1
     */
    public int getRent1(){
        return rent1;
    }
    
    /**
     * Returns the Utility's rent when owner owns both Utilities
     * @author Ansley Solomon
     * @return int rent2
     */
    public int getRent2(){
        return rent2;
    }

    /**
     * Returns the Utility's mortgage value
     * @author Ansley Solomon
     * @return int mortgage value
     */
    public int getMortgageValue(){
        int mv = Integer.parseInt(mortgageValue);
        return mv;
    }
}
