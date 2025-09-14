package topic1.library.model;

import java.time.LocalDate;

public class Loan {
    private final int bookId;
    private final int userId;
    private final LocalDate loanDate;

    public Loan(int bookId, int userId, LocalDate loanDate)
    {
        this.bookId = bookId;
        this.userId = userId;
        this.loanDate = loanDate;
    }
    public int getBookId()
    {
        return bookId;
    }
    public int getUserId()
    {
        return userId;
    }
    public LocalDate getLoanDate()
    {
        return loanDate;
    }
    @Override
    public String toString()
    {
        return "Loan{" +
                "bookId=" + bookId +
                ", userId=" + userId +
                ", loanDate=" + loanDate +
                '}';
    }
}
