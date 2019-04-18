	
package monopolydriver;

/**
 *
 * @author Sean
 */
public class Card_Tile 
{
    int flag = 0;
    private String name;
    private String location;
    private boolean hasEvent = true;
    
    Card_Tile(String name, String location)
    {
	this.name = name;
        this.location = location;
	//System.out.println("CT Name: " + this.name);
        if (this.name.equals("charger_chest"))
        {
            flag = 1;
        }
        else if (this.name.equals("chance"))
        {
            flag = 2;
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
}
