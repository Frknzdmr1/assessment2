package LibraryApp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Librarian librarian = new Librarian(library);
        User user = new User(library);

        // Adding initial books to the library
        library.addBook(new Book("George Orwell", "1984", "1"));


        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean exit = false;
        do {
            System.out.println("\nWelcome to Library Management System");
            System.out.println("1. Librarian");
            System.out.println("2. Library User");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    handleLibrarianMenu(librarian);
                    break;
                case 2:
                    handleLibraryUserMenu(user);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        } while (!exit);

    }

    private static void handleLibrarianMenu(Librarian librarian) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrarian Menu:");
            System.out.println("1. Add new book");
            System.out.println("2. Remove a book");
            System.out.println("0. Back to main menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    librarian.addNewBook();
                    break;
                case 2:
                    librarian.removeBook();
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        } while (choice != 0);
    }

    private static void handleLibraryUserMenu(User user) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nLibrary User Menu:");
            System.out.println("1. Search for books");
            System.out.println("2. Display all books");
            System.out.println("3. Display available books");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("0. Back to main menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    user.searchBooks();
                    break;
                case 2:
                    user.displayAllBooks();
                    break;
                case 3:
                    user.displayAvailableBooks();
                    break;
                case 4:
                    user.borrowBook();
                    break;
                case 5:
                    user.returnBook();
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        } while (choice != 0);
    }
}
