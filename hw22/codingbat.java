public class codingbat {
	
	public static String doubleChar (String str) {
		String reStr = "";
		for (int x = 0; x < str.length(); x +=1) {
			reStr += str.substring(x,x+1) + str.substring(x,x+1);
		}
		return reStr;
	}
	
	public static int countHi (String str) {
		int count = 0;
		for (int x = 0; x < str.length() - 1; x += 1) {
			if (str.substring(x,x+2).equals("hi")) {
				count += 1;
			}
		}
		return count;
	} 
	
	public static boolean catDog (String str) {
		int cat = 0;
		int dog = 0;
		for (int x = 0; x < str.length() - 2; x += 1) {
			if (str.substring(x,x+3).equals("cat")) {
				cat += 1;
			}
			if (str.substring(x,x+3).equals("dog")) {
				dog += 1;
			}
		}
		if (cat == dog) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static int countCode (String str) {
	    int count = 0;
	    for (int x = 0; x < str.length() - 3; x += 1) {
			if (str.substring(x, x + 2).equals("co") && 
					(str.substring(x + 3, x + 4)).equals("e")) {
	        			count += 1; 
			}
	    }
	    return count;  
	}
	
	public static boolean endOther (String a, String b) {
		a = a.toLowerCase();
		b = b.toLowerCase();
		int counta = a.length();
		int countb = b.length();
		if (counta < countb) {
			if (b.substring(countb-counta).equals(a)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			if (a.substring(counta-countb).equals(b)) {
				return true;
			}
			else {
				return false;
			}
		}
		
	}
	
	public static boolean xyzThere (String str) {
		if (str.length() >= 3 && str.substring(0,3).equals("xyz")) {
			return true;
		}
		for (int x = 1; x < str.length() - 2; x += 1) {
			if (str.substring(x,x+3).equals("xyz") && !str.substring(x-1,x).equals(".")) {
				return true;
			}
		}
		return false;
	}	
	
	public static void main (String [] args) {
		System.out.println(doubleChar("yedoh"));
		System.out.println(countHi("hihi hi"));
		System.out.println(catDog("catdogdog"));
		System.out.println(countCode("codecopecore"));
		System.out.println(endOther("abcshihello","hihello"));
		System.out.println(xyzThere("abcxyz"));
	}
	
	
}