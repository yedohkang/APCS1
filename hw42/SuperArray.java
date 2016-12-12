// Team Snail (Yedoh Kang, Lisa Eng)
// Yedoh Kang
// APCS1 -- pd5
// HW#41 -- Array of Grade 316
// 2016-12-09

/*==================================================
class SuperArray version 1.0
Wrapper class for array. Facilitates resizing, 
expansion, and read/write capability on elements.
==================================================*/

public class SuperArray {
	
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
		// goes right to left
		for (int x = _size; x >=index; x -= 1){
			_data[x] = _data[x - 1];
		}
		_data[index] = newVal; // insert
		_lastPos += 1;
		_size += 1; // update size
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

		mayfield.add(3,99);
		System.out.println("Printing SuperArray mayfield post-insert...");
		System.out.println(mayfield);
		mayfield.add(2,88);
		System.out.println("Printing SuperArray mayfield post-insert...");
		System.out.println(mayfield);
		mayfield.add(1,77);
		System.out.println("Printing SuperArray mayfield post-insert...");
		System.out.println(mayfield);
	}//end main()
}//end class SuperArray
