package metodclass.abst;

public class Bank {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        System.out.println("Початковий баланс: " + account.getBalance());
        System.out.println("\n--- Сценарій: Успішний депозит ---");

        try {
            account.deposit(500);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }finally {
            System.out.println("Новий баланс: " + account.getBalance());
        }
        System.out.println("\n--- Сценарій: Депозит з некоректною сумою ---");

        try {
            account.deposit(-100);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }finally {
            System.out.println("Операція депозиту завершена. Поточний баланс: " + account.getBalance());
        }
        System.out.println("\n--- Сценарій: Успішне зняття ---");
        try {
            account.withdraw(300);
        } catch(IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }catch (InsufficientFundsException e) {
            System.err.println("Помилка зняття (недостатньо коштів): " + e.getMessage());
        } finally {
            System.out.println("Новий баланс: " + account.getBalance());
        }
        System.out.println("\n--- Сценарій: Зняття з недостатньою сумою ---");
        try {
            account.withdraw(1500);
        } catch(IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }catch (InsufficientFundsException e) {
            System.err.println("Помилка зняття (недостатньо коштів): " + e.getMessage());
        } finally {
            System.out.println("Операція зняття завершена. Поточний баланс: " + account.getBalance());
        }
        System.out.println("\n--- Сценарій: Зняття з некоректною сумою ---");
        try {
            account.withdraw(-200);
        } catch(IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }catch (InsufficientFundsException e) {
            System.err.println("Помилка зняття (недостатньо коштів): " + e.getMessage());
        } finally {
            System.out.println("Операція зняття завершена. Поточний баланс: " + account.getBalance());
        }
        System.out.println("\n--- Всі операції завершено ---");
        System.out.println("Фінальний баланс рахунку: " + account.getBalance());
        System.out.println("Дякуємо за використання нашої банківської сис теми!");
    }

}
