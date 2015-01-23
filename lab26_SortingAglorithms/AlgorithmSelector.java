

public interface AlgorithmSelector {

	/**
	 * Based upon the array contents in ARY and K, selects
	 * an efficient sorting algorithm. Do not modify the 
	 * contents of ARY.
	 * 
	 * @param ary	An unsorted array
	 * @param k		The minimum k elements of ARY we are interested
	 * 				in sorting
	 * @return The algorithm to be used for searching array.
	 * 			
	 */
	public Sorting chooseSortingAlgorithm(int[] ary, int k);
	
}