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