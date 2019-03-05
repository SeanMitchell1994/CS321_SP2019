// ========================================
// Board.java
// Main class for the board objects
// ========================================

// Imports
import java.util.LinkedList;

public class Board
{
	// Member variables
	//private final Card_Factory c_factory = new Card_Factory();				// card factory
	//private final Tile_Factory t_factory = new Tile_Factory();				// property factory
	private final Dice_Roller dice = new Dice_Roller(6);					// dice object

	private final LinkedList<Player> player_list = new LinkedList<Player>();		// linked list with player objects
	private final LinkedList<Property> property_list = new LinkedList<Property>();		// linked list with property objects
	//private final LinkedList<Card> chance_list = new LinkedList<Card>();			// linked list with chance cards
	//private final LinkedList<Card> community_list = new LinkedList<Card>();		// linked list with community cards

	private int[] scoreboard;								// array containing the total score of each player
	private int turn_flag = 0;								// integer flag identifying whose turn it is

	// Default constructor
	public Board()
	{
		System.out.print("Board created!\n");
		Board_Init();
	}

	private void Board_Init()
	{
		// Creates properties
		for (int i = 0; i < 10; i++)
			property_list.add(new Property(i));
		
		// Creates players
		player_list.add(new Player("p1"));
		player_list.add(new Player("p2"));
		player_list.add(new Player("p3"));
		player_list.add(new Player("p4"));
	}

	public void Update()
	{
		// updates all the dynamic varibles of the game
		Player_Turn(turn_flag);
		
		if (turn_flag < 3)
			turn_flag++;
		else
			turn_flag = 0;
	}
	
	public int Get_Score()
	{
		// Checks the score of each player and returns the scoreboard
		return 0;
	}

	private void Player_Turn(int turn_flag)
	{
		// Walks through player list and calls their turn
		System.out.printf("Player: %-5s |", player_list.get(turn_flag).Get_Name());

		int current_roll = dice.Roll();
		System.out.printf(" Roll: %-5d | ", current_roll);

		player_list.get(turn_flag).Set_Location(current_roll);
		System.out.printf(" Location: %-5d | Money: %-5d\n", 
				player_list.get(turn_flag).Get_Location(),
				player_list.get(turn_flag).Get_Money());	
	}
}