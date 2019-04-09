
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sean
 */
public class Tile 
{
    Property local_p;
    Crosswalk local_cw;
    Utility local_u;
    int flag;
        
    public Tile(Property input)
    {
        //System.out.println("Tile object  created!");
        this.local_p = input;
        this.flag = 1;
    }
        
    public Tile(Crosswalk input)
    {
        //System.out.println("CW object  created!");
        this.local_cw = input;
        this.flag = 2;
    }
            
    public Tile(Utility input)
    {
        //System.out.println("Utlity object created!");
        this.local_u = input;
        this.flag = 3;
    }
    
    public void Set_Owner(String input)
    {
        
    }
    
    public void Set_IsOwned(boolean input)
    {
        
    }
    
    public int getType()
    {
        return flag;
    }
    
    public boolean Get_IsOwned()
    {
        boolean temp = false;
        return temp;
    }
    
    public String getName()
    {
        //System.out.print("debug!\n");
        String temp = "";
        if (this.flag == 1)
            temp = local_p.getName();
        else if (this.flag == 2)
            temp = local_cw.getName();
        else 
            temp = local_u.getName();
        
        return temp;
    }
    
    public int getLocation()
    {
        int temp;
        if (this.flag == 1)
            temp = local_p.getLocation();
        else if (this.flag == 2)
            temp = local_cw.getLocation();
        else 
            temp = local_u.getLocation();
        
        return temp;
    }

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
