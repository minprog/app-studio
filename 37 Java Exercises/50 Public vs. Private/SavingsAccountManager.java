/*
 * A very simple class designed to exercise the services of 
 * the SavingsAccount class.  Only simple text output
 * is implemented
 */ 
public class SavingsAccountManager {
   // Usual "I'm an application gibberish..."
   public static void main(String args[]) {
      // use our no arguments constructor to get a reference
      SavingsAccountManager misterJohnson = new SavingsAccountManager();

      // Now do some banking stuff....
      misterJohnson.doBankingStuff();
   }

   void doBankingStuff() {
      // create some accounts---they are SavingsAccount objects
      // This one uses the default no argument constructor
      SavingsAccount myLifeSavings = new SavingsAccount();

      // This one uses the supplied constructor to set an initial balance
      SavingsAccount myHolidaySavings = new SavingsAccount(42);

      // call some methods from one account...
      myLifeSavings.greet();
      myLifeSavings.deposit(265);
      myLifeSavings.withdraw(100);
      myLifeSavings.showBalance();

      // you do the other...
      myHolidaySavings.showBalance();
   }
}
