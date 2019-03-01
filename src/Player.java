// ========================================
// Player.java
// Main class for the player objects
// ========================================

// Imports

public class Player

{

	// Member Variables

	private int location;

	private int money;

	private int[] property_list;

	// token, this will be an image file

	private String name;

	private boolean is_ready;

	

	// Default constructor

	public Player(){



	}



	// ==================================

	// Accessor Functions

	// ==================================
// Returns location as an int
	public int Get_Location(){
                return location;
	}
// Returns current player money as an int
	public int Get_Money(){
               return money;
	}
        // Returns player's name as a string
	public String Get_Name(){
            return name;
	}

// returns if the player is done with their turn
	public boolean Is_Ready(){
            return is_ready;
	}

	

	// ==================================

	// Mutator Functions

	// ==================================
        
        // sets the player's location as an int
	public void Set_Location(int input){
            location = input;
	}
        // changes a players location based on a value passed in
        public void Shift_Location(int shift){
            if((location + shift) > 39){
                Set_Location((location+shift) - 40);
            }
            else if((location + shift) < 0){
                Set_Location(40+(location+shift));
            }
            else{
                Set_Location(location+shift);
            }
        }

        // sets the player's money
	public void Set_Money(int input){
        money = input;
	}
        
        //shifts a player's money (add/subtraction)
        //needs an if to call morgage/forfiet option when money reaches below zero
        public void shift_Money(int input){
            money = money + input;
        }

// sets the player's name
	public void Set_Name(String input){
            name = input;
	}

	
// Set if the player is done with their turn
	public void Set_Ready(boolean input){
            is_ready = input;
	}

}
