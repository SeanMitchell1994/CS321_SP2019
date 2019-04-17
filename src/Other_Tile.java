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
public class Other_Tile 
{
    private String name;
    private String location;
	private String cost;
    private boolean hasEvent = true;
    
    Other_Tile (String name, String location, String cost)
    {        
        this.name = name;
        this.location = location;
	this.cost = cost;
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

	public int getCost()
	{
	        int co = Integer.parseInt(this.cost);	
	        return co;
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