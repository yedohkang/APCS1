// Yedoh Kang
// APCS1 -- pd5
// HW#47 -- Keep Guessing
// 2016-12-19

import cs1.Keyboard;

public class GuessNumber {
	
	private static int numGuess; // number of guesses
	private static int number; // chosen number by program
	private static int guess; // guess by user
	private static int lowerBound = 1; // lower range
	private static int upperBound = 100; // upper range
	
	// choose random number, [1,100]
	public static void choose () {
		number = (int) (Math.random() * 100);
	}
	
	public static void main (String[] args) {
		
		choose();
		
		System.out.println("Hi! Let's play the guessing game!\n");
		
		// first attempt
		System.out.print("Guess a number from 1-100: ");
		
		guess = Keyboard.readInt(); // reads user's input
		numGuess += 1; // updates guess number
		
		if (guess == number) {
			
			System.out.println("Correct! It took 1 guess.");
			
		} 
		
		else {
			
			while (guess != number) {
				
				if (guess < number) {
					
					lowerBound = guess + 1; // lowerBound is updated (one more than the guess)
					
					System.out.println("Too low, try again...\n");
					System.out.print("Guess a number from " + lowerBound + "-" + upperBound + ": ");
		
					guess = Keyboard.readInt();
					numGuess += 1;
				}
				
				else {
				
					upperBound = guess - 1; // upperBound is updated (one less than the guess)
					
					System.out.println("Too high, try again...\n");
					System.out.print("Guess a number from " + lowerBound + "-" + upperBound + ": ");
		
					guess = Keyboard.readInt();
					numGuess += 1; // updates guess number
				}
			}
			
			System.out.println("Correct! It took " + numGuess + " guesses.");
		}	
	}
	
}