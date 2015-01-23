
import java.util.*;

public class AddingMachine {
	public static void main (String [ ] args) {
		Scanner scanner = new Scanner (System.in);
		boolean justStarting = true;
		int total = 0;
		int subtotal = 0;
		int prevInput = -1; // added this variable.  Must be -1 to take care of a first input that is 0.
		while (true) {
			int input = scanner.nextInt(); // scanner used for user input.
			/* case 1: 
			A nonzero value should be added into a subtotal. 
			*/
			while(input != 0) {  // must be a while to loop on input until it is finally 0. 
				subtotal = subtotal+input;
				prevInput = input;
				input = scanner.nextInt();
			}
			/* case 3: 
			Two consecutive zeroes should print the total of all values input, then terminate. s 
			*/
			if(prevInput==0) {
				System.out.println("total "+total);
				return; // exit main method when prevInput is also 0. 
			}
			/* case 2: 
			A zero value should print the subtotal. 
			*/
			else {
				System.out.println("subtotal "+subtotal);
				total = total+subtotal;
				subtotal = 0; // reset
				prevInput = 0; // reset so that two zeroes (subtotal and prevInput), total will be added
			}
		}
	}
}