
/**
 * A bank account has a balance that can be changed by
 * deposit and withdrawals
 */

import bk.ch09.the_interface.*;

public class BankAccount implements Measurable{

    private double balance;

    public double getMeasure(){
        return balance;
    }

    /**
     * Constructs a bank account with zero balance
     */
    public BankAccount() {
        balance = 0;
    }

    /**
     * Constructs a bank account with a given balance
     * 
     * @param initialBalance the initial balance
     */
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    /**
     * Deposits money into the bank account
     * 
     * @param amount
     */
    public void deposit(double amount) {
        balance = balance + amount;
    }

    /**
     * Withdraws money from the bank account
     * 
     * @param amount the amount to withdraw
     */
    public void withdraw(double amount) {
        balance = balance - amount;
    }

    /**
     * Gets the current balance of the bank account
     * 
     * @return the current balance
     */
    public double getBalance() {
        return balance;
    }

}
