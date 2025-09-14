package topic1.library.app;

import topic1.library.model.Book;
import topic1.library.model.User;
import topic1.library.service.LibraryService;
import topic1.library.service.UserService;
import topic1.library.service.LoanService;

import java.util.List;
import java.util.Scanner;

public class App {
    private final LibraryService library;
    private final UserService users;
    private final LoanService loans;
    private final Scanner sc = new Scanner(System.in);

    public App() {
        this.library = new LibraryService();
        this.users = new UserService();
        this.loans = new LoanService(library, users);
        seed(); // стартові дані (за бажанням)
    }

    private void seed() {
        library.addBook(new Book(1, "It", "Stephen King", 1986, "Horror", 1));
        library.addBook(new Book(2, "Clean Code", "Robert C. Martin", 2008, "Programming", 2));
        users.addUser(new User(1, "Mike", "mike@gmail.com"));
        users.addUser(new User(2, "Jane", "jane@gmail.com"));
    }

    public void run() {
        while (true) {
            System.out.println("\n=== LIBRARY MENU ===");
            System.out.println("1 - Books");
            System.out.println("2 - Users");
            System.out.println("3 - Loans");
            System.out.println("0 - Exit");
            System.out.print("Choose: ");
            int cmd = readInt();

            switch (cmd) {
                case 1 -> booksMenu();
                case 2 -> usersMenu();
                case 3 -> loansMenu();
                case 0 -> { System.out.println("Bye!"); return; }
                default -> System.out.println("Unknown command");
            }
        }
    }

    /* -------- Books -------- */
    private void booksMenu() {
        System.out.println("\n-- Books --");
        System.out.println("1 - List all");
        System.out.println("2 - Add");
        System.out.println("3 - Remove by id");
        System.out.println("4 - Search");
        System.out.print("Choose: ");
        int c = readInt();
        switch (c) {
            case 1 -> library.listBooks().forEach(System.out::println);
            case 2 -> addBookFlow();
            case 3 -> {
                System.out.print("Id: "); int id = readInt();
                System.out.println("Removed? " + library.removeBookById(id));
            }
            case 4 -> searchBooksMenu();
            default -> System.out.println("Unknown");
        }
    }

    private void addBookFlow() {
        System.out.print("Id: "); int id = readInt();
        System.out.print("Title: "); String title = sc.nextLine();
        System.out.print("Author: "); String author = sc.nextLine();
        System.out.print("Year: "); int year = readInt();
        System.out.print("Genre: "); String genre = sc.nextLine();
        System.out.print("Available copies: "); int copies = readInt();
        library.addBook(new Book(id, title, author, year, genre, copies));
        System.out.println("Added.");
    }

    private void searchBooksMenu() {
        System.out.println("Search by: 1-Title  2-Author  3-Year  4-Genre");
        int s = readInt();
        switch (s) {
            case 1 -> { System.out.print("Title: "); printBooks(library.findByTitle(sc.nextLine())); }
            case 2 -> { System.out.print("Author: "); printBooks(library.findByAuthor(sc.nextLine())); }
            case 3 -> { System.out.print("Year: "); printBooks(library.findByYear(readInt())); }
            case 4 -> { System.out.print("Genre: "); printBooks(library.findByGenre(sc.nextLine())); }
            default -> System.out.println("Unknown");
        }
    }

    /* -------- Users -------- */
    private void usersMenu() {
        System.out.println("\n-- Users --");
        System.out.println("1 - List all");
        System.out.println("2 - Add");
        System.out.println("3 - Remove by id");
        System.out.print("Choose: ");
        int c = readInt();
        switch (c) {
            case 1 -> users.listUsers().forEach(System.out::println);
            case 2 -> addUserFlow();
            case 3 -> {
                System.out.print("Id: "); int id = readInt();
                System.out.println("Removed? " + users.removeUserById(id));
            }
            default -> System.out.println("Unknown");
        }
    }

    private void addUserFlow() {
        System.out.print("Id: "); int id = readInt();
        System.out.print("Name: "); String name = sc.nextLine();
        System.out.print("Email: "); String email = sc.nextLine();
        System.out.println("Added? " + users.addUser(new User(id, name, email)));
    }

    /* -------- Loans -------- */
    private void loansMenu() {
        System.out.println("\n-- Loans --");
        System.out.println("1 - List active loans");
        System.out.println("2 - Loan book");
        System.out.println("3 - Return book");
        System.out.print("Choose: ");
        int c = readInt();
        switch (c) {
            case 1 -> loans.listLoans().forEach(System.out::println);
            case 2 -> {
                System.out.print("Book id: "); int b = readInt();
                System.out.print("User id: "); int u = readInt();
                System.out.println("Loaned? " + loans.loanBook(b, u));
            }
            case 3 -> {
                System.out.print("Book id: "); int b = readInt();
                System.out.print("User id: "); int u = readInt();
                System.out.println("Returned? " + loans.returnBook(b, u));
            }
            default -> System.out.println("Unknown");
        }
    }

    /* -------- utils -------- */
    private int readInt() {
        while (!sc.hasNextInt()) {
            System.out.print("Enter number: ");
            sc.nextLine();
        }
        int val = sc.nextInt();
        sc.nextLine(); // з’їсти \n
        return val;
    }

    private void printBooks(List<Book> list) {
        if (list.isEmpty()) System.out.println("(empty)");
        else list.forEach(System.out::println);
    }

    public static void main(String[] args) {
        new App().run();
    }
}
