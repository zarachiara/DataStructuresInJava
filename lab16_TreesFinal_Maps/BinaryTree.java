import java.util.Iterator;
import java.util.Stack;
import java.util.NoSuchElementException;
import java.util.ArrayList;

public class BinaryTree<T> implements Iterable<T> {

	protected TreeNode myRoot;

	public BinaryTree() {
		myRoot = null;
	}

	public BinaryTree(TreeNode t) {
		myRoot = t;
	}
	
	public BinaryTree(ArrayList<T> preorder, ArrayList<T> inorder)
	{
		myRoot = new TreeNode(preorder.remove(0));
		ArrayList<TreeNode> theTree = new ArrayList<TreeNode>();
		theTree.add(myRoot);
		while(!preorder.isEmpty())
		{
			if(theTree.isEmpty())
			{
				return;
			}
			TreeNode currentNode = theTree.remove(0); // the root
			int curPos = inorder.indexOf(currentNode.myItem); // takes position of currentNode in inorder. 
			ArrayList<T> left = new ArrayList<T>(); 
			for (int i = curPos-1; i >= 0; i -- )
			{
				if(!preorder.contains(inorder.get(i)))
				{
					break;
				}
				left.add(inorder.get(i));
			}
			ArrayList<T> right = new ArrayList<T>();
			for(int i = curPos + 1; i < inorder.size(); i++)
			{
				if (!preorder.contains(inorder.get(i)))
				{
					break;
				}
				right.add(inorder.get(i));
			}
			if (!left.isEmpty() && !right.isEmpty())
			{
				currentNode.myLeft = new TreeNode(preorder.remove(0));
				currentNode.myRight = new TreeNode(preorder.remove(0));
				theTree.add(currentNode.myLeft);
				theTree.add(currentNode.myRight);
			}
			else if(!left.isEmpty())
			{
				currentNode.myLeft = new TreeNode(preorder.remove(0));
				theTree.add(currentNode.myLeft);
			}
			else if(!right.isEmpty())
			{
				currentNode.myRight = new TreeNode(preorder.remove(0));
				theTree.add(currentNode.myRight);
			}
			inorder.remove(currentNode);
			{
				
			}
		}
}
	

	// Print the values in the tree in preorder: root value first,
	// then values in the left subtree (in preorder), then values
	// in the right subtree (in preorder).
	public void printPreorder() {
		if (myRoot == null) {
			System.out.println("(empty tree)");
		} else {
			myRoot.printPreorder();
			System.out.println();
		}
	}

	// Print the values in the tree in inorder: values in the left
	// subtree first (in inorder), then the root value, then values
	// in the right subtree (in inorder).
	public void printInorder() {
		if (myRoot == null) {
			System.out.println("(empty tree)");
		} else {
			myRoot.printInorder();
			System.out.println();
		}
	}

	public static BinaryTree<String> fillSampleTree1() {
		BinaryTree<String> t = new BinaryTree<String>();
		t.myRoot = t.new TreeNode("a", t.new TreeNode("b"), t.new TreeNode("c"));
		return t;
	}

	public static BinaryTree<String> fillSampleTree2() {
		BinaryTree<String> t = new BinaryTree<String>();
		t.myRoot = t.new TreeNode("a", t.new TreeNode("b", t.new TreeNode("d", t.new TreeNode("e"), t.new TreeNode("f")), null), t.new TreeNode("c"));
		return t;
	}

	public static void main(String[] args) {
		BinaryTree<String> t = new BinaryTree<String>();
		print(t, "the empty tree");
		BinaryTree<String> s = fillSampleTree1();
		print(s, "sample tree 1");
		BinaryTree<String> r = fillSampleTree2();
		print(r, "sample tree 2");
	}

	protected static void print(BinaryTree<?> t, String description) {
		System.out.println(description + " in preorder");
		t.printPreorder();
		System.out.println(description + " in inorder");
		t.printInorder();
		System.out.println();
	}

	// Method for the BinaryTree class
	public Iterator<T> iterator(){
		return new InorderIterator();
	}

	// Inner class inside of the BinaryTree class.
	// Also, it uses java.util.Iterator and java.util.Stack.
	class InorderIterator implements Iterator<T> {
		private Stack<TreeNode> nodeStack;

		public InorderIterator() {
			nodeStack = new Stack<TreeNode>();
			nodeStack.push(myRoot);
			while (nodeStack.peek().myLeft != null)
			{
				nodeStack.push(nodeStack.peek().myLeft);
			}
		}

		public boolean hasNext() {
			return !nodeStack.isEmpty();
		}
		
		public T next() {
			if (!hasNext())
			{
				throw new IllegalStateException("nothing is left");
			}
			TreeNode next = nodeStack.pop(); 
			if(next.myRight !=null)
			{
				nodeStack.push(next.myRight);
				while(nodeStack.peek().myLeft != null)
				{
					nodeStack.push(nodeStack.peek().myLeft);
				}
			}
			return next.myItem;
		}
			
			
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	protected class TreeNode {

		public T myItem;
		public TreeNode myLeft;
		public TreeNode myRight;

		public TreeNode(T item) {
			myItem = item;
			myLeft = myRight = null;
		}

		public TreeNode(T item, TreeNode left, TreeNode right) {
			myItem = item;
			myLeft = left;
			myRight = right;
		}

		private void printPreorder() {
			System.out.print(myItem + " ");
			if (myLeft != null) {
				myLeft.printPreorder();
			}
			if (myRight != null) {
				myRight.printPreorder();
			}
		}

		private void printInorder() {
			if (myLeft != null) {
				myLeft.printInorder();
			}
			System.out.print(myItem + " ");
			if (myRight != null) {
				myRight.printInorder();
			}
		}
	}
}