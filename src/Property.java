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
	
	private String owner;
        private ImageIcon image;

        // Author: Ansley Solomon
    	// Default constructor
        public Property(String pName, String pLocation, String pColor, String pPrice, 
                String pMV, String pBC, String pRent, String pMR)
	{
            name = pName;
            this.pLocation = pLocation;
            color = pColor;
            price = pPrice;
            mortgageValue = pMV;
            buildingCost = pBC;
            rent = pRent;
            monopolyRent = pMR;
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
	
	public Property getPropertyByLocation(ArrayList<Property> properties, int location){
            Property thisOne = null;
            
            for (int i = 0; i < properties.size(); i++){
                if (location == getLocation()){
                    thisOne = properties.get(i);
                }
            }
		
            return thisOne;
        }
}
