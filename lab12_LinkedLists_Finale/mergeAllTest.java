	@Test
	public void TestmergeAll()
	{
		
		// merge with 3 nonEmptyListNodes in an ArrayList;  
		ArrayList<AbstractListNode> merge1 = new ArrayList<AbstractListNode>();
		merge1.add(0, new NonemptyListNode(1, new NonemptyListNode (2 , new NonemptyListNode (3))));
		merge1.add(1,new NonemptyListNode(4, new NonemptyListNode (5 , new NonemptyListNode (6)))); 
		merge1.add(2, new NonemptyListNode(6, new NonemptyListNode (8, new NonemptyListNode (10))));
		
		AbstractListNode mergeAllList = new NonemptyListNode(1,new NonemptyListNode 
				(2, new NonemptyListNode (3, new NonemptyListNode (4, new NonemptyListNode (5, new NonemptyListNode (6, new NonemptyListNode (
							6, new NonemptyListNode (8, new NonemptyListNode (10)))))))));
		assertEquals(mergeAllList, AbstractListNode.mergeAll(merge1));
		
		
		// merge with nonemptyListNodes and an emptyListNodes in an ArrayList; 
		ArrayList<AbstractListNode> merge2 = new ArrayList<AbstractListNode>();
		merge2.add(0, new NonemptyListNode(1, new NonemptyListNode (2 , new NonemptyListNode (3))));
		merge2.add(1, new EmptyListNode()); 
		merge2.add(2, new EmptyListNode()); 
		merge2.add(3, new NonemptyListNode(2, new NonemptyListNode (4 , new NonemptyListNode (6))));
		
		AbstractListNode mergeAllList1 = new NonemptyListNode(1,new NonemptyListNode 
				(2, new NonemptyListNode (2, new NonemptyListNode (3, new NonemptyListNode (4, new NonemptyListNode (6)))))); 
		
		assertEquals(mergeAllList1, AbstractListNode.mergeAll(merge2));
		
		// merge with emptyListNodes in an ArrayList; 
		ArrayList<AbstractListNode> merge3 = new ArrayList<AbstractListNode>();
		merge3.add(0, new EmptyListNode()); 
		merge3.add(1, new EmptyListNode()); 
		merge3.add(2, new EmptyListNode()); 
	
		AbstractListNode mergeAllList3 = new EmptyListNode(); 
		assertEquals(mergeAllList3, AbstractListNode.mergeAll(merge3)); 	
	}
	