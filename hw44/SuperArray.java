// Yedoh Kang
// APCS1 -- pd5
// HW#44 -- In America, the Driver Sits on the Left
// 2016-12-13

/*==================================================
class SuperArray version 1.0
Wrapper class for array. Facilitates resizing, 
expansion, and read/write capability on elements.
==================================================*/

public class SuperArray extends java.lang.Object implements List {
	
	private java.lang.Object[] _data;  // underlying container structure
	private int _lastPos; // marker for last meaningful value
	private int _size;    // number of meaingful values

	//default constructor
	public SuperArray() { 
		_data = new java.lang.Object[10]; // initialize
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
		java.lang.Object[] newData = new java.lang.Object[_data.length * 2]; // new array (temp)
		for (int i = 0; i < _data.length; i++) {
			newData[i] = _data[i]; // populate
		}
		_data = newData; // substitute
	}

	//accessor method -- return value at specified index
	public java.lang.Object get (int index) throws java.lang.IndexOutOfBoundsException {
		if (index < 0 || index >= size()) {
			throw new java.lang.IndexOutOfBoundsException();
		}
		else {
			return _data[index];
		}
	}

	//mutator method -- set index to newVal, return old value at index
	public java.lang.Object set (int index, java.lang.Object o) throws java.lang.IndexOutOfBoundsException {
		if (index < 0 || index >= size()) {
			throw new java.lang.IndexOutOfBoundsException();
		}
		else {
			java.lang.Object old = _data[index];
			_data[index] = o;
			return old;
		}
	}

	//adds an item after the last item
	public boolean add (java.lang.Object o) { 
		if (_size >= _data.length) {
			expand();
		}
		_data[_lastPos + 1] = o; // add!
		_size += 1; // update size
		_lastPos += 1; // update last meaningful value index
		return true;
	}

	//inserts an item at index
	//shifts existing elements to the right
	public void add (int index, java.lang.Object o) throws java.lang.IndexOutOfBoundsException {
		if (index < 0 || index >= size()) {
			throw new java.lang.IndexOutOfBoundsException();
		}
		else {
			if (_size >= _data.length) {
				expand();
			}
			else {
				// goes right to left
				for (int x = _size; x >=index; x -= 1){
					_data[x] = _data[x - 1];
				}
				_data[index] = o; // insert
				_lastPos += 1;
				_size += 1; // update size
			}
		}
	}

	//removes the item at index
	//shifts elements left to fill in newly-emptied slot
	public java.lang.Object remove (int index) throws java.lang.IndexOutOfBoundsException {
		java.lang.Object oldVal = _data[index];
		if (index < 0 || index >= size()) {
			throw new java.lang.IndexOutOfBoundsException();
		}
		else {
			for (int x = index + 1; x < _data.length; x++) {
				_data[x -1] = _data[x]; // shift everything after the index left
			}
			_data[_data.length - 1] = 0; 
			_lastPos -= 1; // update last meaningful position
			_size -= 1; // update size
		}
		return oldVal;
	}

	//return number of meaningful items in _data
	public int size() {
		return _size;
	}

	//main method for testing
	public static void main (String[] args) {
		
		// tests the List interface
		List mayfield = new SuperArray();
		System.out.println("Printing empty SuperArray mayfield...");
		System.out.println(mayfield);
		
		List curtis = new SuperArray();
		List gordon = new SuperArray();

		System.out.println("Adding...");
		mayfield.add(5);
		mayfield.add(4);
		mayfield.add("hello");
		mayfield.add(2);
		mayfield.add(1.098);
		mayfield.add(curtis);

		System.out.println("Printing populated SuperArray mayfield...");
		System.out.println(mayfield);

		System.out.println("Printing out new SuperArray mayfield...");
		mayfield.set(3, gordon);
		System.out.println(mayfield);
		
		System.out.println("Index 4 is: ");
		System.out.println(mayfield.get(4));
		
		System.out.println("Mayfield size: ");
		System.out.println(mayfield.size());
	
	}//end main()
}//end class SuperArray
