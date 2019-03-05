// ========================================
// driver.java
// Demo driver that spawns a few players 
// and goes through a few turns
// ========================================

// Imports

public class driver
{
   public static void main(String[] args) 
   {
	System.out.print("Main entry point!\n");
        Board test_board = new Board();
	for (int i = 0; i < 16; i++)
	{
		test_board.Update();
	}
	System.out.print("Demo finished!\n");
   }
}