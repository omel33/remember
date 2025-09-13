package topic1.library.app;

import topic1.library.model.Book;
import topic1.library.service.LibraryService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LibraryService lib = new LibraryService();

        lib.addBook(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", 1925, "Classic", 5));
        lib.addBook(new Book(2, "To Kill a Mockingbird", "Harper Lee", 1960, "Classic", 3));
        lib.addBook(new Book(3, "It", "Stephen King", 1986, "Horror", 2));
        lib.addBook(new Book(4, "Misery", "Stephen King", 1987, "Horror", 1));
        lib.addBook(new Book(5, "Clean Code", "Robert C. Martin", 2008, "Programming", 4));

        System.out.println("== All books ==");
        lib.listBooks().forEach(System.out::println);

        System.out.println("\n== Find by title: 'It' ==");
        print(lib.findByTitle("It"));

        System.out.println("\n== Find by author: 'Stephen King' ==");
        print(lib.findByAuthor("Stephen King"));

        System.out.println("\n== Find by year: 1960 ==");
        print(lib.findByYear(1960));

        System.out.println("\n== Find by genre: 'Classic' ==");
        print(lib.findByGenre("Classic"));

        System.out.println("\n== Remove book by id: 2 ==");
        boolean removed = lib.removeBookById(2);
        System.out.println("Removed? " + removed);

        System.out.println("\n== All books after removal ==");
        lib.listBooks().forEach(System.out::println);

        System.out.println("\n== Find by title: 'Non Existing' ==");
        print(lib.findByTitle("Non Existing"));
    }

    private static void print(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("(empty)");
        } else {
            books.forEach(System.out::println);
        }
    }
}
