// Yedoh Kang
// APCS1 -- pd5
// HW#14 -- stAtistically sPeaking
// 2016-10-07

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
	// returns the geometric mean (square root of the product) of two integers
	public static int geoMean (int a, int b) {
		return (int) Math.sqrt(a * b);
	}
	// returns the geometric mean (square root of the product) of two doubles
	public static double geoMean (double a, double b) {
		return Math.sqrt(a * b);
	}
	public static void main (String [] args) {
		// should return 3
		System.out.println(Stats.mean(2,4));
		// should return 3.5
		System.out.println(Stats.mean(2.5,4.5));
		// should return 4
		System.out.println(Stats.max(2,4));
		// should return 4.5
		System.out.println(Stats.max(-2.5,4.5));
		// should return 6
		System.out.println(Stats.geoMean(6,6));
		// should return 1.5
		System.out.println(Stats.geoMean(1.5,1.5));
		
	}
}
	
	
