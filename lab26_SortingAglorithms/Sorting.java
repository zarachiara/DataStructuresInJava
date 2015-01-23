/**
 * A sorting algorithm (e.g. Selection Sort, Insertion Sort, etc.)
 * that implements a single sort method.
 */
public interface Sorting {

	/**
	 * Given an unsorted array ARY, returns a new array
	 * of length K containing the minimum K elements of ARY
	 * in sorted ascending order.
	 * 
	 * It is OK if this method changes the contents of ARY,
	 * though it is not necessary. A correct method only
	 * relies on the fact that the returned array contains
	 * the minimum K elements in sorted ascending order.
	 * 
	 * Precondition: K <= ARY.LENGTH
	 */
	int[] sort(int[] ary, int k);
	
	
}