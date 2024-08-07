public class BankAccountTest {

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        
        Transaction deposit1 = new Transaction(account, true, 500);
        Transaction withdraw1 = new Transaction(account, false, 200);
        Transaction deposit2 = new Transaction(account, true, 100);
        Transaction withdraw2 = new Transaction(account, false, 300);

        
        deposit1.start();
        withdraw1.start();
        deposit2.start();
        withdraw2.start();

        
        try {
            deposit1.join();
            withdraw1.join();
            deposit2.join();
            withdraw2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        
        System.out.println("Final Balance: " + account.getBalance());
    }
}
