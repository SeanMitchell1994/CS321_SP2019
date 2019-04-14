package monopolydriver;


import monopolydriver.Board;

// ========================================
// driver.java
// Demo driver that spawns a few players 
// and goes through a few turns
// ========================================

// Imports

public class driver_nogui
{
    
    static int NUM_PLAYERS;
    static int NUM_ROUNDS;
    static int NUM_TURNS;

   public static void main(String[] args) 
   {
	System.out.print("Main entry point!\n");
        
        NUM_PLAYERS = 1;
        NUM_ROUNDS = 16;
        NUM_TURNS = NUM_PLAYERS*NUM_ROUNDS;
        
        Board test_board = new Board(NUM_PLAYERS);
	for (int i = 0; i < NUM_TURNS; i++)
	{
		test_board.Update();
	}
	System.out.print("Demo finished!\n");
   }
}