package topic1.library.service;


import topic1.library.Genre;
import topic1.library.model.Book;


import java.util.ArrayList;
import java.util.List;

public class LibraryService {
  private List<Book> books;

    public LibraryService() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean removeBookById(int id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Book> listBooks() {
        return books;
    }

    public List<Book> findByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books){
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }
    public List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books){
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }
    public List<Book> findByGenre(Genre g) {
       List<Book> result = new ArrayList<>();
       for (Book book : books){
           if (book.getGenre().equals(g)) {
               result.add(book);
           }
       }
       return result;
    }
    public List<Book> findByYear(int year) {
        List<Book> result = new ArrayList<>();
        for (Book book : books){
            if (book.getYear() == year) {
                result.add(book);
            }
        }
        return result;

    }
    public Book getBookById(int id){
        for (Book b : books) if(b.getId()== id) return b;
        return null;
    }

}
