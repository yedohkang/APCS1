public class ArrayUtilObject {
	
	String m = "";
	
	public ArrayUtilObject (String s){
		m = s;	
	}
	
	public static void populateArray (Object[] arr) {
		for (int i = 0; arr.length > i; i++) {
			ArrayUtilObject z = new ArrayUtilObject("hello");
			Object y = z;
			arr[i] = y;
		}
	}
	
	public String toString() {
		return m;
	}
	
	public static String arrToStr (Object[] arr) {
		String reStr = "";
		for (Object x : arr) {
			reStr += x + "\n";
		}
		return reStr;
	}

	public static void main (String[] args) {
		Object[] arr;
		arr = new Object[5];
		populateArray(arr);
		System.out.println(arrToStr(arr));
	}
	
}