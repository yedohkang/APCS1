// Yedoh Kang
// APCS1 -- pd5
// HW#41 -- Array of Steel
// 2016-12-08

/*==================================================
class SuperArray version 1.0
Wrapper class for array. Facilitates resizing, 
expansion, and read/write capability on elements.
==================================================*/

public class SuperArray {
	
	private int[] _data;  //underlying container structure
	private int _lastPos; //marker for last meaningful value
	private int _size;    //number of meaingful values

	//default constructor
	//initializes 10-item array
	public SuperArray() { 
		_data = new int[10];
		_lastPos = -1;
		_size = 0;
	}

	//output array in [a,b,c] format
	//eg, for int[] a = {1,2,3} ...
	//toString() -> "[1,2,3]"
	public String toString() { 
		String retStr = "";
		retStr += "[";
		for (int i = 0; i < _data.length - 1; i++) {
			retStr += _data[i] + ", ";
		}
		retStr += _data[_data.length - 1] + "]";
		return retStr;
	}

	//double capacity of this instance of SuperArray 
	private void expand() { 
		int[] newData = new int[_data.length * 2]; // new array (temp)
		for (int i = 0; i < _data.length; i++) {
			newData[i] = _data[i]; // populate
		}
		_data = newData; // substitute
	}

	//accessor method -- return value at specified index
	public int get (int index) {
		return _data[index];
	}

	//mutator method -- set index to newVal, return old value at index
	public int set (int index, int newVal) {
		int old = _data[index];
		_data[index] = newVal;
		return old;
	}


	//main method for testing
	public static void main (String[] args) {

		SuperArray curtis = new SuperArray();
		System.out.println( "Printing empty SuperArray curtis..." );
		System.out.println(curtis);

		for (int i = 0; i < curtis._data.length; i++) {
			curtis.set(i, i * 2);
		}

		System.out.println("Printing populated SuperArray curtis...");
		System.out.println(curtis);

		for (int i = 0; i < 3; i++) {
			curtis.expand();
			System.out.println("Printing expanded SuperArray curtis...");
			System.out.println(curtis);
			System.out.println("new length of underlying array: " 
				+ curtis._data.length );
		}
	}//end main()

}//end class SuperArray
