import java.util.*;

public class JugSolver {
	private int desiredAmt;
	private int capacity[];
	private HashSet<JugContents> config = new HashSet<JugContents>(); 
	
	// constructing JugSolver
	public JugSolver (int jug0size, int jug1size, int jug2size, int desired) {
		capacity = new int [3];
		capacity[0] = jug0size;
		capacity[1] = jug1size;
		capacity[2] = jug2size;
		desiredAmt = desired;
	}
	
	// Try to solve the puzzle, starting at configuration b.
	public boolean tryPouring (JugContents jugsObject) {
		debugPrint (jugsObject.toString());
		if (jugsObject.jugs[0] == desiredAmt || jugsObject.jugs[1] == desiredAmt
		        || jugsObject.jugs[2] == desiredAmt) {
			return true;
		}
		// without this for loop, this class will undergo an infinite loop since 
		// it doesn't keep track of configurations already in the JugContents 
		for (JugContents a: config)
		{
			if(a.isEqual(jugsObject))
			{
				return false; 
			}
		}
		config.add(jugsObject);
		
		// Your code at this line, and possibly below
		// if coniguration is already on hashset 
			// add in the hashset 
			// return false
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i != j && tryPouring (pour(jugsObject, i, j))) {
					System.out.println ("Pouring from jug " + i + " to jug " + j);
					return true;
				}
			}
		}
		return false;
	}
	
	// Return the result of pouring as much as possible from jug from to jug to.
	public JugContents pour (JugContents current, int from, int to) {
		JugContents afterPour = new JugContents (current);
		int amtToCanGet = capacity[to] - current.jugs[to];
		int amtFromCanSupply = current.jugs[from];
		int amtPoured = min (amtToCanGet, amtFromCanSupply);
		debugPrint ("Pouring " + amtPoured 
			+ " from jug " + from + " to jug " + to);
		afterPour.jugs[from] -= amtPoured;
		afterPour.jugs[to] += amtPoured;
		return afterPour;
	}
		
	static int min (int x, int y) {
		if (x < y){
			return x;
		}
		else {
			return y;
		}
	}
	// to print more statements, change to true
	private static boolean DEBUGGING = true;

	private static void debugPrint (String s) {
		if (DEBUGGING) {
			System.out.println (s);
		}
	}

}