package monopolydriver;

/**
 * Crosswalk class
 * 
 * This class contains the constructor for the Crosswalk object and the methods
 * used to access individual Crosswalk components
 * 
 * @author Ansley Solomon
 */
public class Crosswalk{
    private String name;
    private String location;
    private String price;
    private String rent1;
    private String rent2;
    private String rent3;
    private String rent4;

    private String owner;
    private int currentRent; 

    /**
     * Default constructor for Crosswalk
     * 
     * @author Ansley Solomon
     * @param cName
     * @param cLocation
     * @param cPrice
     * @param cRent1
     * @param cRent2
     * @param cRent3
     * @param cRent4 
     */
    public Crosswalk(String cName, String cLocation, String cPrice, String cRent1,String cRent2, String cRent3, String cRent4){
        name = cName;
        location = cLocation;
        price = cPrice;
        rent1 = cRent1;
        rent2 = cRent2;
        rent3 = cRent3;
        rent4 = cRent4;
    }

    /**
     * Returns the name of the Crosswalk
     * @author Ansley Solomon
     * @return Returns the name of the Crosswalk
     */
    public String getName(){
        return name;
    }

    /**
     * Returns the location of the Crosswalk on the board
     * @author Ansley Solomon
     * @return Returns int location
     */
    public int getLocation(){
        int lo = Integer.parseInt(location);	
        return lo;
    }

    /**
     * Returns the price of the Crosswalk
     * @author Ansley Solomon
     * @return Returns the int price
     */
    public int getPrice(){
        int p = Integer.parseInt(price);
        return p;
    }

    /**
     * Returns the rent when the Player owns only one Crosswalk
     * @author Ansley Solomon
     * @return Returns int rent1
     */
    public int getRent1(){
        int r = Integer.parseInt(rent1);
        return r;
    }

    /**
     * Returns the rent when the Player owns two Crosswalks
     * @author Ansley Solomon
     * @return Returns int rent2
     */
    public int getRent2(){
        int r = Integer.parseInt(rent2);
        return r;
    }

    /**
     * Returns the rent when the Player owns three Crosswalks
     * @author Ansley Solomon
     * @return Returns int rent3
     */
    public int getRent3(){
        int r = Integer.parseInt(rent3);
        return r;
    }

    /**
     * Returns the rent when the Player owns four Crosswalks
     * @author Ansley Solomon
     * @return Returns int rent4
     */
    public int getRent4(){
        int r = Integer.parseInt(rent4);
        return r;
    }
}
