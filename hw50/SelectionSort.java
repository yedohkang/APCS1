// Yedoh Kang
// APCS1 -- pd5
// HW$50 -- Selection
// 2012-12-22

/*======================================
class SelectionSort -- implements SelectionSort algorithm
======================================*/

import java.util.ArrayList;

public class SelectionSort {
	//~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
	//precond: lo < hi && size > 0
	//postcond: returns an ArrayList of random integers
	//          from lo to hi, inclusive
	public static ArrayList populate (int size, int lo, int hi) {
		ArrayList<Integer> retAL = new ArrayList<Integer>();
		while( size > 0 ) {
			//     offset + rand int on interval [lo,hi]
			retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
			size--;
		}
		return retAL;
	}

	//randomly rearrange elements of an ArrayList
	public static void shuffle( ArrayList al ) {
		int randomIndex;
		for( int i = al.size()-1; i > 0; i-- ) {
			//pick an index at random
			randomIndex = (int)( (i+1) * Math.random() );
			//swap the values at position i and randomIndex
			al.set( i, al.set( randomIndex, al.get(i) ) );
		}
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


	// VOID version of SelectionSort
	// Rearranges elements of input ArrayList
	// postcondition: data's elements sorted in ascending order
	public static void selectionSortV( ArrayList<Comparable> data ) 
	{
		//note: this version places greatest value at rightmost end,

		//maxPos will point to position of SELECTION (greatest value)
		int maxPos;
		
		for (int x = data.size() - 1; x > 0; x--) {
			maxPos = 0; // initialize maxPos
			for (int i = x; i > 0; i--) { // R --> L, finds the maxPos
				if ((data.get(maxPos)).compareTo(data.get(i)) < 0) {
					maxPos = i; // reset if another value is greater
				}
			} 
			// swap (couldn't do the data.set() thing because still confused)
			Comparable temp = data.get(x);
			data.set(x,data.get(maxPos));
			data.set(maxPos,temp);
		}
		
	}//end selectionSort


	// ArrayList-returning selectionSort
	// postcondition: order of input ArrayList's elements unchanged
	//                Returns sorted copy of input ArrayList.
	
	public static ArrayList<Comparable> selectionSort( ArrayList<Comparable> input ) 
	{
		//declare and initialize empty ArrayList for copying
		ArrayList<Comparable> data = new ArrayList<Comparable>();
		//copy input ArrayList into working ArrayList
		for( Comparable o : input )
			data.add( o );
		//sort working ArrayList
		selectionSortV( data );
		return data;
	}//end selectionSort 


	public static void main( String [] args ) 
	{
		/*==========for AL-returning methods==========
			ArrayList glen = new ArrayList<Integer>();
			glen.add(7);
			glen.add(1);
			glen.add(5);
			glen.add(12);
			glen.add(3);
			System.out.println( "ArrayList glen before sorting:\n" + glen );
			selectionSortV(glen);
			System.out.println( "ArrayList glen after sorting:\n" + glen );

			ArrayList coco = populate( 10, 1, 1000 );
			System.out.println( "ArrayList coco before sorting:\n" + coco );
			selectionSortV(coco);
			System.out.println( "ArrayList coco after sorting:\n" + coco );

			============================================*/
	
			ArrayList glen = new ArrayList<Integer>();
		glen.add(7);
		glen.add(1);
		glen.add(5);
		glen.add(12);
		glen.add(3);
		System.out.println( "ArrayList glen before sorting:\n" + glen );
		ArrayList glenSorted = selectionSort( glen );
		System.out.println( "sorted version of ArrayList glen:\n" 
			+ glenSorted );
		System.out.println( "ArrayList glen after sorting:\n" + glenSorted );

		ArrayList coco = populate( 10, 1, 1000 );
		System.out.println( "ArrayList coco before sorting:\n" + coco );
		ArrayList cocoSorted = selectionSort( coco );
		System.out.println( "sorted version of ArrayList coco:\n" 
			+ cocoSorted );
		System.out.println( "ArrayList coco after sorting:\n" + cocoSorted );

	}//end main

}//end class SelectionSort
