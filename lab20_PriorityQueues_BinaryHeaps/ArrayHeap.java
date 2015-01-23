import java.util.ArrayList;

public class ArrayHeap {
    private ArrayList<Node> contents = new ArrayList<Node>();

    public ArrayHeap() {
        // add a blank spot for the unused index
        contents.add(null);
    }

    public void insert(int value) {
    	// call bubble up until value is greater than parent's value 
    	// add the node on the last part of the tree 
    	contents.add(new Node(value, this));
    	// move the node we just put in
    	Node toMove = getNode(contents.size()-1);
    	// so long as the node is bigger than the parent, we will bubble up
    	while(toMove.max(toMove, toMove.getParent()).equals(toMove))
    	{
    		toMove.bubbleUp(); 
    	}
    }
//    
//    
//    this.getParent() != null
//    && this.myValue > this.getParent().myValue
    

    public Node removeMax() {
    	// anything in the position 1 is the maximum node. 
        Node retRemove = getNode(1);
        // swap what we want to remove with the last node in the arrayList
        swap(getNode(1), getNode(contents.size() -1));
        // remove the last node on the list which is the max 
        contents.remove(contents.size()-1);
        
        // storing the new node on the top 
        // in the event that the last node before swapping 
        // is smaller than its childre, we want to bubble down
        Node toMove = getNode(1);
        // take the max of left and right to find the maxChild of toMove 
        Node maxChild = toMove.max(toMove.getLeft(), toMove.getRight());
        // bubble down in the event that node is smaller than its children
        while (maxChild.myValue > toMove.myValue)
        {
        	toMove.bubbleDown(); 
        	// in the event there are no children
        	if (toMove.getLeft() == null && toMove.getRight() == null)
        	{
        		break;
        	}
        	maxChild = toMove.max(toMove.getLeft(), toMove.getRight());
        }
        return retRemove; 
    }

    private Node getNode(int index) {
        if (index >= contents.size()) {
            return null;
        } else {
            return contents.get(index);
        }
    }

    private void swap(Node node1, Node node2) {
        int index1 = node1.myIndex;
        int index2 = node2.myIndex;
        node1.myIndex = index2;
        node2.myIndex = index1;
        this.contents.set(index1, node2);
        this.contents.set(index2, node1);
    }

    private class Node {
        private int myValue;
        private int myIndex;
        private ArrayHeap myTree;

        private Node(int value, ArrayHeap tree) {
            this.myValue = value;
            this.myTree = tree;
            this.myIndex = tree.contents.size()-1;
        }

        // Get the left child of this node
        private Node getLeft() {
            return this.myTree.getNode(this.myIndex * 2);
        }

        // Get the right child of this node
        private Node getRight() {
            return this.myTree.getNode(this.myIndex * 2 + 1);
        }

        // Get the parent of this node
        private Node getParent() {
            return this.myTree.getNode(this.myIndex / 2);
        }

        // Bubble up a recently added node
        private void bubbleUp() {
        	swap(this, getParent());
        }

        // Bubble down a swapped element after a call to removeMax
        private void bubbleDown() {
        	//you fill this in
        	swap(this, max(getLeft(), getRight()));
        }

        // Determine the maximum of the two children
        // Invariant: Only one of node1 and node2 can be null.
        private Node max(Node node1, Node node2) {
            if (node1 == null) {
                return node2;
            } else if (node2 == null) {
                return node1;
            } else if (node1.myValue > node2.myValue) {
                return node1;
            } else {
                return node2;
            }
        }

    }

    public static void main(String[] args) {
        ArrayHeap heap = new ArrayHeap();
        heap.insert(3);
        heap.insert(9);
        heap.insert(7);
        heap.insert(4);
        heap.insert(1);
        heap.insert(8);
        heap.insert(5);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
    }

}