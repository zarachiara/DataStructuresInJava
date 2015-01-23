import java.util.Iterator;
import java.util.*;

public class BinaryTree {

    private TreeNode myRoot;

    public BinaryTree() {
        myRoot = null;
    }

    public BinaryTree(TreeNode t) {
        myRoot = t;
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
    
    public int height() 
    {
    	if (myRoot != null)
    	{
    		myRoot.height(); 
    	}
    	return 0; 
    }
    
    public boolean isCompletelyBalanced()
    {
    	if (myRoot != null)
    	{
    		myRoot.isCompletelyBalanced();
    	}
    	return true; 
    }
    
    public void print() {
    	if (myRoot != null) {
    		myRoot.print(0);
    	}
    	else
    	{
    		myRoot.print(myRoot.height());
    	}
    }


    public static BinaryTree exprTree (String s) {
        BinaryTree result = new BinaryTree();
        result.myRoot = result.exprTreeHelper (s);
        return result;
    }

    // Return the tree corresponding to the given arithmetic expression.
    // The expression is legal, fully parenthesized, contains no blanks, 
    // and involves only the operations + and *.
    
    private TreeNode exprTreeHelper (String expr) {
        if (expr.charAt (0) != '(') {
        	BinaryTree tree = new BinaryTree(); 
        	tree.print(); 
            return null;
        } else {
            // expr is a parenthesized expression.
            // Strip off the beginning and ending parentheses,
            // find the main operator (an occurrence of + or * not nested
            // in parentheses, and construct the two subtrees.
            int nesting = 0;
            int opPos = 0;
            int openCount = 0; 
            for (int k = 1; k < expr.length() - 1; k++) {
                // YOUR CODE HERE
     
            	if (expr.charAt(k) == '(')
            	{
            		openCount++;
            	}
            	else if (expr.charAt(k) == ')')
            	{
            		openCount--; 
            	}
            	else
            		if (openCount == 0 && (expr.charAt(opPos) == '*' || expr.charAt(opPos) == '+'))
	            	{
	            		opPos = k; 
	            	}
            }
            String opnd1 = expr.substring (1, opPos);
            String opnd2 = expr.substring (opPos+1, expr.length()-1);
            String op = expr.substring (opPos, opPos+1);
            System.out.println ("expression = " + expr);
            System.out.println ("operand 1 = " + opnd1);
            System.out.println ("operator = " + op);
            System.out.println ("operand 2 = " + opnd2);
            System.out.println ( );
//            // YOUR CODE HERE
            if (opnd1 != null)
            {
            	this.myLeft.exprTreeHelper(opdn1);
            }
            if (opnd2 != null)
            {
            	
            }
            	
        }
    }
    
    public void fillSampleTree1() {
        myRoot = new TreeNode("a", 
        			new TreeNode("b"), new TreeNode("c"));
        System.out.println("####fillSampleTree1()#####");
        System.out.println(); 
        System.out.println("Height is " + myRoot.height() + "; should be 4"); // should be 2; 
        System.out.println();
        System.out.println("Complete?? " + myRoot.isCompletelyBalanced() + "; Should be true");
        System.out.println();
        System.out.println("PRINTTTTT");
        this.print(); 
        System.out.println("PRINTTTTT");
    }

    public void fillSampleTree2() {
        myRoot = new TreeNode("a", 
        			new TreeNode("b", 
        					new TreeNode("d",
        							new TreeNode("e"), 
        								new TreeNode("f")), null), new TreeNode("c"));
        System.out.println("####fillSampleTree2()#####");
        System.out.println(); 
        System.out.println("Height is " + myRoot.height() + "; should be 4");
        System.out.println(); 
        System.out.println("Complete?? " + myRoot.isCompletelyBalanced() + "; Should be false");
        System.out.println("PRINTTTTT");
        this.print(); 
        System.out.println("PRINTTTTT");
    }
    
    public void fillSampleTree3()
    {
    	myRoot = 
    		new TreeNode("a", 
    				new TreeNode("b"), new TreeNode("c", 
    		    			new TreeNode("d", new TreeNode("e"), new TreeNode("f")), null));
    		
    	System.out.println("####fillSampleTree3()#####");
        System.out.println();
    	System.out.println("Height is " + myRoot.height() + "; should be 4");
    	System.out.println(); 
        System.out.println("Complete?? " + myRoot.isCompletelyBalanced() + "; Should be false");
        System.out.println(); 
    }
    
    public void fillSampleTree4()
    {
    	myRoot = new TreeNode(null);
    	System.out.println("####fillSampleTree4()#####");
        System.out.println();
    	System.out.println("Height is " + myRoot.height() + "; should be 0");
    	System.out.println(); 
        System.out.println("Complete?? " + myRoot.isCompletelyBalanced() + "; Should be true");
        System.out.println();
    }
    
    public void fillSampleTree5()
    {
    	myRoot = new TreeNode("a",
    				new TreeNode ("b"), new TreeNode("c", 
    						new TreeNode("d"), new TreeNode("e"))); 

    	System.out.println("####fillSampleTree5()#####");
    	System.out.println(); 
    	this.print(); 
    	
    	
    }
    
    public static void main(String[] args) {
        BinaryTree t;
        t = new BinaryTree();
        print(t, "the empty tree");
        t.fillSampleTree1();
        print(t, "sample tree 1");
        t.fillSampleTree2();
        print(t, "sample tree 2");
        t.fillSampleTree3(); 
        print(t, "sample tree 3"); 
        t.fillSampleTree4(); 
        print(t, "sample tree 4"); 
        t.fillSampleTree5();
        print(t, "sample tree 5"); 
    }

    private static void print(BinaryTree t, String description) {
        System.out.println(description + " in preorder");
        t.printPreorder();
        System.out.println(description + " in inorder");
        t.printInorder();
        System.out.println();
    }

    private static class TreeNode {

        public Object myItem;
        public TreeNode myLeft;
        public TreeNode myRight;
        private static final String indent1 = "    ";

      

        public TreeNode(Object obj) {
            myItem = obj;
            myLeft = myRight = null;
        }

        public TreeNode(Object obj, TreeNode left, TreeNode right) {
            myItem = obj;
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
        
        public int height() 
        {
        	TreeNode left = this.myLeft; 
        	TreeNode right = this.myRight; 
        	int countLeft = 0; 
        	int countRight = 0; 
        	if (this.myItem == null)
        	{
        		return 0; 
        	}
        	if (left == null && right == null)
        		return 1; 
        	if (left != null)
        	{
        		countLeft = countLeft + left.height();		 
        	}
        	if (right != null)
        	{
        		countRight = countRight + right.height(); 
        	}
        	if (countRight < countLeft)
        	{
        		return countLeft + 1; 
        	}
        	else
        	{
        		return countRight + 1; 
        	}
        }
        
        public boolean isCompletelyBalanced()
        {
        	TreeNode left = this.myLeft; 
        	TreeNode right = this.myRight;
        	if(this.myItem == null)
        	{
        		return true; 
        	}
        	if (left.height() == right.height())
        	{
        		return true; 
        	}
        	if (this.height() == 0 || this.height() == 1)
        	{
        		return true; 
        	}
        	else
        	{
        		return false; 
        	}        	 
        }
        
        public void print(int indent) {
        	// YOUR CODE HERE       	
        	TreeNode right = this.myRight; 
        	TreeNode left = this.myLeft; 
        	
            if (right != null) {
                right.print(indent+1);
            }
            println(myItem, indent);
            if (left != null) {
                left.print(indent+1);
            }
        }

        private static void println (Object obj, int indent) 
        	{
        	for (int k = 0; k < indent; k++) 
        	{
        		System.out.print(indent1); // 4, 8, 12, 16
        	}
        	System.out.println (obj);
        	}
        
    }
}