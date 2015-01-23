public class Debug {

    String myString;

    public Debug (String s) {
        myString = s;
    }

    // Return true when myString is the result of inserting
    // exactly one character into s, and return false otherwise.
    public boolean contains1MoreThan (String s) {
        if (myString.length ( ) == 0) {
            return false;
        } else if (s.length ( ) == 0) {
            return myString.length ( ) == 1;
        } else if (myString.charAt(0) == s.charAt(0)) {
            Debug remainder = new Debug (myString.substring(1));
            return remainder.contains1MoreThan (s.substring(1));
        } else {
            return myString.substring(1) == s;
        }
    }

    public static void main (String [ ] args) {
        check ("abc", "def");  
        // should be false, returns false
        check ("abc2", "abc"); 
        // should be true, returns true
        check ("abc", "def");  
        // should be false, returns false
        check ("abc2", "abc"); 
        // should be true, returns true
        check ("abfc", "acb"); 
        //should be true, returns true
        check ("", "");  
        //should be false, returns false
        check ("", "a"); 
        //should be false, returns false
        check ("abc", "aabc"); 
        //should be true, but is false
        check ("abc", " ");
        // should be false, returns false
        check ("  ", "a;kejl;ja");
        // should be false, returns false
        check("a", "a "); 
        // should be true, returns true
        check (" asd", "zh98 ");
        // check (null, "c"); // crashes at runtime null exception 
        check("a ", "a"); 
        //should be true, returns true 
        check("a c  ", "a c ");
        // should be true, returns true
        check("shigrader", "higrader"); 
        //should be true, but is false
        check("canndy", "candy"); 
        //should be true, but is false
        //seems like it says it's false when it should be true if the off by one is added 
        //either in the beginning of the word, or somewhere in the middle. It does not
        // error when the change is at the end.
        check("candyy", "candy"); 
        //should be true and returns true
    }

    public static void check (String s1, String s2) {
        Debug d = new Debug (s1);
        if (d.contains1MoreThan (s2)) {
            System.out.println (s1 + " is the result of adding a single character to " + s2);
        } else {
            System.out.println (s1 + " is not the result of adding a single character to " + s2);
        }
    }
}