public class IntSequence {

    // instance variables
    protected int[] myValues;   // sequence elements
    int myCount;                // number of array cells used by sequence

    // constructor
    // capacity: actual size of the array or the (temporary) maximum
    // number of elements it can hold
    public IntSequence(int capacity) {
        // YOUR CODE HERE
        this.capacity = myValue.length(); 

    }

    // Add the argument to the sequence by placing it in the first
    // unused spot in the array and incrementing the count.
    // Assume that the sequence isn't full.
    public void add(int toBeAdded) {
        // YOUR CODE HERE
    }

    // Insert toInsert into the sequence at position insertPos,
    // shifting the later elements in the sequence over to make room
    // for the new element.
    // Assumptions: The array isn't full, i.e. myCount < myValues.length
    // Also, insertPos is between 0 and myCount, inclusive.
    public void insert(int toInsert, int insertPos) {
        for (int k = insertPos + 1; k <= myCount; k++) {
            myValues[k] = myValues[k-1];
        }
        myValues[insertPos] = toInsert;
        myCount++;
    }


    // other methods go here

    public boolean isEmpty()
    {
        if (this.capacity == 0);
            return true; 
        else
        {
            return false;
        }
    }

    public int size()
    {   
        int count = 0; 
        for(int i = 0; i <= capacity; i++)
            if (myValues[i] != null)
                {
                    count ++;
                }   
            break; 
        return count; 
    // return Array.getLength(myValues); 
    }


    public int elementAt(int pos)
    {
        int element = 0; 
        for(int i = 0; i <=capacity; i++)
        {
            if (i == pos)
            {
                myValues[i] = element;   
            }
            else
            {
                continue;
            }
        return element; 

        }
    }


}
