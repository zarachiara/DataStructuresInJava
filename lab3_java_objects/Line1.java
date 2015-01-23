public class Line1 
{
	int x1, y1, x2, y2;
	void printLength() 
	{
		double length;
		/* length of a line segment 
		sqrt of (x2-x1)^2 + (y2-y1)^2	
		*/
		length = Math.sqrt (pow((x2-x1),2) + (pow(y2-y1),2);
		System.out.println ("Line length is " + length);
	}

	void printAngle() 
	/*
	arctangent2 of (y2-y1, x2-x1)
	*/
	{
		double angleInDegrees = Math.atan2 (y2-y1, x2-x1) * 180.0 / Math.PI;
		System.out.println ("Angle is " + angleInDegrees + " degrees");
	}

	public static void main(String[] args) 
	{
		System.out.println ("testing Line1");
	// Set myLine to contain a reference to a new line object.
		Line1 myLine = new Line1(); 
	// Initialize myLine's x1 and y1 to the point (5, 10),
		myLine.x1 = 5;
		myLine.y1 = 10;
	// and initialize myLine's x2 and y2 to the point (45, 40).
		myLine.x2 = 45;
		myLine.y2 = 40; 
	// Print the line's length, which should be 50.
		myLine.printLength(); 
	// Print the line's angle, which should be around 36.87 degrees.
		myLine.printAngle(); 
}