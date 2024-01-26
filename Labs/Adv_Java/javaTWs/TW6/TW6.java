// Write a Java program to demonstrate how the standard operations on a bank account can be 
// synchronized.

package TW6;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Synchronized method to deposit money into the account
    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);

        // Notify a single waiting thread that a deposit has been made
        notify();
    }

    // Synchronized method to withdraw money from the account
    public synchronized void withdraw(double amount) throws InterruptedException {
        while (balance < amount) {
            System.out.println("Insufficient balance. Waiting for deposit...");

            // Wait until sufficient funds are available
            wait();
        }
        balance -= amount;
        System.out.println("Withdrawn: $" + amount);

        // Notify all waiting threads that withdrawal is completed
        notifyAll();
    }

    // Synchronized method to get the current balance
    public synchronized double getBalance() {
        return balance;
    }
}

public class TW6 {
    public static void main(String[] args) {
        // Create a bank account with an initial balance of $1000
        BankAccount account = new BankAccount(1000);

        // Create a withdraw thread
        Thread withdrawThread = new Thread(() -> {
            try {
                account.withdraw(1300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Create a deposit thread
        Thread depositThread = new Thread(() -> {
            account.deposit(500);
        });

        // Start the withdraw and deposit threads
        withdrawThread.start();
        depositThread.start();

        // Wait for both threads to complete
        try {
            withdrawThread.join();
            depositThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display the final balance after both transactions
        System.out.println("Final balance: $" + account.getBalance());
    }
}
