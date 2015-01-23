import org.junit.Test;

import junit.framework.TestCase;


public class BankAccountTest extends TestCase 
{
	public void testInit()
	{
		BankAccount b = new BankAccount(100);
		assertTrue (b.balance() == 100);
	}
	
	public void testInvalidArgs()
	{
		BankAccount b = new BankAccount(100);
		b.deposit(-10);
		assertTrue(b.balance() == 100);
		b.withdraw(-200);
		assertTrue(b.balance() == 100);
	}
	
	public void testOverdraft()
	{
		BankAccount b = new BankAccount(100);
		b.withdraw(400);
		assertTrue(b.balance() == 100);
	}
	
	public void testDeposit()
	{
		BankAccount b = new BankAccount(100);
		b.deposit(50);
		assertTrue(b.balance() == 150);
	}
	
	public void testWithdraw()
	{
		BankAccount b = new BankAccount(100);
		b.withdraw(50);
		assertTrue(b.balance() == 50);
	}

}
