import junit.framework.TestCase;
import java.util.*;


public class BinaryTreeTest extends TestCase {
	// InorderIterator tests
	public void testInorderIterator1() {
		BinaryTree<String> t = new BinaryTree<String>();
		t = t.fillSampleTree1();
		Iterator i = t.new InorderIterator();
		assertTrue(i.hasNext());
		assertTrue("b".equals(i.next()));
		assertTrue("a".equals(i.next()));
		assertTrue("c".equals(i.next()));
		assertFalse(i.hasNext());
	}
	public void testInorderIterator2() {
		BinaryTree<Integer> t = new BinaryTree<Integer>();
		t.myRoot = t.new TreeNode(8, t.new TreeNode(2, t.new TreeNode(1), t.new TreeNode(5)), t.new TreeNode(11, t.new TreeNode(9, null, t.new TreeNode(10)), null));
		Iterator i = t.new InorderIterator();
		assertTrue(i.hasNext());
		assertEquals(1,i.next());
		assertEquals(2,i.next());
		assertEquals(5,i.next());
		assertTrue(i.hasNext());
		assertEquals(8,i.next());
		assertEquals(9,i.next());
		assertEquals(10,i.next());
		assertEquals(11,i.next());
		assertFalse(i.hasNext());
	}
	
	// Inorder and Preorder array Constructor tests
	public void testBinaryTreeConstructor() {
		ArrayList<String> preorder = new ArrayList<String>();
		preorder.add("A");
		preorder.add("B");
		preorder.add("C");
		preorder.add("D");
		preorder.add("E");
		preorder.add("F");
		ArrayList<String> inorder = new ArrayList<String>();
		inorder.add("B");
		inorder.add("A");
		inorder.add("E");
		inorder.add("D");
		inorder.add("F");
		inorder.add("C");
		BinaryTree t = new BinaryTree(preorder, inorder);
		t.printPreorder();
		t.printInorder();
	}
}
