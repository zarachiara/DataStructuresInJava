import java.util.*;
import junit.framework.TestCase;


public class BinarySearchTreeTest extends TestCase {

	public void testContains()
	{
		BinarySearchTree<Integer> t = new BinarySearchTree<Integer>();
		t.myRoot = t.new TreeNode(2, t.new TreeNode(1), t.new TreeNode(3));
		t.contains(2);
		assertTrue(t.contains(3));
		assertFalse(t.contains(4));
		assertTrue(t.contains(2));
	}
	

	public void testAdd()
	{
		BinarySearchTree<Integer> t = new BinarySearchTree<Integer>();
		t.myRoot = t.new TreeNode(5, t.new TreeNode(4, t.new TreeNode(8, t.new TreeNode(7), t.new TreeNode(9)), null), t.new TreeNode(12));
		t.printInorder(); 
	}
	
	public void testIter()
	{
		// general case 
		BinarySearchTree<String> t1 = new BinarySearchTree<String>();
		t1.myRoot = t1.new TreeNode("2", t1.new TreeNode("1"), t1.new TreeNode("3"));
		Iterator i1= t1.new InorderIterator();
		assertTrue(i1.hasNext()); 
		System.out.println(i1.hasNext());
		assertTrue(i1.next().equals("1"));
		assertTrue(i1.next().equals("2"));
		assertTrue(i1.next().equals("3"));
	
		// complicated tree; not a complete binary search tree
		BinarySearchTree<String> t = new BinarySearchTree<String>();
		t.myRoot = t.new TreeNode("8", t.new TreeNode("5", t.new TreeNode("4"), t.new TreeNode("6")), t.new TreeNode("10"));
		Iterator i= t.new InorderIterator();
		assertTrue(i.hasNext()); 
		assertTrue(i.next().equals("4"));
		assertTrue(i.next().equals("5"));
		assertTrue(i.next().equals("6"));
		assertTrue(i.next().equals("8"));
		assertTrue(i.next().equals("10"));
		
		//empty null tree
		BinarySearchTree<String> t2 = new BinarySearchTree<String>();
		t2.myRoot = t.new TreeNode(null);
		Iterator i2= t2.new InorderIterator();
		assertEquals(i2.next(), null); 
		assertFalse(i2.hasNext());
	}
	
	public void testBSTarrayList()
	{
		ArrayList<String> preOrder = new ArrayList<String>();
		preOrder.add("A");
		preOrder.add("B");
		preOrder.add("C");
		preOrder.add("D");
		preOrder.add("E");
		preOrder.add("F");
		ArrayList<String> inOrder = new ArrayList<String>();
		inOrder.add("B");
		inOrder.add("A");
		inOrder.add("E");
		inOrder.add("D");
		inOrder.add("F");
		inOrder.add("C");
		BinaryTree t = new BinaryTree(preOrder, inOrder);
		t.printPreorder();
		t.printInorder();
	}
}
