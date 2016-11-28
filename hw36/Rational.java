// Yedoh Kang
// APCS1 -- pd5
// HW#36 -- Be Rational
// 2016-11-29

public class Rational {
    
	// instance variables
	private int p;
	private int q;

	// default constructor
	public Rational () {
		p = 0;
		q = 1;
	}
    
	// constructor
	public Rational (int numerator, int denominator) {
		if (denominator == 0) {
			System.out.println("Error: Invalid Denominator; Number set to 0/1");
			p = 0;
			q = 1;
		}
		else {
			p = numerator;
			q = denominator;
		}
	}

	// toString 
	public String toString () {
		String retStr = "";
		retStr += "Numerator: " + p;
		retStr += "\nDenominator: " + q;
		return retStr;
	}
    
	// methods
    
	// returns a floating point value of the number
	public double floatValue () {
		return ((double) p / (double) q);
	}
    
	// takes 1 Rational object and multiplies it by this Rational object
	public void multiply (Rational rational) {
		int numerator = rational.p;
		int denominator = rational.q;
		p = p * numerator;
		q = q * denominator;
	}

	// takes 1 Rational object and divides it by this Rational object
	public void divide (Rational rational) {
		int numerator = rational.p;
		int denominator = rational.q;
		p = p / numerator;
		q = q / denominator;
	}

	public static void main (String [] args) {
		Rational r = new Rational(2,3); // Stores the rational number 2/3
		Rational s = new Rational(1,2); // Stores the rational number 1/2

		System.out.println(r.floatValue());
    
		r.multiply(s); // Multiplies r by s, changes r to 2/6.  s remains 1/2
		System.out.println(r);
		System.out.println(s);

		r.divide(s); // Divides r by s, changes r to 2/3.  s remains 1/2
		System.out.println(r);
		System.out.println(s);
	}
}