// Yedoh Kang, Jake Zaia
// APCS1 -- pd5
// HW#20 -- GCD Three Ways
// 2016-10-20

public class Stats {
	
	// returns the integer value of the mean of the two numbers
	public static int mean (int a, int b) {
		return ((a + b) / 2);
	}
	
	// returns the double value of the mean of the two numbers
	public static double mean (double a, double b) {
		return ((a + b) / 2);
	}
	
	// returns the greater number of the two numbers
	public static int max (int a, int b) {
		if (a < b) {
			return b;
		}
		else {
			return a;
		}
	}
	
	// returns the greater number of the two numbers but accepts doubles
	public static double max (double a, double b) {
		if (a < b) {
			return b;
		}
		else {
			return a;
		}	
	}
	
	// returns the greater number of the three numbers
	public static int max (int a, int b, int c) {
		if (a > b && a > c) {
			return a;
		}
		else if (b > c) {
			return b;
		}
		else {
			return c;
		}
	}
	
	// returns the greater number of the three numbers but accepts doubles
	public static double max (double a, double b, double c) {
		if (a > b && a > c) {
			return a;
		}
		else if (b > c) {
			return b;
		}
		else {
			return c;
		}
	}
	
	// returns the geometric mean (square root of the product) of two integers
	public static int geoMean (int a, int b) {
		return (int) Math.sqrt(a * b);
	}
	
	// returns the geometric mean (square root of the product) of two doubles
	public static double geoMean (double a, double b) {
		return Math.sqrt(a * b);
	}

	// returns the geometric mean (third root of the product) of three integers
	public static int geoMean (int a, int b, int c) {
		return (int) Math.pow((a * b * c), (1.0/3));
	}
	
	// returns the geometric mean (third root of the product) of three doubles
	public static double geoMean (double a, double b, double c) {
		return Math.pow((a * b * c), (1.0/3));
	}
	
	// returns the greatest common factor of two integers
	public static int gcd (int a, int b) {
		// tracker
		int count = 1;
		// current GCD
		int currGCD = 1;
		if (b < a) {
	   		gcd(b,a); // switch a and b and rerun the method
		}
       	while (count < a) {
	    	if (a % count == 0 && b % count == 0) {
				// when a and b are both divisible by the count, then update current GCD
				currGCD = count;
	    	}
			// update count!
	   	 	count += 1;
		}
		return currGCD;
    }
	
	/* --------
		Euclid’s Algorithm
			- if the smaller number is 0, return the larger
			- if the bigger number is divisible by the smaller number, then return the smaller number
			- if it isn’t divisible, then keep on subtracting the smaller number from the larger number until one number becomes 0, which then it becomes the GCD and is therefore returned
		--------- */

	// returns the greatest common factor of two integers using Euclid's algorithm recursively
    public static int gcdER (int a, int b) {
		if (b < a) {
			// switch a and b and rerun the method
	    	return gcdER(b,a);
		}
		if (a == 0) {
			// if a is equal to 0, then return b
	   		return b;
		}
		else {
	   		if (b % a == 0) {
				// if remainder when b / a is 0, then return a
				return a;
	    	}
			// rerun the method recursively until a (b-a) becomes 0
	    	return gcdER((b - a), a);
		}
    }
	
	// returns the greatest common factor of two integers using Euclid's algorithm with a while loop
	public static int gcdEW (int a, int b) {
		if (b < a) {
			// flip b and a so that this condition turns false
			return gcdEW (b, a);
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
				int c = b - a;
				// set a equal to b
				b = a;
				// set c equal to a
				a = c;
			}
		}
		// not an actual answer --> only there so that the class can compile w/o
		return -1;
	}

	public static void main (String [] args) {
		// should return 3
		System.out.println(Stats.mean(3,4));
		// should return 3.5
		System.out.println(Stats.mean(2.5,4.5));
		// should return 4
		System.out.println(Stats.max(2,4));
		// should return 4.5
		System.out.println(Stats.max(-2.5,4.5));
		// should return 6
		System.out.println(Stats.max(-2,4,6));
		// should return 6.78
		System.out.println(Stats.max(-2.5,4.5, 6.78));
		// should return 6
		System.out.println(Stats.geoMean(6,6));
		// should return 1.5
		System.out.println(Stats.geoMean(1.5,1.5));
		// should return 1
		System.out.println(Stats.geoMean(1,2,4));
		// should return 2.99
		System.out.println(Stats.geoMean(3.0,3.0,3.0));
		// should return 5
		System.out.println(Stats.gcd(15,20)); 
		// should return 5
		System.out.println(Stats.gcd(20,15)); 
		// should return 5
		System.out.println(Stats.gcdER(15,20));
		// should return 5
		System.out.println(Stats.gcdER(20,15)); 
		// should return 5
		System.out.println(gcdEW(15,20));
		// should return 5
		System.out.println(gcdEW(20,15));
	}
}
	
	