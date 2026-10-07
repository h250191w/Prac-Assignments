import java.util.ArrayList;
import java.util.List;

public class BankDemo {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();

        accounts.add(new SavingsAccount("S001", 500.0, 100.0, 0.05));
        accounts.add(new CurrentAccount("C001", 300.0, 500.0, 10.0));

        for (Account account : accounts) {
            if (account instanceof SavingsAccount) {
                account.withdraw(450.0);
            } else {
                account.withdraw(700.0);
            }

            account.endOfMonth();
            System.out.println(account.getBalance());
        }
    }
}
