import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title.trim();
        this.author = author.trim();
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "\"" + title + "\" by " + author;
    }
}

class LibraryCatalog {
    private List<Book> books = new ArrayList<>();

    public void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Book \"" + title + "\" by " + author + " added successfully.");
    }

    public void searchBooks(String keyword) {
        keyword = keyword.toLowerCase();
        boolean found = false;

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword) ||
                    book.getAuthor().toLowerCase().contains(keyword)) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found matching \"" + keyword + "\".");
        }
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the catalog.");
        } else {
            System.out.println("\nList of Books:");
            int index = 1;
            for (Book book : books) {
                System.out.println(index + ". " + book);
                index++;
            }
        }
    }
}

public class LibraryCatalogApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryCatalog catalog = new LibraryCatalog();
        boolean running = true;

        while (running) {
            System.out.println("\nLibrary Catalog Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book by Title or Author");
            System.out.println("3. List All Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    catalog.addBook(title, author);
                    break;

                case "2":
                    System.out.print("Enter title or author to search: ");
                    String keyword = scanner.nextLine();
                    catalog.searchBooks(keyword);
                    break;

                case "3":
                    catalog.listBooks();
                    break;

                case "4":
                    running = false;
                    System.out.println("Exiting Library Catalog. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }

        scanner.close();
    }
}
