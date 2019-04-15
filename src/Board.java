package monopolydriver;

// ========================================
// Board.java
// Main class for the board objects
// ========================================

// Imports
import java.util.LinkedList;

public class Board
{
        // ========================================================
	// Member variables
        // ========================================================
	//private final Card_Factory c_factory = new Card_Factory();				// card factory
	//private final Tile_Factory t_factory = new Tile_Factory();				// property factory
	private final Dice_Roller dice = new Dice_Roller(6);					// dice object
        private final int board_size = 40;
        private final Tile_Adapter board[] = new Tile_Adapter[board_size];                      // Tile array to store the game tiles (Size of 40)
                                                                                                // Tile reference key:
                                                                                                // index 0: Start/Go 
                                                                                                // index 5: Holmes Av
                                                                                                // index 10: Jail
                                                                                                // Index 15: John Write Dr
                                                                                                // Index 20: Free parking
                                                                                                // Index 25: Ben Graves Dr
                                                                                                // Index 30: Go to jail
                                                                                                // index 35: Sparkman Dr
        
        
	private final LinkedList<Player> player_list = new LinkedList<Player>();		// linked list with player objects
	private final LinkedList<Property_Tile> property_list = new LinkedList<Property_Tile>();		// linked list with property objects
	//private final LinkedList<Card> chance_list = new LinkedList<Card>();			// linked list with chance cards
	//private final LinkedList<Card> community_list = new LinkedList<Card>();		// linked list with community cards
        private PropertyList pl = new PropertyList();
        private Decks d1 = new Decks();
	private int[] scoreboard;								// array containing the total score of each player
	private int turn_flag = 0;								// integer flag identifying whose turn it is
        private int NUM_PLAYERS;

	/**
	* Default constructor for Board objects
	*
	* @param  	None  
	* @return      	A Board object
	*/
	public Board(int num_players)
	{
		System.out.print("Board created!\n");
                NUM_PLAYERS = num_players;
           
		Board_Init();
	}

	/**
	* Init utility function for board objects, called on object creation
	* Main purpose is to call other functions and populate member variables
	*
	* @param  	None  
	* @return      	None
	*/
	private void Board_Init()
	{
            //pl.Get_Property();
            //pl.Get_CW();
            //pl.Get_U();

            System.out.println("Properties tiles!");
            for (int i = 0; i < pl.Get_Property().size(); i++)
            {
                //System.out.print(i);
                board[pl.Get_Property().get(i).getLocation()] = new Tile_Adapter(pl.Get_Property().get(i));
            }
            
            System.out.println("CW tiles!");
            for (int i = 0; i < pl.Get_CW().size(); i++)
            {
                //System.out.print(pl.Get_CW().get(i).getLocation()+"\n");
                board[pl.Get_CW().get(i).getLocation()] = new Tile_Adapter(pl.Get_CW().get(i));
            }
            
            System.out.println("Utility tiles!");
            for (int i = 0; i < pl.Get_U().size(); i++)
            {
                //System.out.print(i);
                board[pl.Get_U().get(i).getLocation()] = new Tile_Adapter(pl.Get_U().get(i));
            }
            
            System.out.println("Charger Chest tiles!");
            for (int i = 0; i < pl.Get_CC().size(); i++)
            {
                //System.out.print(i);
                board[pl.Get_CC().get(i).getLocation()] = new Tile_Adapter(pl.Get_CC().get(i));
            }
            
            System.out.println("Chance tiles!");
            for (int i = 0; i < pl.Get_C().size(); i++)
            {
                //System.out.print(i);
                board[pl.Get_C().get(i).getLocation()] = new Tile_Adapter(pl.Get_C().get(i));
            }
            
            System.out.println("Corner tiles!");
            for (int i = 0; i < pl.Get_CT().size(); i++)
            {
                //System.out.print(i);
                board[pl.Get_CT().get(i).getLocation()] = new Tile_Adapter(pl.Get_CT().get(i));
            }
            
            /*
            System.out.println("\nMember values from tiles:");
            for (int i = 0; i < board_size; i++)
            {
                if (board[i] != null)
                {
                    System.out.println(board[i].getName() +", "+ board[i].getLocation()+", ");//+board[i].getPrice());
                }
            }
            */
            
            // Creates properties
            //for (int i = 0; i < board_size; i++)
            //        property_list.add(new Property(i));

            // Creates players\
            System.out.print("\n");
            player_list.add(new Player("p1",1));
            player_list.add(new Player("p2",2));
            player_list.add(new Player("p3",3));
            player_list.add(new Player("p4",4));
            System.out.print("\n");
	}

	/**
	* Main function to update the events of the board
	* Calls various other functions on each player that need to happen each turn
	*
	* @param  	None  
	* @return      	None
	*/
	public void Update()
	{
		// updates all the dynamic varibles of the game
		Player_Turn(turn_flag);
		
		if (turn_flag < this.NUM_PLAYERS-1)
			turn_flag++;
		else
			turn_flag = 0;
	}
	
	/**
	* Gets all the scores of each player
	*
	* @param  	None  
	* @return      	The player's score
	*/
	public int Get_Score()
	{
		// Checks the score of each player and returns the scoreboard
		return 0;
	}

	/**
	* Calls the turn() on each player in the player_list
	*
	* @param  	turn_flag	Identifier of which player's turn it is
	* @return      	None
	*/
	private void Player_Turn(int turn_flag)
	{		

            int current_roll_1 = dice.Roll();
            int current_roll_2 = dice.Roll();
            System.out.println("roll: " + current_roll_1+", "+current_roll_2);
            // TODO: doubles check
            //System.out.printf(" Roll: %-5d | ", current_roll);

            player_list.get(turn_flag).Set_Location(current_roll_1 + current_roll_2);
            if (player_list.get(turn_flag).Get_Location() >= 40)
            {
                player_list.get(turn_flag).Set_Location(-40);
            }
            //System.out.println(player_list.get(turn_flag).Get_Location());

            // Walks through player list and calls their turn
            System.out.printf("Player: %-5s | Money: %-5d |", player_list.get(turn_flag).Get_Name(),player_list.get(turn_flag).Get_Money());

            if (board[player_list.get(turn_flag).Get_Location()] != null)
            {
                player_list.get(turn_flag).Turn(board[player_list.get(turn_flag).Get_Location()]);
            }
            else
            {
                d1.draw("chance").Get_Event(player_list.get(turn_flag));
            }
            //player_list.get(turn_flag).Buy_Property(property_list.get(1));
            //System.out.printf(" \nLocation: %-5d | Money: %-5d\n", 
            //                player_list.get(turn_flag).Get_Location(),
            //                player_list.get(turn_flag).Get_Money());	
	}
}