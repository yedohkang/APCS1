// Yedoh Kang
// APCS1 -- pd5
// HW#18 -- Loopy
// 2016-10-18

public class Driver {

	// until x heads have come up
	public static String numofheads (int x) {
		// new objects of the class Coin
		Coin yours = new Coin ("quarter");
		Coin wayne = new Coin ("dollar", "heads");
		//tracker
		int i = 0;
		// headsCtr for yours
		int headsCountyours = 0;
		// headsCtr for wayne
		int headsCountwayne = 0;
		// while statement, keep on doing it until i is = to x
		while (i < x) {
			// flip!
			yours.flip();
			wayne.flip();
			if (yours.upFace == "heads") {
				headsCountyours += 1; // update # of matches
				i += 1; // update tracker
			}
			if (wayne.upFace == "heads") {
				headsCountwayne += 1; // update # of matches
				i += 1; // update tracker
			}
		}
		return ("Total # of Heads: " + x + "\n# of heads for Yours: " + headsCountyours + "\n# of heads for Wayne: " + headsCountwayne);
		
	}
	
	// until y matches have come up
	public static String numofmatches (int x) {
		// creates new objects of the class Coin
		Coin yours = new Coin ("quarter");
		Coin wayne = new Coin ("dollar", "heads");
		// tracker
		int i = 0;
		// keep track of how many matches
		int matchCount = 0;
		// keep track of how many flips
		int flipCount = 0;
		// while statement, keep on doing it until i = x
		while (i < x) {
			// flip!
			yours.flip();
			wayne.flip();
			// if upFace of both are equal, then...
			if (yours.equals(wayne)) { 
			    matchCount += 1; // update number of matches
				i += 1; // update tracker
				flipCount += 1; // update number of flips
			}
			// if not equal, then...
			else {
				flipCount += 1; // update number of flips
			}
		}
		return ("# of matches: " + matchCount + "\n# of flips: " + flipCount);
		
	}
	
	// until at least 13 matches & # of matches is divisible by the year of my birth year
	public static String numofsuccess () {
		// creates new objects of the class Coin
		Coin yours = new Coin ("quarter");
		Coin wayne = new Coin ("dollar", "heads");
		// to number the matches
		int matches = 0;
		// to keep track of the matches
		int matchCount = 0;
		// keep track of the flips
		int flipCount = 0;
		// takes into account 13 matches & certain number of flips before the actual one to randomize
		// keep doing it as long as # of matches is less than or = to 13
		while (matches <= 13) {
			// flip!
			yours.flip();
			wayne.flip();
			if (yours.equals(wayne)) { // if upFace is equal...
			    matchCount += 1; // update matchCount
				matches += 1; // update # of matches
				flipCount += 1; // update flips
			}
			else { // if fails...
				flipCount += 1; // update flips
			}
		}
		// second condition - keep on doing this as long as #ofmatches >= 13 AND matches cannot divide 2000 
		while (matches >= 13 && ! (matches % 2000 == 0)) {
			// flip!
			yours.flip();
			wayne.flip();
			if (yours.equals(wayne)) { // if upFaces are equal
			    matchCount += 1; // update matchCount
				matches += 1; // update # of matches
				flipCount += 1; // update # of flips
			}
			else { // if fails...
				flipCount += 1; // update # of flips
			}
		}
		return ("# of matches: " + matchCount + "\n# of flips: " + flipCount);
	}
	
	
	public static void main (String [] args) {
		System.out.println(numofheads(5));
		System.out.println(numofmatches(5));
		System.out.println(numofsuccess());
	}
}