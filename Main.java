import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== 📚 Library Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(id, title, author));
                    break;

                case 2:
                    library.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter title/author to search: ");
                    String keyword = sc.nextLine();
                    Book found = library.searchBook(keyword);
                    System.out.println(found != null ? found : "Book not found!");
                    break;

                case 4:
                    System.out.print("Enter Book ID to borrow: ");
                    library.borrowBook(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter Book ID to return: ");
                    library.returnBook(sc.nextInt());
                    break;

                case 6:
                    System.out.println("👋 Exiting...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }
}
