

/**
 * Determines which sorting algorithm to use based on 
 * the contents of the array, and K.
 */
public class MyAlgorithmSelector implements AlgorithmSelector {
	
	@Override
	public Sorting chooseSortingAlgorithm(int[] ary, int k) {
		if (k < 40) {
			return MySortingAlgorithms.SelectionSort();
		} else if (k < 300) {
			return MySortingAlgorithms.InsertionSort();
		} else return MySortingAlgorithms.RadixSort();
	}

}
