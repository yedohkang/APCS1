public class twoDArrays {

	public static void populate (int[][] arr) {
		int num = 0;
		for (int x = 0; x < arr.length; x++) {
			for (int h = 0; h < arr[0].length; h++){
				arr[x][h] = num;
				num += 1;
			}
		}
	}
	public static void view (int[][] arr) {
		for (int x = 0; x < arr.length; x++) {
			for (int h = 0; h < arr[0].length; h++){
				System.out.print(arr[x][h] + " ");
			}
			System.out.print("\n");
		}
	}

	public static void main (String [] args) {
		int[][] a2 = new int[4][5];
		populate(a2);
		view(a2);
	}
}