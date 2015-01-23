import java.io.*;
public class DateConverter {
// Given a day number in 2008, an integer between 1 and 366,
// as a command-line argument, prints the date in month/day format.
// Example:
// java DateConverter 365
// should print
// 12/30
// The code is missing two assignment statements.
	public static void main (String [] args) 
	{
		int dayOfYear = 0;
		try 
		{
			dayOfYear = Integer.parseInt (args[0]);
		} 	
		catch (NumberFormatException e) 
		{
		e.printStackTrace(); // very useful tool for diagnosing an Exception. It tells you what happened and where in the code this happened.
		}
		int month, dateInMonth, daysInMonth;
		month = 1;
		daysInMonth = 31;
		while (dayOfYear > daysInMonth) 
		{
		// *** Here is one possible place to put assignment statements.
			month ++; // added statement. Increment month before entering conditional statements
			if (month == 2) 
			{
				daysInMonth = 29;
			}
			else if (month == 4 || month == 6 || month == 9 || month == 11) 
			{
				daysInMonth = 30;
			} 
			else 
			{
				daysInMonth = 31;
			}
			dayOfYear -= daysInMonth; // complements while loop counter
		// *** Here is another possible place to put assignment statements.
		}
			dateInMonth = dayOfYear; // from computation above: dayOfYear -= daysInMonth
			System.out.println (month %12 + "/" + dateInMonth); // mont % 12 takes into consideration any day >365 repeats back to january
	}
}

/*	Tips and Tricks
		1. introduction to printStackTrace() exception - very useful to track down which method the error occured
		2. identifying edge cases: what if month given is greater than 365? 
		3. use for % - track down edge cases when a number exceeds something, it restarts. 

*/