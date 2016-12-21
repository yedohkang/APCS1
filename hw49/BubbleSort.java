// Yedoh Kang
// APCS1 -- pd5
// HW#49 -- Dat Bubbly Tho
// 2016-12-21

/*======================================
class BubbleSort -- implements bubblesort algorithm (vanilla version)

..------..                          
/~~-.-~__-'`-__  ~-.  .-~-.                
|   /~~~\     / ~~---\|     |               
|  ||| * |   | | |  * |     |               
/_-|\ \ /     \ \ \__.|\.  |                
~   \~~   |_|   ~~~~ /   ~-.\               
~-.._      _.-~~                       
.--~~~~~~--.                         
|  |______|  |                        
~-|______|-~                         
|      |                           
|______|                           
|  |   |                           
|__|___|                           
|_|| _||                        
`--'`--'                           
======================================*/

import java.util.ArrayList;

public class BubbleSort {

	//~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
	//precond: lo < hi && size > 0
	//postcond: returns an ArrayList of random integers
	//          from lo to hi, inclusive
	public static ArrayList populate (int size, int lo, int hi) {
		ArrayList<Integer> retAL = new ArrayList<Integer>();
		while (size > 0) {
			// offset + rand int on interval [lo,hi]
			retAL.add(lo + (int)((hi-lo+1) * Math.random()));
			size--;
		}
		return retAL;
	}

	//randomly rearrange elements of an ArrayList
	public static void shuffle (ArrayList al) {
		int randomIndex;
		//setup for traversal fr right to left
		for (int i = al.size()-1; i > 0; i--) {
			//pick an index at random
			randomIndex = (int)((i+1) * Math.random());
			//swap the values at position i and randomIndex
			al.set(i, al.set(randomIndex, al.get(i)));
		}
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


	// VOID version of bubbleSort
	// Rearranges elements of input ArrayList
	// postcondition: data's elements sorted in ascending order
	public static void bubbleSortV (ArrayList<Comparable> data) {
		// number of passes left
		int passLeft = data.size() - 1;
		int size = data.size();
		while (passLeft > 0) { // as long as number of passes is not 0
			passLeft -= 1; // decrement (counting down)
			for (int i = size - 1; i > 0; i--) { // right to left
				if ((data.get(i)).compareTo(data.get(i-1)) < 0) {
					// swap
					Comparable tempRight = data.get(i);
					data.set(i, data.get(i-1));
					data.set(i-1, tempRight);
				}
			}
		}
	}//end bubbleSortV


	// ArrayList-returning bubbleSort
	// postcondition: order of input ArrayList's elements unchanged
	//                Returns sorted copy of input ArrayList.
	public static ArrayList<Comparable> bubbleSort (ArrayList<Comparable> input) {
		int passLeft = input.size() - 1;
		int size = input.size();
		while (passLeft > 0) {
			passLeft -= 1;
			for (int i = size - 1; i > 0; i--) { // right to left
				if ((input.get(i)).compareTo(input.get(i-1)) < 0) {
					Comparable tempRight = input.get(i);
					input.set(i, input.get(i-1));
					input.set(i-1, tempRight);
				}
			}
		}
		return input;
		
	}//end bubbleSort
		
		
		
	public static void main (String [] args) {
		/*
			ArrayList glen = new ArrayList<Integer>();
			glen.add(7);
			glen.add(1);
			glen.add(5);
			glen.add(12);
			glen.add(3);
			System.out.println( "ArrayList glen before sorting:\n" + glen );
			bubbleSortV(glen);
			System.out.println( "ArrayList glen after sorting:\n" + glen );

			ArrayList coco = populate( 10, 1, 1000 );
			System.out.println( "ArrayList coco before sorting:\n" + coco );
			bubbleSortV(coco);
			System.out.println( "ArrayList coco after sorting:\n" + coco );
			
		*/
				ArrayList glen = new ArrayList<Integer>();
				glen.add(7);
				glen.add(1);
				glen.add(5);
				glen.add(12);
				glen.add(3);
				System.out.println( "ArrayList glen before sorting:\n" + glen );
				ArrayList glenSorted = bubbleSort( glen );
				System.out.println( "sorted version of ArrayList glen:\n" 
				+ glenSorted );
				System.out.println( "ArrayList glen after sorting:\n" + glen );

				ArrayList coco = populate( 10, 1, 1000 );
				System.out.println( "ArrayList coco before sorting:\n" + coco );
				ArrayList cocoSorted = bubbleSort( coco );
				System.out.println( "sorted version of ArrayList coco:\n" 
				+ cocoSorted );
				System.out.println( "ArrayList coco after sorting:\n" + coco );


	}//end main

}//end class BubbleSort



/***
Bulbasaur by Maija Haavisto
/
_,.------....___,.' ',.-.
,-'          _,.--"        |
,'         _.-'              .
/   ,     ,'                   `
.   /     /                     ``.
|  |     .                       \.\
____      |___._.  |       __               \ `.
.'    `---""       ``"-.--"'`  \               .  \
.  ,            __               `              |   .
`,'         ,-"'  .               \             |    L
,'          '    _.'                -._          /    |
,`-.    ,".   `--'                      >.      ,'     |
. .'\'   `-'       __    ,  ,-.         /  `.__.-      ,'
||:, .           ,'  ;  /  / \ `        `.    .      .'/
j|:D  \          `--'  ' ,'_  . .         `.__, \   , /
/ L:_  |                 .  "' :_;                `.'.'
.    ""'                  """""'                    V
`.                                 .    `.   _,..  `
`,_   .    .                _,-'/    .. `,'   __  `
) \`._        ___....----"'  ,'   .'  \ |   '  \  .
/   `. "`-.--"'         _,' ,'     `---' |    `./  |
.   _  `""'--.._____..--"   ,             '         |
| ." `. `-.                /-.           /          ,
| `._.'    `,_            ;  /         ,'          .
.'          /| `-.        . ,'         ,           ,
'-.__ __ _,','    '`-..___;-...__   ,.'\ ____.___.'
`"^--'..'   '-`-^-'"--    `-^-'`.''"""""`.,^.`.--' mh

***/
