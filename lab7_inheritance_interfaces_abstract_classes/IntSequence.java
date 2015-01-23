public class IntSequence 
{

    /* INSTANCE VARIABLES 
    *////////////////////

    protected int[] myValues;   // sequence elements
    int myCount;                // number of array cells used by sequence


    /* CONSTRUCTOR
    // capacity: actual size of the array or the (temporary) maximum
    // number of elements it can hold */
    ////////////////////////////////////////////////////////////////

    public IntSequence(int capacity) 
    {
        myValues = new int[capacity];
        myCount = 0;
    }
    
     /* METHODS 
        1. isEmpty()
        2. size()
        3. elementAt
        4. add
        5. toString()
        6. insert
        7. remove
        8. contains
     *//////////////


    public boolean isEmpty() {
        if (myCount == 0) return true;
        else return false;
    }
    
    public int size() {
        return myCount;
    }
    
    public int elementAt(int pos){
        if (pos >= myCount|| pos < 0){
            System.err.println("It does not exist.");
            System.exit(1);
            return 0;
        } else {
            return myValues[pos];
        }
    }
    
    /* ADD 
        Add the argument to the sequence by placing it in the first
        unused spot in the array and incrementing the count.
        Assume that the sequence isn't full.
    *//////////////////////////////////////////////////////////////

    public void add(int toBeAdded) {
        if (myCount == myValues.length)    {
             System.err.println("It is full.");
             System.exit(1);
        } else {
            myValues[myCount] = toBeAdded;
            myCount++;
        }
    }
    
    public String toString(){
        int i;
        String a = "";
        for (i=0; i < myCount; i++)    {
            a += myValues[i];
            a += " ";
        }
        return a;
    }

    /* INSERT 
        Insert toInsert into the sequence at position insertPos,
        shifting the later elements in the sequence over to make room
        for the new element.
        Assumptions: The array isn't full, i.e. myCount < myValues.length
        Also, insertPos is between 0 and myCount, inclusive.
    */////////////////////////////////////////////////////////////////////

    public void insert(int toInsert, int insertPos) {
        
        if (myCount == myValues.length)    {
            System.err.println("It is full.");
            System.exit(1);
        } else {
            for (int k = myCount; k > insertPos; k--) {
                myValues[k] = myValues[k-1];
            }
        }
        myValues[insertPos] = toInsert;
        myCount++;
    }
    
    public void remove(int pos) {
        if (pos < 0 || pos >= myCount) {
            return;
        }
        for (int k = pos; k < myCount ; k++) {
            myValues[k] = myValues[k+1];
        }
        myValues[myCount] = 0;
        myCount--;
    }
    
    public boolean contains(int k) {
        for(int i = 0; i < myCount; i++) {
            if (k == myValues[i]) {
                return true;
            }
        }
        return false;
    }
    
}