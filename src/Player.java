// ========================================
// Player.java
// Main class for the player objects
// ========================================

// Imports

import javax.swing.ImageIcon;

public class Player

{

	// Member Variables

	private int location;
	private int money;
	private int[] property_list;
	private ImageIcon image;
	private String name;
	private boolean is_ready;
	// list with money broken down into types of money
	// integer that shows the sum total of money

	// Default constructor
	public Player(String input_name)
	{
		System.out.print("Player created!\n");

		location = 0;		// starting location
		name = input_name;	// player name as a string
		money = 1500;		// temp variable, this will change
		is_ready = false;	// is the player ready to move to the next
	} 

	// ==================================

	// Accessor Functions
// Main class for the property objects
	// ==================================
	// Returns location as an int
	public int Get_Location(){
                return this.location;
	}
	// Returns current player money as an int
	public int Get_Money(){
               return this.money;
	}
        // Returns player's name as a string
	public String Get_Name(){
            return this. name;
	}

	// returns if the player is done with their turn
	public boolean Is_Ready(){
            return this.is_ready;
	}
        
        public ImageIcon Get_Image(){
            return this.image;
        }

	

	// ==================================
	// Mutator Functions
	// ==================================
        
        // sets the player's location as an int
	public void Set_Location(int input){
            location = location + input;
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
	public void Set_Ready(){
            is_ready = true;
	}
        
        public void Set_Image(ImageIcon x){
            image = x;
        }

}

