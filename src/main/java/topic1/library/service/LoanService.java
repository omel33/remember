package topic1.library.service;

import topic1.library.model.Book;
import topic1.library.model.Loan;
import topic1.library.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LoanService {
    private final LibraryService libraryService;
    private final UserService userService;
    private final List<Loan> loans = new ArrayList<>();

    public LoanService(LibraryService libraryService, UserService userService) {
        this.libraryService = libraryService;
        this.userService = userService;
    }

    public boolean loanBook(int bookId, int userId) {
        Book book = libraryService.getBookById(bookId);
        User user = userService.getUserById(userId);
        if (book == null) {
            System.out.println("Book not found" + bookId);
            return false;
        }
        if (user == null) {
            System.out.println("User not found" + userId);
            return false;
        }
        if (book.getAvailableCopies() <= 0) {
            System.out.println("No available copies of book: " + bookId);
            return false;
        }
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        loans.add(new Loan(bookId, userId, LocalDate.now()));
        return true;
    }

    public boolean returnBook(int bookId, int userId) {
        Book book = libraryService.getBookById(bookId);
        User user = userService.getUserById(userId);
        if (book == null || user == null) {
            System.out.println("Book or user not found");
            return false;
        }
        for (int i = 0; i < loans.size(); i++) {
            Loan loan = loans.get(i);
            if (loan.getBookId() == bookId && loan.getUserId() == userId) {
                loans.remove(i);
                book.setAvailableCopies(book.getAvailableCopies() + 1);
                return true;
            }
        }
        System.out.println("No such active loan for userId=" + userId + ", bookId=" + bookId);
        return false;
    }

    public List<Loan> listLoans() {
        return loans;
    }
}
