public class CheckingAccount extends BankAccount {

    private static final int FREE_TRANSACTIONS = 3;
    private static final double TRANSACTION_FEE = 2.0;

    private int transactionCount;

    /**
     * Constructs checkings account with a given balance
     * 
     * @param initialBalance
     */
    public CheckingAccount(double initialBalance) {
        // construct superclass
        super(initialBalance);

        // initialize transaction count
        transactionCount = 0;
    }

    public void deposite(double amount) {
        transactionCount++;

        // add amount to balance
        super.deposit(amount);
    }

    public void withdraw(double amount) {
        transactionCount++;

        // subtract amount from balance
        super.withdraw(amount);
    }

    /**
     * Deducts the accumulated fess and resets the transaction aount
    */
    public void deductFees() {
        if(transactionCount > FREE_TRANSACTIONS){
            double fees = TRANSACTION_FEE * (transactionCount - FREE_TRANSACTIONS);
            super.withdraw(fees);
        }
        transactionCount = 0;
    }

    public static void main(String[] args) {
        CheckingAccount acc1 = new CheckingAccount(10);
        BankAccount bkaac1 = acc1;
        Object anacc1Object = bkaac1;

        System.out.println(anacc1Object instanceof BankAccount);
    }

}
