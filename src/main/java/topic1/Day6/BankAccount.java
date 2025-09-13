package topic1.Day6;

public class BankAccount {
    double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }
    public double deposit(double amount) {
        balance += amount;
        return balance;
    }
    public double withdraw(double amount) {
        balance -= amount;
        return balance;
    }
}
