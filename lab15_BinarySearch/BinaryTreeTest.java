import org.junit.Test;

public class BinaryTreeTest {

	@Test
	public void testFibTree() {
		System.out.println("####FIBONACCI####");
		BinaryTree fib = new BinaryTree();
		fib = BinaryTree.fibTree(0);
		System.out.println("Fibonacci(0):");
		fib.print();	
		
		fib = BinaryTree.fibTree(1);
		System.out.println("Fibonacci(1):");
		fib.print();
		
		fib = BinaryTree.fibTree(2);
		System.out.println("Fibonacci(2):");
		fib.print();	
		
		fib = BinaryTree.fibTree(3);
		System.out.println("Fibonacci(3):");
		fib.print();
	}
	
	@Test
	public void testExpressionTree() {
		System.out.println("####testExpressionTree()####");
		// general case 
		BinaryTree tree;
		tree = BinaryTree.exprTree("((1+2)*3)");
		System.out.println("Expression ((1+2)*3)");
		tree.print();
		
		// lab test
		BinaryTree tree1;
		tree1 = BinaryTree.exprTree("((a+(5*(a+b)))+(6*5))");
		System.out.println("Expression ((a+(5*(a+b)))+(6*5))");
		tree1.print();
		
		// must compute every part of the expression 
		BinaryTree tree2; // doesnt work 
		tree2 = BinaryTree.exprTree("((1*2)*(1+25))"); 
		System.out.println("Expression ((1*2)*(1+25))");
		tree2.print(); 
		tree2.optimize(); 
		tree2.print(); 
		
		// only one child 
		BinaryTree tree3; 
		tree3 = BinaryTree.exprTree("(2*(1+25))"); 
		System.out.println("Expression (2*(1+25))");
		tree3.print(); 
		tree3.optimize(); 
		tree3.print(); 
		
	}
	
	@Test
	public void testOptimize()
	{
		System.out.println("####testOptimize####");
		
		// lab test
		System.out.println(); 
		BinaryTree tree = BinaryTree.exprTree("((a+(5*(9+1)))+(6*5))");
		tree.optimize();
		tree.print();
		
		// more general test
		BinaryTree tree1;
		tree1 = BinaryTree.exprTree("(a+(2*(1+2)))"); 
		System.out.println("Expression (a+(2*(1+2))");
		tree1.optimize();
		tree1.print(); 
		
		// must compute every part of the expression 
		BinaryTree tree2; 
		tree2 = BinaryTree.exprTree("((1*2)*(1+25))"); 
		System.out.println("Expression ((1*2)*(1+25))");
		tree2.optimize(); 
		tree2.print(); 
		
		// only one child and must compute every part of the expression 
		BinaryTree tree3; 
		tree3 = BinaryTree.exprTree("(2*(1+25))"); 
		System.out.println("Expression (2*(1+25))");
		tree3.optimize(); 
		tree3.print(); 	
	}

}
