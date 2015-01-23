public class TestExceptions {

	public static void main (String [ ] args) {
		Object[] x = new String[3]; 
		try {
			
			System.out.println(x[0]);
		} catch (NullPointerException e) {
			System.out.println ("got null pointer");
		}
		try {
			x[0] = new int[3];

		} catch (ArrayStoreException e) {
			System.out.println ("got illegal array store");
		}
		try {
			 
			System.out.println((String)x[0]);
		} catch (ClassCastException e) {
			System.out.println ("got illegal class cast");
		}
	}

}