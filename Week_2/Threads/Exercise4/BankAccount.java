public class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    
    public synchronized void deposit(double amount) {
        System.out.println("Depositing: " + amount);
        balance += amount;
        System.out.println("New Balance after deposit: " + balance);
    }

    
    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            System.out.println("Withdrawing: " + amount);
            balance -= amount;
            System.out.println("New Balance after withdrawal: " + balance);
        } else {
            System.out.println("Insufficient balance for withdrawal: " + balance);
        }
    }

    
    public synchronized double getBalance() {
        return balance;
    }
}