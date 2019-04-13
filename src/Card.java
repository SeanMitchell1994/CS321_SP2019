package monopolydriver;

/**
 * Card class
 * 
 * This class contains the card object and methods to access the individual
 * card components. 
 * 
 * @author Ansley Solomon, Sean Mitchell
 */
public class Card
{
	private final String card_type;
	private final String card_id;
	//private final Card_Event event;
	private final String text;
        private final String event_type;
        private final String event_value;
    
    /*
     * @author Sean Mitchell, Ansley Solomon
     * Default construct for a card object
     *
     * @param card_id_input The card's ID number
     * @param text_input The card's text
     * @param type_input The card's type (chance or charger chest)
     * @param event_type_input The type of event the card performs
     * @param event_value_input The value that goes in the even function
     * @return None
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
     * This method returns the card's type (chance or charger chest)
     * @author Ansley Solomon
     * @return Returns the card's type (chance or charger chest)
     */
    public String getCardType()
    {
            return card_type;
    }
    
    /*
     * This method returns the card's ID number
     * @author Ansley Solomon
     * @return Returns the card's ID number as an int
     */
    public int getID()
    {
        int id = Integer.parseInt(card_id);
        return id;
    }

    /*
     *This method returns the card's text as a string
     * @author Ansley Solomon
     * @return Returns the card's text as a string
     */   
    public String getText(){
        return text;
    }
    
    /*
     * This method returns the card's event type
     * @author Ansley Solomon
     * @return Returns the card's event type as a string
     */    
    public String getEventType()
    {
        return event_type;
    }
    
    /*
     * This method returns the value that is a parameter for the event function
     * @author Ansley Solomon
     * @return Returns the card's event value as a string
     */
    public String getEventValue()
    {
        return event_value;
    }

    /*
     * This method performs the event on the Player
     * @author Sean Mitchell
     * @param input The player that the event is happening to
     * @return Returns the event string from the member event object in a card
     */
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
