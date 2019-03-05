// ========================================
// Property.java
// Main class for the property objects
// ========================================

// Imports


import javax.swing.ImageIcon;

public class Property
{

	// Member Variables

	private int location;
	private int cost;
	private String owner;
        private ImageIcon image;
	// token, this will be an image file
	private String name;

    	// Default constructor
        public Property(int location_input)
	{
            	Set_Location(location_input);
		System.out.printf("Property created at location %d!\n", this.Get_Location());
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
            return cost;
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

            cost = newCost;

        }

        public void Set_Name(String newName){

            name = newName;

        }
        
        public void Set_Image(ImageIcon x){
            image = x;
        }

}
