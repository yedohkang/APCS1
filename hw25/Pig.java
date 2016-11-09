//Team Yip Yip -- Yedoh Kang (Angela Kim + Tiffany Moi)
//APCS1 pd5
//HW25 -- ?_?_?/Scanners!
//2016-11-01

import java.util.Scanner;

public class Pig {
  
    private static final String VOWELS = "aeiou";
    private static final String PUNC = ".,?!:;";

    /*=====================================
      boolean hasA(String,String) -- checks for a letter in a String
      pre:  w != null, letter.length() == 1
      post: hasA("cat", "a") --> true  
      hasA("cat", "p") --> false
      =====================================*/
    public static boolean hasA (String w, String letter) {
		String l=letter.toLowerCase(); // not case sensitive
		String t=w.toLowerCase();
        	return t.indexOf(l) != -1;
    }

    /*=====================================
      boolean isAVowel(String) -- tells whether a letter is a vowel
      precondition: letter.length() == 1
      =====================================*/
    public static boolean isAVowel (String letter) {
		return hasA(VOWELS, letter);
    }

    /*=====================================
      int countVowels(String) -- counts vowels in a String
      pre:  w != null
      post: countVowels("meatball") --> 3
      =====================================*/
    public static int countVowels (String w) {
		int count=0;
		for (int i=0; i < w.length(); i+=1){
	    	String s= w.substring(i,i+1);
	    	if (isAVowel(s)){
				count+=1;
	    	}
		}
		return count;
    }

    /*=====================================
      boolean hasAVowel(String) -- tells whether a String has a vowel
      pre:  w != null
      post: hasAVowel("cat") --> true
      hasAVowel("zzz") --> false
      =====================================*/
    public static boolean hasAVowel (String w) {
		return countVowels(w)!=0;
    }

    /*=====================================
      String allVowels(String) -- returns vowels in a String
      pre:  w != null
      post: allVowels("meatball") --> "eaa"
      =====================================*/
    public static String allVowels (String w) {
		String retStr = "";
		String first = w.substring(0,1);
		if (!(hasAVowel(w))) {
	    	return retStr;
		}
		else {
	    	for (int i=0; i < w.length(); i+=1) {
				String s= w.substring(i,i+1);
				if (isAVowel(s)) {
		    		retStr += s;
				}
	    	}
		}
		if (first.equals(first.toUpperCase()) && (isAVowel(first))) {
	    	retStr = retStr.substring(0, 1).toUpperCase() + retStr.substring(1);
		}
		return retStr;
    }

    /*=====================================
      String firstVowel(String) -- returns first vowel in a String
      pre:  w != null
      post: firstVowel("") --> ""
      firstVowel("zzz") --> ""
      firstVowel("meatball") --> "e"
      =====================================*/
    public static String firstVowel (String w) {
		String s = allVowels(w);
		if (s.equals("")) {
	    	return s;
		}
		return s.substring(0,1);
    }

    /*=====================================
      boolean beginsWithVowel(String) -- tells whether a String begins with a vowel
      pre:  w != null and w.length() > 0
      post: beginsWithVowel("apple")  --> true
      beginsWithVowel("strong") --> false
      =====================================*/
    public static boolean beginsWithVowel (String w) {
        String s = w.substring(0,1);
		return isAVowel(s);
    }
    
    /*=====================================
      boolean isAPunc(String) -- checks if a character is punctuation
      pre:  w.length() = 1
      post: isAPunc("c") --> false
      isAPunc(".") --> true
      isAPunc("!") --> true
      =====================================*/
    public static boolean isAPunc (String p) {
		return hasA(PUNC, p);
    }
	
    /*=====================================
      String engToPig(String) -- converts an English word to Pig Latin
      pre:  w.length() > 0
      post: engToPig("apple")  --> "appleway"
      engToPig("strong") --> "ongstray"
      engToPig("java")   --> "avajay"
      =====================================*/
    public static String engToPig (String w) {
		String retStr = "";
		String n = w.toLowerCase();
		int len = n.length();
		String p = "";
		String first = w.substring(0, 1);
		//checks is punctuation is given
		if (isAPunc(n.substring(len-1,len))){
	   		p = n.substring(len-1,len);
	    	n = n.substring(0,len-1);
		}
		//does it start with a vowel?
       	if (beginsWithVowel(n)) {
	    	retStr += n.substring(0,1) + n.substring(1) + "way"; 
		}
		else {
	    	int t = countVowels(n);
	   	 	int x;
	    	//are there any vowels? If none, count ys as vowels
	   	 	if (t == 0) {
				x = n.indexOf("y");
	    	}
	    	//there are vowels
	    	else {
				x = n.indexOf(firstVowel(n));
	    	}
	    	retStr += n.substring(x,x+1) + n.substring(x+1);
	    	retStr += n.substring(0,x) + "ay"; 
	    }
		if (first.equals(first.toUpperCase())) {
	    	retStr = retStr.substring(0, 1).toUpperCase() + retStr.substring(1);
		}
		return retStr + p; // add punctuation at the end
    }
 
    public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		while (sc.hasNext()){
	    	System.out.println(engToPig(sc.next()));
		}
    }
}


