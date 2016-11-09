// Team JYKL (Joelle Lum + Yedoh Kang)
// Yedoh Kang
// APCS1 -- pd5
// HW#23 -- Karmacomma
// 2016-10-27


public class Commafier {

    /*=====================================
      String commafyR(int) -- inserts commas in a number, every 3rd digit,
      recursively.
      precondition:  n is non-negative integer
      postcondition: returns String version of n with commas inserted
      =====================================*/
    public static String commafyR (int n) {
		String numStr = "" + n;
		String newStr = "";
		int x = numStr.length();
		// if number is < 1000
		if (x < 4) {
			newStr += numStr;
		}
		// if argument needs commas
		else {
			newStr += commafyR(Integer.parseInt(numStr.substring(0,x-3))) + "," + numStr.substring(x-3,x);
			x -= 3;
		}
    	return newStr; //placeholder to get past compiler
    }


    /*=====================================
      String commafyF(int) -- inserts commas in a number, every 3rd digit,
      using a FOR Loop.
      precondition:  n is non-negative integer
      postcondition: returns String version of n with commas inserted
      =====================================*/
	public static String commafyF (int n) {
		String numStr = "" + n;
		String newStr = "";
		int x = numStr.length();
		// if argument < 1000
		if (x < 4) {
		    newStr += numStr;
		}
		// if argument needs commas 
		else {
		    for (int i = 0; i < x; i += 1) {
				// if a comma is not needed, such as within the string or at the end
				if (i == x - 1 || numStr.substring(i+1).length() % 3 != 0) {
			    	newStr += numStr.substring(i,i+1);
				}
				//if a comma is needed
				else {
			    	newStr += numStr.substring(i,i+1) + ",";
				}
		    }
		}
		return newStr;
	}


    public static void main (String[] args) { 
		//test calls for development:
		// recursion:
		/* ==========
		System.out.println( "commafyR(1): " + commafyR(1) ); 
		System.out.println( "commafyR(10): " + commafyR(10) ); 
		System.out.println( "commafyR(101): " + commafyR(101) ); 
		System.out.println( "commafyR(1000): " + commafyR(1000) ); 
		System.out.println( "commafyR(12345): " + commafyR(12345) ); 
		System.out.println( "commafyR(1234567890): " + commafyR(1234567890) ); 
 	   	// for loop:
		System.out.println( "commafyF(1): " + commafyF(1) ); 
		System.out.println( "commafyF(10): " + commafyF(10) ); 
		System.out.println( "commafyF(101): " + commafyF(101) ); 
		System.out.println( "commafyF(1000): " + commafyF(1000) ); 
		System.out.println( "commafyF(12345): " + commafyF(12345) ); 
		System.out.println( "commafyF(1234567890): " + commafyF(1234567890) );
		========== */ 	
			 
		//code to handle command line input: 
		// (note, need only work for int CLI...)
		for (String intAsStr : args) {
	    	System.out.println(commafyF(Integer.parseInt(intAsStr)));
		}
		//or
		for (String intAsStr : args) {
	    	System.out.println(commafyR(Integer.parseInt(intAsStr)));
		}
    }
} 