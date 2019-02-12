// ========================================
// Card.java
// ========================================

// Imports
import Card_Event.java;

public class Card
{
	private final boolean card_type;
	private final Card_Event event;
	//private final token

	// Default constructor
	public Card(Card_Event event_input)
	{
		event = event_input;
	}

	public String Get_Card_Type()
	{
		// TODO: Move this to constructor
		str = "";
		if (card_type == 1) {str = "chance";}
		else {str = "community";}
		return str;
	}

	public Get_Event()
	{

	}
}