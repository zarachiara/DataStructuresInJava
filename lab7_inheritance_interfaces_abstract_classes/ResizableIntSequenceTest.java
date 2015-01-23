import static org.junit.Assert.*;

import org.junit.Test;

public class ResizableIntSequenceTest {
	
	@Test
	public void testResizeAdd() {
		ResizableIntSequence c = new ResizableIntSequence(10);
		c.add(14);
		assertEquals(c.elementAt(0),14);
	}
	
	@Test
	public void testResizeAdd2() {
		ResizableIntSequence c = new ResizableIntSequence(4);
		for (int i = 0; i < 10; i++) {
			c.add(i);
		}
		assertEquals(c.toString(), "0 1 2 3 4 5 6 7 8 9 ");
		assertEquals(c.size(), 10);
		assertEquals(c.myValues.length, 16);
	}
	
	@Test
	public void testResizeAdd3() {
		ResizableIntSequence c = new ResizableIntSequence(2);
		for (int i = 0; i < 1000; i++) {
			c.add(i);
		}
		assertEquals(c.size(), 1000);
		assertEquals(c.myValues.length, 1024);
	}
	
	@Test
	public void testResizeInsert() {
		ResizableIntSequence c = new ResizableIntSequence(10);
		c.add(1);
		c.add(2);
		c.insert(3, 0);
		assertEquals(c.toString(), "3 1 2 ");
	}
	
	@Test
	public void testResizeInsert2() {
		ResizableIntSequence c = new ResizableIntSequence(10);
		for (int i = 0; i < 10; i++) {
			c.add(i);
		}
		c.insert(5, 0);
		assertEquals(c.toString(), "5 0 1 2 3 4 5 6 7 8 9 ");
		assertEquals(c.size(), 11);
		assertEquals(c.myValues.length, 20);
	}
	
	@Test
	public void testResizeInsert3() {
		ResizableIntSequence c = new ResizableIntSequence(2);
		for (int i = 0; i < 1000; i++) {
			c.add(i);
		}
		c.insert(5, 0);
		assertEquals(c.size(), 1001);
		assertEquals(c.myValues.length, 1024);
	}

	@Test
	public void testResizeRemove() {
		ResizableIntSequence c = new ResizableIntSequence(10);
		c.add(1);
		c.add(2);
		c.remove(0);
		assertEquals(c.toString(), "2 ");
	}
	
	@Test
	public void testResizeRemove2() {
		ResizableIntSequence c = new ResizableIntSequence(128);
		c.add(1);
		c.remove(0);
		assertEquals(c.size(), 0);
		assertEquals(c.myValues.length, 64);
	}
	
	@Test
	public void testResizeRemove3() {
		ResizableIntSequence c = new ResizableIntSequence(2048);
		for (int i = 0; i < 10; i++) {
			c.add(i);
		}
		c.remove(0);
		assertEquals(c.size(), 9);
		assertEquals(c.myValues.length, 1024);
	}
	
}
