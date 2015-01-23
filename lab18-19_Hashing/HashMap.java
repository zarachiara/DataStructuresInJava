
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class HashMap<K,V> implements Iterable<K> {
	private final int DEFAULT_SIZE = 30; // default size of hash map if none selected
	private float loadFactor = 0.7f; // frequency of elements the array can reach before needing resizing
	private int arraySize = DEFAULT_SIZE; // current size of the array
	private int totalRelations; // number of new KEYS in database currently
	// you may instantiate new instance variables here
	private LinkedList<HashItem>[] bucket;

	// no argument constructor
	public HashMap() {
		totalRelations = 0;	
		bucket = new LinkedList[arraySize];		
	}
	
	// the initial size of the hashMap can be set
	// here "size" refers to the size of the underlying array
	// which will hold your HashItems
	public HashMap(int initialSize) {
		arraySize = initialSize;
		totalRelations = 0;
		bucket = new LinkedList[arraySize];		
	}

	// 2 arg constructor
	// can both set initial size as well as load factor
	public HashMap(int initialSize, float lf) {
		arraySize = initialSize;
		loadFactor = lf;
		totalRelations = 0;
		bucket = new LinkedList[arraySize];		
	}
		
	// CORE FUNCTIONALITY
	///////////////////////////////////////////////////////////////////////////////////////////////////
	
	// returns whether or not a given key is in the HashMap
	// should take O(1) or more precisely amoritized constant time
	public boolean hasKey(K key) {
		boolean ret = false;
		int num = key.hashCode() % arraySize;
		// first spot to check after calling hashCode mod arraySize
		if (bucket[num] == null)
			ret = false;
		// loops through all of bucket list 
		else{
			for(int i = 0; i < bucket[num].size(); i++)
				if(bucket[num].get(i).key.equals(key)){
					ret = true;
					break;
				}
		}
		return ret;
	}
	
	// returns whether or not a given value is stored in hashMap
	// Q: what would you expect the runtime of this function to be?
	public boolean hasValue(V value) {
		boolean ret = false;	
		// go through the hash 
		for(int i = 0; i < arraySize; i++){
			// if bucket element is not null, we want to investigate 
			// the linked list with a for loop
			if(bucket[i] != null){
				for(int j = 0; j < bucket[i].size(); j++){
					if(bucket[i].get(j).value.equals(value)){
						ret = true;
						break;
					}	
				}
			}
		}
		return ret; 
	}
		
	// standard dictionary put method (see Java docs if you have questions)
	public V put(K key, V value) {
		int num;
		V ret = null;
		num = key.hashCode() % arraySize;
		// put key and value to the first hashChode mod arraySize 
		if(bucket[num] == null){
			// create a new linked list to store key and value
			bucket[num] = new LinkedList<HashItem>();
			// add the key and value but must create new object to 
			// extend linked list
			bucket[num].add(new HashItem(key, value));
			// modify number of new keys 
			totalRelations += 1;
			
		} else {
			for(int i = 0; i < bucket[num].size(); i++){
				if(bucket[num].get(i).key.equals(key)){
					// will return the previous value of the key. 
					ret = bucket[num].get(i).value;
					bucket[num].get(i).value = value;
					break;
				}
			}
			// add new key and value by creating a new hashitem. 
			bucket[num].add(new HashItem(key, value));
			//modify number of keys 
			totalRelations += 1;
		}
		return ret;
	}
		
	// standard hashMap remove method (see Java docs if you have questions)
	public V remove(K key) {
		// initialize return value to null
		V ret = null;
		// create hashmap 
		int num = key.hashCode() % arraySize;
		// if the key is in the hash 
		if(this.hasKey(key)){
			// first element of bucket has the key
			if(bucket[num].get(0).key.equals(key)){
				ret = bucket[num].remove(0).value;
				totalRelations -= 1;
			// iterate through bucket[num] to see if key exists 
			} else {
				for(int i = 1; i < bucket[num].size(); i++){
					if(bucket[num].get(i).key.equals(key)){
						ret = bucket[num].get(i).value;
						bucket[num].remove(i);
						break;
					}		
				}
			}
		}
		return ret; 
	}
	
	// standard hashMap get method (see Java docs if you have questions)
	// should take O(1) or more precisely amoritized constant time
	public V get(K key) {
		int num = key.hashCode() % arraySize;
		V ret = null;
		if(this.hasKey(key)){
			for(int i = 0; i < bucket[num].size(); i++){
				if(bucket[num].get(i).key.equals(key)){
					ret = bucket[num].get(i).value;
					break;
				}
			}
		}
		return ret;
	}
	
	// returns the number of items currently in the hashMap
	public int size() {
		return totalRelations; 
	}

	// HASHMAP ITERATOR
	// HINT: THIS IS SIMILAR TO VOTEITERATOR
	// why would you need an iterator for a hash map?
	///////////////////////////////////////////////////////////////////////////////////////////////////
	public class HashMapIterator implements Iterator<K> {
		int arrayIndex;
		int chainIndex =-1;
		int idx = 0;
		public HashMapIterator() {
			for(int i = 0; i < arraySize; i++)
				if(bucket[i] != null){
					arrayIndex = i;
					chainIndex = -1;
				}	
		}
		@Override
		public boolean hasNext() {
			if (bucket[0] == null)
			{
				return false;
			}
			else if(idx < arraySize) {
				if(chainIndex < bucket[idx].size() - 1) {
					System.out.println("inside if, chainIndex: " + chainIndex);
					return true;
				}else{
					System.out.println("in else, chainIndex: " +chainIndex);
					int temp = idx + 1;
					for(int i = temp; i < arraySize; i++)
						if(bucket[i] != null)
							return true;
						else
						{
							return false;
						}
				}
			}
			return false;
		}

		@Override
		public K next() {;
			if(hasNext() && idx < arraySize){	
				if(chainIndex < bucket[idx].size() - 1)
					chainIndex++;
				else {
					idx++;
					System.out.println("here");
					while(bucket[idx] == null){
						idx++;
					}
					chainIndex = 0;		
				}
			} 
			    if (idx < arraySize)
				   return bucket[idx].get(chainIndex).key;
			    else return null;
			
		}

		@Override
		public void remove() {
			
		if (chainIndex >= 0)
		{
//			System.out.println(chainIndex + " chainIndex in REMOVEEEEE");
//			System.out.println(idx + " idx in REMOVEEEEE");
//		System.out.println(bucket[idx].get(chainIndex).key + " PRINTTTTTTT");
			HashMap.this.remove(bucket[idx].get(chainIndex).key);
		
			if(chainIndex > 0)
			{
				chainIndex--;
			}
		
				
			else if (idx > 0)
			{
				idx--; 
				while (bucket[idx].size() == 0)
				{
					if(arrayIndex == 0)
					{
						chainIndex = -1; 
						return;
					}
					arrayIndex --; 
				}
				arrayIndex = bucket[arrayIndex].size() -1; 
			} 
			else
			{
				chainIndex = -1; 
			}
		}
		else
		{
			throw new IllegalStateException("Nothing to remove!");
		}
	
	}
}
				
		
	
	public Iterator<K> iterator() {
		return new HashMapIterator();
	}
	
	// RESIZING FUNCTIONS
	///////////////////////////////////////////////////////////////////////////////////////////////////
	// boolean helper function which indicates whether you have 
	// gone above the load factor
	public boolean aboveLoad() {
		int n = 0;
		for(int i = 0; i < arraySize; i++)
			if(bucket[i] != null)
				n += bucket[i].size();
		return (((double) totalRelations/arraySize) > loadFactor); 
	}
	
	// expands the size of the hashMap
	public void resize(int newSize) {
		LinkedList<HashItem>[] temp = bucket;
		bucket = new LinkedList[newSize];
		for(LinkedList<HashItem> L:temp){
			for(HashItem H: L){
				int num = H.hashCode() % newSize;
				if(bucket[num] == null){
					bucket[num] = new LinkedList<HashItem>();
					this.put(H.key, H.value);
				}else {
					this.put(H.key, H.value);
				}
			}
		}
		arraySize = newSize;
	}
		

	// calculates what the new size of the hashMap should be
	public int calculateNewSize() {
		return 2*arraySize; 
	}
	// Q: How do you calculate the new size and what is your reasoning behind it?
	// COMMENT HERE:
	
	
	
	// INTERNAL TESTING/INVARIANT CHECKING
	///////////////////////////////////////////////////////////////////////////////////////////////////
	// check that there are no duplicate keys
	// check that all keys are hashed to the right location
	public boolean isOk() {
		return noDuplicateKeys() && hasCorrectHashing();
	}
	
	// verifies that all entries are appropriately hashed
	public boolean hasCorrectHashing() {
		for(int i = 0; i < arraySize; i++){
			for(int j = 0; j < bucket[i].size() - 1; j++)
				if((bucket[i].get(j).key.hashCode() % arraySize) != i)
					return false;
		}
		return true; 
	}
	
	// verfies that there exists only one copy of a key 
	// for all keys in all indicies in internal array
	public boolean noDuplicateKeys() {
		ArrayList<K> keys = new ArrayList<K>();
		for(int i = 0; i < arraySize; i++){
			for(int j = 0; j < bucket[i].size()-1; j++){
				if(keys.contains(bucket[i].get(j).key))
					return false;
				else
					keys.add(bucket[i].get(j).key);
			}
		}
		return true; 
	}
		
	// rekey rehashes every key in the hashMap
	public void rekey() {
		for(int i = 0; i < arraySize; i++){
			for(HashItem hi: bucket[i]){
				this.put(hi.key, hi.value);
			}
		}
	}
	
	
	// THE HASHITEM CLASS
	///////////////////////////////////////////////////////////////////////////////////////////////////
	
	// the "node" of a hashmap. Should never be accessed out of class
	private class HashItem {
		public final K key;
		public V value;
		
		public HashItem(K inputKey, V inputValue) {
			this.key = inputKey;
			this.value = inputValue;
		}
				
		public void setValue(V val) {
			this.value = val;
		}
		
	}
	
	// FUNCTIONS FOR TESTING
	///////////////////////////////////////////////////////////////////////////////////////////////////	
	// you may add what functions you like to the public interface
	// the only constraint in that of the hashItem class
	// hashItem should NEVER be accessed/returned outside of this class
	// by extension you cannot return the internal array of the hashMap
	// provide it as an argument

	// returns the array size
	public int arraySize() {
	    return this.arraySize;
	}
	public int totalRelations(){
		return this.totalRelations;
	}
	public LinkedList getList(int i){
		return this.bucket[i];
	}
	public LinkedList<HashItem>[] getBucket() {
		return bucket;
	}
	public double getLoadFactor(){
		return loadFactor;
	}
	
	public int getIndex(V key)
	{
		return key.hashCode() % arraySize; 
	}
}
