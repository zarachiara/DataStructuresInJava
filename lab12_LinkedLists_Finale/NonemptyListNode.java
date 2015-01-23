abstract public class AbstractListNode 
{
	abstract public Object item ();
	abstract public AbstractListNode next ();
	abstract public boolean isEmpty ();
	// implemented
	abstract public int size(); 
	
	// implemented
	abstract public Object get(int position);
		
	// implemented
	abstract public boolean isequals(Object value);
	
	// implemented 
	abstract public String toString(); 
	
}

class EmptyListNode extends AbstractListNode 
{
	
	public EmptyListNode () {
	}
	public Object item () {
		throw new IllegalArgumentException ("There is no 'item' value stored in an EmptyListNode.");
	}
	public AbstractListNode next () {
		throw new IllegalArgumentException ("No elements follow an EmptyListNode.");
	}
	public boolean isEmpty () {
		return true;
	}
	public int size()
	{
		return 0; 
	}
	public Object get(int position)
	{
		Object getItem = null; 
		return getItem; 
	}
	public boolean isequals(Object value)
	{
		return true;
	}
	
	public String toString()
	{
		return new String("()");
	}
}

class NonemptyListNode extends AbstractListNode {
	private Object myItem;
	private AbstractListNode myNext;
	
	public NonemptyListNode (Object item, AbstractListNode next) 
	{
		myItem = item;
		if (next == null) 
		{
			myNext = new EmptyListNode ();
		} else {
			myNext = next;
		}
	}
	
	public NonemptyListNode (Object item) 
	{
		this (item, new EmptyListNode ()); 
	}
	
	public Object item () 
	{
		return myItem;
	}
	
	public AbstractListNode next () 
	{
		return myNext;
	}
	
	public boolean isEmpty () 
	{
		return false;
	}
	
	/* 
    look like a base case and a recursive case, except that they are taking place in two different classes.
	We strongly recommend you use recursion in your solution.
	You might try writing it two ways: like VERSION 3 and VERSION 1 (from the last step).
    */
	public int size()
	{ 
		return 1 + myNext.size();
	}
	
	/*
	//Implement a get method get in the ListNode class. get takes an int position as argument, and returns the list element at the given position in the list, starting with element zero. For example, if get(1) is called, you should return the second item in the list. If the position is out of range, get should throw an IllegalArgumentException with an appropriate error message.
	//First write JUnit tests to provide evidence of the get method correctness.
	//Then add the get method to your ListNode class
	 */
	public Object get(int position)
	{
		Object getItem = null;
		AbstractListNode curNode = this;
		for(int i = 0; i <=  position; i++)
		{	
			if (curNode.isEmpty() == true)
			{
				throw new IllegalArgumentException ("position is not available.");
			}
			if (i == position)
			{
				getItem = curNode.item(); 
				break;
			}
			curNode = curNode.next();
			
		}	
		return getItem; 
	}
	
	/*
	 * The AbstractListNode.equals method, given an Object as argument, 
	 * returns true if the input list is also an AbstractListNode, and this 
	 * list and the argument list are the same length with equal elements 
	 * in corresponding positions (determined by using the elements' equals method).
	 */
	public boolean isequals(Object value)
	{
		AbstractListNode curNode = this; 
		if (value instanceof AbstractListNode)
		{
			
			AbstractListNode castValue = (AbstractListNode)value; 
			if (curNode.size() != castValue.size())
			{

				return false; 
			}
			for (int i = 0; i < curNode.size(); i++)
			{
				if (curNode.item() != castValue.item())
				{
					return false;
				}
				curNode = curNode.next();
				castValue = castValue.next();
			}
			return true; // went through the whole loop and items were all equal.
		}
		return false;  // catches Object value is NOT an AbstractListNode
	}
	
	/*
	a left parenthesis, followed by a blank,
	followed by the String representation of the first element, followed by a blank,
	followed by the String representation of the second element, followed by a blank,
	...
	followed by a right parenthesis.
	 */
	public String toString()
	{
	
		AbstractListNode curNode = this;
		String makeString = "(" + curNode.item();
		for (int i = 0; i <= curNode.size(); i++)
		{
		
			 
			curNode = curNode.next(); 
//			System.out.println(curNode + "STRINGGGGGG");
			makeString += " " + curNode.item(); 
		}
		return makeString + ")";
	}
}