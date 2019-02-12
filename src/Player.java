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
	public Player()
	{

	}

	// ==================================
	// Accessor Functions
	// ==================================
	public int Get_Location()
	{
		// Returns location as an int
	}

	public int Get_Money()
	{
		// Returns current player money as an int
	}

	public String Get_Name()
	{
		// Returns player's name as a string
	}

	public boolean Is_Ready()
	{
		// returns if the player is done with their turn
	}
	
	// ==================================
	// Mutator Functions
	// ==================================
	public void Set_Location(int input)
	{
		// sets the player's location as an int
	}

	public void Set_Money(int input)
	{
		// sets the player's money
	}	

	public void Set_Name(String input)
	{
		// sets the player's name
	}
	
	public void Set_Ready(boolean input)
	{
		// Set if the player is done with their turn
	}
}