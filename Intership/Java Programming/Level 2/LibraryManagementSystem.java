import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String id;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean isIssued) {
        this.isIssued = isIssued;
    }

    @Override
    public String toString() {
        return "Book [ID=" + id + ", Title=" + title + ", Author=" + author + ", Issued=" + isIssued + "]";
    }
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void issueBook(String id) {
        for (Book book : books) {
            if (book.getId().equals(id) && !book.isIssued()) {
                book.setIssued(true);
                System.out.println("Book issued successfully.");
                return;
            }
        }
        System.out.println("Book not found or already issued.");
    }

    public void returnBook(String id) {
        for (Book book : books) {
            if (book.getId().equals(id) && book.isIssued()) {
                book.setIssued(false);
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("Book not found or not issued.");
    }

    public void listBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

public class LibraryManagementSystem {
    private static Library library = new Library();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. List Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    issueBook(scanner);
                    break;
                case 3:
                    returnBook(scanner);
                    break;
                case 4:
                    listBooks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addBook(Scanner scanner) {
        System.out.print("Enter Book ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Book Author: ");
        String author = scanner.nextLine();

        Book book = new Book(id, title, author);
        library.addBook(book);
        System.out.println("Book added successfully.");
    }

    private static void issueBook(Scanner scanner) {
        System.out.print("Enter Book ID to issue: ");
        String id = scanner.nextLine();
        library.issueBook(id);
    }

    private static void returnBook(Scanner scanner) {
        System.out.print("Enter Book ID to return: ");
        String id = scanner.nextLine();
        library.returnBook(id);
    }

    private static void listBooks() {
        library.listBooks();
    }
}
