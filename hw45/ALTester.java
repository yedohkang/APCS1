// Yedoh Kang
// APCS1 -- pd5
// HW#45 -- Al<B> Sorted!
// 2016-12-14

import java.util.ArrayList;

public class ALTester  {
	
	// instance variable
	private ArrayList<Integer> _data;
	
	// constructor
	public ALTester () {
		_data = new ArrayList<Integer>();
	}

	// checks to see if the ArrayList contains integers in ascending order
	public static boolean sorted (ArrayList<Integer> a) {
		for (int i = 1; i < a.size(); i++) {
			if (a.get(i-1) > a.get(i)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main (String[] args) {
		
		// new object called test
		ArrayList<Integer> test = new ArrayList<Integer>();
		
		// add 23 integers, each as elements to test
		for (int i = 0; i < 23; i++) {
			test.add(i);
		}
		
		// print it out
		System.out.println(test);
		
		// check to see if sorted
		if (sorted(test) == true) {
			System.out.println("ArrayList is in order.");
		}
		else {
			System.out.println("ArrayList is not in order.");
		}
	}
}