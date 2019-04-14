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
    private Property local_p;
    private Crosswalk local_cw;
    private Utility local_u;
    private Card_Tile local_ct;
    private Corner_Tile local_corner;
    
    private int flag;
    private boolean is_owned;
    private String owner = "None";
        
    // ======================================
    // Constructors
    // ======================================
    /**
    * Constructor for Property types
    *
    * @param                    None
    * @return   Tile_Adapter    Tile_Adapter object
    */
    public Tile_Adapter(Property input)
    {
        //System.out.println("Tile object  created!");
        this.local_p = input;
        this.flag = 1;
    }
       
    /**
    * Constructor for Crosswalk types
    *
    * @param                    None
    * @return   Tile_Adapter    Tile_Adapter object
    */
    public Tile_Adapter(Crosswalk input)
    {
        //System.out.println("CW object  created!");
        this.local_cw = input;
        this.flag = 2;
    }
         
    /**
    * Constructor for Utility types
    *
    * @param                    None
    * @return   Tile_Adapter    Tile_Adapter object
    */
    public Tile_Adapter(Utility input)
    {
        //System.out.println("Utlity object created!");
        this.local_u = input;
        this.flag = 3;
    }
    
    /**
    * Constructor for Card_Tile types
    *
    * @param                    None
    * @return   Tile_Adapter    Tile_Adapter object
    */
    public Tile_Adapter(Card_Tile input)
    {
        //System.out.println("Tile object  created!");
        this.local_ct = input;
        this.flag = 4;
    }
    
        /**
    * Constructor for Card_Tile types
    *
    * @param                    None
    * @return   Tile_Adapter    Tile_Adapter object
    */
    public Tile_Adapter(Corner_Tile input)
    {
        //System.out.println("Tile object  created!");
        this.local_corner = input;
        this.flag = 5;
    }
    
    // ======================================
    // Mutator functions
    // ======================================
    
    /**
    * Adapter interface for setting if a tile's owner
    *
    * @param    String  input
    * @return           None
    */
    public void Set_Owner(String input)
    {
        if (flag == 1)
        {
            this.owner = input;
        }
        return;
    }
    
    /**
    * Adapter interface for setting if a tile is owned
    *
    * @param    input   boolean value
    * @return           None
    */
    public void Set_IsOwned(boolean input)
    {
        if ((this.flag == 1 ) || (this.flag == 2))
            this.is_owned = input;
        else
            this.is_owned = false;
    }
    
    // ======================================
    // Accessor functions
    // ======================================
    /**
    * Adapter interface for is tile classification
    *
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
    * Adapter interface for tile names
    *
    * @param            None
    * @return   String  Name of tile
    */
    public String getName()
    {
        //System.out.print("debug!\n");
        String temp = "";
        if (this.flag == 1)
            temp = local_p.getName();
        else if (this.flag == 2)
            temp = local_cw.getName();
        else if (this.flag == 3)
            temp = local_u.getName();
        else if (this.flag == 4)
            temp = local_ct.getName();
        else if (this.flag == 5)
            temp = local_corner.getName();
        
        return temp;
    }
    
    /**
    * Adapter interface for tile locations
    *
    * @param            None
    * @return   int     Location of tile
    */
    public int getLocation()
    {
        int temp = 0;
        if (this.flag == 1)
            temp = local_p.getLocation();
        else if (this.flag == 2)
            temp = local_cw.getLocation();
        else if (this.flag == 3)
            temp = local_u.getLocation();
        else if (this.flag == 4)
            temp = local_ct.getLocation();
        else if (this.flag == 5)
            temp = local_corner.getLocation();
        
        return temp;
    }

    /**
    * Adapter interface for tile prices
    *
    * @param            None
    * @return   int     Price of tile
    */
    public int getPrice()
    {
        int temp;
        if (this.flag == 1)
            temp = local_p.getPrice();
        else if (this.flag == 2)
            temp = local_cw.getPrice();
        else 
            temp = local_u.getPrice();
        
        return temp;
    }
}