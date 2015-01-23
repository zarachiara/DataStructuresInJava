public abstract class Date1 {

    private int myDayOfMonth;
    private int myMonth;
    private int myYear;


    /*  METHODS 
        1. Abstract METHODS: dayOfYear()
        2. dayOfMonth(), month(), year(), toString()
    */

    public abstract int dayOfYear(); // both FrenchRevolution and GregorianDate override this 

    // modified with this method: nextDate

    public abstract int nextDate(); 

    public Date(int year, int month, int dayOfMonth) {
        myDayOfMonth = dayOfMonth;
        myMonth = month;
        myYear = year;
    }

    public int dayOfMonth() {
        return myDayOfMonth;
    }

    public int month() {
        return myMonth;
    }

    public int year() {
        return myYear;
    }

    public String toString() {
        return "" + myDayOfMonth + "/" + myMonth + "/" + myYear;
    }
}

// Question 

/*
    Another approach to the organization of the date classes is to eliminate the Date class entirely, copy its concrete methods into the GregorianDate class, and have FrenchRevolutionaryDate extend the updated GregorianDate class. Would this be a better, worse, or equivalent organization? Discuss with your lab partners.

    No because Date class acts as the main abstract superclass method such that if we would like to add other dates that we can override dayOfYear method, all we would have to do is extend it to Date.java. 

*/
