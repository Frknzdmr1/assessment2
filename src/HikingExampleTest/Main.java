package HikingExampleTest;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TrailManager trailManager = new TrailManager();
        Administrator administrator = new Administrator(trailManager);
        Hiker hiker = new Hiker(trailManager);

        // Adding initial trails to the system
        trailManager.addTrail(new Trail("Trail1", "Location1", "Easy", 5.0));

        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean exit = false;
        do {
            System.out.println("\nWelcome to Trail Management System");
            System.out.println("1. Administrator");
            System.out.println("2. Hiker");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    handleAdministratorMenu(administrator);
                    break;
                case 2:
                    handleHikerMenu(hiker);
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

    private static void handleAdministratorMenu(Administrator administrator) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nAdministrator Menu:");
            System.out.println("1. Add new trail");
            System.out.println("2. Remove a trail");
            System.out.println("0. Back to main menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    administrator.addNewTrail();
                    break;
                case 2:
                    administrator.removeTrail();
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        } while (choice != 0);
    }

    private static void handleHikerMenu(Hiker hiker) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nHiker Menu:");
            System.out.println("1. Search for trails");
            System.out.println("2. Display all trails");
            System.out.println("3. Display open trails");
            System.out.println("4. Mark trail as completed");
            System.out.println("5. Unmark trail as completed");
            System.out.println("0. Back to main menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    hiker.searchTrails();
                    break;
                case 2:
                    hiker.displayAllTrails();
                    break;
                case 3:
                    hiker.displayOpenTrails();
                    break;
                case 4:
                    hiker.markTrailAsCompleted();
                    break;
                case 5:
                    hiker.unmarkTrailAsCompleted();
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
