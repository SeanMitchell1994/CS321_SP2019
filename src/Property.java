// ========================================
// Property.java
// Main class for the property objects
// ========================================

// Imports


import javax.swing.ImageIcon;

public class Property
{

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
	private  String rentHouse1;     // Cost of rent with one house
	private  String rentHouse2;     // Cost of rent with two houses
	private  String rentHouse3;     // Cost of rent with three houses
	private  String rentHouse4;     // Cost of rent with four houses
	private  String rentHotel;      // Cost of rent with hotel
	
	private String owner;
        private ImageIcon image;

        // Author: Ansley Solomon
    	// Default constructor
        public Property(String pName, String pLocation, String pColor, String pPrice, 
                String pMV, String pBC, String pRent, String pMR, String pRent1, 
                String pRent2, String pRent3, String pRent4, String pRentH)
	{
            name = pName;
            this.pLocation = pLocation;
            color = pColor;
            price = pPrice;
            mortgageValue = pMV;
            buildingCost = pBC;
            rent = pRent;
            monopolyRent = pMR;
            rentHouse1 = pRent1;
            rentHouse2 = pRent2;
            rentHouse3 = pRent3;
            rentHouse4 = pRent4;
            rentHotel = pRentH;
	}
        
        /*public Property(int location_input)
        {
            this.location = location_input;
            this.name = "";
            this.color = "";
            this.price = "";
            this.is_owned = false;
        }
*/
        /*
	// overloaded constructor
        public Property(int location, int cost, String owner, String name, ImageIcon image)
	{
            Set_Location(location);
            Set_Cost(cost);
            Set_Owner(owner);
            Set_Name(name);  
        }
        */
        
    	//Accessor Methods
        
        public String getName(){
            return name;
        }
        
        public int getLocation(){
            int lo = Integer.parseInt(pLocation);	
            return lo;
            //return location;
        }
        
        public int getPrice(){
            int p = Integer.parseInt(price);
            return p;
        }
        
        public String getColor(){
            return color;
        }
        
        public int Get_Cost()
        {
            return 50;
        }
        
        public boolean Get_IsOwned()
        {
            return this.is_owned;
        }
        
        public void Set_IsOwned(boolean input)
        {
            this.is_owned = input;
        }
        
        public void Set_Owner(String input)
        {
            this.owner = input;
        }
        
        public String Get_Owner()
        {
            return this.owner;
        }
        
        public int getMortgageValue(){
            int mv = Integer.parseInt(mortgageValue);
            return mv;
        }
        
        public int getBuildingCost(){
            int bc = Integer.parseInt(buildingCost);
            return bc;
        }
        
        public int getRent(){
            int r = Integer.parseInt(rent);
            return r;
        }
        
        public int getMonopolyRent(){
            int mr = Integer.parseInt(monopolyRent);
            return mr;
        }
        
        public int getRent1(){
            int r = Integer.parseInt(rentHouse1);
            return r;
        }
        
        public int getRent2(){
            int r = Integer.parseInt(rentHouse2);
            return r;
        }
        
        public int getRent3(){
            int r = Integer.parseInt(rentHouse3);
            return r;
        }
        
        public int getRent4(){
            int r = Integer.parseInt(rentHouse4);
            return r;
        }
        
        public int getRentHotel(){
            int r = Integer.parseInt(rentHotel);
            return r;
        }
}
