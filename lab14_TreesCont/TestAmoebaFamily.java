import static org.junit.Assert.*;
import org.junit.Test;

public class TestAmoebaFamily{

	@Test
	public void TestmakeNamesLowercase()
	{
		AmoebaFamily fam = new AmoebaFamily("Amos McCoy");
		fam.addChild("Amos McCoy", "mom/dad");
		fam.addChild("Amos McCoy", "auntie");
		fam.addChild("mom/dad", "me");
		fam.addChild("mom/dad", "Fred");
		fam.addChild("mom/dad", "Wilma");
		fam.makeNamesLowercase();
		fam.printFlat(); 
		System.out.println();
		
	}
	
	@Test
	public void TestreplaceName()
	{
		AmoebaFamily fam = new AmoebaFamily("Amos McCoy");
		fam.addChild("Amos McCoy", "mom/dad");
		fam.replaceName("Amos McCoy", "Zara Feran");
		fam.printFlat(); 
		System.out.println();
		
	}
	
	@Test
	public void TestPrettyPrint()
	{
		AmoebaFamily fam = new AmoebaFamily("Amos McCoy");
		fam.addChild("Amos McCoy", "mom/dad");
		fam.addChild("Amos McCoy", "auntie");
		fam.addChild("mom/dad", "me");
		fam.addChild("mom/dad", "Fred");
		fam.addChild("mom/dad", "Wilma");
		fam.makeNamesLowercase();
		fam.prettyprint(); 
	}
	
	@Test
	public void TestlongestName()
	{
		AmoebaFamily family = new AmoebaFamily("Amos McCoy");
		family.addChild("Amos McCoy", "mom/dad");
		family.addChild("Amos McCoy", "auntie");
		family.addChild("mom/dad", "me");
		family.addChild("mom/dad", "Fred");
		family.addChild("mom/dad", "Wilma");
		family.addChild("me", "Mike");
		family.addChild("me", "Homer");
		family.addChild("me", "Marge");
		family.addChild("Mike", "Bart");
		family.addChild("Mike", "Lisa");
		family.longestName(); 
		System.out.println(family.longestName() + "LongNameTest");
		assertEquals(family.longestName(), "Amos McCoy");
	}
	
	
	
	@Test 
	public void TestlongestnameLength()
	{
		// longest nameLength is the root. 
		AmoebaFamily family = new AmoebaFamily("Amos McCoy");
		family.addChild("Amos McCoy", "mom/dad");
		family.addChild("Amos McCoy", "auntie");
		family.addChild("mom/dad", "me");
		family.addChild("mom/dad", "Fred");
		family.addChild("mom/dad", "Wilma");
		family.addChild("me", "Mike");
		family.addChild("me", "Homer");
		family.addChild("me", "Marge");
		family.addChild("Mike", "Bart");
		family.addChild("Mike", "Lisa");
		family.longestName(); 
		assertEquals(family.longestNameLength(), 10);
		
		// longest nameLength is the child 	
		AmoebaFamily family1 = new AmoebaFamily("Super");
		family1.addChild("Super", "SuperCaliFraga");
		family1.addChild("Super", "ListicEspiali");
		family1.addChild("SuperCaliFraga", "Bob");
		family1.addChild("ListicEspiali", "Fred");
		family1.addChild("Bob", "Diana");
		family1.addChild("Diana", "Mike");
		family1.longestName();
		assertEquals(family1.longestNameLength(), 14);
		
	}
	
	@Test 
	public void TestSize()
	{
		// generic test of a normal tree. 
		AmoebaFamily family = new AmoebaFamily("Amos McCoy");
		family.addChild("Amos McCoy", "mom/dad");
		family.addChild("Amos McCoy", "auntie");
		family.addChild("mom/dad", "me");
		family.addChild("mom/dad", "Fred");
		family.addChild("mom/dad", "Wilma");
		family.addChild("me", "Mike");
		family.addChild("me", "Homer");
		family.addChild("me", "Marge");
		family.addChild("Mike", "Bart");
		family.addChild("Mike", "Lisa");
		System.out.println(family.size() + "SIZEE"); 
		assertEquals(family.size(), 11);
//		
//		// Tree only has one person...the root.
		AmoebaFamily family1 = new AmoebaFamily("Amos McCoy");
		System.out.println(family1.size() + "SIZEE"); 
		assertEquals(family1.size(), 1);
		
	}
	
	@Test
	public void Height()
	{
		AmoebaFamily family = new AmoebaFamily("Amos McCoy");
		family.addChild("Amos McCoy", "mom/dad");
		family.addChild("Amos McCoy", "auntie");
		family.addChild("mom/dad", "me");
		family.addChild("mom/dad", "Fred");
		family.addChild("mom/dad", "Wilma");
		family.addChild("me", "Mike");
		family.addChild("me", "Homer");
		family.addChild("me", "Marge");
		family.addChild("Mike", "Bart");
		family.addChild("Mike", "Lisa");
		family.height();
		System.out.println(family.height() + "HEIGHTTT");
	}
	
	
	
	
}