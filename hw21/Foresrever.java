// Yedoh Kang
// APCS1 -- pd5
// HW#21 -- For the Love of Strings
// 2016-10-25

public class Foresrever {
	
	// takes non-negative integer posts, and returns a String representation of a fence
	public static String fenceF (int posts) {
		String reStr = "";
		// initialization: x = 0
		// test: posts > x
		// update: x += 1
		for (int x = 0; posts > x; x += 1) {
			if (x == 0) {
				reStr += "|";
			}
			else {
				reStr += "--|";
			}
		}
		return reStr;	
	}
	
	// takes a non-empty String s and returns s with its letters reversed
	public static String reverseF (String s) {
		String reStr = "";
		// initialization: x = s.length() - 1 (in order to account for the 0)
		// test: x >= 0
		// update: x -= 1 (in order to go backwards)
		for (int x = s.length() - 1; x >= 0; x -= 1) {
			// s.substring(x,x+1) returns ONE specific letter
			reStr += s.substring(x, x+1);
		}
		return reStr;
	}
	
	// takes a non-empty String s and returns s with its letters reversed, but with recursion
	public static String reverseR (String s) {
		String reStr = "";
		// in order to account for the 0
		int x = s.length() - 1;
		// if s.length() is 1
		if (x == 0) {
			reStr = s;
		}
		else {
			// returns ONE specific letter
			reStr += s.substring(x, x+1);
			// updates s so that it's one index smaller
			s = s.substring(0,x);
			// recursive case with new argument
			reStr += reverseR(s);
		}
		return reStr;
	}
	
	public static void main (String [] args) {
		// should be |
		System.out.println(fenceF(1));
		// should be |--|
		System.out.println(fenceF(2));
		// should be |--|--|
		System.out.println(fenceF(3));
		// should be stressed
		System.out.println(reverseF("desserts"));
		// should be hodey
		System.out.println(reverseF("yedoh"));
		// should be stressed
		System.out.println(reverseR("desserts"));
		// should be hodey
		System.out.println(reverseR("yedoh"));
	}
}