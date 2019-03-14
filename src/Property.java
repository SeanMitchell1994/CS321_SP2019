// ========================================
// Property.java
// Main class for the property objects
// ========================================

// Imports


import javax.swing.ImageIcon;

public class Property
{

	// Member Variables
	private String name;
	private int location;
	private String color;
	private int price;
	private int mortgageValue;
	private int buildingCost;
	private int rent;           // Cost of rent with no monopoly or buildings
	private int monopolyRent;   // Cost of rent when owner has monopoly
	private int rentHouse1;     // Cost of rent with one house
	private int rentHouse2;     // Cost of rent with two houses
	private int rentHouse3;     // Cost of rent with three houses
	private int rentHouse4;     // Cost of rent with four houses
	private int rentHotel;      // Cost of rent with hotel
	
	private String owner;
        private ImageIcon image;

    	// Default constructor
        public Property(int location_input)
	{
            	Set_Location(location_input);
		System.out.printf("Property created at location %d!\n", this.Get_Location());
		this.price = 50;
	}

	// overloaded constructor
        public Property(int location, int cost, String owner, String name, ImageIcon image)
	{
            Set_Location(location);
            Set_Cost(cost);
            Set_Owner(owner);
            Set_Name(name);  
        }
        
    	//Accessor Methods
        
        public int Get_Location(){
            return location;
        }
        
        public int Get_Cost(){
            return price;
        }
        
        public String Get_Owner(){
            return owner;
        }
        
        public String Get_Name(){
            return name;
        }
        
        public ImageIcon Get_Image(){
            return image;
        }
        
        
        //Mutator Methods
        
	// temporarly commented for debuging
        /*public void Set_Location(int x){

            if(x < 0){

                throw new NegativeException("Can't set location to negative number");

            }

            location = x;

        }*/

      	public void Set_Location(int location_input){

            location = location_input;

        }

        public void Set_Owner(String newOwner){

            owner = newOwner;

        }

        public void Set_Cost(int newCost){

            price = newCost;

        }

        public void Set_Name(String newName){

            name = newName;

        }
        
        public void Set_Image(ImageIcon x){
            image = x;
        }

}
