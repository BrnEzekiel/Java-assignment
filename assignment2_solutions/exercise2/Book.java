
public class Book {
    String title;
    int pages;

    // Parameterized constructor
    public Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Pages: " + pages);
    }
}
