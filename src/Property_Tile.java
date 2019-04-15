package monopolydriver;
/**
 * Main class for the Property objects
 * @author Ansley Solomon, Sean Mitchell
 */
import javax.swing.ImageIcon;

public class Property_Tile{
    
	// Member Variables
	private final String name;
        private String location;
	private  String color;
	private  String price;
        private boolean is_owned;
        private  String pLocation;
	private  String mortgageValue;
	private  String buildingCost;
	private  String rent;           // Cost of rent with no monopoly or buildings
	private  String monopolyRent;   // Cost of rent when owner has monopoly
	private String owner;
        private ImageIcon image;
        private boolean hasEvent = false;

        /**
         * Default constructor
         * @author Ansley Solomon
         * @param pName         The Property's name
         * @param pLocation     The Property's location on the Board
         * @param pColor        The Property's color
         * @param pPrice        The Property's price
         * @param pMV           The Property's mortgage value
         * @param pRent         The Property's rent
         * @param pMR           The Property's rent when owner has a monopoly
         */
        public Property_Tile(String pName, String pLocation, String pColor, String pPrice, 
                String pMV, String pRent, String pMR){
            name = pName;
            this.pLocation = pLocation;
            color = pColor;
            price = pPrice;
            mortgageValue = pMV;
            rent = pRent;
            monopolyRent = pMR;
	}

        /**
         * Returns the name of the Property
         * @author Ansley Solomon
         * @return String name
         */
        public String getName(){
            return name;
        }
        
        /**
         * Returns the Property's location on the Board
         * @author Ansley Solomon
         * @return int location
         */
        public int getLocation(){
            int lo = Integer.parseInt(pLocation);	
            return lo;
        }
        
        /**
         * Returns the price of the Property
         * @author Ansley Solomon
         * @return int price
         */
        public int getPrice(){
            int p = Integer.parseInt(price);
            return p;
        }
        
        /**
         * Returns the color of the PRoperty
         * @author Ansley Solomon
         * @return String color
         */
        public String getColor(){
            return color;
        }
        
        /**
         * Returns the Property's value when mortgaged
         * @author Ansley Solomon
         * @return int mortgage value
         */
        public int getMortgageValue(){
            int mv = Integer.parseInt(mortgageValue);
            return mv;
        }
        
        /**
         * Returns the Property's rent
         * @author Ansley Solomon
         * @return int rent
         */
        public int getRent(){
            int r = Integer.parseInt(rent);
            return r;
        }
        
        /**
         * Returns the Property's rent when the owner has a monopoly
         * @author Ansley Solomon
         * @return int monopoly rent
         */
        public int getMonopolyRent(){
            int mr = Integer.parseInt(monopolyRent);
            return mr;
        }
        
        /**
         * Tells if a property is owned
         * @author Sean Mitchell
         * @return boolean is_owned
         */
        public boolean Get_IsOwned(){
            return this.is_owned;
        }
        
        /**
         * Sets the Property's ownership status
         * @author Sean Mitchell
         * @param input 
         */
        public void Set_IsOwned(boolean input){
            this.is_owned = input;
        }
        
        /**
         * Sets the Property's owner
         * @author Sean Mitchell
         * @param input 
         */
        public void Set_Owner(String input){
            this.owner = input;
        }
        
        /**
         * Returns the name of the Property's owner
         * @author Sean Mitchell
         * @return String owner
         */
        public String Get_Owner(){
            return this.owner;
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
