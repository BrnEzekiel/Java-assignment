public class LibraryTest {
    public static void main(String[] args) {
        Library myLibrary = new Library();

        // --- Demonstrate Constructor Overloading & Encapsulation (Book) ---
        Book book1 = new Book("The Lord of the Rings", "J.R.R. Tolkien", "978-0618053267");
        Book book2 = new Book("The Hobbit", "J.R.R. Tolkien"); // Uses overloaded constructor
        myLibrary.addBook(book1);
        myLibrary.addBook(book2);
        myLibrary.displayAllBooks();
        // book1.title = "New Title"; // This would be a compile error due to encapsulation

        // --- Demonstrate Member Management (Constructor Overloading & Encapsulation) ---
        Member member1 = new Member("Alice Smith", "M001");
        Member member2 = new Member("Bob Johnson"); // Uses overloaded constructor with auto-generated ID
        myLibrary.addMember(member1);
        myLibrary.addMember(member2);
        myLibrary.displayAllMembers();

        // --- Demonstrate Borrowing and Returning (Interaction between objects) ---
        myLibrary.borrowBook(member1, book1);
        myLibrary.borrowBook(member1, book2);
        myLibrary.borrowBook(member2, book1); // book1 is not available

        myLibrary.displayAllBooks();
        System.out.println("\n" + member1.getName() + "'s borrowed books:");
        member1.getBorrowedBooks().forEach(b -> System.out.println("- " + b.getTitle()));

        myLibrary.returnBook(member1, book1);
        myLibrary.displayAllBooks();
        System.out.println("\n" + member1.getName() + "'s borrowed books:");
        member1.getBorrowedBooks().forEach(b -> System.out.println("- " + b.getTitle()));

        // --- Demonstrate Searchable Interface ---
        System.out.println("\n--- Search Results for 'Lord' ---");
        myLibrary.searchBooks("Lord").forEach(System.out::println);

        System.out.println("\n--- Search Results for 'M001' ---");
        myLibrary.searchMembers("M001").forEach(System.out::println);
    }

    /*
     * Explanation of OOP Principles Applied:
     *
     * 1.  Classes and Objects: The system is built using classes like Book, Member, and Library, which serve as blueprints for creating objects.
     *     Objects (e.g., 'book1', 'member1', 'myLibrary') are instances of these classes, representing real-world entities.
     *
     * 2.  Encapsulation: All attributes (e.g., Book's title, Member's name, Library's lists) are declared as 'private'.
     *     Access to and modification of these attributes are controlled through 'public' getter and setter methods.
     *     This protects the internal state of objects and ensures data integrity.
     *
     * 3.  Abstraction: The 'Searchable' interface provides a contract for searching books and members without revealing the underlying implementation details.
     *     The 'Library' class implements this interface, providing concrete implementations for the search methods. Users of the 'Library' class
     *     interact with the abstract 'Searchable' behavior without needing to know how the searching is performed internally.
     *
     * 4.  Inheritance: Although not explicitly used for class hierarchy in this mini-project (as per the minimal requirement),
     *     the concept is implicitly demonstrated in how 'Book' and 'Member' objects are managed by the 'Library'
     *     and how they interact, representing a "has-a" relationship (composition). If there were different types of books (e.g., EBook, Audiobook),
     *     inheritance would be directly applied.
     *
     * 5.  Polymorphism:
     *     -   Interface Polymorphism: The 'Searchable' interface allows for a common way to interact with different search functionalities.
     *         If other classes were to implement 'Searchable', they could be treated uniformly.
     *     -   Method Overloading (Constructor Overloading): The 'Book' and 'Member' classes have multiple constructors with different parameter lists.
     *         This allows creating objects in various ways, providing flexibility.
     *
     * The system demonstrates a clear separation of concerns, reusability of code (through classes and methods),
     * and maintainability due to well-defined interfaces and encapsulated data.
     */
}