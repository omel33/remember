package metodclass.abst;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if(initialBalance < 0) {
            throw new IllegalArgumentException("Початковий баланс не може бути від'ємним.");
        }
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }


    public void deposit(double amount) {
        if (amount < 0){
        throw new IllegalArgumentException("Сума поклаunkи не може бути від'ємною."+amount);

    }
        balance += amount;
        System.out.printf("Успішний депозит: %.2f. Новий баланс: %.2f%n", amount, balance);
    }

    public void withdraw(double amount) throws InsufficientFundsException{
        if (amount < 0) {
            throw new IllegalArgumentException("Сума зняття не може бути від'ємною."+amount);
        }
        if (amount > balance) {
            throw new InsufficientFundsException(String.format("Недостатньо коштів на рахунку." + amount + "Баланс: %.2f", balance));
        }
        balance -= amount;
        System.out.printf("Успішне зняття: %.2f. Новий баланс: %.2f%n", amount, balance);
    }
}
