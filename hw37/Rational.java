// Yedoh Kang
// APCS1 -- pd5
// HW#37 -- Be More Rational
// 2016-12-01

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

	// takes 1 Rational object and adds it to the current rational number object
	public void add (Rational rational) {
		int numerator = rational.p;
		int denominator = rational.q;
		p = (p * denominator) + (q * numerator);
		q = (q * denominator);
	}

	// takes 1 Rational object and substracts it from  the current rational number object
	public void subtract (Rational rational) {
		int numerator = rational.p;
		int denominator = rational.q;
		p = (p * denominator) - (q * numerator);
		q = (q * denominator);
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

	// returns gcd of the numerator and denominator
	public int gcd () {
		int a = p;
		int b = q;
		if (b < a) {
			// flip b and a so that this condition turns false
			a = q;
			b = p;
		}
		if (a == 0) {
			// if a is 0, then return the larger number
			return b;
		}
		// while a is not 0 AND b is not 0
		while (a != 0 && b != 0) {
			if (b % a == 0) {
				// if b is divisible by a, then return a
				return a;
			}
			else {
				// create int c which will be the subtraction
				int c = Math.abs(b - a);
				// set a equal to b
				b = a;
				// set c equal to a
				a = c;
			}
		}
		// not an actual answer --> only there so that the class can compile w/o
		return -1;
	}  

	public void reduce () {
		int number = gcd();
		p = p / number;
		q = q / number;
	}
	
	// returns gcd of the numerator and denominator
	public static int gcd (int r, int s) {
		int a = r;
		int b = s;
		if (b < a) {
			// flip b and a so that this condition turns false
			a = r;
			b = s;
		}
		if (a == 0) {
			// if a is 0, then return the larger number
			return b;
		}
		// while a is not 0 AND b is not 0
		while (a != 0 && b != 0) {
			if (b % a == 0) {
				// if b is divisible by a, then return a
				return a;
			}
			else {
				// create int c which will be the subtraction
				int c = Math.abs(b - a);
				// set a equal to b
				b = a;
				// set c equal to a
				a = c;
			}
		}
		// not an actual answer --> only there so that the class can compile w/o
		return -1;
	}
	
	// compares Rational object taken in with the calling object  
	public int compareTo (Rational rational) {
		int numerator = rational.p;
		int denominator = rational.q;
		int number1 = p * denominator;
		int number2 = q * numerator;
		if (number1 == number2) {
			return 0;
		}
		else if (number1 > number2) {
			return 1;
		}
		else {
			return -1;
		}
	}

	public static void main (String [] args) {
		Rational r = new Rational(2,3); // Stores the rational number 2/3
		Rational s = new Rational(1,2); // Stores the rational number 1/2
		Rational t = new Rational(4,18); // Stores the rational number 4/18
		Rational u = new Rational(2,9); // Stores the rational number 4/18

		System.out.println("R's floatValue = " + r.floatValue());
		System.out.println("S's floatValue = " + s.floatValue());
		System.out.println("T's floatValue = " + t.floatValue() + "\n");

		System.out.println("Addition");
		r.add(s); // Adds r to s, changes r to 7/6. s remains 1/2
		System.out.println("R is: \n" + r);
		System.out.println("S is: \n" + s + "\n");

		System.out.println("Subtraction");
		r.subtract(s); // Subtracts s from r, changes r to 1/6. s remains 1/2
		System.out.println("R is: \n" + r);
		System.out.println("S is: \n" + s + "\n");
    
		System.out.println("Multiplication");
		r.multiply(s); // Multiplies r by s, changes r to 2/6.  s remains 1/2
		System.out.println("R is: \n" + r);
		System.out.println("S is: \n" + s + "\n");
    
		System.out.println("Division");
		r.divide(s); // Divides r by s, changes r to 2/1.5.  s remains 1/2
		System.out.println("R is: \n" + r);
		System.out.println("S is: \n" + s + "\n");
		
		System.out.println("Reduce");
		t.reduce(); // reduces 4/18 to 2/9
		System.out.println("T is: \n" + t + "\n");
		
		System.out.println("GCD");
		int n = gcd(4,18);
		System.out.println("GCD of 4/18 is: " + n + "\n");
		
		System.out.println("CompareTo");
		// should be 1
		System.out.println("R compared with S is: " + r.compareTo(s));
		// should be -1
		System.out.println("S compared with R is: " + s.compareTo(r));
		// should be 0
		System.out.println("T compared with U is: " + t.compareTo(u));
	}
}