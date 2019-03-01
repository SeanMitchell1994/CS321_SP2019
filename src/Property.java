// ========================================
// Property.java
// ========================================

// Imports

public class Property{

	// Member Variables

	private int location;
	private int cost;
	private String owner;
	// token, this will be an image file
	private String name;

    // Default constructor
        public Property(){      
        }
        public Property(int location, int cost, String owner, String name){
            Set_Location(location);
            Set_Cost(cost);
            Set_Owner(owner);
            Set_Name(name);  
        }
        
    //Accessor Methods
        
        public int Get_Loacation(){
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
        
        
        //Mutator Methods
        
        //throw negative number exception
        public void Set_Location(int x){
            if(x < 0){
                throw new NegativeException("Can't set location to negative number");
            }
            location = x;
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

}
