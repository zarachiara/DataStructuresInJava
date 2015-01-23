import java.util.*;
public class FrenchRevolutionaryDate extends Date1 {
    // In a nonleap year in the French Revolutionary Calendar,
    // the first twelve months have 30 days and month 13 has five days.
    public FrenchRevolutionaryDate(int year, int month, int dayOfMonth) {
        super(year, month, dayOfMonth);
    }

    @Override
    public int dayOfYear() {
        return (month() - 1) * 30 + dayOfMonth();
    }

    @Override
    public int nextDate(){
    	return dayOfYear() + 1;
    }

    public static void main (String [ ] args)  
    {
    	FrenchRevolutionaryDate french = new FrenchRevolutionaryDate(1, 3, 20);
    	int frenchOfYear = french.dayOfYear(); 
    	System.out.println(frenchOfYear + " is the dayOfYear");
    	int frenchDate = french.nextDate(); 
    	System.out.println(frenchDate + "nextDate");
    } 
}

