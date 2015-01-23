import java.lang.reflect.Array;
import java.util.*;

/**
 * Class containing all the sorting algorithms.
 * 
 * You may add any number instance variables and instance methods 
 * to your Sorting Algorithm classes. 
 * You may also override the no-argument constructor, but please
 * only use the no-argument constructor for each of the Sorting 
 * Algorithms, as that is what will be used for testing.
 * 
 */
public class MySortingAlgorithms {

	/**
	 * Java's Sorting Algorithm.
	 * DO NOT USE THIS in your implementation.
	 * DO NOT USE Arrays.SORT in your implementation.
	 * 
	 * This algorithm may be helpful for testing.
	 */
	// returns truncated part of sort
	public static class JavaSort implements Sorting {
		@Override
		public int[] sort(int[] array, int k) {
			// sorts array in ascending order 
			Arrays.sort(array);
			// creates a new array with length k. 
			int[] truncated = new int[k];
			//System.arraycopy(array, 0, truncated, 0, k);
			for (int i = 0 ; i < k; i++)
			{
				truncated[i] = array[i];
			}
			return truncated;
		}
	}
	
//	public static void main(String[] args)
//	{
//		JavaSort B = new JavaSort(); 
//		int[] a = {4, 3, 2, 1};
//		System.out.println(a[0] + "," + a[1] + "," + a[2] + "," + a[3]);
//		
//		int[] newArray = B.sort(a, 3);
//		for (int i = 0; i < newArray.length; i++) {
//		  System.out.println(newArray[i] + " ");
//		}	
//	}
	
	// insertion sort
	public static class InsertionSort implements Sorting {
		@Override
		public int[] sort(int[] ary, int k) {
			int sorted = 0; 
			int key = 0; 
			int i = 0; 
			for(sorted = 1; sorted < ary.length; sorted++)
			{
				key = ary[sorted];
				for (i = sorted-1; (i >=0 && ary[i] > key); i--)
				{
					ary[i+1] = ary[i]; 
				}
				ary[i+ 1] = key; 
			}
			int[] ret = new int[k];
			for (int j = 0; j < k; j++)
			{
				ret[j] = ary[j];
			}
			return ret; 
		}
		@Override
		public String toString() {
			return "Insertion Sort";
		}	
	}
	
//	public static void main(String[] args)
//	{
//		InsertionSort B = new InsertionSort(); 
//		int[] a = {4, 3, 2, 1};
//		System.out.println(a[0] + "," + a[1] + "," + a[2] + "," + a[3]);
//		
//		int[] newArray = B.sort(a, 3);
//		for (int i = 0; i < newArray.length; i++) {
//		  System.out.println(newArray[i] + " ");
//		}	
//	}
	
	/**
	 * Selection Sort for small K should be more efficient
	 * than for larger K
	 */
	public static class SelectionSort implements Sorting {
		
		@Override
		public int[] sort(int[] ary, int k) {
			for (int i = ary.length-1; i> 0; i--)
			{
				int latestPos = 0; 
				for (int j =1; j <= i; j++)
				{
					if (ary[latestPos] < ary[j])
					{
						latestPos = j;
					}
				}
				// swapping occurs 
				if (i != latestPos && ary[latestPos] != ary[i])
				{
					int temp = ary[i];
					ary[i] = ary[latestPos];
					ary[latestPos] = temp;		
				}
			}
			// take the minimum values of ary up to k 
			int[] ret = new int[k];
			for (int m = 0; m < k; m++)
			{
				ret[m] = ary[m];
				
			}
			return ret; 		
		}
		@Override
		public String toString() {
			return "Selection Sort";
		}
	}
	
//	public static void main(String[] args)
//	{
//		SelectionSort B = new SelectionSort(); 
//		int[] a = {4, 3, 2, 1};
//		System.out.println(a[0] + "," + a[1] + "," + a[2] + "," + a[3]);
//		
//		int[] newArray = B.sort(a, 3);
//		for (int i = 0; i < newArray.length; i++) {
//		  System.out.println(newArray[i] + " ");
//		}	
//	}

	
	public static class MergeSort implements Sorting {
		private int[] numbers; 
		private int[] helper; 
		private int number; 
		//@Override
		public int[] sort(int[] ary, int k) {
			this.numbers = ary; 
			number = ary.length; 
			this.helper = new int[number]; 
			ary = mergesort(0, number-1);
			return ary; 
		}
		
		private int[] mergesort(int low, int high) {
		    // check if low is smaller then high, if not then the array is sorted
		    if (low < high) {
		      // Get the index of the element which is in the middle
		      int middle = low + (high - low) / 2;
		      // Sort the left side of the array
		      mergesort(low, middle);
		      // Sort the right side of the array
		      mergesort(middle + 1, high);
		      // Combine them both
		      helper.merge(low, middle, high);
		    }
		  }
		
		private int[] merge(int low, int middle, int high) {

		    // Copy both parts into the helper array
		    for (int i = low; i <= high; i++) {
		      helper[i] = numbers[i];
		    }

		    int i = low;
		    int j = middle + 1;
		    int k = low;
		    // Copy the smallest values from either the left or the right side back
		    // to the original array
		    while (i <= middle && j <= high) {
		      if (helper[i] <= helper[j]) {
		        numbers[k] = helper[i];
		        i++;
		      } else {
		        numbers[k] = helper[j];
		        j++;
		      }
		      k++;
		    }
		    // Copy the rest of the left side of the array into the target array
		    while (i <= middle) {
		      numbers[k] = helper[i];
		      k++;
		      i++;
		    }
		   return helper;

		  }
		
		
//			int first = ary.length/2; 
//			int last = ary.length - first;  
//			ary = mergeHelper(ary, first, last); 
//			System.out.println(ary[0] + "aryy");
//			
//			int[] ret = new int[k];
//			for (int m = 0; m < k; m++)
//			{
//				ret[m] = ary[m];
//				
//			}
//			return ret; 
//		}
//		
//		public static int[] mergeHelper(int[] ary, int first, int last)
//		{
//			int[] recurse1 = new int[first + last];
//			int[] recurse2 = new int[first + last];
//			if (first < last)
//			{
//				int mid = (first + last)/ 2; 
//				recurse1 = mergeHelper(ary, first, mid); 
//				recurse2 = mergeHelper(ary, mid+1, last); 
//				mergerStep(ary, recurse1, first, mid, last);
//				mergerStep(ary, recurse2, first, mid, last);
//				System.out.println(ary[0] + "aryy");
//			}
//			return ary; 
//			//merger(sort(part1, k),sort(part2, k));
//		}
//				
//		public static int[] mergerStep(int[] ary, int[] tempArray, int first, int mid, int last)
//		{
//			int firstHalf = first; 
//			int firstEnd =  mid;
//			int secondHalf = mid+1; 
//			int secondEnd = last; 
//			int index = 0; 
//			
//			while ((firstHalf <= firstEnd) && (secondHalf <= secondEnd))
//			{
//				if (ary[firstHalf] < ary[secondHalf])
//				{
//					tempArray[index] = ary[firstHalf];
//					firstHalf++; 
//				}
//				else
//				{
//					tempArray[index] = ary[secondHalf];
//					secondHalf++;
//				}
//				index++;
//			}
//			return tempArray; 
//		}
		
			// version with NO helpers 
//			int halfLength = ary.length/2; 
//			System.out.println("firstHalfLength: " + halfLength);
//			int restOfLength = ary.length- halfLength;
//			System.out.println("rest of Length: " + restOfLength);
//			int[] firstArr = new int[halfLength];
//			// splitting up arr into two separate arrays
//			for (int i = 0; i<= halfLength-1; i++)
//			{
//				firstArr[i] = ary[i];
//				System.out.println(firstArr[i] + " firstArr");
//			}
//			
//
//			int[] restArr = new int[restOfLength];
//			for (int j = restOfLength-1, restIndex = 0; j <= ary.length-1; j++, restIndex++)
//			{
//				restArr[restIndex] = ary[j];
//				System.out.println(restArr[restIndex] + "rest of Arr");
//			}
//			int firstArrSize = firstArr.length; 
//			System.out.println("firstArrSize: " + firstArrSize);
//			int restArrSize = restArr.length; 
//			System.out.println("restArrSize " + restArrSize);
//			int[] mergeArr = new int[ary.length];
//			int newIndex = 0; 
//			int indexA = 0; 
//			int indexB = 0; 
//			while (indexA < firstArrSize && indexB <= restArrSize)
//			{	
//				if (firstArr[indexA] < restArr[indexB])
//				{
//					mergeArr[newIndex] = firstArr[indexA];
//					indexA++; 
//				}
//				else 
//				{
//					mergeArr[newIndex] = restArr[indexB];
//					indexB++; 
//	
//				}
//				newIndex++;
//			}
//			//Copy the rest 
//			while (indexA < firstArrSize)
//			{
//				mergeArr[newIndex] = firstArr[indexA];
//				indexA ++; 
//				newIndex++; 
//			}
//			while(indexB < restArrSize)
//			{
//				mergeArr[newIndex] = restArr[indexB];
//				indexB++; 
//				newIndex++; 
//			}
//			System.out.println(mergeArr[0] + "test");
//			System.out.println(mergeArr[1] + "test");
//			System.out.println(mergeArr[2] + "test");
//			System.out.println(mergeArr[3] + "test");
//			return mergeArr;		
		// may want to add additional methods

		@Override
		public String toString() {
			return "Merge Sort";
		}
		
	}
	
	public static void main(String[] args)
	{
		MergeSort B = new MergeSort(); 
		int[] a = {4, 3, 2, 1, 5, 8, 0};
		
		int[] newArray = B.sort(a, 3);
		for (int i = 0; i < newArray.length; i++) 
		{
			System.out.println(newArray[i] + " ");
		}
	}	

	
	public static class RadixSort implements Sorting {
		@Override
		public int[] sort(int[] ary, int k) {
			// largest place for a 32 bit int is the 1 billionth place
			for ( int i = 1; i <= 1000000000; i*=10)
			{
				// use conting sort to place the values in the 
				// correct digit bucket
				ary = countingSort(ary, i);
			}
			return ary;
		}
		
		// this works like the voteIterator problem from 
			// midterm1!!
		private static int[] countingSort(int[] ary, int place){
	        
			int[] out = new int[ary.length];
			
	        int[] bucket = new int[10];
	        
	        // loop through the whole length
	        for(int i=0; i < ary.length; i++){
	        	// get the digit place of the array 
	            int digit = getDigit(ary[i], place);
	            // increment the value of the digit place in count
	            bucket[digit] += 1;
	        }
	        // adds the total number of digits stored in the last element 
	        for(int i=1; i < bucket.length; i++){
	            bucket[i] += bucket[i-1];
	        }
	 
	        // placing numbers based on digit ascending order to out
	        for(int i = ary.length-1; i >= 0; i--){
	            int digit = getDigit(ary[i], place);
	 
	            out[bucket[digit]-1] = ary[i];
	            bucket[digit]--;
	        }
	        return out;
	 
	    }
		 
	    private static int getDigit(int value, int digitPlace){
	        return ((value/digitPlace ) % 10);
	    }
				
//			public int[] sort(int[] array, int k) {
//			// why didnt you just make max 0?
//		    int max = Integer.MIN_VALUE;
//		    // place the value of array as max 
//		    for (int i = 0; i < array.length; i ++) {
//		    	if (array[i] > max) {
//		    		max = array[i];
//		    	}
//		    }
//		    //concatenate max length to get the digits. 
//		    //the first digit is the length
//		    int digits = String.valueOf(max).length();
	}
		
		
		/////////////////////
		// FILIP's VERSION //
		/////////////////////
//		public int[] sort(int[] array, int k) {
//			// why didnt you just make max 0?
//		    int max = Integer.MIN_VALUE;
//		    // place the value of array as max 
//		    for (int i = 0; i < array.length; i ++) {
//		    	if (array[i] > max) {
//		    		max = array[i];
//		    	}
//		    }
//		    //concatenate max length to get the digits. 
//		    //the first digit is the length
//		    int digits = String.valueOf(max).length();
//		    for (int i = 0; i < digits; i++) {
//		    	// sorts the array by base
//		        array = sortByBase(array, i);
//		    }    
//		    if (k < array.length) {
//		    	int [] kary = new int[k];
//		    	for (int i = 0; i < k; i++) {
//		    		kary[i] = array[i];
//		    	}
//		    	return kary;
//		    } else {
//		    	return array;
//		    }
//		}
//		// helper method for radixSort
//			// sorts the values by their digits 
//		public int[] sortByBase(int[] ary, int base) {
//			// create return array that has values sorted by base 
//			int[] rtn = new int [ary.length];
//			// bucket contains 10 length.  Where you will store values first 
//			int[] buckets = new int [10];
//			// loop through the length of the array 
//			for (int i = 0; i < ary.length; i++) {
//				// digit is the base of the ary value 
//				int digit = getDigit(ary[i], base);
//				// increase the digit 
//				buckets[digit]++;
//				System.out.println(buckets[digit] + "bucketttt");
//			}
//			for (int i = 1; i < buckets.length ; i++) {
//				buckets[i] += buckets[i-1];
//			}
//			for (int i = ary.length-1; i >= 0; i--) {
//				int digit = getDigit(ary[i], base);
//				rtn[buckets[digit]-1] = ary[i];
//				buckets[digit]--;
//			}
//			return rtn;
//		}
//		
//		// helper method for radixSort
//			// sorts the values by their digits 
//		public int getDigit(int num, int base) {
//			return (int) ((num/(Math.pow(10, base))) % 10);
//		}
//	}
		
	
//	public static void main(String[] args)
//	{
//		RadixSort B = new RadixSort(); 
//		int[] a = {1234, 1243, 1222, 1301, 1435, 2358, 8770};
//		
//		int[] newArray = B.sort(a, 3);
//		for (int i = 0; i < newArray.length; i++) {
//		  System.out.println(newArray[i] + " ");
//		}	
//	}
//	
	
	
}



