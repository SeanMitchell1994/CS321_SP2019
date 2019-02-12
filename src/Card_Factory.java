// ========================================
// Card_Factory.java
// ========================================

// Imports
import Card.java;
import Card_Event.java;

public class Card_Factory
{
	private static Card_Factory instance;	// Singleton reference

	private final Card production;

	// Private constructor
	private Card_Factory()
	{
		
	}

	// Public accessor to the singleton instance
	public static Card_Factory() Get_Instance()
	{
		if(instance == null)
		{
		    instance = new Card_Factory();
		}

		return instance;
	}

	public Card Create_Deck(String type, int number)
	{
		// Returns a list of cards
	}

	private Card Create_Chance_Card()
	{
		// Creates a chance card
	}

	private Card Create_Community_Card()
	{
		// Creates a community card
	}
}