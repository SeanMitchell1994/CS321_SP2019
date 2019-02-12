// ========================================
// Card.java
// ========================================

// Imports
import Card_Event.java;

public class Card
{
	private final String card_type;
	private final int card_id;
	private final Card_Event event;
	//private final token

	// Default constructor
	public Card(int event_input, int card_id_input)
	{
		event = event_input;
		card_id = card_id_input;
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
		// Returns the event string from the member even object
		// TODO: add the event integer 
		return this.event.Get_Event();
	}
}