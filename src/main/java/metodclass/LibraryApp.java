package metodclass;

public class LibraryApp {
    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book();
        book1.title = "The Great Gatsby";
        book1.author = " Green";
        book1.publishYear = 1925;
        book1.price = 10.99;
        book2.title = "To Kill a Mockingbird";
        book2.author = " Harper Lee";
        book2.publishYear = 1960;
        book2.price = 12.99;
        book1.displayInfo();
        book2.displayInfo();
        System.out.println("Is book1 published after 1950? " + book1.isPublishedAfter(1950));
    }
}
