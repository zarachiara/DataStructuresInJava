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

    public void fillSampleTree1() {
        myRoot = new TreeNode("a", 
        			new TreeNode("b"), new TreeNode("c"));
        System.out.println("####fillSampleTree1()#####");
        System.out.println(); 
        System.out.println("Height is " + myRoot.height() + "; should be 4"); // should be 2; 
        System.out.println();
        System.out.println("Complete?? " + myRoot.isCompletelyBalanced() + "; Should be true");
        System.out.println();
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
        System.out.println(); 
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
        
        private int height() 
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
    }
}