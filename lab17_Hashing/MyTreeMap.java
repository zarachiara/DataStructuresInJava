import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyTreeMap<K extends Comparable<K>, V> implements Map<K, V> {
//    public MapNode myRoot;
	private MapNode myRoot; 
    @Override
    public V get(Object key) {
    	if (myRoot == null)
    	{
    		throw new IllegalArgumentException("Key is not in the tree map");
    	}
    	else
    	{
    		return myRoot.get(key);
    	}
    }
    
    @Override
    public V put(K key, V value) {
        // TODO To be implemented.
    	if (myRoot == null)
    	{
    		myRoot = new MapNode (key, value, null); // create a new mapNode for insertion to the whole map
    		return null;
    	}
    	else
    	{
    		return myRoot.put(key, value);
    	}
    }
    
    @Override
    public boolean containsKey(Object key) {
        // TODO To be implemented.
        if(myRoot == null)
        {
        	return false;
        }
        else
        {
        	return myRoot.containsKey(key);
        }
    }
    
    @Override
    public boolean containsValue(Object value) {
        // TODO To be implemented.
        if(myRoot == null)
        {
        	return false;
        }
        else
        {
        	return myRoot.containsValue(value);
        }
    }
    
    @Override
    public boolean isEmpty() {
        // TODO To be implemented.
        if(myRoot == null)
        {
        	return true;
        }
        return myRoot.isEmpty(); 
    }

    @Override
    public int size() {
        if (myRoot != null)
        {
        	return myRoot.mySize; 
        }
    	return 0;
    }

    @Override
    public V remove(Object key) {
        // TODO To be implemented.
        if (size() == 1 && myRoot.myKey.equals(key))
        {
        	myRoot = null;
        }
        else if (containsKey(key))
        {
        	return myRoot.remove(key);
        }
        return null;
    }

    // The methods below do not need to be implemented for the homework.
    // They are provided only to satisfy the Map interface.
    
    @Override
    public Collection<V> values() {
        // No Need to implement this method for the homework.
        // This method is provided to satisfy the Map interface.
        return null;
    }
    
    @Override
    public void clear() {
        // No Need to implement this method for the homework.
        // This method is provided to satisfy the Map interface.
    }
    
    @Override
    public Set<K> keySet() {
        // No Need to implement this method for the homework.
        // This method is provided to satisfy the Map interface.
        return null;
    }
    
    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        // No Need to implement this method for the homework.
        // This method is provided to satisfy the Map interface.
    }
    
    @Override
    public Set<java.util.Map.Entry<K, V>> entrySet() {
        // No Need to implement this method for the homework.
        // This method is provided to satisfy the Map interface.
        return null;
    }
    
    private class MapNode {
    	private K myKey; // myKey 
    	private V myValue; // myValue 
    	private MapNode myLeft; // left node
    	private MapNode myRight; // right node
    	private MapNode myParent; // keeps track of parent 
    	private int mySize; // size function 
    	
    	private MapNode(K key, V value)
    	{
    		myKey = key; 
    		myValue = value; 
    		myLeft = null;
    		myRight = null;
    		mySize = 1; // starts at the root
    	}
    	
    	private MapNode(K key, V value, MapNode parent)
    	{
    		myKey = key; 
    		myValue = value; 
    		myLeft = null;
    		myRight = null;
    		myParent = parent; 
    		mySize = 1; // starts at the root
    	}
    	
    	private V get(Object key)
    	{
    		// base case 
    		if (myKey == key)
    		{
    			return myValue; 
    		}
    		// looking through the left; 
    		else if (((Comparable<K>)key).compareTo(myKey) < 0)
    		{
    			if (myLeft == null)
    			{
    				throw new IllegalArgumentException("key is not in the tree map");
    			}
    			return myLeft.get(key);
    		// looking through the right 
    		}else{
    			if (myRight == null){
    				throw new IllegalArgumentException("key is not in the tree map");
    			}
    			return myRight.get(key);
    		}			
    	}
    	
//    	private V remove(K key)
//    	{
//    		
//    	}
    	
    	private V put(K key, V value)
    	{
    		// if left and right nodes are empty, add to the root the key and value 
    		if (myLeft == null && myRight == null)
    		{	
    			if (value == myValue )
    			{
    				if (myKey.compareTo(key) == 0)
    				{	V oldMyParentValue = myParent.myValue; 
	        			myParent.myValue = value; 
	        			return oldMyParentValue;
    				}
    				if (myKey.compareTo(key) < 0)
    				{
    					myLeft.myValue = value; 
    					myLeft.myKey = key; 
    					return null;
    				}
    				myRight.myValue = value; 
    				myRight.myKey = key; 
    				return null;
    			}
    		}
    		// if key and myKey are the same, replace with new value and
    		//return the old
    		if (key.compareTo(myKey) == 0)
    		{	
    			V oldmyValue = myValue; 
    			myValue = value; 
    			return oldmyValue;
    		}
    		
    		// if key is greater than myKey, recurse to the right 
    		if (key.compareTo(myKey) > 0)
    		{
    			if (myRight == null)
    			{
    				myRight = new MapNode(key ,value, this);
    				mySize++;
    				System.out.println();
    			}
    			if(myRight.put(key, value) == null)
    			{
    				mySize++;
    			}
    			
    		}
    		// if the key is less than myKey, recurse to the left
    		else
    		{
    			if (myLeft == null)
    			{
    				myLeft = new MapNode(key, value, this);
    				mySize++;
    			}
    			
    			if (myLeft.put(key, value) == null)
    			{
    				mySize ++;
    			}
    			
    		}
    		return null;
    	}
    	
    	private boolean containsKey(Object key)
    	{
    		// base case 
    		if (myKey == key)
    		{
    			return true; 
    		}
    		// casting key to a comparable and comparing to myKey and going through the 
    		// right side of the tree 
    		else if (((Comparable<K>)key).compareTo(myKey) < 0)
    		{
    			if (myLeft == null)
    			{
    				return false;
    			}
    			return myLeft.containsKey(key);
    		// going through the right side of the tree. 
    		}else{
    			if (myRight != null){
    				return myRight.containsKey(key);
    			}
    			return false;	
    		}
    	}
    	
    	private boolean containsValue(Object value)
    	{
    		// base case 
    		if (myValue.equals(value))
    		{
    			return true; 
    		}
    		// if only contains a root 
    		else if (myLeft != null && myRight != null)
    		{
    
    			return myLeft.containsValue(value) || myRight.containsValue(value);
    		}
    		else if (myRight != null)
    		{
    			return myRight.containsValue(value);
    			
    		}
    		else if(myLeft != null)
    		{
    			return myLeft.containsValue(value); 
    			
    		}
    		else
    		{
    			return false;
    		}
    	}
    	
        private boolean isEmpty() {
            // TODO To be implemented.
            if (myValue == null)
            {
            	return true; 
            }
            return false; 
        }
        
//        private int size(int count)
//        { 
//        	int i = count; 
//        	if (myLeft == null && myRight == null)
//        	{
//        		return i; 
//        	}
//        	if (myLeft != null)
//        	{
//        		myLeft.size(count + 1); 
//        	}
//        	if (myRight != null);
//        	{
//        		myRight.size(count + 1); 
//        	}
//        	System.out.println(count + "countttt");
//        	return i; 
//        	
//        }
 
    }

    
    public static void main(String[] args)
    {
    	// test mapNode constructor 
    	MyTreeMap<String,Integer> t = new MyTreeMap();
		t.myRoot = t.new MapNode("b", 2);
		System.out.println(t.myRoot.myKey);
		System.out.println(t.myRoot.myValue);
		MyTreeMap<String,Integer> t1 = new MyTreeMap();
		t1.myRoot = t1.new MapNode("b", 2);
		
		// test put
		t1.put("c", 5); // adds a new mapNode to the right 
		System.out.println(t1.myRoot.myRight.myKey.equals("c"));
		System.out.println(t1.myRoot.myRight.myValue.equals(5));
		t1.put("a", 6); // adds a new mapNode to the left
		System.out.println(t1.myRoot.myLeft.myKey.equals("a"));
		System.out.println(t1.myRoot.myLeft.myValue.equals(6));
		t1.put("b", 4); // replaces the value of "b" to 4
		System.out.println(t1.myRoot.myValue.equals(4)); 
		t1.put("f", null); // program doesnt crash if value is null
		//System.out.println(t1.myRoot.myRight.myRight.myValue); 
		//t1.put(null, null); // causes a nullPointer exception when key is null
		t1.put("g", 19);
		
		// test get 
		System.out.println(t1.get("b")); // should return 4 
		System.out.println(t1.get("a")); // should be 6
		//	System.out.println(t1.get("z")); // exception error
		
		// test size()
		System.out.println(t1.size() + "t1 size"); 
		System.out.println(t.size() + "t1 size");
		
		// test containsKey 
		System.out.println(t1.containsKey("b")); //true
		System.out.println(t1.containsKey("c")); //true 
		System.out.println(t1.containsKey("a")); //true
		System.out.println(t1.containsKey("f")); //true
		System.out.println(t1.containsKey("g")); //true
		System.out.println(t1.containsKey("z")); //false 
		
		// test containsValue 
//		System.out.println(t1.containsValue(2)); // changed value of 2 so nullPointerException
//		System.out.println(t1.containsValue(5));
//		System.out.println(t.containsValue(2));
		
		
		// test isEmpty 
		MyTreeMap<String,Integer> empty = new MyTreeMap();
		System.out.println(empty.isEmpty()); // true.
		System.out.println(t1.isEmpty());
	
		// test remove 
		
    	
    }

}

