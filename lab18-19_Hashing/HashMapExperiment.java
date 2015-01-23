import java.util.*;
public class HashMapExperiment {
	
	// tracks how many numbers are inserted in the
	// HashMap items before a collision occurs. 
	public static int itemsCollide()
	{
		int count = 0;
		HashMap<Integer,Integer> items = new HashMap<Integer, Integer>(365);
		while (count < 365)
		{
			if (items.put((int) (Math.random() * 365), 0) != null)
			{
				return count; 
			}
			count++; 
		}
		return 365;
	}
	
	// returns the average of itemsCollide.  We tested the average of 10000 items
	public static int average(int iterations)
	{
		int average = 0;
		for (int i = 0; i < iterations; i++)
		{
			average += itemsCollide(); 
		}
		return average/iterations; 	
	}
	
	public static void main(String[] args)
	{
		System.out.println(average(10000) + " average items before collision");
		// this prints 23 average items before collision
	}
}
