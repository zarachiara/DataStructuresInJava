import junit.framework.TestCase;
import java.util.Iterator; 


public class HashMapTest extends TestCase {
	public void testConstructor() {
		HashMap A = new HashMap();
			assertTrue(A.totalRelations() == 0);
			assertTrue(A.arraySize() == 30);
			
		for(int i = 0; i < 30; i++)
			assertTrue(A.getList(i)==null);
			assertTrue(A.getLoadFactor() == 0.7f);
		HashMap B = new HashMap(50);
		assertTrue(B.totalRelations() == 0);
		assertTrue(B.arraySize() == 50);
		
		for(int i = 0;i < 50; i++)
			assertTrue(B.getBucket()[i] == null);
			assertTrue(B.getLoadFactor() == 0.7f);
			
		HashMap C = new HashMap(20, 0.5f);
		assertTrue(C.totalRelations() == 0);
		assertTrue(C.arraySize() == 20);
		
		for(int i = 0;i < 20; i++)
			assertTrue(C.getBucket()[i] == null);
			assertTrue(C.getLoadFactor() == 0.5f);
	}

	public void testHasKey() {
		HashMap A = new HashMap();
		A.put("X", "5");
		A.put("Y", "5");
		A.put("AaAaAa", "5");
		A.put("AaAaBB", "55");
		assertTrue(A.hasKey("X"));
		assertTrue(A.hasKey("Y"));
		assertTrue(A.hasKey("AaAaAa"));
		assertTrue(A.hasKey("AaAaBB"));
		System.out.println("AaAaAa".hashCode());
		System.out.println("AaAaBB".hashCode());
	}
	
	public void testHasValue() {
		HashMap A = new HashMap();
		A.put("X", "5");
		//A.put("X", null);
		A.put("AaAaAa", "5");
		A.put("AaAaBB", "55");
		assertTrue(A.hasValue("5"));
		assertTrue(A.hasValue("55"));
		//assertTrue(A.hasValue(null));
	}
	
	public void testRemove() {
		HashMap A = new HashMap();
		int n = "X".hashCode() % 30;
		A.put("AaAaAa", "5");
		A.put("AaAaBB", "55");
		assertTrue(A.hasKey("AaAaAa"));
		assertTrue(A.hasValue("5"));
		assertTrue(A.hasKey("AaAaBB"));
		assertTrue(A.hasValue("55"));
		assertEquals("55", A.remove("AaAaBB"));
		assertEquals("5", A.remove("AaAaAa"));
		assertTrue(A.getBucket()[n] == null);	
	}
	
	public void testGetKey(){
		HashMap A = new HashMap();
		A.put("AaAaAa", "5");
		A.put("AaAaBB", "55");
		A.put("X", "555");
		A.put("Y", "5555");
		assertEquals("555", A.get("X"));
		assertEquals("5555", A.get("Y"));
		assertEquals("5", A.get("AaAaAa"));
		assertEquals("55", A.get("AaAaBB"));
	}
	
	public void testSize(){
		HashMap A = new HashMap();
		assertTrue(A.size() == 0);
		A.put("AaAaAa", "5");
		assertTrue(A.size() == 1);
		A.put("AaAaBB", "55");
		assertTrue(A.size() == 2);
		A.put("X", "555");
		assertTrue(A.size() == 3);
		A.put("Y", "5555");
		assertTrue(A.size() == 4);
		A.remove("X");
		assertTrue(A.size() == 3);
	}
	
	public void testPut(){
		HashMap A = new HashMap();
		A.put("AaAaAa", "5");
		A.put("AaAaAa", "10");
		assertTrue(A.hasValue("10"));
		assertFalse(A.hasValue("5"));
		A.put(3, "sup");
		assertTrue(A.hasValue("sup"));
		assertTrue(A.hasKey(3));	
	}
	
	public void testInterator() {
		// general case 
		HashMap hm1 = new HashMap(5);
		Iterator iter1 = hm1.iterator(); 
		hm1.put(1, "a");
		hm1.put(2, "c");
		hm1.put(3, "d");
		hm1.put(4, "e");
		hm1.put(5, "f");
//		
//		System.out.println(hm1.getIndex(1) + " key 1 ");
//		System.out.println(hm1.getIndex(2) + " key 2 ");
//		System.out.println(hm1.getIndex(3) + " key 3 ");
//		System.out.println(hm1.getIndex(4) + " key 4");
//		System.out.println(hm1.getIndex(5) + " key 5");
		
		// testing next in general case 
		assertEquals(iter1.next(), 5);
		assertEquals(iter1.next(), 1);
		assertEquals(iter1.next(), 2);
		assertEquals(iter1.next(), 3);
		assertEquals(iter1.next(), 4);
		
		//testing remove in general case
		HashMap hm3 = new HashMap(5);
		Iterator iter3 = hm3.iterator(); 
		hm3.put(1, "a");
		hm3.put(2, "c");
		hm3.put(3, "d");
		hm3.put(4, "e");
		hm3.put(5, "f");
		assertEquals(iter3.next(), 5);
		iter3.next();
		iter3.next();
		iter3.next();
		iter3.next();
		iter3.next();
		iter3.remove();
		System.out.println();
		iter3.remove(); 
		iter3.remove(); 
		iter3.remove(); 
		assertTrue(iter3.hasNext()); 
		assertFalse(hm3.hasKey(1));
		assertFalse(hm3.hasKey(2));
		assertFalse(hm3.hasKey(3));
		assertFalse(hm3.hasKey(4));
		assertTrue(hm3.hasKey(5));
		
		// testing the index of the keys
			//	System.out.println(iter1.next() + " should be 5");
			//	System.out.println(iter1.next() + " should be 1");
			//	System.out.println(iter1.next() + " should be 2");
			//	System.out.println(iter1.next() + " should be 3");
			//	System.out.println(iter1.next() + " should be 4");
	
		// when collision occurs 
		HashMap hm = new HashMap(3);
		hm.put(1, "a");
		//hm.put(1, "b");
		hm.put(2, "c");
		hm.put(3, "d");
		hm.put(4, "e");
		hm.put(5, "f");
		hm.put(6, "g");
		Iterator iter = hm.iterator(); 
		// testing hasNext 
		assertTrue(iter.hasNext());
		
		// testing the index of the keys 
		//		System.out.println(hm.getIndex(1) + " key 1 ");
		//		System.out.println(hm.getIndex(2) + " key 2 ");
		//		System.out.println(hm.getIndex(3) + " key 3 ");
		//		System.out.println(hm.getIndex(4) + " key 4");
		//		System.out.println(hm.getIndex(5) + " key 5");
		//		System.out.println(hm.getIndex(6) + " key 6");
		
		assertEquals(iter.next(), 3);
		assertEquals(iter.next(), 6);
		assertEquals(iter.next(), 1);
		assertEquals(iter.next(), 4);
		assertEquals(iter.next(), 2);
		assertEquals(iter.next(), 5);
		// testing hasNext when it is false 
		assertFalse(iter.hasNext());	
		
		// testing an empty hash 
		HashMap hm2 = new HashMap();
		Iterator iter2 = hm2.iterator(); 
		assertFalse(iter2.hasNext());
		
	}
}
