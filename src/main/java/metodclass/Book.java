package metodclass;

  class Book {
    String title;
    String author;
    int publishYear;
    double price;

    public void displayInfo() {
        System.out.println("Title: " + title + "\nAuthor: " + author + "\nPublish Year: " + publishYear + "\nPrice: " + price);
    }
    public boolean isPublishedAfter(int year) {
        return publishYear > year;
    }
}
