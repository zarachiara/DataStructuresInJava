public class ArrayOperations {

	// Delete the value at the given position in the argument array,
	// shifting all the subsequent elements down, and storing a 0
	// as the last element of the array.
	public static void delete (int[] values, int pos) {
		if (pos < 0 || pos >= values.length) {
			return;
		}
		else
		{
			for (int i = pos; i < values.length-1; i++) {
				values[i] = values[i + 1];
			}
			values[values.length-1] = 0;
		}
	}

	
	// Insert newInt at the given position in the argument array,
	// shifting all the subsequent elements up to make room for it.
	// The last element in the argument array is lost.
	public static void insert (int[] values, int pos, int newInt) {
		if (pos < 0 || pos >= values.length) {
			return;
		} else {
			for(int i = values.length-1; pos<i; i--){
				values[i] = values[i-1]; // decrements towards position 
			}
			values[pos] = newInt; 
		}
		// YOUR CODE HERE
	}
	public static int[] zip(int[] val1 , int[] val2)
	{
		int[] temp = new int[2*val1.length];
		for (int i = 0; i < val1.length; i++) {
			temp[2*i] = val1[i];
			temp[2*i+1] = val2[i];
			
			System.out.println(temp[2*i]);
			System.out.println(temp[2*i+1]);
		}
		return temp;
	}
	
}


/*	Tips and tricks
		1. Manipulating arrays 
		2. Think about your for loops: 
			1. What are the arguments? 
			2. What should the length be and when should it stop? 
			3. When should new values be deleted? 
			4. What are the edge cases? If position < 0 || position < length
*/
