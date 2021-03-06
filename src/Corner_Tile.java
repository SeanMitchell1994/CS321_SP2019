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
    private String event_text;
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
            {
		this.flag = 1;
                this.event_text = "Passed GO! Collect $200";
		break;
            }
	    case "Jail":
            {
		this.flag = 2;
                this.event_text = "Just visiting";
		break;
            }
	    case "Free Parking":
            {
		this.flag = 3;
                this.event_text = "Free parking!";
		break;
            }
	    case "Go to Jail":
            {
		this.flag = 4;
                this.event_text = "Go to jail! Pay $50";
		break;
            }
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
    * 
    * @author   Sean Mitchell
    * @param     Player  the player who is involved in the event
    * @return None
    */
    public void getEvent(Player input_obj)
    {
        switch(flag)
        {
            case 1:
                System.out.println("Passed GO!");
                input_obj.shift_Money(200);
                break;
            case 2:
                System.out.println("Passed Jail!");
                break;
            case 3:
                System.out.println("Passed Free Parking!");
                break;
            case 4:
                System.out.println("Passed Go to Jail!");
                input_obj.Set_Location(10);
                input_obj.shift_Money(-50);
                break;
        default:
                break;
        }
    }
    
    public String getEventText()
    {
        return this.event_text;
    }
}
