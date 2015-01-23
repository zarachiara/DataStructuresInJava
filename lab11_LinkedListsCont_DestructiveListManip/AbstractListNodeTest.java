import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;


public class AbstractListNodeTest {

	@Test
	public void testEmptyListNodeConstructor() {
		//creates EmptyListNode
		EmptyListNode empty = new EmptyListNode(); 
		//tests that .item() errors
		try {
			empty.item();
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
		//tests that .next() errors
		try {
			empty.next();
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}	
		//tests if isEmpty returns true
		boolean state = empty.isEmpty(); 
		assertTrue(state == true);
	}
	
	@Test
	public void testNonemptyListNodeConstructor() {
		//creates 3 NonemptyListNodes
		NonemptyListNode nonEmpty = new NonemptyListNode("hello", new NonemptyListNode("CS", new NonemptyListNode("Peeps")));
		//tests that next Node is not empty
		assertTrue(nonEmpty.next() instanceof NonemptyListNode);
		
		boolean state = nonEmpty.isEmpty(); 
		assertTrue(state == false);
		//test next() of each link list node 
		assertTrue(nonEmpty.item() == "hello");
		assertTrue(nonEmpty.next().item() == "CS");
		assertTrue(nonEmpty.next().next().item() == "Peeps");
		
		//tests that 4th node is empty
		assertTrue(nonEmpty.next().next().next() instanceof EmptyListNode);
		try	{
			nonEmpty.next().next().next().item();
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
		
		try	{
			nonEmpty.next().next().next().next();
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void testSize() {
		//creates empty ListNode
		EmptyListNode empty = new EmptyListNode();
		assertTrue(empty.size() == 0);
		
		//creates 1 NonemptyListNodes
		NonemptyListNode nonEmpty1 = new NonemptyListNode("sup");
		assertTrue(nonEmpty1.size() == 1);
		
		//creates 3 NonemptyListNodes
		NonemptyListNode nonEmpty3 = new NonemptyListNode("hello", new NonemptyListNode("CS", new NonemptyListNode("Peeps")));
		assertTrue(nonEmpty3.size() == 3);	
	}
	
	@Test
	public void testGet() {
		//creates empty ListNode
		EmptyListNode empty = new EmptyListNode();
		try {
			empty.get(0); //errors because list is empty
		} catch (IllegalArgumentException e) {
			System.err.println (e.getMessage());
		}
		
		//creates 1 NonemptyListNodes
		NonemptyListNode nonEmpty1 = new NonemptyListNode("sup");
		assertTrue(nonEmpty1.get(0) == "sup");
		try {
			nonEmpty1.get(1);
		}  catch (IllegalArgumentException e) {
			System.err.println (e.getMessage());
		}
		
		//creates 3 NonemptyListNodes
		NonemptyListNode nonEmpty3 = new NonemptyListNode("hello", new NonemptyListNode("CS", new NonemptyListNode("Peeps")));
		assertTrue(nonEmpty3.get(0) == "hello");	
		assertTrue(nonEmpty3.get(1) == "CS");
		assertTrue(nonEmpty3.get(2) == "Peeps");
		try {
			nonEmpty1.get(3);
		}  catch (IllegalArgumentException e) {
			System.err.println (e.getMessage());
		}
	}
	
	@Test
	public void testToString() {
		//creates empty ListNode
		EmptyListNode empty = new EmptyListNode();
		assertTrue(empty.toString() == "()");
		
		//creates 1 NonemptyListNodes
		NonemptyListNode nonEmpty1 = new NonemptyListNode("sup");
		assertTrue(nonEmpty1.toString().equals("( sup )"));
		
		//creates 3 NonemptyListNodes
		NonemptyListNode nonEmpty3 = new NonemptyListNode (1, new NonemptyListNode (3, new NonemptyListNode (5)));
		assertTrue(nonEmpty3.toString().equals("( 1 3 5 )"));
	}
	
	@Test
	public void testEquals() {
		//test empty ListNode
		EmptyListNode empty = new EmptyListNode();
		EmptyListNode emptyTest = new EmptyListNode();
		NonemptyListNode nonEmptyempty = new NonemptyListNode("sup");
		assertTrue(empty.equals(emptyTest));
		assertFalse(empty.equals(nonEmptyempty)); //compared to NonemptyListNode
		
		//test 1 NonemptyListNode
		NonemptyListNode nonEmpty1 = new NonemptyListNode("sup");
		NonemptyListNode nonEmpty1Test = new NonemptyListNode("sup");
		NonemptyListNode nonEmpty1False = new NonemptyListNode("cat");
		NonemptyListNode nonEmpty1False1 = new NonemptyListNode("sup", new NonemptyListNode("cat"));
		assertTrue(nonEmpty1.equals(nonEmpty1Test));
		assertFalse(nonEmpty1.equals(nonEmpty1False)); //not same value
		assertFalse(nonEmpty1.equals(nonEmpty1False1)); //too long
		assertFalse(nonEmpty1.equals(empty)); //compared to empty list
		
		//test 3 NonemptyListNode with int
		NonemptyListNode nonEmpty3 = new NonemptyListNode (1, new NonemptyListNode (3, new NonemptyListNode (5)));
		NonemptyListNode nonEmpty3Test = new NonemptyListNode (1, new NonemptyListNode (3, new NonemptyListNode (5)));
		NonemptyListNode nonEmpty3False = new NonemptyListNode (1, new NonemptyListNode (3, new NonemptyListNode (5, new NonemptyListNode (7))));
		NonemptyListNode nonEmpty3False1 = new NonemptyListNode (1, new NonemptyListNode (3, new NonemptyListNode (4)));
		NonemptyListNode nonEmpty3False2 = new NonemptyListNode (1, new NonemptyListNode (2, new NonemptyListNode (5)));
		NonemptyListNode nonEmpty3False3 = new NonemptyListNode (0, new NonemptyListNode (3, new NonemptyListNode (5)));
		assertTrue(nonEmpty3.equals(nonEmpty3Test));
		assertFalse(nonEmpty3.equals(empty)); //compared to empty list
		assertFalse(nonEmpty3.equals(nonEmpty3False)); //too long
		assertFalse(nonEmpty3.equals(nonEmpty3False1)); //not same value at end
		assertFalse(nonEmpty3.equals(nonEmpty3False2)); //not same value at middle
		assertFalse(nonEmpty3.equals(nonEmpty3False3)); //not same value at beginning
		
		//test 3 NonemptyListNode with String
		NonemptyListNode nonEmpty = new NonemptyListNode("hello", new NonemptyListNode("CS", new NonemptyListNode("Peeps")));
		NonemptyListNode nonEmptyTest = new NonemptyListNode("hello", new NonemptyListNode("CS", new NonemptyListNode("Peeps")));
		NonemptyListNode nonEmptyFalse = new NonemptyListNode("hello", new NonemptyListNode("cat", new NonemptyListNode("Peeps")));
		assertTrue(nonEmpty.equals(nonEmptyTest));
		assertFalse(nonEmpty.equals(empty)); //compared to empty list
		assertFalse(nonEmpty.equals(nonEmptyFalse)); //not same value
	}
	
	@Test
	public void testAdd() {
		AbstractListNode l1 = new EmptyListNode();
		AbstractListNode l2 = l1.add("a");
		assertEquals("( a )", l2.toString());
		AbstractListNode l3 = l2.add("b");
		assertEquals("( a b )", l3.toString());
		assertEquals("( a )", l2.toString());
	} 
	
	@Test
	public void testAppend() {	
		// append two NonemptyList nodes 
		NonemptyListNode append1 = new NonemptyListNode(1, new NonemptyListNode (2 , new NonemptyListNode (3)));
		NonemptyListNode append2 = new NonemptyListNode(4, new NonemptyListNode (5 , new NonemptyListNode (6)));
		NonemptyListNode append3 = new NonemptyListNode(1, new NonemptyListNode (2 , new NonemptyListNode (3, new NonemptyListNode (4, new NonemptyListNode (5, new NonemptyListNode (6)) ))));
		assertEquals(append1.append(append2), append3);
		
		// list is empty 
		EmptyListNode list = new EmptyListNode(); 
		NonemptyListNode nonEmpty = new NonemptyListNode(1, new NonemptyListNode (2 , new NonemptyListNode (3)));
		assertEquals(list.append(nonEmpty), nonEmpty);
		
		// argument is empty 
		NonemptyListNode list1 = new NonemptyListNode(1, new NonemptyListNode (2 , new NonemptyListNode (3)));
		EmptyListNode empty = new EmptyListNode(); 
		assertEquals(list1.append(empty), list1);
		
		// the argument and this list remain the same.
		NonemptyListNode list2 = new NonemptyListNode(2, new NonemptyListNode (4 , new NonemptyListNode (6)));
		NonemptyListNode arg2 = new NonemptyListNode(8, new NonemptyListNode (10 , new NonemptyListNode (12)));
		AbstractListNode append = list2.append(arg2);
		assertEquals(list2.toString(), "( 2 4 6 )");
		assertEquals(arg2.toString(), "( 8 10 12 )");
		assertEquals(list2.append(arg2), append);
	}
	
	@Test
	public void testReverse() {
		// reverse a list 
		NonemptyListNode list1 = new NonemptyListNode(1, new NonemptyListNode (2 , new NonemptyListNode (3)));
		AbstractListNode reverse1 = list1.reverse(); 
		assertEquals(reverse1.toString(), "( 3 2 1 )");
		
		// reverse a list with Strings
		NonemptyListNode list = new NonemptyListNode("hi", new NonemptyListNode ("hello" , new NonemptyListNode ("sup")));
		AbstractListNode reverse = list.reverse(); 
		assertEquals(reverse.toString(), "( sup hello hi )");
		
		// reverse an empty list 
		EmptyListNode list2 = new EmptyListNode(); 
		assertEquals(list2.reverse(), list2);
	}
	

	@Test
	public void testMerge()
	{
		// merge 2 nonempty lists 
		NonemptyListNode list1 = new NonemptyListNode(1, new NonemptyListNode (2 , new NonemptyListNode (3)));
		NonemptyListNode list2 = new NonemptyListNode(4, new NonemptyListNode (5 , new NonemptyListNode (6)));
		NonemptyListNode list3 = new NonemptyListNode(1, new NonemptyListNode (2 , new NonemptyListNode (3 , new NonemptyListNode (4, new NonemptyListNode (5, new NonemptyListNode (6) )))));
		assertEquals(AbstractListNode.merge(list1, list2) , list3);
		
		// merge 1 nonempty  list and an empty list 
		NonemptyListNode list8 = new NonemptyListNode(1, new NonemptyListNode (1 , new NonemptyListNode (2)));
		EmptyListNode list4 = new EmptyListNode(); 
		NonemptyListNode merge1 = new NonemptyListNode(1, new NonemptyListNode (1 , new NonemptyListNode (2)));
		assertEquals(AbstractListNode.merge(list8, list4),merge1);
		
		// merge 2 empty lists 
		EmptyListNode list5 = new EmptyListNode(); 
		EmptyListNode list6 = new EmptyListNode(); 
		assertEquals(AbstractListNode.merge(list5, list6), list5);
		assertEquals(AbstractListNode.merge(list5, list6), list6);
		
		NonemptyListNode list10 = new NonemptyListNode(1, new NonemptyListNode (3 , new NonemptyListNode (5)));
		NonemptyListNode list11 = new NonemptyListNode(2, new NonemptyListNode (4 , new NonemptyListNode (6)));
		NonemptyListNode list12 = new NonemptyListNode(1, new NonemptyListNode (2 , new NonemptyListNode (3 , new NonemptyListNode (4, new NonemptyListNode (5, new NonemptyListNode (6) )))));
		assertEquals(AbstractListNode.merge(list10, list11) , list12);


	}
	
	@Test
	public void testMergeAll() {
		// merge with 3 nonEmptyListNodes in an ArrayList;  
		ArrayList<AbstractListNode> merge1 = new ArrayList<AbstractListNode>();
		merge1.add(0, new NonemptyListNode(1, new NonemptyListNode (2 , new NonemptyListNode (3))));
		merge1.add(1, new NonemptyListNode(4, new NonemptyListNode (5 , new NonemptyListNode (6)))); 
		merge1.add(2, new NonemptyListNode(6, new NonemptyListNode (8, new NonemptyListNode (10))));
		
		AbstractListNode mergeAllList = new NonemptyListNode(1,new NonemptyListNode 
				(2, new NonemptyListNode (3, new NonemptyListNode (4, new NonemptyListNode (5, new NonemptyListNode (6, new NonemptyListNode (
							6, new NonemptyListNode (8, new NonemptyListNode (10)))))))));
		assertEquals(mergeAllList, AbstractListNode.mergeAll(merge1));
		
		
		// merge with nonemptyListNodes and an emptyListNodes in an ArrayList; 
		ArrayList<AbstractListNode> merge2 = new ArrayList<AbstractListNode>();
		merge2.add(0, new NonemptyListNode(1, new NonemptyListNode (2 , new NonemptyListNode (3))));
		merge2.add(1, new EmptyListNode()); 
		merge2.add(2, new EmptyListNode()); 
		merge2.add(3, new NonemptyListNode(2, new NonemptyListNode (4 , new NonemptyListNode (6))));
		
		AbstractListNode mergeAllList1 = new NonemptyListNode(1,new NonemptyListNode 
				(2, new NonemptyListNode (2, new NonemptyListNode (3, new NonemptyListNode (4, new NonemptyListNode (6)))))); 
		
		assertEquals(mergeAllList1, AbstractListNode.mergeAll(merge2));
		
		// merge with emptyListNodes in an ArrayList; 
		ArrayList<AbstractListNode> merge3 = new ArrayList<AbstractListNode>();
		merge3.add(0, new EmptyListNode()); 
		merge3.add(1, new EmptyListNode()); 
		merge3.add(2, new EmptyListNode()); 
	
		AbstractListNode mergeAllList3 = new EmptyListNode(); 
		assertEquals(mergeAllList3, AbstractListNode.mergeAll(merge3)); 	
	}
	
	@Test
	public void testMergeAllEfficiency() {
		ArrayList<AbstractListNode> test = new ArrayList<AbstractListNode>();
		for (int i = 0; i < 1000; i++) {
			test.add(i, makeSortedList(5000));
		}
		AbstractListNode thing;
		thing = AbstractListNode.mergeAll(test);
	}
	
	private static AbstractListNode makeSortedList(int listSize) {
		double[] nums = new double[listSize];
		for (int i = 0; i < listSize; i++) {
			nums[i] = Math.random();
		}
		Arrays.sort(nums);
		AbstractListNode sortedList = new EmptyListNode();
		for (int i = nums.length - 1; i >= 0; i--) {
			sortedList = new NonemptyListNode(new Double(nums[i]), sortedList);
		}
		return sortedList;
	} 
}