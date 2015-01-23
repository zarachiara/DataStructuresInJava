 public class AccountTester {

    public static void main (String [ ] args) {
        Account mike = new Account (1000);
        //create an Account object mike who has $1000
        System.out.println (mike.balance ());
        
        /*
        Deposit test
        */
        mike.deposit (100);
        System.out.println (mike.balance ());
        // balance is now 1100


        /*
        Withdraw test
        1. basic withdraw algorithm
        2. negative withdraw 
        3. insufficient funds from withdrawing more than balance
        */ 
        mike.withdraw (200);
        System.out.println (mike.balance ());
        // balance is now 900

        mike.withdraw(-600);
        System.out.println (mike.balance ());
        //balance cannot withdraw a negative ammount. 
        
        mike.withdraw(2000);
        System.out.println(mike.balance ());
        //balance should stay at 900 and Insufficient funds. 

        mike.withdraw(60);
        System.out.println(mike.balance ());
        //balance should decrease to 840
        
        mike.withdraw(840);
        //balance should be 0
        System.out.println(mike.balance ());

        
        /*
        Overdraft proftection test
        */
        Account bob = new Account(550);
        bob.deposit(50);
        System.out.println("Bob's balance: " + bob.balance ());
        mike.merge(bob);
        System.out.println("Mike's new balance is: " + mike.balance ());
        System.out.println("Bob's new balance is: " + bob.balance ());
        //Mike gets all the money and Bob is left with 0$
        
        Account grandma = new Account (10000);
        Account mom = new Account (1000, grandma);
        Account daughter = new Account(200, mom);
        daughter.withdraw(50); //daughter has 150 dollars left
        System.out.println("daughter's balance: " + daughter.balance ());
        daughter.withdraw(300); //daughter is broke!
        System.out.println("daughter's balance: " + daughter.balance ());
        System.out.println("mom's balance: " + mom.balance ());
        daughter.withdraw(2000); //mom is broke!
        System.out.println("mom's balance: " + mom.balance ());
        System.out.println("grandma's balance: " + grandma.balance ());        
    }
}