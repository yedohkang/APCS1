// Yedoh Kang
// APCS1 -- pd5
// HW#39 -- Put it together
// 2016-12-05

/*==============
To randomly create words and place them into each element of the 2D array,
I used a forach loop. At each element, each letter of the three letter word 
was randomly chosen using an array of 26 elements (each letter of the alphabet).
They were then added together and repeated, to create unique words for each element.
After displaying the newly created 2D array in the terminal, the user can then input
two integers. Each word at that index of the 2D Array is saved, then swapped with 
each other. Finally, the swapped array is displayed.

=========*/

import cs1.Keyboard;

public class Swapper {
	
	// creates a new 2D array of 1 row and 6 columns
	private static String[][] a = new String[1][6];
	// a String array of 26 elements, with each letter of the alphabet as one element
	private static final String[] ALPHABET = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
	
	// overridden constructor; doesn't do anything
	public Swapper () {
	}
	
	// generates unique 3-letter words and places them into the 2D array
	public void generate () {
		for (int x = 0; x < a.length; x++) {
			for (int h = 0; h < a[x].length; h++) {
				a[x][h] = ALPHABET[(int) (Math.random() * 26 - 1)] + ALPHABET[(int) (Math.random() * 26 - 1)] + ALPHABET[(int) (Math.random() * 26 - 1)]; 
			}
		}
	}
	
	// swaps the two places of the 2D array, given user's preference
	public void swap (int one, int two) {
		String word1 = a[0][one];
		String word2 = a[0][two];
		a[0][one] = word2;
		a[0][two] = word1;
	}
	
	public static void main (String[] args) {
		
		Swapper test = new Swapper();
		
		// generate new array!
		test.generate();
		
		// prints out the 2D array, column by column
		System.out.println("List of words: \n");
		for (int x = 0; x < a.length; x++) {
			for (int h = 0; h < a[x].length; h++) {
				System.out.println("" + h + ": " + a[x][h] + "\n");
			}
		}
		
		// enter in first integer
		System.out.println("Please enter in the place you want to swap: ");
		int int1 = Keyboard.readInt();
		
		// enter in second integer
		System.out.println("Please enter in the other place you want to swap with: ");
		int int2 = Keyboard.readInt();
		
		// swap!
		test.swap(int1, int2);
		
		// prints out the newly created 2D array, column by column
		System.out.println("New list of words: \n");
		for (int x = 0; x < a.length; x++) {
			for (int h = 0; h < a[x].length; h++) {
				System.out.println("" + h + ": " + a[x][h] + "\n");
			}
		}
	}	
}