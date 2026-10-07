public class SavingsAccount extends Account {
    private final double minimumBalance;
    private final double interestRate;

    public SavingsAccount(String accountNumber, double balance,
                          double minimumBalance, double interestRate) {
        super(accountNumber, balance);
        this.minimumBalance = minimumBalance;
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal must be positive.");
            return;
        }
        if (balance - amount < minimumBalance) {
            System.out.println("Withdrawal rejected: minimum balance of "
                    + minimumBalance + " required.");
            return;
        }
        balance -= amount;
    }

    @Override
    public void endOfMonth() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest applied: " + interest);
    }
}
