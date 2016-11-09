// Yedoh Kang
// APCS1 -- pd5
// HW#24 -- Otnay Ybay ethay Airhay Onway Ymay Inneechay Inchay Inchay
// 2016-10-31

// class Pig, a Pig Latin translator

/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
           9
     ,--.-'-,--.
     \  /-~-\  /
    / )' a a `( \
   ( (  ,---.  ) )
    \ `(_o_o_)' /
     \   `-'   /
      | |---| |     
      [_]   [_]
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

public class Pig {

    private static final String VOWELS = "aeiou";

    /*=====================================
      boolean hasA(String,String) -- checks for a letter in a String
      pre:  w != null, letter.length() == 1
      post: hasA("cat", "a") → true  
      hasA("cat", "p") → false
      =====================================*/
    public static boolean hasA (String w, String letter) {
		if (w.indexOf(letter) != -1) {
			return true;
		}
		else {
			return false;
		}
    }

    /*=====================================
      boolean isAVowel(String) -- tells whether a letter is a vowel
      precondition: letter.length() == 1
      =====================================*/
    public static boolean isAVowel (String letter) {
		if (VOWELS.indexOf(letter) == -1) {
			return false;
		}
		else {
			return true;
		}
    }

    /*=====================================
      int countVowels(String) -- counts vowels in a String
      pre:  w != null
      post: countVowels("meatball") → 3
      =====================================*/
    public static int countVowels (String w) {
		int count = 0;
		for (int x = 0; x < w.length(); x++) {
			if (isAVowel(w.substring(x,x+1)) == true) {
				count += 1;
			}
		}
		return count;
    }

    /*=====================================
      boolean hasAVowel(String) -- tells whether a String has a vowel
      pre:  w != null
      post: hasAVowel("cat") → true
      hasAVowel("zzz") → false
      =====================================*/
    public static boolean hasAVowel (String w) {
		if (countVowels(w) > 0) {
			return true;
		}
		else {
			return false;
		}
    }

    /*=====================================
      String allVowels(String) -- returns vowels in a String
      pre:  w != null
      post: allVowels("meatball") → "eaa"
      =====================================*/
    public static String allVowels (String w) {
		String reStr = "";
		if (hasAVowel(w) == true) {
			for (int x = 0; x < w.length(); x++) {
				if (isAVowel(w.substring(x,x+1)) == true) {
					reStr += w.substring(x,x+1);
				}
				else {
					reStr += "";
				}
			}
		}
		return reStr;
    }

    /*=====================================
      String firstVowel(String) -- returns first vowel in a String
      pre:  w != null
      post: firstVowel("zzz") --> ""
      firstVowel("meatball") --> "e"
      =====================================*/
    public static String firstVowel (String w) {
		String reStr = "";
		int x = 0;
		if (hasAVowel(w) == false) {
			return reStr;
		}
		else {
			while (isAVowel(w.substring(x,x+1)) == false) {
				x += 1;
			}
			reStr += w.substring(x,x+1);
		}
		return reStr;
    }

    /*=====================================
      boolean beginsWithVowel(String) -- tells whether a String begins with a vowel
      pre:  w != null and w.length() > 0
      post: beginsWithVowel("apple")  --> true
      beginsWithVowel("strong") --> false
      =====================================*/
    public static boolean beginsWithVowel (String w) {
		if (isAVowel(w.substring(0,1))) {
			return true;
		}
		else {
			return false;
		}
    }

    /*=====================================
      String engToPig(String) -- converts an English word to Pig Latin
      pre:  w.length() > 0
      post: engToPig("apple")  --> "appleway"
      engToPig("strong") --> "ongstray"
      engToPig("java")   --> "avajay"
      =====================================*/	
    public static String engToPig (String w) {
		String reStr = "";
		String rest = "";
		int x = 0;
		if (beginsWithVowel(w)) {
			reStr += w + "way";
		}
		else {
			x = w.indexOf(firstVowel(w));
			reStr += w.substring(x) + w.substring(0,x) + "ay";	
		}
		return reStr;
    }

    public static void main (String[] args) {
		
		System.out.println("hasA");
		// should return true
		System.out.println("hello,e: " + hasA("hello", "e"));
		// should return false
		System.out.println("hello,p: " + hasA("hello", "p"));
		
		System.out.println("isAVowel");
		// should return true
		System.out.println("i: " + isAVowel("i"));
		// should return false
		System.out.println("p: " + isAVowel("p"));
		
		System.out.println("countVowels");
		// should return 2
		System.out.println("hello: " + countVowels("hello"));
		// should return 5
		System.out.println("aeious: " + countVowels("aeiou"));
		// should return 0
		System.out.println("nnn: " + countVowels("nnn"));
		
		System.out.println("hasAVowel");
		// should return true
		System.out.println("hello: " + hasAVowel("hello"));
		// should return false
		System.out.println("nnn: " + hasAVowel("nnn"));
		
		System.out.println("allVowels");
		// should return ae
		System.out.println("apple: " + allVowels("apple"));
		// should return oe
		System.out.println("power: " + allVowels("power"));
		
		System.out.println("firstVowel");
		// should return a
		System.out.println("apple: " + allVowels("apple"));
		// should return o
		System.out.println("power: " + allVowels("power"));
		
		System.out.println("beginsWithVowel");
		// should return true
		System.out.println("apple: " + beginsWithVowel("apple"));
		// should return false
		System.out.println("power: " + beginsWithVowel("power"));
		
		System.out.println("engToPig");
		// should return appleway
		System.out.println("apple: " + engToPig("apple"));
		// should return ongstray
		System.out.println("strong: " + engToPig("strong"));
	
    }

}

