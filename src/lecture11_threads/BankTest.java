package lecture11_threads;

/**
 * Example to show how to synchronize access.
 * @author Terry Lee
 */
public class BankTest {
    /**
     * Program to demo the issue of race condition and synchronization.
     * @param args arguments
     */
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        // Total Expected Deposit: 10000 (100 x 100)
        for (int i = 0; i < 100; i++) {
            Thread t = new BankTransaction(account,
                    BankTransaction.TransactionType.DEPOSIT, 100);
            t.start();
        }

        // Total Expected Withdrawal: 5000 (100 x 50)
        for (int i = 0; i < 100; i++) {
            Thread t = new BankTransaction(account,
                    BankTransaction.TransactionType.WITHDRAW, 50);
            t.start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Final balance should be 5000.0 and actual balance is "
                + account.getBalance());
    }
}
