package monopolydriver;


/**
 * This class contains the Other_Tile class. It is for the "Buy Books" and "Pay
 * Tuition" tiles on the game board.
 */
public class Other_Tile 
{
    private int flag = 0;
    private String name;
    private String location;
    private String cost;
    private boolean hasEvent = true;
    
    /**
     * Class constructor
     * @author Sean Mitchell
     * 
     * @param name
     * @param location
     * @param cost 
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
    
    /**
     * Returns the name of the tile
     * @author Ansley Solomon
     * @return Returns the name of the Property
     */
    public String getName(){
        return this.name;
    }

    /**
     * Returns the tile's location on the Board
     * @author Ansley Solomon
     * @return Returns tile location on the game board
     */
    public int getLocation(){
        int lo = Integer.parseInt(location);	
        return lo;
    }

    /**
     * Returns the tile's cost
     * @author Ansley Solomon
     * @return Returns the tile's cost
     */
    public int getCost()
    {
            int co = Integer.parseInt(this.cost);	
            return co;
    }
    
    /**
     * Tells if the tile has an event
     * @author Sean Mitchell
     * @return boolean hasEvent
     */
    public boolean getHasEvent()
    {
        return this.hasEvent;
    }

    /**
     * Returns the text that displays when the tile has an event
     * @author Sean Mitchell
     * @return String text
     */
    String getEventText() {
        return "no event";
    }
}
