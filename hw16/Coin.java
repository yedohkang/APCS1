// Yedoh Kang
// APCS1 -- pd5
// HW#16 -- Wayne's World
// 2016-10-13

public class Coin {
	
	// attributes
	private double value; // monetary worth
	private String upFace; // face currently showed ; "heads" or "tails"
	private String name; // type of coin
	private int flipCtr; // # of times coin has been flipped
	private int headsCtr; // # of times coin lands heads up
	private int tailsCtr; // # of times coin lands tails up
	private double bias; // likelihood of landing heads-up every time (1.0) or tails-up every time (0.0)
	
	// default constructor
	public Coin () {
		value = 0.0;
		upFace = "heads";
		name = "null";
		flipCtr = 0;
		headsCtr = 0;
		tailsCtr = 0;
		bias = 0.5;
	}
	
	// overloaded constructor
	// takes String input to indicate denomination
	public Coin (String denomination) {
		this();
		name = denomination;
	}
	
	// overloaded constructor
	// takes String input to indicate denomination and current face
	public Coin (String denomination, String currentFace) {
		this();
		name = denomination;
		upFace = currentFace;
	}
	
	// simulates a coin flip, updates face
	public String flip () {
		String face;
		if (Math.random() < bias) {
			face = "heads";
			headsCtr += 1;
		}
		else {
			face = "tails";
			tailsCtr += 1;
		}
		upFace = face;
		flipCtr += 1;
		return upFace;	
	}
	
	// returns a coin's denomination and current face
	// overloaded toString()
	public String toString() {
		String result = "";
		result = name + " -- " + upFace;
		return result;
	}
	
	// compares Coin to another
	public boolean equals (Coin object) {
		if (this.upFace == object.upFace) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// assigns a coin's monetary value according to name
	private double assignValue (String s) {
		if (name == "penny") {
			return 0.01;
		}
		else if (name == "nickel") {
			return 0.05;
		}
		else if (name == "dime") {
			return 0.10;
		}
		else if (name == "quarter") {
			return 0.25;
		}
		else {
			return 1.00;
		}
	}
	
}







