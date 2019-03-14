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

	
    /*
    // Author: Sean Mitchel
    // public static Card_Factory() Get_Instance()
    // Public accessor to the singleton instance
    // 
    */
	public static Card_Factory() Get_Instance()
	{
		if(instance == null)
		{
		    instance = new Card_Factory();
		}

		return instance;
	}
 
     /*
    // Author: Sean Mitchel
    // Create_Deck(String type, int number)
    // Returns a list of cards. Number of cards is sepecified by int "number" passed in, and type of cards 
    // is specified by the string 'type" passed in
    */
	public Card Create_Deck(String type, int number)
	{
		// Returns a list of cards
	}

    /*
    // Author: Sean Mitchel
    // Create_Chance_Card()
    // Creates a Card with type "chance". Card information is pulled from an XML sheet.
    // 
    */
	private Card Create_Chance_Card()
	{
		// Creates a chance card
	}

    /*
    // Author: Sean Mitchel
    // Create_Community_Card()
    // Creates a Card with type "community". Card information is pulled from an XML sheet.
    // 
    */
	private Card Create_Community_Card()
	{
		// Creates a community card
	}
}
