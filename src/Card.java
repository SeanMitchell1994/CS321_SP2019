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
	private final String text;
	//private final token

     /*
    // Author: Sean Mitchel
    // Card(int event_input, int card_id_input)
    // Default construct for a card object. A card's event is set to even_input passed in and
    // card_id is set to card_id_input passed in.
    */
	public Card(int event_input, int card_id_input, String text_input)
	{
		event = event_input;
		card_id = card_id_input;
		text = text_input;
	}

    /*
    // Author: Sean Mitchel
    // Get_Card_Typre
    // Returns a card's type as a string.
    // Useful for determining if a card is chance or community
    */
	public String Get_Card_Type()
	{
		// TODO: Move this to constructor
		str = "";
		if (card_type == 1) {str = "chance";}
		else {str = "community";}
		return str;
	}
	
     /*
    // Author: Sean Mitchel
    // Get_Event
    // Returns the event string from the member event object in a card
    /
    */
	public Get_Event()
	{
		// Returns the event string from the member even object
		// TODO: add the event integer 
		return this.event.Get_Event();
	}
}
