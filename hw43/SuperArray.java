// Team Fee Fy (!!!!) Fo Fum (Fabiha Ahmed, Yedoh Kang)
// Yedoh Kang
// APCS1 -- pd5
// HW#43 -- Array of Titanium
// 2016-12-12

/*==================================================
class SuperArray version 1.0
Wrapper class for array. Facilitates resizing, 
expansion, and read/write capability on elements.
==================================================*/

public class SuperArray implements ListInt {
	
	private int[] _data;  // underlying container structure
	private int _lastPos; // marker for last meaningful value
	private int _size;    // number of meaingful values

	//default constructor
	public SuperArray() { 
		_data = new int[10]; // initialize
		_lastPos = -1; // initialize
		_size = 0; // initialize
	}

	//output array in [a,b,c] format
	public String toString() { 
		String retStr = "[";
		for (int i = 0; i < _size; i++) {
			retStr += _data[i] + ",";
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

	//adds an item after the last item
	public void add (int newVal) { 
		if (_size >= _data.length) {
			expand();
		}
		_data[_lastPos + 1] = newVal; // add!
		_size += 1; // update size
		_lastPos += 1; // update last meaningful value index
	}

	//inserts an item at index
	//shifts existing elements to the right
	public void add (int index, int newVal) {
		if (_size >= _data.length) {
			expand();
		}
		if (index >= _size) {
			System.out.println("Failed to insert the new element at the index because the index is invalid.");
		}
		else {
			// goes right to left
			for (int x = _size; x >=index; x -= 1){
				_data[x] = _data[x - 1];
			}
			_data[index] = newVal; // insert
			_lastPos += 1;
			_size += 1; // update size
			
		}
	}

	//removes the item at index
	//shifts elements left to fill in newly-emptied slot
	public void remove (int index) {
		for (int x = index + 1; x < _data.length; x++) {
			_data[x -1] = _data[x]; // shift everything after the index left
		}
		_data[_data.length - 1] = 0; 
		_lastPos -= 1; // update last meaningful position
		_size -= 1; // update size
	}

	//return number of meaningful items in _data
	public int size() {
		return _size;
	}

	//main method for testing
	public static void main (String[] args) {
		
		//** curtis cannot be of type ListInt because set() is not a method in ListInt
		SuperArray curtis = new SuperArray();
		System.out.println("Printing empty SuperArray curtis...");
		System.out.println(curtis);

		for (int i = 0; i < curtis._data.length; i++) {
			curtis.set(i, i*2);
			curtis._size++;
		}

		System.out.println("Printing populated SuperArray mayfield...");
		System.out.println(curtis);

		SuperArray mayfield = new SuperArray();
		System.out.println("Printing empty SuperArray mayfield...");
		System.out.println(mayfield);

		mayfield.add(5);
		mayfield.add(4);
		mayfield.add(3);
		mayfield.add(2);
		mayfield.add(1);

		System.out.println("Printing populated SuperArray mayfield...");
		System.out.println(mayfield);

		mayfield.remove(3);
		System.out.println("Printing SuperArray mayfield post-remove...");
		System.out.println(mayfield);
		mayfield.remove(3);
		System.out.println("Printing SuperArray mayfield post-remove...");
		System.out.println(mayfield);

		mayfield.add(30,99); // should print out "exception" because index>=_size
		System.out.println("Printing SuperArray mayfield post-insert...");
		System.out.println(mayfield);
		mayfield.add(2,88);
		System.out.println("Printing SuperArray mayfield post-insert...");
		System.out.println(mayfield);
		mayfield.add(1,77);
		System.out.println("Printing SuperArray mayfield post-insert...");
		System.out.println(mayfield);
		
		// gordon is of type ListInt******
		ListInt gordon = new SuperArray();
		System.out.println("Printing empty ListInt(SuperArray) gordon...");
		System.out.println(gordon);
		
		/*
		gordon.expand();
		System.out.println("Expanded.");
			*/ // --> cannot expand because expand isn't a method in ListInt
			// same with get(), set() and size()
		
		gordon.add(10);
		gordon.add(9);
		gordon.add(8);
		gordon.add(7);
		gordon.add(6);

		System.out.println("Printing populated SuperArray gordon...");
		System.out.println(gordon);

		gordon.remove(3);
		System.out.println("Printing SuperArray gordon post-remove...");
		System.out.println(gordon);
		gordon.remove(3);
		System.out.println("Printing SuperArray gordon post-remove...");
		System.out.println(gordon);

		gordon.add(30,99); // should print out "exception" because index>=_size
		System.out.println("Printing SuperArray gordon post-insert...");
		System.out.println(gordon);
		gordon.add(2,88);
		System.out.println("Printing SuperArray gordon post-insert...");
		System.out.println(gordon);
		gordon.add(1,77);
		System.out.println("Printing SuperArray gordon post-insert...");
		System.out.println(gordon);
	}//end main()
}//end class SuperArray
