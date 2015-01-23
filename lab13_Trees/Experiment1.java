import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Experiment1 extends Timer {
	
	public static void main(String[] args) {
		ArrayList<Integer> testArray = new ArrayList<Integer>();
		LinkedList<Integer> testLinked = new LinkedList<Integer>();
		Timer timer = new Timer();
		for (int i = 0; i < 10000000; i++) {
			testArray.add(i, i);
		}
		for (int i = 0; i < 10000000; i++) {
			testLinked.add(i, i);
		}
		timer.start();
		testArray.get(5000000);
		long aGet = timer.stop();
		timer.reset();
		timer.start();
		testLinked.get(5000000);
		long lGet = timer.stop();
		timer.reset();
		System.out.println("Time to get an element of an ArrayList was " + aGet + " vs the time to get an element of a LinkedList was " + lGet);
	}

}

