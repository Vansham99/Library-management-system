import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("✅ Book added successfully!");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available!");
        } else {
            books.forEach(System.out::println);
        }
    }

    public Book searchBook(String keyword) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(keyword) || book.getAuthor().equalsIgnoreCase(keyword)) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(int id) {
        for (Book book : books) {
            if (book.getId() == id && !book.isBorrowed()) {
                book.borrowBook();
                System.out.println("📖 You borrowed: " + book.getTitle());
                return;
            }
        }
        System.out.println("❌ Book not available or already borrowed!");
    }

    public void returnBook(int id) {
        for (Book book : books) {
            if (book.getId() == id && book.isBorrowed()) {
                book.returnBook();
                System.out.println("🔄 Book returned successfully!");
                return;
            }
        }
        System.out.println("❌ Invalid return request!");
    }
}
