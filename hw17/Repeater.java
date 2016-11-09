// Yedoh Kang with Tiffany Moi
// APCS1 -- pd5
// HW#17 -- Do I repeat myself? Very well, then I repeat myself
// 2016-10-17

public class Repeater {

	// a method that uses while! ex: 1, |; 2, |â€”-|
	public static String fenceW (int posts) {
		// tracker
		int i = 0;
		// to return concatenated string
		String reStr = "";
		// as long as the number of posts is greater than 1...
		while (posts > i) {
			// if the tracker is = 0
			if (i == 0) {
				// reStr is updated
				reStr += "|";
				// tracker is updated
				i += 1;
	    	}
			// if tracker is not 0 (if it's greater than or equal to 1)
	   		else {
				// update reStr
				reStr += "--|";
				// update tracker
				i += 1;
	    	}
		}
		return reStr;
    }

	// a method that uses recursion! ex: 1, |; 2, |â€”-|
	public static String fenceR (int posts) {
		// to keep track
		int p = posts;
		// to return the concatenated string as a result
		String reStr = "";
		// base case
		if (p == 1) {
	    	reStr = "|";
		}
		// recursive case
		else {
	    	reStr = "|--";
	    	reStr += fenceR(p -1);
		}
		return reStr;
    	}
		
	// main method that tests both methods	
	public static void main (String [] args) {
		// should be |
		System.out.println(fenceW(1));
		// should be |--|--|
		System.out.println(fenceW(2));
		// should be |--|--|--|
		System.out.println(fenceW(3));
		// should be |
		System.out.println(fenceR(1));
		// should be |--|--|
		System.out.println(fenceR(2));
		// should be |--|--|--|
		System.out.println(fenceR(3));
    	}
}