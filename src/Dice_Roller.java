// ========================================
// Dice_Roller.java
// ========================================

// Imports
import java.util.Random;

//WILL WE RECOGNIZE DOUBLES ROLLED?
public class Dice_Roller
{
	private final Random rand_int;
	private final int sides;

/*
// Author: Sean Mitchel
// Dice_Roller(int sides)  
// Default Dice_Roller constructor. rand_int is set to a new random and sides is set to the value passed in.
// 
*/
	public Dice_Roller(int sides)
	{
		this.rand_int = new Random();
		this.sides = sides;
	}


/*
// Author: Sean Mitchel
// Roll()  
// Rolls the dice and returns the result as an int
// 
*/	
	// Rolls the dice and returns the result as an int
	public int Roll()
	{
		return 1 + rand_int.nextInt(sides);
	}
}	
