package monopolydriver;

/**
 * Event_Adapter class
 * 
 * Description goes here
 * 
 * @author Sean Mitchell
 */
public class Event_Adapter 
{
    Card local_c;
    
    /**
     * Default constructor
     * @author: Sean Mitchell
     * @param obj_input 
     */
    Event_Adapter(Card obj_input)
    {
        this.local_c = obj_input;     
    }
    
    /**
     * Does an Event to a Player object
     * @author Sean Mitchell
     * @param input Which Player the event is happening to
     */
    public void Event(Player input)
    {
        if (this.local_c.getEventType().equals("collect"))
        {
            input.Set_Money(Integer.parseInt(this.local_c.getEventValue()));
        }
        else if (this.local_c.getEventType().equals("move"))
        {
            input.Set_Location(Integer.parseInt(this.local_c.getEventValue()));
        }
    }
}
