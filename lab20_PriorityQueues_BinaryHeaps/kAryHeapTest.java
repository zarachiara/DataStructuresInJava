import junit.framework.TestCase;
public class kAryHeapTest extends TestCase {
	// test getParent
	public void testGetParent() {
		kAryHeap k = new kAryHeap(4);
		k.insert(20);
		k.insert(19);
		k.insert(18);
		k.insert(17);
		k.insert(16);
		k.insert(12);
		k.insert(13);
		k.insert(14);
		k.insert(15);
		k.insert(10);
		k.insert(22);
		k.insert(8);
		k.insert(1);
		k.insert(6);
		k.insert(4);
		k.insert(3);
		k.insert(2);
		System.out.println(k + "root should be 22");
		k.removeMax();
		System.out.println(k + "root should be 20"); 
		k.removeMax();
		System.out.println(k + "root should be 19");
		k.removeMax();
		System.out.println(k + "root should be 18");
		k.removeMax();
		System.out.println(k + "root should be 17");
		k.removeMax();
		System.out.println(k + "root should be 16");	
	}
	public void testgetChild()
	{
		kAryHeap k = new kAryHeap(4);
		k.insert(20);
		k.insert(19);
		k.insert(18);
		k.insert(17);
		k.insert(16);
		k.insert(12);
		k.insert(13);
		k.insert(14);
		k.insert(15);
		k.insert(10);
		k.insert(22);
		k.insert(8);
		k.insert(1);
		k.insert(6);
		k.insert(4);
		k.insert(3);
		k.insert(2);
		k.removeMax(); 
		System.out.println(k.getNodePub(2) + "--should be 19"); 
		System.out.println(k.getNodePub(3) + "--should be 18"); 
		System.out.println(k.getNodePub(4) + "--should be 17"); 
		System.out.println(k.getNodePub(5) + "--should be 16");
		System.out.println(k.getNodePub(6) + "--should be 19"); 
		System.out.println(k.getNodePub(7) + "--should be 18"); 
		System.out.println(k.getNodePub(8) + "--should be 17"); 
		System.out.println(k.getNodePub(9) + "--should be 16");
	}
}
