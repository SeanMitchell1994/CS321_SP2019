// ========================================
// Board.java
// ========================================

// Imports
import java.util.LinkedList;

import Card_Factory.java;
import Tile_Factory.java;
import Dice_Roller.java;

public class Board
{
	// Member variables
	private final Card_Factory c_factory = new Card_Factory();
	private final Tile_Factory t_factory = new Tile_Factory();
	private final Dice_Roller dice = new Dice_Roller(6);

	private final LinkedList<Card> chance_list = new LinkedList<Card>();
	private final LinkedList<Card> community_list = new LinkedList<Card>();
	private final LinkedList<Player> player_list = new LinkedList<Player>();

	// Default constructor
	public Board()
	{
		
	}

	public Update()
	{

	}
	
	public Get_Score()
	{

	}

	private Player_Turn()
	{

	}
}