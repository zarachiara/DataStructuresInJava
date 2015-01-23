import junit.framework.TestCase;


public class MeasurementTest extends TestCase 
{
	public void testInit() // Testing constructor without argument
	{
		Measurement m = new Measurement();
		assertTrue (m.feet == 0);
		assertTrue (m.inches == 0);
	}
	
	public void testInit1() // Testing constructor with 1 argument
	{
		Measurement m = new Measurement(6);
		assertTrue (m.feet == 6);
		assertTrue (m.inches == 0);
	}
	
	public void testInit2() // Testing constructor with 2 arguments
	{
		Measurement m = new Measurement(6,2);
		assertTrue (m.feet == 6);
		assertTrue (m.inches == 2);
	}
	
	public void testPlus() // Testing method plus
	{
		Measurement m1 = new Measurement(3,2); // Simple addition
		Measurement m2 = new Measurement(4,5);
		m1 = m1.plus(m2);
		assertTrue (m1.feet == 7);
		assertTrue (m1.inches == 7);
		
		Measurement m3 = new Measurement(3,5); // Addition that has inches overflow
		Measurement m4 = new Measurement(4,10);
		m3 = m3.plus(m4);
		assertTrue (m3.feet == 8);
		assertTrue (m3.inches == 3);
		
		Measurement m5 = new Measurement(6,5); // Addition that has inches overflow
		Measurement m6 = new Measurement(3,7); // inches adds up exactly to 12
		m5 = m5.plus(m6);
		assertTrue (m5.feet == 10);
		assertTrue (m5.inches == 0);
		
		Measurement m7 = new Measurement(0,1); // Addition with just inches
		Measurement m8 = new Measurement(0,10);
		m7 = m7.plus(m8);
		assertTrue (m7.feet == 0);
		assertTrue (m7.inches == 11);
		
	}
	
	public void testMinus() // Testing method Minus
	{
		Measurement m1 = new Measurement(3,2); // Simple Subtraction
		Measurement m2 = new Measurement(1,1);
		m1 = m1.minus(m2);
		assertTrue (m1.feet == 2);
		assertTrue (m1.inches == 1);	
		
		Measurement m3 = new Measurement(5,5); // Subtraction that requires extra inches from foot
		Measurement m4 = new Measurement(4,7);
		m3 = m3.minus(m4);
		assertTrue (m3.feet == 0);
		assertTrue (m3.inches == 10);
		
		Measurement m5 = new Measurement(6,5); // Inches cancel out
		Measurement m6 = new Measurement(3,5);  
		m5 = m5.minus(m6);
		assertTrue (m5.feet == 3);
		assertTrue (m5.inches == 0);
		
		Measurement m7 = new Measurement(0,11); // Subtraction with just inches
		Measurement m8 = new Measurement(0,4); 
		m7 = m7.minus(m8);
		assertTrue (m7.feet == 0);
		assertTrue (m7.inches == 7);	
	}
	
	public void testMultiple() // Testing method Minus
	{
		Measurement m1 = new Measurement(4,2); // Simple Multiplication
		m1 = m1.multiple(2);
		assertTrue (m1.feet == 8);
		assertTrue (m1.inches == 4);	
		
		Measurement m2 = new Measurement(3,10); // Multiplication with inches overflow
		m2 = m2.multiple(3);
		assertTrue (m2.feet == 11);
		assertTrue (m2.inches == 6);
		
		Measurement m3 = new Measurement(0,7); // Multiplication with just inches
		m3 = m3.multiple(3);
		assertTrue (m3.feet == 1);
		assertTrue (m3.inches == 9);	
	}
	
	public void testtoString()
	{
		Measurement m1 = new Measurement(); // Constructor with no arguments
		assertTrue(m1.toString().equals("0\'0\""));
		
		Measurement m2 = new Measurement(3); // Constructor with 1 argument
		assertTrue(m2.toString().equals("3\'0\""));
		
		Measurement m3 = new Measurement(5,7); // Constructor with 2 arguments
		assertTrue(m3.toString().equals("5\'7\""));
		
		Measurement m4 = new Measurement(6,11); // Constructor with 2 arguments, value is 2-digit long
		assertTrue(m4.toString().equals("6\'11\""));
	}
}
