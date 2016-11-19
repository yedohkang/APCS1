// Team DoReMi (Kenny Chen, Lisa Eng, Yedoh Kang)
// Yedoh Kang
// APCS1 -- pd5
// HW#32 -- Ye Olde Role Playing Game, Expanded
// 2016-11-21

/*=============================================
  class YoRPG -- Driver file for Ye Olde Role Playing Game.
  Simulates monster encounters of a wandering adventurer.
  Required classes: Warrior, Monster
  =============================================*/

import java.io.*;
import java.util.*;

public class YoRPG {
	
	// ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

	//change this constant to set number of encounters in a game
	public final static int MAX_ENCOUNTERS = 5;

	//each round, a Warrior, Mage, Cleric or Scavenger, and a Monster will be instantiated...
	private Character pat; // general
	private Warrior warrior;   
	private Cleric cleric;
	private Scavenger scavenger;
	private Mage mage;
	private Rogue rogue;
	private Monster smaug; //Friendly generic monster name?

	private int moveCount;
	private boolean gameOver;
	private int difficulty;

	private InputStreamReader isr;
	private BufferedReader in;
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	// ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~
	
	public YoRPG () {
		
   		moveCount = 0;
    	gameOver = false;
    	isr = new InputStreamReader( System.in );
  	  	in = new BufferedReader( isr );
    	newGame();
	}
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	// ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~
	
	/*=============================================
  	void newGame() -- gathers info to begin a new game
  	pre:  
  	post: according to user input, modifies instance var for difficulty
  	and instantiates a Warrior
  	=============================================*/
	public void newGame () {
		
    	String s;
    	String name = "";
    	s = "~~~ Welcome to Ye Olde RPG! ~~~\n";
		s += "\nChoose your difficulty: \n";
    	s += "\t1: Easy\n";
    	s += "\t2: Not so easy\n";
    	s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
    	s += "Selection: ";
    	System.out.print( s );

		try {
    		difficulty = Integer.parseInt( in.readLine() );
    	}
    	catch ( IOException e ) { }
		s = "Intrepid warrior, what doth thy call thyself? (State your name): ";
   		System.out.print( s );

		try {
    		name = in.readLine();
    	}
    	catch ( IOException e ) { }
		
		// choose your own character!
		int patNumber = 1;
		String y = "";
		y += "Choose your character!\n";
		y += "\t1: Warrior\n";
		y += "\t2: Scavenger\n";
		y += "\t3; Cleric\n";
		y += "\t4: Mage\n";
		y += "\t5: Rogue\n";
		System.out.println(y);
		
		try {
    		patNumber = Integer.parseInt( in.readLine() );
    	}
    	catch ( IOException e ) { }
		
		String classSelection;
		
		// check what class a new instance should be made of
		if (patNumber == 1) {
			warrior = new Warrior (name);
			pat = warrior; // for use throughout the rest of this class
			System.out.println("Selection: Warrior");
		}
		else if (patNumber == 2) {
			scavenger = new Scavenger (name);
			pat = scavenger;
			System.out.println("Selection: Scavenger");
		}
		else if (patNumber == 3) {
			cleric = new Cleric (name);
			pat = cleric;
			System.out.println("Selection: Cleric");
		}
		else if (patNumber == 4) {
			mage = new Mage (name);
			pat = mage;
			System.out.println("Selection: Mage");
		}
		else {
			rogue = new Rogue (name);
			pat = rogue;
			System.out.println("Selection: Rogue");
		}

	}

	/*=============================================
  	boolean playTurn -- simulates a round of combat
  	pre:  Warrior pat has been initialized
  	post: Returns true if player wins (monster dies).
  	Returns false if monster wins (player dies).
  	=============================================*/
	public boolean playTurn () {
		
    	int i = 1;
    	int d1, d2;
		
    	if (Math.random() >= (difficulty / 3.0)) {
    		System.out.println("\nNothing to see here. Move along!");
		}
   	 	else {
    		System.out.println("\nLo, yonder monster approacheth!");

    		smaug = new Monster();

    		while( smaug.isAlive() && pat.isAlive() ) {
				// Give user the option of using a special attack:
   				// If you land a hit, you incur greater damage,
   	 	   	 	// ...but if you get hit, you take more damage.
   	 			try {
   	 				System.out.println("\nDo you feel lucky?");
   	 		  		System.out.println("\t1: Nay.\n\t2: Aye!");
   	 		  		i = Integer.parseInt(in.readLine());
   	 	 		}
   	 			catch (IOException e) {
   	 			}

   	 			if (i == 2) {
 					pat.specialize();  	 		
   	 			}
   	 			else {
   	 				pat.normalize();
   	 			}

   				d1 = pat.attack(smaug);
   	 			d2 = smaug.attack(pat);

   	 			System.out.println("\n" + pat.getName() + " dealt " + d1 + " points of damage.");
   	 			System.out.println( "\n" + "Ye Olde Monster smacked " + pat.getName() + 
					" for " + d2 + " points of damage.");
				System.out.println(pat.about());
    		}//end while

    		//option 1: you & the monster perish
    		if (!smaug.isAlive() && !pat.isAlive()) {
   	 			System.out.println( "'Twas an epic battle, to be sure... " +
   			 		"You cut ye olde monster down, but " + 
						"with its dying breath ye olde monster. " +
   			 				"laid a fatal blow upon thy skull." );
   	 			return false;
    		}
		
    		//option 2: you slay the beast
    		else if (!smaug.isAlive()) {
   	 			System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
   	 	   		return true;
    		}
    	
			//option 3: the beast slays you
    		else if (!pat.isAlive()) {
   	 			System.out.println( "Ye olde self hath expired. You got dead." );
   	 	   		return false;
    		}
    	}//end else

    	return true;
	}//end playTurn()
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public static void main (String[] args) {

    	//loading...
    	YoRPG game = new YoRPG();

    	int encounters = 0;

		while (encounters < MAX_ENCOUNTERS) {
    		if (!game.playTurn()) {
    			break;
    		}
    		encounters++;
    		System.out.println();
    	}

    	System.out.println("Thy game doth be over.");
	}//end main
	
}//end class YoRPG
