package monopolydriver;

/**
 * Other_Tile.java
*
 * This class contains the member variables and methods for "other tiles"
* Other tiles are the two cost tiles on the board
* These are the Buy Books and Pay Tutition tiles
 * 
 * @author Sean Mitchell
 */
public class Other_Tile 
{
    // ======================================
    // Member variables
    // ======================================
    private String name;
    private String location;
    private String cost;
    private int flag;
    private boolean hasEvent = true;
    
    // ======================================
    // Constructors
    // ======================================
    /**
    * Constructor for Other_Tile types
    *
	* @author Sean Mitchell
    * @param    String		name of tile
* @param	String		location of tile
* @param	String		cost of tile
    * @return   Other_Tile    Other_Tile object
    */
    Other_Tile (String name, String location, String cost)
    {        
        this.name = name;
        this.location = location;
	this.cost = cost;

	switch(this.name)
	{
	    case "Buy Books":
		this.flag = 1;
		break;
	    case "Pay Tutition":
		this.flag = 2;
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