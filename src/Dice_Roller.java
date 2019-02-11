// ========================================
// Dice_Roller.java
// ========================================

// Imports
import java.util.Random;

public class Dice_Roller
{
	private final Random rand_int;
	private final int sides;

	// Default constructor
	public Dice_Roller(int sides)
	{
		this.rand_int = new Random();
		this.sides = sides;
	}

	// Rolls the dice and returns the result as an int
	public int Roll()
	{
		return 1 + rand.nextInt(sides);
	}
}	