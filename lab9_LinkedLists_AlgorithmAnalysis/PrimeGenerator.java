import java.util.*;

public class PrimeGenerator implements Iterator<Integer> {
	
	private int currPrime = 0;
	private int lastPrime = 0;
	private int maxPrime;
	public static void main (String[] args) {
		// Make sure there is exactly one argument, an integer.
		// Store the argument, converted to an int, in n.
		if (args.length == 1) {
			try{
				int n = Integer.parseInt(args[0]);
			} catch (IllegalArgumentException e) {
				System.out.println("Argument is not an int");
			}
		} else {
			System.out.println("Argument is not exactly one integer");
			return;
		}
		int n = Integer.parseInt(args[0]);

		PrimeGenerator primeGen = new PrimeGenerator (n);
		int mostRecentPrime = 0;

		while (primeGen.hasNext()) {
			mostRecentPrime = primeGen.next();
		}
		
		System.out.println("The nth prime is: " + mostRecentPrime + " where n was: " + n);
	}
	
	public PrimeGenerator (int n) {
		// Make sure n is positive; throw IllegalArgumentException if not.
		// Initialize the iterator of the first n prime numbers.
		if (n < 1) {
			throw new IllegalArgumentException();
		}
		maxPrime = n;
	}
	
	// Return true if there are more primes to return.
	public boolean hasNext() {
		return currPrime < maxPrime;
	}
	
	// Return the next prime number.
	public Integer next() {
		if (currPrime == 0) {
			currPrime++;
			lastPrime = 2;
			return 2;		
		}
		lastPrime++;

		while (!testPrime(lastPrime)) {
			lastPrime++;		
		}
		currPrime++;
		return lastPrime;
	}


	public boolean testPrime(int n) {

		for (int i = 2; i < (int) Math.sqrt(n) + 1; i++) {
			if (n%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	// This is only here because the Iterator interface requires it.
	public void remove() {
	}

}
