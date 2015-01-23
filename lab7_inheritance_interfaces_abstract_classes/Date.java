import java.util.*;
public class Date implements Comparable<Date>
{
	int month;
	int day; 

	public Date(int theMonth, int theDay) {
        day = theDay; 
        month = theMonth;
    }	

    public String toString() 
    {
        return "" + month + "/" + day;
    }

    public int compareTo(Date compDate) {
   		
    	if (this.month < compDate.month) {
    		return -1;
    	} else if (this.month > compDate.month) {
    		return 1;
    	} else  {
    		if (this.day < compDate.day) {
    			return -1;
    		} else if (this.day > compDate.day) {
    			return 1;
    		} else {
    			return 0; // if month and day are the same
    		}
    	}
        //compare month of this and compDate
        //compare day of this and compDate
        //return int
        //-1
    }

	public static void main (String [ ] args) 
	{	
		Date[] dArray = new Date[4]; 
        
		dArray[0] = new Date (5, 2); // 5/2 
		dArray[1] = new Date (2, 9); // 2/9 
		dArray[2] = new Date (6, 3); // 6/3 
		dArray[3] = new Date (1, 11); // 1/11 
		Arrays.sort (dArray); 
		for (int k=0; k<dArray.length; k++) 
		{
		  System.out.println(dArray [k]);
	    } 
		// should print the dates in chronological order: 
		// 1/11, 2/9, 5/2, 6/3
	}
}