package topic1.library.model;

import topic1.library.Genre;

public class Book {
    private int id;
    private String title;
    private String author;
    private int year;
    private Genre genre;
    private int availableCopies;

    public Book(int id, String title, String author, int year,Genre genre,  int availableCopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.availableCopies = availableCopies;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public Genre getGenre() {
        return genre;
    }
    public void setGenre(Genre  genre) {
        this.genre = genre;
    }
    public int getAvailableCopies() {
        return availableCopies;
    }
    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", availableCopies=" + availableCopies +
                '\''+'}';
    }
}
