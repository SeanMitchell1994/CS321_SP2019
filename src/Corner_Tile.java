/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolydriver;

/**
 *
 * @author Sean
 */
public class Corner_Tile 
{
    private int flag = 0;
    private String name;
    private String location;
    private final boolean hasEvent = true;
    
    Corner_Tile(String name, String location)
    {
        this.name = name;
        this.location = location;

	switch(this.name)
	{
	    case "GO":
		this.flag = 1;
		break;
	    case "Jail":
		this.flag = 2;
		break;
	    case "Free Parking":
		this.flag = 3;
		break;
	    case "Go to Jail":
		this.flag = 4;
		break;
	default:
		break;
	}
        
    }
    
    /*()
    Event_Adapter Get_Event()
    {
        return 
    }*/
    
    /**
     * Returns the name of the Property
     * @author Ansley Solomon
     * @return String name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Returns the Property's location on the Board
     * @author Ansley Solomon
     * @return int location
     */
    public int getLocation(){
        int lo = Integer.parseInt(location);	
        return lo;
    }
    
    /**
     * Returns if the tile has an event
     * @author Sean Mitchell
     * @return boolean hasEvent 
     */
    public boolean getHasEvent()
    {
        return this.hasEvent;
    }

    public void getEvent(Player input_obj)
    {
        switch(flag)
        {
            case 1:
                input_obj.shift_Money(200);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                //input_obj.Set_Location
                break;
        default:
                break;
        }
    }
}
