// Yedoh Kang
// APCS1 -- pd5
// HW#26 -- I Demand Arrays!
// 2016-11-03

public class ArrayUtils {
	
	public static void populateArray (int[] arr) {
		for (int i = 0; arr.length > i; i++) {
			int y = (int) (Math.random() * 100);
			arr[i] = y;
		}
	}
	
	public static String arrToStr (int[] arr) {
		String reStr = "";
		for (int x : arr) {
			reStr += x + "\n";
		}
		return reStr;
	}
	
	public static void main (String[] args) {
		int[] arr;
		arr = new int[5];
		populateArray(arr);
		System.out.println(arrToStr(arr));
	}
}