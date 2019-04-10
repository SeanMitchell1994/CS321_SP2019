// ========================================
// Card.java
// ========================================

// Imports
//import Card_Event.java;

public class Card
{
	private final String card_type;
	private final String card_id;
	//private final Card_Event event;
	private final String text;
        private final String event_type;
        private final String event_value;
	//private final token

     /*
    // Author: Sean Mitchell, Ansley Solomon
    // Card(int event_input, int card_id_input)
    // Default construct for a card object. A card's event is set to event_input passed in and
    // card_id is set to card_id_input passed in.
    */
	public Card(String card_id_input, String text_input, String type_input, String event_type_input, String event_value_input)
	{
		//event = event_input;
		card_id = card_id_input;
		text = text_input;
                card_type = type_input;
                event_type = event_type_input;
                event_value = event_value_input;
	}

    /*
    // Author: Ansley Solomon
    // getCardType()
    // Returns a card's type as a string.
    */
    public String getCardType()
    {
            return card_type;
    }

    // Author: Ansley Solomon
    // getID()
    // Returns a card's ID number as an int
    public int getID()
    {
        int id = Integer.parseInt(card_id);
        return id;
    }

    // Author: Ansley Solomon
    // getText()
    // Returns a card's text as a string
    public String getText(){
        return text;
    }
    
    public String getEventType()
    {
        return event_type;
    }
    
    public String getEventValue()
    {
        return event_value;
    }
        
     
    // Author: Sean Mitchel
    // Get_Event
    // Returns the event string from the member event object in a card
    //
    public void Get_Event(Player input)
    {
        if (this.getEventType().equals("collect"))
        {
            input.shift_Money(Integer.parseInt(this.getEventValue()));
        }
        else if (this.getEventType().equals("move"))
        {
            input.Set_Location(Integer.parseInt(this.getEventValue()));
        }
    }     
}
