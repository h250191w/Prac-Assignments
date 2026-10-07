public class CurrentAccount extends Account {
    private final double overdraftLimit;
    private final double monthlyFee;

    public CurrentAccount(String accountNumber, double balance,
                          double overdraftLimit, double monthlyFee) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
        this.monthlyFee = monthlyFee;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal must be positive.");
            return;
        }
        if (balance - amount < -overdraftLimit) {
            System.out.println("Withdrawal rejected: overdraft limit of "
                    + overdraftLimit + " exceeded.");
            return;
        }
        balance -= amount;
        if (balance < 0) {
            System.out.println("Account is in overdraft (within limit).");
        }
    }

    @Override
    public void endOfMonth() {
        balance -= monthlyFee;
        System.out.println("Maintenance fee deducted: " + monthlyFee);
    }
}
