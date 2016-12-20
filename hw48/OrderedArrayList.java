// Yedoh Kang
// APCS1 -- pd5
// HW#46 -- Halving the Halves
// 2016-12-20

/*============================================
  class OrderedArrayList
  Wrapper class for ArrayList.
  Imposes the restriction that stored items 
  must remain sorted in ascending order
  ============================================*/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;

public class OrderedArrayList{

    // instance of class ArrayList, holding objects of type Comparable 
    // (ie, instances of a class that implements interface Comparable)
    private ArrayList<Comparable> _data;
	private int midIndex = 0;

    // default constructor initializes instance variable _data
    public OrderedArrayList() {
		_data = new ArrayList<Comparable>();
    }

    public String toString() { 
		String retStr = "";
		retStr += "[";
		for (int i = 0; i < _data.size() - 1; i++) {
			retStr += _data.get(i) + ", ";
		}
		retStr += _data.get(_data.size() - 1) + "]";
		return retStr;
    }

    public Comparable remove (int index) { 
		return _data.remove(index);
    }

    public int size() {
		return _data.size();
    }

    
    public Comparable get (int index) { 
		return _data.get(index);
    }


    // addLinear takes as input any comparable object 
    // (i.e., any object of a class implementing interface Comparable)
    // inserts newVal at the appropriate index
    // maintains ascending order of elements
    // uses a linear search to find appropriate index
    public void addLinear (Comparable newVal) { 
		boolean check = false; //boolean to check if newVal is already added to the list
		for (int i = 0; i <  _data.size(); i++){
			// loops until element greater than newVal is found then inserts
		    if (_data.get(i).compareTo(newVal) > 0){
		        _data.add(i, newVal);
				check = true;
				i = _data.size(); //breaks the loop
		    }
		}
	    if (check == false) {
	    	_data.add(newVal);
	    }
    }
	
	// helper function for addBinary (idea by Brian Kwong!!!)
	public int binaryHelp (Comparable newVal) {
		int lowerBound = 0;
		int upperBound = size() - 1;
		while (lowerBound <= upperBound) { // so that upperBound is never bigger than lowerBound
			int mid = (lowerBound + upperBound) / 2; // midpoint
			if (newVal.compareTo(get(mid)) < 0) {
				upperBound = mid - 1; // make upperBound one less than the mid
			} else if (newVal.compareTo(_data.get(mid)) > 0) {
				lowerBound = mid + 1; // make lowerBound one more than the mid
			} else {
				return mid; // if equal
			}
		}
		return lowerBound;
	}
	
	// addBinary takes as input any comparable object
	// inserts newVal at the appropriate index
	// maintains ascending order of elements
	// uses a binary search to find appropriate index
	public void addBinary (Comparable newVal) {
		_data.add(binaryHelp(newVal), newVal);
	}
	

    // main method solely for testing purposes
    public static void main( String[] args ) {

		OrderedArrayList Franz = new OrderedArrayList();

		System.out.println("\nValues to add via addLinear() calls:");

		// testing linear search
		for( int i = 0; i < 15; i++ ) {
	 		int valToAdd = (int)( 50 * Math.random() );
	   		System.out.println( valToAdd );
	        Franz.addLinear( valToAdd );
		}

		System.out.println("\nafter population via addLinear() calls:");
		System.out.println( Franz );
		System.out.println();

		OrderedArrayList Lizst = new OrderedArrayList();

		System.out.println("\nValues to add via addLinear() calls:");

		// testing linear search
		for( int i = 0; i < 15; i++ ) {
	 		int valToAdd = (int)( 50 * Math.random() );
	   		System.out.println( valToAdd );
	        Lizst.addBinary( valToAdd );
		}

		System.out.println("\nafter population via addBinary() calls:");
		System.out.println( Lizst );
		System.out.println();
    }

}//end class OrderedArrayList
 
