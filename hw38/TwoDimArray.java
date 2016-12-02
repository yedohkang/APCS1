// Yedoh Kang
// APCS1 -- pd5
// HW#38 -- Arrays of Arrays
// 2016-12-02

public class TwoDimArray {

	//postcond: prints each row of 2D integer array a on its own line 
	//   		uses a FOR loop
	public static void print1 (int[][] a) { 
		for (int x = 0; x < a.length; x++) {
			for (int h = 0; h < a[0].length; h++){
				System.out.print(a[x][h] + " ");
			}
			System.out.println();
		}
	}

	//postcond: prints each row of 2D integer array a on its own line 
	// 			uses a FOREACH loop
	public static void print2 (int[][] a) { 
		for (int[] row : a) {
			for (int n : row) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}

	//postcond: returns sum of all items in 2D integer array a
	public static int sum1 (int[][] a) { 
		int sum = 0;
		for (int x = 0; x < a.length; x++) {
			for (int h = 0; h < a[0].length; h++){
				sum += a[x][h];
			}
		}
		return sum;
	}

	//postcond: returns sum of all items in 2D integer array a
	//          * uses helper fxn sumRow
	public static int sum2 (int [][] m) { 
		int sum = 0;
		for (int x = 0; x < m.length; x++) {
			sum += sumRow(x,m);
		}
		return sum;
	}

	//postcond: returns sum of all items on row r of 2D integer array 
	//          uses a FOR loop
	public static int sumRow (int r, int[][] a) { 
		int sum = 0;
		for (int x = 0; x < a[r].length; x++) {
			sum += a[r][x];
		}
		return sum;
	}

	//postcond: returns sum of all items on row r of 2D integer array 
	//          uses a FOREACH loop
	public static int sumRow2 (int r, int[][] m) { 
		int sum = 0;
		for (int n : m[r]) {
			sum += n;
		}
		return sum;
	}

	//postcond: returns sum of all items in column c of 2D integer array 
	public static int sumCol (int c, int[][] m) { 
		int sum = 0;
		for (int x = 0; x < m.length; x ++) {
			sum += m[x][c];
		}
		return sum;
	}

	public static void main (String [] args) {
			int [][] m1 = new int[4][2];
			int [][] m2 = { {2,4,6}, {3,5,7} };
			int [][] m3 = { {2}, {4,6}, {1,3,5} };
			print1(m1); // 0 0 | 0 0 | 0 0 | 0 0
			print1(m2); // 2 4 6 | 3 5 7
			print1(m3); // 2 | 4 | 1
			print2(m1); // 0 0 | 0 0 | 0 0 | 0 0
			print2(m2); // 2 4 6 | 3 5 7
			print2(m3); // 2 | 4 6 | 1 3 5
			System.out.print("testing sum1...\n");
			System.out.println("sum m1 : " + sum1(m1)); // 0
			System.out.println("sum m2 : " + sum1(m2)); // 27
			System.out.println("sum m3 : " + sum1(m3)); // 7
			System.out.print("testing sum2...\n");
			System.out.println("sum m1 : " + sum2(m1)); // 0 
			System.out.println("sum m2 : " + sum2(m2)); // 27
			System.out.println("sum m3 : " + sum2(m3)); // 21
	}
}//end class TwoDimArray