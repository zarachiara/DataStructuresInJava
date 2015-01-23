public class List {

	private ListNode myHead;

	public List() {
		myHead = null;
	}

	public boolean isEmpty() {
		return myHead == null;
	}

	private static class ListNode {

		private Object myItem;
		private ListNode myNext;

		private ListNode (Object first, ListNode rest) {
			myItem = first;
			myNext = rest;
		}

		private ListNode (Object first) {
			myItem = first;
			myNext = null;
		}

	}

	public String toString() {
		String rtn = "( ";
		for (ListNode p = myHead; p != null; p = p.myNext) {
			rtn = rtn + p.myItem + " ";
		}
		return rtn + ")";
	}

	// Return the number of items in this list ("length" in Scheme).
	public int size() {
		int rtn = 0;
		for (ListNode p = myHead; p != null; p = p.myNext) {
			rtn++;
		}
		return rtn;
	}

	// Return true if the list contains the object 
	public boolean contains (Object obj) {
		for (ListNode p = myHead; p != null; p = p.myNext) {
			if (obj.equals (p.myItem)) {
				return true;
			}
		}
		return false;
	}

	// Returns the element at the given position in this list.
	public Object get (int pos) {
		if (pos < 0) {
			throw new IllegalArgumentException (
					"Argument to get must be at least 0.");
		}
		if (pos >= size()) {
			throw new IllegalArgumentException ("Argument to get is too large.");
		}
		int k = 0;
		for (ListNode p = myHead; p != null; p = p.myNext) {
			if (k == pos) {
				return p.myItem;
			}
			k++;
		}
		return null;
	}
	
	public void addToFront (Object obj) {
		myHead = new ListNode (obj, myHead);
	}

	public boolean equals (Object obj) {
		// YOUR CODE HERE
		return true;
	}

	public void add (Object x) {
		// YOUR CODE HERE
		for (ListNode p = myHead; p!= null; p = p.myNext)
		{
			if p.myNext.isEmpty()
			{
				p.myNext.myItem = x; 
				
			}
		}
	}

	public void appendInPlace (List l) {
		// YOUR CODE HERE
	}

	public Iterator iterator() {
		return new SequenceIterator();
	}
	
	public class SequenceIterator implements Iterator {
		public SequenceIterator() {
		// YOUR CODE HERE
		}
		public boolean hasNext() {
		// YOUR CODE HERE
		return false;
		}
		public Object next() {
		// YOUR CODE HERE
		return null;
		}
		public void remove() {
		// YOUR CODE HERE
		}
	}

/* 	isOK
	Write a List method named isOK that checks this list for consistency. 
	In particular, it should check that
	the value stored in mySize is the number of nodes in this list
	all myItem objects in this list are non-null
	either both myHead and myTail are null, or myTail is a reference to 
	the last node in the list whose first node is the node thatmyHead refers to.
	// YOUR CODE HERE

*/


	/* Iterative reverse 
	Fill in the framework for reverseHelper (given below) so that, 
	instead of making a recursive call, it uses a loop to change the 
	relevant links. (You'll also need to change the call to reverseHelper.) 
	Each iteration of your loop should maintain the invariant described for 
	the recursive version. Your JUnit test from the previous step should work 
	for this version as well.
	*/
	private static ListNode reverseHelper (ListNode head) 
	{
		ListNode p, soFar;
		// p plays the role of L in the previous version.
		for (p = head, soFar = null; p != null; ) {
		ListNode temp = p;
		// YOUR CODE HERE
		}
		return soFar;
	}
		

}