public class Date implements Comparable<Date> {
    
    // You may need to change the modifiers of the instance variables below
    int month;
    int dayOfMonth;
    int year;
    
    public Date(int month, int dayOfMonth, int year) {
        this.month = month;
        this.dayOfMonth = dayOfMonth;
        this.year = year;
    }
    
    /**
     *  Assume the date is well-formed.
     *  If the current date occurs before ARG, return -1
     *  If the current date is the same day as ARG, return 0
     *  Otherwise, return 1
     */
    @Override
    public int compareTo(Date ARG) {
        if (year < ARG.year)
        {
        	return -1;
        }
        else if( year > ARG.year)
        {
        	return 1;
        }
      
        else{
        	if (dayOfMonth < ARG.dayOfMonth)
        	{
        		return -1; 
        		
        	}
        	else if (dayOfMonth > ARG.dayOfMonth)
        	{
        		return 1; 
        	}
        	else
        	{
        		if (dayOfMonth < ARG.dayOfMonth)
        		{
        			return -1;
        		}
        		else if(dayOfMonth > ARG.dayOfMonth)
        		{
        			return 1;
        		}
        		else
        		{
        			return 0; 
        		}
        	}
        	
        }     	
    }

    
    @Override
    public boolean equals(Object o) {
        // TODO to be implemented
        return o instanceof Date && month == ((Date)o).month && dayOfMonth == ((Date)o).dayOfMonth && year == ((Date)o).year;
    }
}