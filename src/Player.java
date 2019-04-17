package monopolydriver;
/**
 * Main class for the Player objects
 * 
 * @author 
 */
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class Player{
	// Member Variables

	private int location;
	private int money;
	//private int[] property_list;
	//ArrayList<Property> property_list = new ArrayList<>();
        ArrayList<Tile_Adapter> property_list = new ArrayList<>();
	private ImageIcon image;
	private String name;
	private boolean is_ready;
	// list with money broken down into types of money
	// integer that shows the sum total of money

	/**
         * Default constructor
         * Somebody put more description, I don't know what this does
         * @author 
         * @param input_name
         * @param whichP 
         */
	public Player(String input_name, int whichP)
	{
            System.out.print("Player created!\n");

	    location = 0;		// starting location
            name = input_name;	// player name as a string
	    money = 1500;		// temp variable, this will change
	    is_ready = false;	// is the player ready to move to the next
             
             if(whichP == 1){
                 File imageFile = new File("Fadora.PNG");
                 BufferedImage tokinImage = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
                 try{
                    tokinImage = ImageIO.read(imageFile);
                    } 
                catch(IOException e){
                    System.out.println("Error: " + e);
                    }
            image = new ImageIcon(tokinImage);
            }
             if(whichP == 2){
                 File imageFile = new File("Beaker.PNG");
                 BufferedImage tokinImage = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
                 try{
                    tokinImage = ImageIO.read(imageFile);
                    } 
                catch(IOException e){
                    System.out.println("Error: " + e);
                    }
            image = new ImageIcon(tokinImage);
            }
             if(whichP == 3){
                 File imageFile = new File("Glasses.PNG");
                 BufferedImage tokinImage = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
                 try{
                    tokinImage = ImageIO.read(imageFile);
                    } 
                catch(IOException e){
                    System.out.println("Error: " + e);
                    }
            image = new ImageIcon(tokinImage);
            }
             if(whichP != 1 && whichP != 2 && whichP != 3){
                 File imageFile = new File("Horse.PNG");
                 BufferedImage tokinImage = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
                 try{
                    tokinImage = ImageIO.read(imageFile);
                    } 
                catch(IOException e){
                    System.out.println("Error: " + e);
                    }
            image = new ImageIcon(tokinImage);
            }
	} 

	/**
         * Returns the Player's current location as an int
         * @author 
         * @return Location
         */
	public int Get_Location(){
                return this.location;
	}
	
        /**
         * Returns the Player's current money as an int
         * @author 
         * @return Money
         */
	public int Get_Money(){
               return this.money;
	}
        
        /**
         * Returns a Player's name as a String
         * @author 
         * @return 
         */
	public String Get_Name(){
            return this. name;
	}

	/**
         * Tells if a Player is ready to take their turn
         * @author 
         * @return boolean is_ready
         */
	public boolean Is_Ready(){
            return this.is_ready;
	}
        
        /**
         * Returns a Player's token
         * @author 
         * @return ImageIcon image
         */
        public ImageIcon Get_Image(){
            return this.image;
        }
        
        /**
         * Returns the Y-coordinate of the Player's location on the Board
         * @author 
         * @return int y-coordinate
         */
        public int Get_YCordinate(){
        int starty = 545;
        if(location <= 10 && location >= 0){
            return starty;
        }
        if(location < 30 && location >= 20 ){
            starty = 50;
            return starty;
        }
            
        if(Get_Location() == 11 || Get_Location() == 39){return 500;}
        if(Get_Location() == 12 || Get_Location() == 38){return 470;}
        if(Get_Location() == 13 || Get_Location() == 37){return 440;}
        if(Get_Location() == 14 || Get_Location() == 36){return 400;}
        if(Get_Location() == 15 || Get_Location() == 35){return 370;}
        if(Get_Location() == 16 || Get_Location() == 34){return 335;}
        if(Get_Location() == 17 || Get_Location() == 33){return 300;}
        if(Get_Location() == 18 || Get_Location() == 32){return 260;}
        if(Get_Location() == 19 || Get_Location() == 31){return 220;}        
            
            return 0;
        }
        
        /**
         * Returns the X-coordinate of the Player's location on the Board
         * @author 
         * @return int x-coordinate
         */
        public int Get_XCordinate(){
            int startx = 750;
            if(Get_Location() == 0){ return startx;}
            if(Get_Location() == 1 || Get_Location() == 29){return 730;}
            if(Get_Location() == 2 || Get_Location() == 28){return 670;}
            if(Get_Location() == 3 || Get_Location() == 27){return 590;}
            if(Get_Location() == 4 || Get_Location() == 26){return 500;}
            if(Get_Location() == 5 || Get_Location() == 25){return 420;}
            if(Get_Location() == 6 || Get_Location() == 24){return 365;}
            if(Get_Location() == 7 || Get_Location() == 23){return 300;}
            if(Get_Location() == 8 || Get_Location() == 22){return 260;}
            if(Get_Location() == 9 || Get_Location() == 21){return 220;}
            
            if(Get_Location() >= 10 && location < 20){
                return 170;
            }
            if(Get_Location() >= 30 && location < 40){
                return 770;
            }
            return 0;
        }

	/**
	* Sets the player's location as an int
        * @author 
	* @param  input  an integer representing the location of the player
	*/
	public void Set_Location(int input){
            location = location + input;
	}
        
        /**
	* changes a players location based on a value passed in
        * @author 
	* @param  	shift  The amount to shift the player's location by
	*/
        public void Shift_Location(int shift){
            if((Get_Location() + shift) > 39){
                Set_Location(((Get_Location()+shift) - 40));
                Set_Money(Get_Money()+200);
            }
            else if((Get_Location() + shift) < 0){
                Set_Location(40+(Get_Location()+shift));
            }
            else{
                Set_Location(Get_Location()+shift);
            }
        }

	/**
	* Sets the player's money to the given input
        * @author 
	* @param  input  The amount of money a Player has
	*/
	public void Set_Money(int input)
	{
        	money = input;
	}
        
        /**
         * Shifts a Player's money (add/subtract)
         * Needs an if to call mortgage/forfeit option when money reaches zero
         * @author 
         * @param input The amount of money being shifted
         */
        public void shift_Money(int input){
            money = money + input;
        }

	/**
	* Sets the player's name to the given input
        * @author 
	* @param  input  A string representing the player's name
	*/
	public void Set_Name(String input){
            name = input;
	}
	
	/**
	* Sets if the player is ready to end their turn
        * @author 
	*/
	public void Set_Ready(){
            is_ready = true;
	}
        
	/**
	* Sets the image used for the player's token
        * @author 
	* @param  	x	A loaded image file
	*/
        public void Set_Image(ImageIcon x){
            image = x;
        }
        
        /**
	* Allows the player to buy a property
	* Adds the property object to the player's property list 
	* and subtracts the cost of the property from the player's current money
	* @author 
	* @param  	tile	A property object
	*/
	public void Buy_Property(Tile_Adapter tile){
            // to do: check if player already owns tile
            System.out.print("Buy function!\n");
            if (tile.getType() == 1)
                if (!tile.Get_IsOwned())
                {                                //THERE WAS AN ERROR THERE WAS AN ERRORTHERE WAS AN ERROR THERE WAS AN ERROR THERE WAS AN ERROR THERE WAS AN ERROR THERE WAS AN ERROR
                    property_list.add(tile);   //THERE WAS AN ERROR THERE WAS AN ERROR THERE WAS AN ERROR THERE WAS AN ERROR THERE WAS AN ERROR THERE WAS AN ERROR
                    tile.Set_IsOwned(true);
                    tile.Set_Owner(this.name);
                    money = money - tile.getPrice();
                }
                else
                    System.out.print("Property is already owned!\n");
        }

	/**
	* Allows the player to sell a property
	* Removes the property object to the player's property list 
	* and adds the cost of the property from the player's current money
	* @author 
	* @param  	tile	A property object
	*/
	public void Sell_Property(Tile_Adapter tile){
            System.out.print("Sell detected!\n");
            property_list.remove(tile);
            money = money + tile.getPrice();
	}
     
        /**
         * DESCRIPTION NEEDED
         * @author 
         * @param p_other DESCRIPTION NEEDED
         * @param tile DESCRIPTION NEEDED
         */
	public void Trade_Property(Player p_other, Tile_Adapter tile){
		Sell_Property(tile);
		p_other.Buy_Property(tile);	
	}
        
        /**
         * DESCRIPTION NEEDED
         * @author 
         * @param current_tile The tile the current Player is on at the beginning
         * of their turn
         */
        public void Turn(Tile_Adapter current_tile){
		String s = "";
		System.out.print("Actions: Buy | Sell | Trade\n");
		Scanner sc = new Scanner(System.in);
		s = sc.nextLine();
		if (s.equals("Buy"))
                {
                    this.Buy_Property(current_tile);
                }
		else if (s.equals("Sell"))
                {
                    this.Sell_Property(current_tile);
                }
		else if (s.equals("Trade")){System.out.print("Trade detected!\n");}
            //    else if(s.equals("Debug")){Print_Property();}
        }
        
        /**
         * DESCRIPTION NEEDED
         * @author 
         */
        public void Turn()
	{
		String s = "";
		System.out.print("Actions: Buy | Sell | Trade\n");
		Scanner sc = new Scanner(System.in);
		s = sc.nextLine();
		if (s.equals("Buy")){System.out.print("Buy detected!\n");}
		else if (s.equals("Sell")){System.out.print("Sell detected!\n");}
		else if (s.equals("Trade")){System.out.print("Trade detected!\n");}
	}
        
        /**
         * Rolls the dice
         * @author 
         * @return Returns an int between 1 and 12
         */
        public int PlayerRoll(){
            int rollValue = (new Dice_Roller(12).Roll());
           // Shift_Location(rollValue);
            System.out.println("The Player Rolled a: "+ rollValue);
            return rollValue;
        }
        
        /**
         * Prints out the entire PropertyList
         * For testing purposes
         * @author 
         */
        public void Print_Property()
        {
            for (int  i = 0; i < property_list.size(); i++)
            {
                System.out.println("Name: " + property_list.get(i).getName());
                System.out.println("Location: "  + property_list.get(i).getLocation());
                System.out.println("Price: " + property_list.get(i).getPrice());
                System.out.println();
            } 
        }
}
