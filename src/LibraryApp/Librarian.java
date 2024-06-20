package LibraryApp;

import java.util.Scanner;

public class Librarian {
    private Library library;


    public Librarian(Library library) {
        this.library = library;

    }

    public void addNewBook() {
        System.out.print("Enter book title: ");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book ID: ");
        String id = scanner.nextLine();

        boolean idExists = false;
        for (Book book : library.getAllBooks()) {
            if (book.getId().equals(id)) {
                idExists = true;
                break;
            }
        }

        if (!idExists) {
            Book newBook = new Book(title, author, id);
            library.addBook(newBook);
            System.out.println(newBook.getTitle() + " added successfully.");
        } else {
            System.out.println("Book ID already exists. Please enter a different ID.");
        }

    }

    public void removeBook() {
        System.out.print("Enter book ID to remove: ");
        Scanner scanner = new Scanner(System.in);
        String bookId = scanner.nextLine();

        boolean idExists = false;
        for (Book book : library.getAllBooks()) {
            if (book.getId().equals(bookId)) {
                idExists = true;
                break;
            }
        }

        if (idExists) {
            library.removeBook(bookId);
            System.out.println(bookId +"Book removed successfully.");
        } else {
            System.out.println("Book ID doesnt found. Please enter a different ID.");
        }


    }
}