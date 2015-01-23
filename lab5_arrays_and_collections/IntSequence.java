public class IntSequence {

    /* ///////////////////////
    ////instance variables///
    *///////////////////////
    protected int[] myValues;   // sequence elements
    int myCount;                // number of array cells used by sequence


    /////////////////
    /* constructor///
    *////////////////
    public IntSequence(int capacity) 
    {
        this.myValues = new int[capacity];
        this.myCount = 0;
    }

    /////////////////
    /* METHODS
        1. add
        2. insert
        3. isEmpty()
        4. size()
        5. elementAt
        6. toString()
        7. contains(intVal)
    *////////////////

    /* ADD
        the argument to the sequence by placing it in the first
        unused spot in the array and incrementing the count.
        Assume that the sequence isn't full.*/
    public void add(int toBeAdded) 
    {
    	if (this.isEmpty()) {
    		this.myValues[myCount] = toBeAdded;// add in the tail. 
    		myCount++;
    	}
    }

    /* INSERT
        Insert toInsert into the sequence at position insertPos,
        shifting the later elements in the sequence over to make room
        for the new element.
        Assumptions: The array isn't full, i.e. myCount < myValues.length
        Also, insertPos is between 0 and myCount, inclusive. */
    public void insert(int toInsert, int insertPos) {
    	
	for(int i = myValues.length-1; i >insertPos; i--){
		myValues[i] = myValues[i-1]; // decrements towards position. Makes room for toInsert by shifting to the right.  
	}
	myValues[insertPos] = toInsert; 
	
	if (insertPos >= myCount) { // case when inserted in between index that has no element. 
		myCount++; // update number of elements in the array. 
	}
	
    }


    /* isEmpty() 
        returns true when this sequence is empty and returns false otherwise */
    public boolean isEmpty()
    {
    	return myCount != myValues.length;
    }

    /* size() 
        returns the number of values in this sequence
        Note: There is a distinction between size and capacity. */
    public int size() {   
    	return myCount; //only includes elements that contain values. 
    }

    /* elementAt
        returns the value at the given position in the sequence
        e.g. If the sequence contains 3, 1, and 4, elementAt(0) returns 3.
        Note: If someone asks for the elementAt an index that does not exist, you should call System.err.println and include a description of the error and call System.exit(1) to exit the method. The same is true for any case where a method is called with incorrect input.
        */
    public int elementAt(int pos) {
    	if (pos >= myCount || pos < 0) {
    		System.err.println("Out of index");
    		System.exit(1);
    	}
    	return myValues[pos];
    }
    
    /* toString()
        for the IntSequence class. It will return a String that contains the elements of the sequence separated by blanks.
    */
    public String toString()
    {
    	String arrSt = "";
    	for (int i =0; i < myCount; i++) {
    		arrSt += myValues[i] + " ";
    	}
    	return arrSt;
    }

    /* contains
        Given an int argument - we'll call it k - contains returns true if k is one of the elements of this sequence, and returns false otherwise. 
    */
    public boolean contains(int val) {
    	for (int elem : myValues) {
    		if (elem == val) {
    			return true;
    		}
    	}
    	return false;
    }
}
