import java.util.NoSuchElementException;
import java.util.*;
abstract public class AbstractListNode {
	
    abstract public Comparable item();
    abstract public AbstractListNode next();
    abstract public boolean isEmpty();

    // Every other list-processing method goes here.
    abstract public int size();
    abstract public Comparable get(int pos);
    abstract public String toString();
    abstract public boolean equals(Object obj);
    
    public Comparable smallest() {
    	if (isEmpty()) {
    		throw new NoSuchElementException ("can't find smallest in empty list");
    	}
    	return this.next().smallestHelper(this.item());
   	}
   	public Comparable smallestHelper (Comparable smallestSoFar) {
   		if (this.isEmpty()) {
   			return smallestSoFar;
   		} else if (this.item().compareTo(smallestSoFar) < 0) {
    		return smallestHelper(this.item());
    	} else {
    		return smallestHelper(smallestSoFar); 
    	}
   	}
   	public static Comparable min (Comparable c1, Comparable c2) {
    	if (c1.compareTo (c2) < 0) {
    		return c1;
    	} else {
    		return c2;
    	}
    } 
   	
   	abstract public void setItem(Comparable obj);
   	abstract public void setNext(AbstractListNode insert);
   	abstract public AbstractListNode add(Comparable x);
   	abstract public AbstractListNode append(AbstractListNode list);
   	abstract public AbstractListNode reverse();
   	
   	public static AbstractListNode merge(AbstractListNode a, AbstractListNode b ) {
   		if (a.isEmpty()) {
   			return b;
   		} else if (b.isEmpty()) {
   			return a;
   		}

        AbstractListNode head;
        AbstractListNode point1;
        AbstractListNode point2;

        if (a.item().compareTo(b.item()) < 0) {
            head = a;
        } else {
            head = b;
            b = a;
            a = head;

        }

        
        AbstractListNode currPoint;
        while (!a.next().isEmpty() && !b.isEmpty()) {
            if (a.next().item().compareTo(b.item()) < 0) {
                a = a.next();
            } else {
                point1 = a.next();
                point2 = b.next();
                currPoint = b;
                b = b.next();
                currPoint.setNext(point1);
                a.setNext(currPoint);
                a = currPoint;

            }
        }
        AbstractListNode tail;
        a.setNext(b);
        return head;
   	}
   	
   	public static AbstractListNode mergeAll(ArrayList<AbstractListNode> allLinkedLists) { 
      	if (allLinkedLists.size() == 1) {
            return allLinkedLists.get(0);
        }
   		return mergeRec(allLinkedLists,0,allLinkedLists.size());
   	}


    private  static AbstractListNode mergeRec(ArrayList<AbstractListNode> allLinkedLists, int start, int end) {
            if (end - 1 == start) {
                return allLinkedLists.get(start); 
            } else if (end - 2 == start) {
                return merge(allLinkedLists.get(start), allLinkedLists.get(start+1));
            } else {
                return merge(mergeRec(allLinkedLists,start,(start+end)/2),mergeRec(allLinkedLists, (start+end)/2, end));
            }


    }

}

class NonemptyListNode extends AbstractListNode {

    private Comparable myItem;
    private AbstractListNode myNext;

    public NonemptyListNode (Comparable item, AbstractListNode next) {
        myItem = item;
        if (next == null) {
            myNext = new EmptyListNode();
        } else {
            myNext = next;
        }
    }

    public NonemptyListNode (Comparable item) {
        this (item, new EmptyListNode());
    }

    public Comparable item() {
        return myItem;
    }

    public AbstractListNode next() {
        return myNext;
    }
    
    public boolean isEmpty() {
        return false;
    }
    
    public int size() {
    	return 1 + this.next().size();
    }
    
    public Comparable get(int pos) {
    	int length = this.size() - 1;
    	if (this.size() == 0) {
    		throw new IllegalArgumentException ("List is empty");
    	}
    	if (pos > length) {
    		throw new IllegalArgumentException ("Position is out of range");
    	} else if (pos == 0) {
    		return this.item();
    	} else {
    		return this.next().get(pos-1);
    	}
    }

    public String toString() {
    	int length = this.size() - 1;
    	AbstractListNode curNode = this;
    	String makeString = "( " + curNode.item() + " ";
    	for (int i = 0; i < length; i++)
		{
			curNode = curNode.next(); 
			makeString += curNode.item() + " "; 
		}
		return makeString + ")";
    }
    
    
    public boolean equals(Object obj) {
    	AbstractListNode curNode = this; 
    	if (obj instanceof AbstractListNode) {
    		AbstractListNode castValue = (AbstractListNode) obj;
    		if (this.size() == castValue.size()) {
    			for (int i = 0; i < size(); i++) {
    				if (!(curNode.item().toString().equals(castValue.item().toString()))) {
    					return false; //not same item value
    				}
    				curNode = curNode.next();
    				castValue = castValue.next();
    			}
    			return true; //went through all items, and all same
    		}
    		return false; //not same size
    	}
    	return false; //not a NonemptyListNode
    }
    
    public void setItem(Comparable obj) {
    	this.myItem = obj;
    }
    
   	public void setNext(AbstractListNode insert) {
   		this.myNext = insert;
   	}
   	
   	public AbstractListNode add(Comparable x) {
   		NonemptyListNode newList = new NonemptyListNode(this.myItem, this.myNext.add(x));
   		return newList;
   	}
   	
   	public AbstractListNode append(AbstractListNode list) {
   		NonemptyListNode newList = new NonemptyListNode(this.myItem, this.myNext.append(list));
   		return newList;
   	}
   	
   	public AbstractListNode reverse() {

   		AbstractListNode first = new NonemptyListNode(this.item());
   		AbstractListNode rest = this.next();
   		if (rest.isEmpty()) {
   			return first;
   		}
   		AbstractListNode rev = rest.reverse();
   		rev = rev.add(first.item());
   		return rev;
   	}
}

class EmptyListNode extends AbstractListNode {
    
    public EmptyListNode() {
        
    }
    
    public Comparable item() {
        throw new IllegalArgumentException ("There is no 'item' value stored in an EmptyListNode.");
    }
    
    public AbstractListNode next() {
        throw new IllegalArgumentException ("No elements follow an EmptyListNode.");
    }
    
    public boolean isEmpty() {
        return true;
    }
    
    public int size() {
    	return 0;
    }
    
    public Comparable get(int pos) {
    	return null;
    }
    
    public String toString() {
    	return "()";
    }
    
    public boolean equals(Object obj) {
    	return (obj instanceof EmptyListNode);
    }

    public void setItem(Comparable obj) {
    	return;
    }
    
   	public void setNext(AbstractListNode insert) {
   		return;
   	}
   	
   	public AbstractListNode add(Comparable x) {
   		NonemptyListNode before = new NonemptyListNode(x, this);
   		return before;
   	}
   	
   	public AbstractListNode append(AbstractListNode list) {
   		return list;
   	}
    
   	public AbstractListNode reverse() {
   		return new EmptyListNode();
   	}
}

   	