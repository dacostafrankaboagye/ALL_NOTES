// package bk.ch10.accounts;

/** 
 * An Account that earns interest at a fixed rate
*/
public class SavingsAccount extends BankAccount{

    private double interestRate;

    /**
     * Constructs a bank account with a given interest rate
     * @param rate the interest rate
     */
    public SavingsAccount(double rate){
        interestRate = rate;
    }

    /** 
     * Adds the earned interest to the account balance
    */
    public void addInterest(){
        double interest = super.getBalance() * interestRate / 100;
        super.deposit(interest);
    }



    
}
