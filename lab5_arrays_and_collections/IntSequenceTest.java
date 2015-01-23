import java.util.Arrays;

import junit.framework.TestCase;
public class IntSequenceTest extends TestCase {
	
	
	 public void IntSequencetest()
	 {
		 IntSequence testSequence = new IntSequence(5);
		 assertEquals(testSequence.myValues.length,5);
		 assertEquals(testSequence.myCount,0);
		 
	 }
	
	 
	 public void testaddTest()
	 {
		 IntSequence testSequence = new IntSequence(5);
		 testSequence.add(-6);
		 assertEquals(testSequence.myCount,1);
		 assertEquals(testSequence.myValues[0],-6);
		 testSequence.add(4);
		 testSequence.add(7);
		 testSequence.add(19);
		 assertEquals(testSequence.myCount,4);
		 String testArr = "-6 4 7 19 ";
		 System.out.println(testSequence.toString());
		 assertEquals(testSequence.toString(),testArr);
	 }
	 
	 public void Testinsert()
	 {
		IntSequence testSequence = new IntSequence(10);
		IntSequence testSequence2 = new IntSequence(5);
		
		int[] values = {1, 2, 3, 4, 5};
		for (int elem : values) {
			testSequence.add(elem);
			testSequence2.add(elem);
		}
		testSequence.insert(0, 0);
		String after1 = "0 1 2 3 4 5 ";
		assertEquals(testSequence.toString(), after1);
		testSequence.insert(44, 2);
		String after2 = "0 1 44 2 3 4 5 ";
		assertEquals(testSequence.toString(), after2);
		testSequence.insert(0, 0);
		String after3 = "0 1 2 3 4 ";
		assertEquals(testSequence2.toString(), after3);
		
	 }
	 
	 public void TestisEmpty()
	 {
		 IntSequence testSequence = new IntSequence(0);
		 assertEquals(testSequence.isEmpty(), true);
	 }

	 
	 public void TestelementAt()
	 {
		IntSequence testSequence = new IntSequence(5);
		int[] values = {1, 2, 3, 4, 5};
		for (int elem : values) {
			testSequence.add(elem);
		}
		assertEquals(testSequence.elementAt(4), 5);
		
	 }
	 public void Testcontains()
	 {
		IntSequence testSequence = new IntSequence(5);
		int[] values = {1, 2, 3, 4, 5};
		for (int elem : values) {
			testSequence.add(elem);
		}
		assertTrue(testSequence.contains(5));
		assertTrue(!testSequence.contains(8));
	 }
}
