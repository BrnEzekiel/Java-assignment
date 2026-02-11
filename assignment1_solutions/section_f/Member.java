
import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String memberId;
    private List<Book> borrowedBooks;

    // Constructor with all details
    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
    }

    // Constructor with only name (overloading)
    public Member(String name) {
        this(name, generateMemberId()); // Call the main constructor with a generated ID
    }

    // A simple method to generate a unique member ID (for demonstration purposes)
    private static String generateMemberId() {
        return "M" + System.currentTimeMillis();
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getMemberId() {
        return memberId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Methods to manage borrowed books
    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailable(false);
            System.out.println(name + " borrowed: " + book.getTitle());
        } else {
            System.out.println(book.getTitle() + " is currently not available.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.setAvailable(true);
            System.out.println(name + " returned: " + book.getTitle());
        } else {
            System.out.println(name + " did not borrow: " + book.getTitle());
        }
    }

    @Override
    public String toString() {
        return "Member Name: " + name + ", Member ID: " + memberId + ", Books Borrowed: " + borrowedBooks.size();
    }
}
