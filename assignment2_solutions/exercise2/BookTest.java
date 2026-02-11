
public class BookTest {
    public static void main(String[] args) {
        // Book object created using the parameterized constructor
        Book myBook = new Book("The Java Programming Language", 1200);
        System.out.println("Book details after constructor initialization:");
        myBook.displayBookDetails();

        // If no constructor was defined, and we tried to create a book like this:
        // Book defaultBook = new Book(); // This would work if only default constructor exists
        // System.out.println("Default book title: " + defaultBook.title); // would be null
        // System.out.println("Default book pages: " + defaultBook.pages); // would be 0
        // But since we defined a parameterized constructor, the default one is not automatically provided.
    }
}
