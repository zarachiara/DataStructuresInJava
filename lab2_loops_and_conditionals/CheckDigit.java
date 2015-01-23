public class CheckDigit {

    public static void main (String [ ] args) {
        int id = 0;
        // esception for non-zero inputs. 
        try {
            id = Integer.parseInt (args[0]);
        } catch (NumberFormatException e) {
            System.out.println ("The argument has to be a sequence of digits.");
            System.exit (1);
        }
        boolean isLegal = true;
        // your missing code goes here
        int digit = id % 10; // deals with the last digit of id that we need to keep track of
        int sum = 0; // sum of all digits 
        int remainder = id/10; // keep cutting out the last digit 
        while (remainder != 0)
        { 
            sum += remainder % 10; // take last digit 
            remainder = remainder/10; // keep cutting out the last digit and add to sum 
        }
        if (sum% 10 != digit) // compares sum of digits and last digit of ID 
        {
            isLegal = false; // if not the same it is false. 
        }
        if (isLegal) {
            System.out.println (id + " is legal");
        } else {
            System.out.println (id + " is not legal");
        }
    }
}
/*  Tricks Discoveered: 
     % 10= use to manipulate the integer's last digit   
    / 10= use to manipulate an integer's number except for its last digit
*/

