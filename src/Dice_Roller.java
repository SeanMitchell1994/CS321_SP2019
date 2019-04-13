package monopolydriver;

/**
 * Dice_Roller class
 * 
 * This class contains the constructor for the Dice_Roller object. 
 * 
 * @author Sean Mitchell
 */
import java.util.Random;
//call twice for two die

public class Dice_Roller{
    private final Random rand_int;
    private final int sides;
        
    /**
     * Default constructor
     * Creates a random integer
     * @author Sean Mitchell
     * @param i Number of sides on the die
     */
    Dice_Roller(int i) {
     this.rand_int = new Random();
     this.sides = i;
    }

    /**
     * Rolls a die and returns the result as an int
     * @author Sean Mitchell
     * @return Random number between 1 and the number of sides
     */
    public int Roll(){
        return 1 + rand_int.nextInt(sides);
    }
}
