// Yedoh Kang
// APCS1 -- pd5
// HW#54 -- Never Fear, Big O Is Here!
// 2017-01-04

/*=====
A public class with public methods of bubbleSort, insertionSort, and 
	selectionSort, each with a single int array parameter.
=====*/

public class MySorts {

	/*=====
		Description:
			Starts at one end, traverses through the list, comparing and swapping with its
				adjacent values. Repeats if necessary.
		Execution Time:
			the number of comparisons is (n-1)^2, which is a quadratic, where n is the number
				of elements in the data set.
			ex. if the size is small, like 5, it will be fast, b/c it takes 16 comparisons
				if the size is large, like 100, it will be slower, and in fact, it is the
					slowest method, b/c it takes 9801 comparisons
		=====*/
	public static void bubbleSortV (int[] data) {
		// number of passes left
		int passLeft = data.length - 1;
		int size = data.length;
		while (passLeft > 0) { // as long as number of passes is not 0
			passLeft -= 1; // decrement (counting down)
			for (int i = size - 1; i > 0; i--) { // right to left
				if (data[i] < data[i-1]) {
					// swap
					int tempRight = data[i];
					data[i] = data[i-1];
					data[i-1] = tempRight;
				}
			}
		}
	}
		
	/*=====
		Description:
			Starts with a sorted partition of size 1. 1 value at a time is inserted
				into the sorted region, by comparing and swapping the adjacent values. 
				Repeats until sorted.
		Execution Time:
			if the dataset is already sorted, it will take n-1 comparisons. if it is not, it
				varies, but the maximum is 2n comparisons. either way, it varies directly with
				the number of elements in the dataset, being not too fast and not too slow.
			ex. if the list is sorted and has 5 elements, it will only take 4 comparisons.
				if the list is unsorted and has 5 elements, it will take max 10 comparisons.
				if the list is sorted and has 100 elements, it will only take 99 comparisons,
					which is slower.
				if the list is unsorted and has 100 elements, it will only take max 200
					comparisons, which is much slower.

		=====*/
	public static void insertionSortV (int[] data) {
		for (int partition = 1; partition < data.length; partition++) {
			for (int i = partition; i > 0; i--) {
				// if adjacent(left) value is greater than the right-adjacent value
				if (data[i] < data[i-1]) {
					// SWAP!
					int temp = data[i];
					data[i] = data[i-1];
					data[i-1] = temp;
				}
			}
		}
		
	}
	
	/*=====
		Description:
			Finds the smallest element, and is swapped with the value at the end. The next
				smallest is selected, and is swapped with the next-to-end. Repeats until sorted.
		Execution Time:
			Varies directly with the size of the dataset (n-1)
			ex. if the size is small, like 5, it will be fast bc it takes 4 comparisons
				if the size is large, like 100, it will be slower b/c it takes 99 comparisons
		=====*/
	public static void selectionSortV (int[] data) {
			//note: this version places greatest value at rightmost end,
			//maxPos will point to position of SELECTION (greatest value)
			int maxPos;
			for (int x = data.length - 1; x > 0; x--) {
				maxPos = 0; // initialize maxPos
				for (int i = x; i > 0; i--) { // R --> L, finds the maxPos
					if (data[maxPos] < data[i]) {
						maxPos = i; // reset if another value is greater
					}
				} 
				// swap
				int temp = data[x];
				data[x] = data[maxPos];
				data[maxPos] = temp;
			}
	}		
}

