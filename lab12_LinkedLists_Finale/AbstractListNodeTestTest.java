import static org.junit.Assert.*;

import org.junit.Test;

public class AbstractListNodeTestTest{

	@Test
	public void TestEmptyListNode()
	{
		EmptyListNode empty = new EmptyListNode(); 
		try 
		{
			empty.item();
		}
		catch (IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
		try 
		{
			empty.next();
		}
		catch (IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}	
	}
	
	@Test
	public void TestisEmptyEmptyListNode()
	{
		EmptyListNode empty = new EmptyListNode(); 
		boolean state = empty.isEmpty(); 
		assertTrue(state == true);
	}
	
	@Test
	public void TestNonemptyListNode1()
	{
		NonemptyListNode nonEmpty1 = new NonemptyListNode("hello", new NonemptyListNode("CS", new NonemptyListNode("Peeps")));
		System.out.println("the next item " + nonEmpty1.next().item()); // prints an object 
		// test next() of each link list node 
		assertTrue(nonEmpty1.item() == "hello");
		assertTrue(nonEmpty1.next().item() == "CS");
		assertTrue(nonEmpty1.next().next().item() == "Peeps");
		try
		{
			nonEmpty1.next().next().next().item();
		}
		catch (IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
		
		// test that each node is not empty except for the last 
		assertTrue(nonEmpty1.isEmpty() == false);
		assertTrue(nonEmpty1.next().isEmpty() == false);
		assertTrue(nonEmpty1.next().next().isEmpty() == false);
		assertTrue(nonEmpty1.next().next().next().isEmpty() == true);  

	}
	
	@Test
	public void TestNonemptyListNode2()
	{
		NonemptyListNode nonEmpty1 = new NonemptyListNode("hello");
		
		// test items are accurate in TestNonemptyListNode constructor that has one Object item argument
		System.out.println(nonEmpty1.item());
		assertTrue(nonEmpty1.item() == "hello");
		NonemptyListNode nonEmpty2 = new NonemptyListNode("CS"); 
		System.out.println(nonEmpty2.item());
		assertTrue(nonEmpty2.item() == "CS");
		NonemptyListNode nonEmpty3 = new NonemptyListNode("peeps");
		System.out.println(nonEmpty3.item());
		assertTrue(nonEmpty3.item() == "peeps");
		NonemptyListNode nonEmpty4 = new NonemptyListNode(null);
		assertTrue(nonEmpty4.item() == null);
	}
	
	@Test
	public void TestGet()
	{
		NonemptyListNode nonEmpty1 = new NonemptyListNode("hello", new NonemptyListNode("CS", new NonemptyListNode("Peeps")));
		System.out.println(nonEmpty1.get(0) + " get(0)"); // prints "hello"
		assertTrue(nonEmpty1.get(0) == "hello");
		assertTrue(nonEmpty1.get(1) == "CS");
		System.out.println(nonEmpty1.get(1) + " get(1)");
		assertTrue(nonEmpty1.get(2) == "Peeps");
		System.out.println(nonEmpty1.get(2) + " get(2)");
//		
		
	}
	
	@Test

	public void testisequal()
	{
		AbstractListNode nonEmpty1 = new NonemptyListNode("hello", new NonemptyListNode("CS", new NonemptyListNode("Peeps")));
		AbstractListNode nonEmpty2 = new NonemptyListNode("hello", new NonemptyListNode("CS", new NonemptyListNode("Peeps")));
		AbstractListNode nonEmpty3 = new NonemptyListNode("hello", new NonemptyListNode("CS", new NonemptyListNode("Peeps", new NonemptyListNode("in Berkeley"))));
		String a = new String("kombucha");
//		System.out.println(nonEmpty1.isequals(nonEmpty2) + "EQUALSS");
		System.out.println(nonEmpty1.next().next().item());
		System.out.println(nonEmpty2.next().next().item());
		
		assertTrue(nonEmpty1.isequals(nonEmpty2) == true); // the same AbstractListNode
		assertTrue(nonEmpty1.isequals(a) == false); // value is not an AbstractListNode
		assertTrue(nonEmpty1.isequals(nonEmpty3) == false); // sizes are different
	}
	
	
	@Test
	public void TestToString()
	{
		AbstractListNode nonEmpty1 = new NonemptyListNode("hello", new NonemptyListNode("CS", new NonemptyListNode("Peeps")));
		String StringOfEmpty1 = "(hello CS Peeps)";
	
		System.out.println(nonEmpty1.toString());

		nonEmpty1.toString();
		
		assertEquals(nonEmpty1.toString(), StringOfEmpty1);
		
	}
	

	
	
	
}
	