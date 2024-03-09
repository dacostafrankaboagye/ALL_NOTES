

public class BankAccount implements Measurable{

    private double balance;

    public double getMeasure(){
        return balance;
    }


    public BankAccount() {
        balance = 0;
    }


    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }


    public void withdraw(double amount) {
        balance = balance - amount;
    }


    public double getBalance() {
        return balance;
    }

}
