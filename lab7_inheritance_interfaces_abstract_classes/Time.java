public class Time {

    private int myHours;
    private int myMinutes;
    
    public Time (String s) {
    	if (s == null) {
    		throw new NullPointerException("String is null");
    	}
        int colonPos = s.indexOf (":");
        
        for (char letter : s.toCharArray()) {
        	if (letter == ' ') {
        		throw new IllegalArgumentException("Space in time format");
        	}
        }
        
        if (colonPos == 0) {
        	throw new IllegalArgumentException("Bad time formatting!");
        } else if (colonPos > 2) {
        	throw new IllegalArgumentException("Too many digits in hours!");
        } else if (s.length() - 1 -colonPos > 2) {
        	throw new IllegalArgumentException("Too many digits in minutes!");
        } 
        
        myHours = Integer.parseInt (s.substring (0, colonPos));
        myMinutes = Integer.parseInt (s.substring (colonPos+1));
        if (myHours > 12) {
        	throw new IllegalArgumentException("Hours out of range");
        } else if (myMinutes > 59) {
        	throw new IllegalArgumentException("Minutes out of range");
        } else if (s.length() > 2 && colonPos == 2) {
        	throw new IllegalArgumentException("too few leading zeroes in the minutes");
        } else if (s.length() - 1 == colonPos + 1) {
        	throw new IllegalArgumentException("no minute digits");
        }
        
    }
    
    public Time (int hours, int minutes) {
        myHours = hours;
        myMinutes = minutes;
    }

    public boolean equals (Object obj) {
        Time t = (Time) obj;
        return myHours == t.myHours && myMinutes == t.myMinutes;
    }

    public String toString() {
        if (myMinutes < 10) {
            return myHours + ":0" + myMinutes;
        } else {
            return myHours + ":" + myMinutes;
        }
    }

    

    
}