// ========================================
// Player.java
// Main class for the player objects
// ========================================

// Imports
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.Scanner;

public class Player
{

	// Member Variables

	private int location;
	private int money;
	//private int[] property_list;
	ArrayList<Tile> property_list = new ArrayList<>();
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
     
	/**
	* Sets the player's location as an int
	*
	* @param  input  an integer representing the location of the player
	* @return      None
	*/
	public void Set_Location(int input){
            location = location + input;
	}

	/**
	* changes a players location based on a value passed in
	*
	* @param  	shift  The amount to shift the player's location by
	* @return      	None
	*/
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

	/**
	* Sets the player's money to the given input
	*
	* @param  input  an integer representing the player's money
	* @return      None
	*/
	public void Set_Money(int input)
	{
        	money = input;
	}
        
        //shifts a player's money (add/subtraction)
        //needs an if to call morgage/forfiet option when money reaches below zero
        public void shift_Money(int input){
            money = money + input;
        }

	/**
	* Sets the player's name to the given input
	*
	* @param  input  a string representing the player's name
	* @return      None
	*/
	public void Set_Name(String input){
            name = input;
	}

	
	/**
	* Sets if the player is ready to end their turn
	*
	* @param  	None
	* @return      	None
	*/
	public void Set_Ready(){
            is_ready = true;
	}
        
	/**
	* Sets the image used for the player's token
	*
	* @param  	x	A loaded image file
	* @return      	None
	*/
        public void Set_Image(ImageIcon x){
            image = x;
        }

	/**
	* Allows the player to buy a property
	* Adds the property object to the player's property list 
	* and subtracts the cost of the property from the player's current money
	*
	* @param  	tile	A property object
	* @return      	None
	*/
	public void Buy_Property(Tile tile)
	{
            // to do: check if player already owns tile
            System.out.print("Buy function!\n");
            if (tile.getType() == 1)
                if (!tile.Get_IsOwned())
                {
                    property_list.add(tile);
                    tile.Set_IsOwned(true);
                    tile.Set_Owner(this.name);
                    money = money - tile.getPrice();
                }
                else
                    System.out.print("Property is already owned!\n");
            //System.out.print("Property bought!\n");
	}

	/**
	* Allows the player to sell a property
	* Removes the property object to the player's property list 
	* and adds the cost of the property from the player's current money
	*
	* @param  	tile	A property object
	* @return      	None
	*/
	public void Sell_Property(Tile tile)
	{
		// to do: check if player doesnt own tile
            System.out.print("Sell detected!\n");
            property_list.remove(tile);
            money = money + tile.getPrice();
	}

	/**
	* Allows the player to to trade a property to another player
	* Calls Sell_Property() on the this player object
	* and calls Buy_Property() on the other player object
	* 
	*
	* @param	p_other	The other player to interact with
	* @param  	tile	A property object
	* @return      	None
	* @see		Buy_Property()
	* @see		Sell_Property()
	*/
	public void Trade_Property(Player p_other, Tile tile)
	{
		Sell_Property(tile);
		p_other.Buy_Property(tile);	
	}

	public void Turn(Tile current_tile)
	{
		String s = "";
		System.out.print("Actions: Buy | Sell | Trade\n");
		Scanner sc = new Scanner(System.in);
		s = sc.nextLine();
                
		if (s.equals("Buy"))
                {
                    this.Buy_Property(current_tile);
                }
		else if (s.equals("Sell"))
                {
                    this.Sell_Property(current_tile);
                }
		else if (s.equals("Trade")){System.out.print("Trade detected!\n");}
	}
}

