
import java.util.List;

public interface Searchable {
    List<Book> searchBooks(String query);
    List<Member> searchMembers(String query);
}
