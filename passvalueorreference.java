public class passvalueorreference {
	
    public static void main (String[] args) {
		
		//int(primitive)
		int a = 2;
		System.out.println(intfxn(a));// 3
		//if it's 3, pass-by-reference
		//if it's 2, pass-by value
		System.out.println(a);// 2

		//array
		int[] b = {0,0,0};
		System.out.println(array2String(intArrfxn(b)));//23 0 0
		//if 23 0 0, pass by reference
		//if 0 0 0, pass by value
		System.out.println(array2String(b)); //23 0 0

		//string
		String c = "cats";
		System.out.println(stringfxn(c));//catsdogs
		//if catsdogs pass by reference
		//if cats pass by value
		System.out.println(c);//cats
	}
	
    //changes int value
    public static int intfxn (int a) {
		a += 1;
		return a;
    }

    //changes array value
    public static int[] intArrfxn (int[] b) {
		b[0] = 23;
		return b;
    }
	
    //changes array to a string
    public static String array2String(int[] b){
		String retString = "";
		for (int num: b){
	    	retString = retString + num + " ";
		}
		return retString;
    }
	
    //changes string
    public static String stringfxn (String c) {
		c += "dogs";
		return c;
    }
}