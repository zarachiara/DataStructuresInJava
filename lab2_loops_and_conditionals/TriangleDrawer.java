import java.io.*;
public class TriangleDrawer 
{
// The code is missing two assignment statements.
	public static void main (String [] args) 
	{
		int row = 0;
		int SIZE = 10;
		while (row < SIZE) 
		{	
			// System.out.println(row + "rowb4");
			int col = 0; // need this because must restart column on next row 
			while (col <= row) 
			{
				System.out.print ('*');
				col = col + 1;
			}
			System.out.println ( );
			row = row + 1; 
			// System.out.println(row + "row");
		}
	}
}    

/* Tips and Tricks 
	1. Learning how to Role Play with code. 
	2. <= v. < ..when in a while loop, think about which one should hit and then move on. 
		ie. col <= row makes sense because for each row there is exactly a maximum of the same # of columns such that in row2, there are 2column* 
	3. Starting at an initialize integer 0 makes counting complicated. Basically think as the first loop with value 0 as 1.  This occurs in arrays too when the length starts at 1, but indices start at 0. Pay attention! 
*/ 