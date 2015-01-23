public class InsertionSort {
    
    /*METHODS:
        1. insert
        2. isOk
        3. insertionSort
    */

    /* insert
        Precondition: elements 0 through k-1 of list are in increasing order.
        Postcondition: elements 0 through k of list are in increasing order. */
    public static void insert (int list[], int k) {
    /* int val = list[k];  
     int newindex = 0;
     
     for (int i=0; i<k ;i++) {
         if (val < list[i]) {
             for (int j = k; j > newindex; j -= 1) {
                 list[j] = list[j-1];
             }
             list[i] = val;
             break;
         }
         newindex = i;
     }
     */
        ///////////////////////////
        // more intuitive option //
        ///////////////////////////
        int key = 0; // the value to be inserted in its proper position  
        int i = 0; // going backwards of sorted values 
        int unsorted = 0; // unsorted indices 
        for (k =1, unsorted = k; k < list.length; k++, unsorted++) 
        {
            key = list[unsorted]; // first unsorted key is the value after the length of k.  Since k starts at 1, just use k 
            for (i = k-1; (i >= 0 && list[i] > key); i--)
            {
                list[i + 1] = list[i]; // shifts from decreasing to increasing
                
            }
            list[i + 1] = key; // places value of key to its proper position. 
        }
    }

    /* isOk
        Does nothing when the first k elements of LIST are sorted in
        increasing order.
        Throws an IllegalStateException otherwise.
    */
    public static void isOK (int[] list, int k) 
    {
        for (int i = 0; i < k; i++) 
        {
            if (list[i] > list[i+1]) 
            {
                throw new IllegalStateException();
            }
        }
    }

     /* insertionSort
        the entire procedure of the class: it makes a copy of an unsorted array and then sorts it.
        Insert is a subprocedure of InsertionSort (refer to its precondition and postcondition to see what it does) that uses isOK to enforce its precondition.
    */
    public static int[] insertionSort(int[] list) 
    {
        int[] rtn = new int[list.length]; // creates an array rtn with the same length as list
        for (int k = 0; k < list.length; k++) 
        {
            rtn[k] = list[k]; // copies contents of list to rtn.  We are now able to manipulate rtn without mutating list
        }
        for (int k = 0; k < rtn.length; k++) 
        {
            insert(rtn, k); // insert method 
            // finds an exception and catches if it is present 
            try 
            { 
                isOK(rtn, k);
            } catch (IllegalStateException e) 
            {
                System.err.println("inconsistency at position " + k);
            }
        }
        return rtn; 
    }
    
    public static void main (String[] args) {
        int[] list = {3, 1, 7, 4, 5, 9, 2, 8, 6}; // create a test array 
        list = insertionSort(list); // run insertion list
        for (int k = 0; k < list.length; k++) {
            System.out.print(list[k]); // print every part of the array
        }
        System.out.println();
    }

}