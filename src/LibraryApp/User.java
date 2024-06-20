package LibraryApp;

import java.util.List;
import java.util.Scanner;

public class User {
    private Library library;

    public User(Library library) {
        this.library = library;
    }

    public void searchBooks() {
        System.out.print("Enter search query (title or author): ");
        Scanner scanner = new Scanner(System.in);
        String query = scanner.nextLine();

        List<Book> searchResults = library.searchByTitleOrAuthor(query);
        if (searchResults.isEmpty()) {
            System.out.println("No books found matching the query.");
        } else {
            System.out.println("Search results:");
            for (Book book : searchResults) {
                System.out.println(book.toString());
            }
        }
    }

    public void displayAllBooks() {
        List<Book> allBooks = library.getAllBooks();
        System.out.println("All books in the library:");
        for (Book book : allBooks) {
            System.out.println(book);
        }
    }

    public void displayAvailableBooks() {
        List<Book> availableBooks = library.getAvailableBooks();
        System.out.println("Available books in the library:");
        for (Book book : availableBooks) {
            System.out.println(book);
        }
    }

    public void borrowBook() {
        System.out.print("Enter book ID to borrow: ");
        Scanner scanner = new Scanner(System.in);
        String bookId = scanner.nextLine();

        Book borrowedBook = library.borrowBook(bookId);
        if (borrowedBook != null) {
            System.out.println("Book borrowed successfully: " + borrowedBook.getTitle());
        } else {
            System.out.println("Book not available or not found.");
        }
    }

    public void returnBook() {
        System.out.print("Enter book ID to return: ");
        Scanner scanner = new Scanner(System.in);
        String bookId = scanner.nextLine();

        library.returnBook(bookId);
        System.out.println("Book returned successfully.");
    }
}

