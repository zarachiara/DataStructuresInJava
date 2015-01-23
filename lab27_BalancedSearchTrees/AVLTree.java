public class AVLTree {

    private int myItem;
    private AVLTree myLeft;
    private AVLTree myRight;
    private int myBalanceFactor;    // Use this only if you feel you find it convenient

    // Constructor for an AVLTree with one item
    // Don't worry about the empty AVLTree case
    public AVLTree(int item) {
        myItem = item;
        myLeft = null;
        myRight = null;
        myBalanceFactor = 0;
    }

    // Maintains the binary search tree invariants
    // Also maintains the height-balanced invariant
    public void insert(int item) {
    	if (item < myItem) {
    		// increment balanceFactor
    		myBalanceFactor += 1;
    		// if the left branch is null, create a newAVL tree with the item 
    		if (myLeft == null) {
    			myLeft = new AVLTree(item);
    		// if not null, recursively call until it is null 
    		} else {
    			myLeft.insert(item);
    		}
    	// if item is greater than myItem 
    	} else {
    		// decrement the balanceFactor because this means that it is getting closer, 
    		// to balancing with the left tree
    		myBalanceFactor -= 1;
    		// if right is null, create a new AVL tree with the item 
    		if (myRight == null) {
    			myRight = new AVLTree(item);
    		// else recursively call until right is null. 
    		} else {
    			myRight.insert(item);
    		}
    	}
    	// if balanceFactor is greater than one
    	if (myBalanceFactor > 1) {
    		// rotate to right 
    		rotateRight();
    	// if less than -1, rotate left
    	} else if (myBalanceFactor < -1) {
    		rotateLeft();
    	}
    	// if 0, dont do anything
    }
    
    // Helper methods 
    
    /*
     * Consists of 
     * 		1. height()
     * 		2. rotateRight()
     * 		3. rotateLeft()
     * 		4. toString()
     * 		5. toString() helper
     */
    
    public int height() {
    	// if myLeft is null and myRight is null, return 0 
    	if (myLeft == null && myRight == null) {
    		return 0;
    	// if myLeft is null, 
    	} else if (myLeft == null) {
    		// return 1 + recursive call of myRight. 
    		return 1 + myRight.height();
    	} else if (myRight == null) {
    		// return 1 + recursive call to myLeft
    		return 1 + myLeft.height();
    	} else {
    		// find the max of both myRight and myLeft
    		return 1 + Math.max(myRight.height(), myLeft.height());
    	}
    }
    
    public void rotateRight() {
    	// create an AVLTree called temp 
    	AVLTree temp = new AVLTree(this.myItem);
    	// set temp.myRight to myRight
    	temp.myRight = myRight;
    	// if the left child of the right is not null 
    	if (myLeft.myRight != null) {
    		// doesnt make sense to me: shouldn't this be 
    		// temp..myLeft.myRight = myRight.myleft ?
    		// rotate right so that myLeft is now myRight
    		temp.myLeft = myLeft.myRight;
    	}
    	// assigning left
    	AVLTree left = myLeft.myLeft;
    	// assigning the root
    	myItem = myLeft.myItem;
    	myRight = temp;
    	// why did you have to repeat yourself here? 
    	myLeft = left;
    }
    
    public void rotateLeft() {
    	// create an AVLTree called temp with myItem as root 
    	AVLTree temp = new AVLTree(myItem);
    	// set temp.myLeft to be myLeft 
    	temp.myLeft = myLeft;
    	// if myRight.myleft is not null, we want to make it the
    	// right child of the new left child
    	if (myRight.myLeft != null) {
    		// temp.myRight.myLeft = myLeft.myRight
    		temp.myRight = myRight.myLeft;
    	}
    	// assigning right 
    	AVLTree right = myRight.myRight;
    	// assigning the root 
    	myItem = myRight.myItem;
    	myLeft = temp;
    	myRight = right;
    }
    
    
    public String toString() {
        return toStringHelper(this, "");
    }

    private String toStringHelper(AVLTree subTree, String soFar) {
        String toReturn = "";
        if (subTree.myRight != null) {
            toReturn += toStringHelper(subTree.myRight, "    " + soFar);
        }
        toReturn += "\n" + soFar + subTree.myItem + "\n";
        if (subTree.myLeft != null) {
            toReturn += toStringHelper(subTree.myLeft, "    " + soFar);   
        }
        return toReturn;
    }
}