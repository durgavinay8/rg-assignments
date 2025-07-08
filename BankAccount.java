public class BankAccount {
    // Step 1: Make fields private
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        }
    }

    // Step 2: Provide public getters and methods for safe access

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    // Controlled method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Controlled method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid or insufficient balance.");
        }
    }
}

/*
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("John Doe", 500.0);

        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Initial Balance: $" + account.getBalance());

        account.deposit(200);
        account.withdraw(100);
        account.withdraw(700); // Will be rejected due to insufficient balance

        System.out.println("Final Balance: $" + account.getBalance());
    }
}
*/