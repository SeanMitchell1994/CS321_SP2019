/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sean
 */
public class Event_Adapter 
{

    Card local_c;
    Event_Adapter(Card obj_input)
    {
        this.local_c = obj_input;     
    }
    
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
