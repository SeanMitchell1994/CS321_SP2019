package monopolydriver;

/**
 * Main class for the Utility objects
 * @author Ansley Solomon
 */

public class Utility_Tile
{
    // Variables
    private String name;
    private String location;
    private String price;
    private int rent1;
    private int rent2;
    private String mortgageValue;
    private final Dice_Roller dice = new Dice_Roller(6);
    
    private String owner;
    private int currentRent; 
    private boolean hasEvent = false;
    
    /**
     * Default constructor
     * @author Ansley Solomon
     * @param uName         The name of the Utility
     * @param uLocation     The Utility's location on the Board
     * @param uPrice        The Utility's price
     * @param uMV           The Utility's price when owner owns all Utilities
     */
    public Utility_Tile(String uName, String uLocation, String uPrice, String uMV){
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
    public int getRent(){
        int rent = 4*dice.Roll();
        return rent;
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
    
    /**
     * Returns if the tile has an event
     * @author Sean Mitchell
     * @return boolean hasEvent
     */
    public boolean getHasEvent()
    {
        return this.hasEvent;
    }
}
