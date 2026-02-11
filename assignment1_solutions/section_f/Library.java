import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library implements Searchable {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    // Book management
    public void addBook(Book book) {
        this.books.add(book);
        System.out.println("Added book: " + book.getTitle());
    }

    public void removeBook(Book book) {
        if (this.books.remove(book)) {
            System.out.println("Removed book: " + book.getTitle());
        } else {
            System.out.println("Book not found: " + book.getTitle());
        }
    }

    // Member management
    public void addMember(Member member) {
        this.members.add(member);
        System.out.println("Registered member: " + member.getName());
    }

    public void removeMember(Member member) {
        if (this.members.remove(member)) {
            System.out.println("Deregistered member: " + member.getName());
        } else {
            System.out.println("Member not found: " + member.getName());
        }
    }

    // Borrow and Return
    public void borrowBook(Member member, Book book) {
        member.borrowBook(book);
    }

    public void returnBook(Member member, Book book) {
        member.returnBook(book);
    }

    @Override
    public List<Book> searchBooks(String query) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                                 book.getAuthor().toLowerCase().contains(query.toLowerCase()) ||
                                 book.getIsbn().contains(query))
                .collect(Collectors.toList());
    }

    @Override
    public List<Member> searchMembers(String query) {
        return members.stream()
                .filter(member -> member.getName().toLowerCase().contains(query.toLowerCase()) ||
                                 member.getMemberId().contains(query))
                .collect(Collectors.toList());
    }

    public void displayAllBooks() {
        System.out.println("\n--- All Books in Library ---");
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        books.forEach(System.out::println);
    }

    public void displayAllMembers() {
        System.out.println("\n--- All Members of Library ---");
        if (members.isEmpty()) {
            System.out.println("No members registered.");
            return;
        }
        members.forEach(System.out::println);
    }
}
