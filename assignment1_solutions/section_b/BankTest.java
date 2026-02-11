
public class BankTest {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456", 1000);

        System.out.println("Initial balance: " + account.getBalance());

        account.deposit(500);
        System.out.println("Balance after deposit: " + account.getBalance());

        account.withdraw(200);
        System.out.println("Balance after withdrawal: " + account.getBalance());

        // Trying to withdraw more than the balance
        account.withdraw(2000);
        System.out.println("Balance after attempting to withdraw more than balance: " + account.getBalance());

        // Trying to access balance directly (will cause a compile error)
        // System.out.println(account.balance);
    }
}
