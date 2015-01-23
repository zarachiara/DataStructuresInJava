public class Measurement 
{
	
	int feet;
	int inches;

	/*
	 * Constructor: initialize this object to be a measurement of 0 feet, 0
	 * inches.
	 */
	public Measurement() 
	{
		this.feet = 0;
		this.inches = 0;
	}

	/*
	 * Constructor: takes a number of feet as its single argument, using 0 as
	 * the number of inches
	 */
	public Measurement(int feet) 
	{
		this.feet = feet;
		this.inches = 0;
	}

	/*
	 * Constructor: takes the number of feet in the measurement and the number
	 * of inches as arguments (in that order), and does the appropriate
	 * initialization
	 */
	public Measurement(int feet, int inches) 
	{
		this.feet = feet;
		this.inches = inches;
	}

	/*
	METHODS: 
	1. plus 
	2. minus
	3. multiple
	*/ 



	/*
	 * plus
	 Adds the argument m2 to the current measurement
	*/
	public Measurement plus(Measurement m2) 
	{
		Measurement m = new Measurement(); // Create new Object
		m.inches = inches;
		m.feet = feet;
		
		m.inches = m.inches + m2.inches; // if inches is less than 11. 
		if(m.inches >= 12) // Inches Max = 12 in display. 1 feet = 12 inches. 
		{
			// subtract to inches and convert to feet. 
			m.inches = m.inches - 12; 
			m.feet = m.feet + 1;
		}
		m.feet = m.feet + m2.feet;
		
		return m;
	}



	/*
	 * minus
	 Subtracts the argument m2 from the current measurement. You may assume
	 * that m2 will always be smaller than the current measurement.
	*/
	public Measurement minus(Measurement m2) 
	{
		Measurement m = new Measurement(); // Create new Object
		m.inches = inches;
		m.feet = feet;
		
		if(m.inches < m2.inches) // Case where you can't subtract inches without borrowing from feet
		{
			m.inches = m.inches + 12;
			m.feet = m.feet - 1;
		}
		m.inches = m.inches - m2.inches;
		m.feet = m.feet - m2.feet;
		
		return m; 
	}



	/* multiple:
	 * Takes a nonnegative integer argument n, and returns a new object that
	 * represents the result of multiplying this object's measurement by n. For
	 * example, if this object represents a measurement of 7 inches, multiple
	 * (3) should return an object that represents 1 foot, 9 inches.
	 */
	public Measurement multiple(int multipleAmount) 
	{
		Measurement m = new Measurement(); // Create new Object
		m.inches = inches;
		m.feet = feet;
		
		int totalFeet = m.feet*12 + m.inches; // Convert entire thing to inches
		int newTotalFeet = totalFeet * multipleAmount; // Multiply
		
		m.feet = newTotalFeet/12; // Convert back to feet and inches.
		m.inches = newTotalFeet%12;
		
		return m; // provided to allow the file to compile
	}



	/*
	 * toString should return the String representation of this object in the
	 * form f'i" that is, a number of feet followed by a single quote followed
	 * by a number of inches less than 12 followed by a double quote (with no
	 * blanks).
	 */
	public String toString() 
	{
		return new String(feet + "\'" + inches + "\"");
	}

}