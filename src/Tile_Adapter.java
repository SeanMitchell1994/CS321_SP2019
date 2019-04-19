package monopolydriver;

/**
 * Tile_Adapter.java
 * This class contains the adapters to allow the various property classes 
 * to interact with a common set of code
 * 
 * @author Sean Mitchell
 */

import java.util.ArrayList;

public class Tile_Adapter 
{
    // ======================================
    // Member variables
    // ======================================
    private Property_Tile local_p;
    private Crosswalk_Tile local_cw;
    private Utility_Tile local_u;
    private Card_Tile local_ct;
    private Corner_Tile local_corner;
    private Other_Tile local_ot;
    private Decks d1 = new Decks();
    private Card local_card;
    
    private int flag;
    private boolean is_owned;
    private String owner = "None";
        
    // ======================================
    // Constructors
    // ======================================
    /**
    * Constructor for Property types
    *
	* @author Sean Mitchell
    * @param                    None
    * @return   Tile_Adapter    Tile_Adapter object
    */
    public Tile_Adapter(Property_Tile input)
    {
        //System.out.println("Tile object  created!");
        this.local_p = input;
        this.flag = 1;
    }
       
    /**
    * Constructor for Crosswalk types
    *
* @author Sean Mitchell
    * @param                    None
    * @return   Tile_Adapter    Tile_Adapter object
    */
    public Tile_Adapter(Crosswalk_Tile input)
    {
        //System.out.println("CW object  created!");
        this.local_cw = input;
        this.flag = 2;
    }
         
    /**
    * Constructor for Utility types
    *
* @author Sean Mitchell
    * @param                    None
    * @return   Tile_Adapter    Tile_Adapter object
    */
    public Tile_Adapter(Utility_Tile input)
    {
        //System.out.println("Utlity object created!");
        this.local_u = input;
        this.flag = 3;
    }
    
    /**
    * Constructor for Card_Tile types
    *
* @author Sean Mitchell
    * @param                    None
    * @return   Tile_Adapter    Tile_Adapter object
    */
    public Tile_Adapter(Card_Tile input)
    {
        //System.out.println("Tile object  created!");
        this.local_ct = input;
        
        if (this.local_ct.getName().equals("Charger Chest"))
        {
            this.flag = 4;
        }
        else if (this.local_ct.getName().equals("Chance"))
        {
            this.flag = 5;
        }
        
        //System.out.println("Flag: "+this.flag);
    }
    
    /**
    * Constructor for Corner_Tile types
    *
* @author Sean Mitchell
    * @param                    None
    * @return   Tile_Adapter    Tile_Adapter object
    */
    public Tile_Adapter(Corner_Tile input)
    {
        //System.out.println("Tile object  created!");
        this.local_corner = input;
        this.flag = 6;
    }
    
    /**
    * Constructor for Other_Tile types
    *
* @author Sean Mitchell
    * @param                    None
    * @return   Tile_Adapter    Tile_Adapter object
    */
    public Tile_Adapter(Other_Tile input)
    {
        //System.out.println("Tile object  created!");
        this.local_ot = input;
        this.flag = 7;
    }
    
    // ======================================
    // Mutator functions
    // ======================================
    
    /**
    * Adapter interface for setting if a tile's owner
    *
* @author Sean Mitchell
    * @param    String  input
    * @return           None
    */
    public void Set_Owner(String input)
    {
	/*
        if (flag == 1)
        {
            this.owner = input;
        }
        return;
        */
	switch(this.flag)
        {
            case 1:
                this.owner = input;;
                break;
            case 2:
                this.owner = input;
                break;
            case 3:
                this.owner = input;
                break;
	/*
            case 4:
                temp = local_ct.getName();
                break;
            case 5:
                temp = local_ct.getName();
                break;
            case 6:
                temp = local_corner.getName();
                break;
            case 7:
                temp = local_ot.getName();
                break;
	*/
            default:
                break;
        }
    }
    
    /**
    * Adapter interface for setting if a tile is owned
    *
* @author Sean Mitchell
    * @param    input   boolean value
    * @return           None
    */
    public void Set_IsOwned(boolean input)
    {
	this.is_owned = false;
	
	/*
        if ((this.flag == 1 ) || (this.flag == 2))
            this.is_owned = input;
        else
            this.is_owned = false;
	*/
	switch(flag)
        {
            case 1:
                this.is_owned = input;
                break;
            case 2:
                this.is_owned = input;
                break;
            case 3:
                this.is_owned = input;
                break;
	/*
            case 4:
                temp = local_ct.getName();
                break;
            case 5:
                temp = local_ct.getName();
                break;
            case 6:
                temp = local_corner.getName();
                break;
            case 7:
                temp = local_ot.getName();
                break;
	*/
            default:
                break;
        }
    }
    
    // ======================================
    // Accessor functions
    // ======================================
    /**
    * Adapter interface for is tile classification
    *
    * @author Sean Mitchell
    * @param            None
    * @return   int     Tile classification
    */
    public int getType()
    {
        return flag;
    }
    
    /**
    * Adapter interface for is tile currently owned
    *
    * @param            None
    * @return   boolean Is tile owned?
    */
    public boolean Get_IsOwned()
    {
        return this.is_owned;
    }
    
    /**
    * Adapter interface for if the tile is buyable
    *
    * @author Sean Mitchell
    * @param            None
    * @return   boolean is tile buyable?
    */
    public boolean Get_IsBuyable()
    {
        boolean temp = false;
        if (!Get_IsOwned())
        {
            switch(flag)
            {
                case 1:
                    temp = true;
                    break;
                case 2:
                    temp = true;
                    break;
                case 3:
                    temp = true;
                    break;
                default:
                    break;
            }
        }
        return temp;
    }
    
    /**
    * Adapter interface for tile names
    *
    * @author Sean Mitchell
    * @param            None
    * @return   String  Name of tile
    */
    public String getName()
    {
        //System.out.print("debug!\n");
        String temp = "";

	switch(flag)
        {
            case 1:
                temp = temp = local_p.getName();
                break;
            case 2:
                temp = local_cw.getName();
                break;
            case 3:
                temp = local_u.getName();
                break;
            case 4:
                temp = local_ct.getName();
                break;
            case 5:
                temp = local_ct.getName();
                break;
            case 6:
                temp = local_corner.getName();
                break;
            case 7:
                temp = local_ot.getName();
                break;
            default:
                break;
        }
        
        return temp;
    }
    
    /**
    * Adapter interface for tile locations
    *
    * @author Sean Mitchell
    * @param            None
    * @return   int     Location of tile
    */
    public int getLocation()
    {
        int temp = 0;
        
        switch(flag)
        {
            case 1:
                temp = local_p.getLocation();
                break;
            case 2:
                temp = local_cw.getLocation();
                break;
            case 3:
                temp = local_u.getLocation();
                break;
            case 4:
                temp = local_ct.getLocation();
                break;
            case 5:
                temp = local_ct.getLocation();
                break;
            case 6:
                temp = local_corner.getLocation();
                break;
            case 7:
                temp = local_ot.getLocation();
                break;
            default:
                break;
        }

        return temp;
    }

    /**
    * Adapter interface for tile prices
    *
    * @author Sean Mitchell
    * @param            None
    * @return   int     Price of tile
    */
    public int getPrice()
    {
        int temp = 0;

	switch(flag)
        {
            case 1:
                temp = local_p.getPrice();
                break;
            case 2:
                temp = local_cw.getPrice();
                break;
            case 3:
                temp = local_u.getPrice();
                break;
	/*
            case 4:
                if (local_ct.getHasEvent()) {temp = 0}
                break;
            case 5:
                if (local_ct.getHasEvent()) {temp = 0}
                break;
            case 6:
                if (local_corner.getHasEvent()) {temp = 0}
                break;
            case 7:
                if (this.local_ot.getHasEvent()) {temp = 0}
                break;
	*/
            default:
                break;
        }
        
        return temp;
    }
    
    /**
    * Adapter interface for if a tile has an event
    *
    * @author Sean Mitchell
    * @param            None
    * @return   boolean     Does a the tile have an event?
    */
    public boolean getHasEvent()
    {
        boolean temp = false;
        switch(flag)
        {
            case 1:
                if (local_p.getHasEvent()) {temp = true;}
                break;
            case 2:
                if (local_cw.getHasEvent()) {temp = true;}
                break;
            case 3:
                if (local_u.getHasEvent()) {temp = true;}
                break;
            case 4:
                if (local_ct.getHasEvent()) {temp = true;}
                break;
            case 5:
                if (local_ct.getHasEvent()) {temp = true;}
                break;
            case 6:
                if (local_corner.getHasEvent()) {temp = true;}
                break;
            case 7:
                if (this.local_ot.getHasEvent()) {temp = true;}
                break;
            default:
                break;
        }
        return temp;
    }
    
    /**
    * Adapter interface for tile events
    *
* @author Sean Mitchell
    * @param	Player	the player who the event happens to
    * @return   	None
    */
    public void getEvent(Player input)
    {
        //System.out.println("Event function!");
        if (getHasEvent())
        {
            switch(flag)
            {
                case 4:
                {
                    //System.out.println("CC event!");
                    this.local_card = d1.draw("cc");
                    this.local_card.Get_Event(input);
                    break;
                }
                case 5:
                {
                    //System.out.println("Chance event!");
                    this.local_card = d1.draw("chance");
                    this.local_card.Get_Event(input);
                    break;
                }
                case 6:
                {
                    //System.out.println("Corner event!");
                    this.local_corner.getEvent(input);
                    break;
                }
                case 7:
                {
                    //System.out.println("Other event!");
                    input.shift_Money(-local_ot.getCost());
                    break;
                }
                default:
                    break;
            }
	
        }
    }
    
    /**
    * Adapter interface for getting the text describing an event
    * Need to call @see getEvent() first to draw a new card
    * Gets the text for the same event until a new card is drawn
    * 
    * Usage: Need to call getEvent() before this to draw a new card
    *
    * @author Sean Mitchell
    * @param            None
    * @return   String    The text describing the event
    */
    public String getEventText()
    {
	String temp = "";
        if (getHasEvent())
        {
            switch(flag)
            {
                case 4:
                    temp = this.local_card.getText();
                    break;
                case 5:
                    temp = this.local_card.getText();
                    break;
                case 6:
                    temp = this.local_corner.getEventText();
                    break;
                case 7:
                    temp = this.local_ot.getEventText();
                    break;
                default:
                    break;
            }
        }
        return temp;
    }
}