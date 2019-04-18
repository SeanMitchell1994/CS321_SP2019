package monopolydriver;

/**
 * Corner_Tile.java
*
 * This class contains the member variables and methods for "corner tiles"
* Corner tiles are the four corner tiles on the board
* These are the GO, Jail, Free Parking, Go to Jail tiles
 * 
 * @author Sean Mitchell
 */

public class Corner_Tile 
{
    // ======================================
    // Member variables
    // ======================================
    private int flag = 0;
    private String name;
    private String location;
    private final boolean hasEvent = true;
    
    // ======================================
    // Constructors
    // ======================================
    /**
    * Constructor for Other_Tile types
    *
	* @author Sean Mitchell
    * @param    String		name of tile
* @param	String		location of tile
    * @return   Corner_Tile    Corner_Tile object
    */
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
   
    // ======================================
    // Accessors
    // ====================================== 
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

    /** 
     * Returns the event of this tile
     * @author Sean Mitchell
*@param Player the player who is involved in the event
     * @return None
     */
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
