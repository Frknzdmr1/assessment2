package assessment2;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static HikingTripPlanner planner = new HikingTripPlanner();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // exampleHikers
        planner.addHiker(new Hiker("Ceren"));
        planner.addHiker(new Hiker("Furkan"));
        planner.addHiker(new Hiker("Mia"));
        planner.addHiker(new Hiker("Tilu"));

        // exampleTrips
        planner.createHikingTrip(1, "Easy", 4);
        planner.createHikingTrip(2, "Moderate", 3);

        // group
        Group group1 = new Group(1);
        planner.getTrips().get(0).addGroup(group1);

        displayMenu();
    }

    private static void displayMenu() {
        int choice;
        do {
            System.out.println("\n--- Hiking Trip Planner Menu ---");
            System.out.println("1. View all Hikers");
            System.out.println("2. Search for a Hiker by name");
            System.out.println("3. Create a Hiking Trip");
            System.out.println("4. View Trips Not Fully Booked");
            System.out.println("5. View Group");
            System.out.println("6. Add Hiker to Group");
            System.out.println("7. Remove Hiker from Group");
            System.out.println("8. Assign Group to Trip");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        viewAllHikers();
                        break;
                    case 2:
                        searchHikerByName();
                        break;
                    case 3:
                        createHikingTrip();
                        break;
                    case 4:
                        viewTripsNotFullyBooked();
                        break;
                    case 5:
                        viewGroup();
                        break;
                    case 6:
                        addHikerToGroup();
                        break;
                    case 7:
                        removeHikerFromGroup();
                        break;
                    case 8:
                        assignGroupToTrip();
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Please enter a valid option.");
                }
            } catch (Exception e) { //handle invalid exeptions
                System.out.println("Please enter a valid option.");
                scanner.nextLine();
                choice = -1;
            }
        } while (choice != 0);
    }

    private static void viewAllHikers() {
        List<Hiker> hikers = planner.viewAllHikers();
        System.out.println("\n--- All Hikers ---");
        for (Hiker hiker : hikers) {
            System.out.println(hiker);
        }
    }

    private static void searchHikerByName() {
        System.out.print("Enter the name of the hiker: ");
        String name = scanner.nextLine();
        List<Hiker> searchResult = planner.searchHikerByName(name);
        System.out.println("\n--- Result for '" + name + "' ---");
        if (searchResult.isEmpty()) {
            System.out.println("No hiker found with name '" + name + "'.");
        } else {
            for (Hiker hiker : searchResult) {
                System.out.println(hiker);
            }
        }
    }

    private static void createHikingTrip() {
        System.out.print("Enter Trip ID: ");
        int tripId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Level (Easy/Moderate/Difficult): ");
        String difficultyLevel = scanner.nextLine();
        System.out.print("Enter Maximum Participants: ");
        int maxParticipants = scanner.nextInt();
        scanner.nextLine();

        planner.createHikingTrip(tripId, difficultyLevel, maxParticipants);
        System.out.println("Hiking Trip created successfully.");
    }

    private static void viewTripsNotFullyBooked() {
        List<HikingTrip> trips = planner.getTripsNotFullyBooked();
        System.out.println("\n--- Trips Not Fully Booked ---");
        if (trips.isEmpty()) {
            System.out.println("No trips available.");
        } else {
            for (HikingTrip trip : trips) {
                System.out.println("Trip ID: " + trip.getTripId() + ", Difficulty: " + trip.getDifficultyLevel()
                        + ", Max Participants: " + trip.getMaxParticipants());
            }
        }
    }

    private static void viewGroup() { // added because was ready in my Hiking Example Test :)
        System.out.print("Enter Group ID to view: ");
        int groupId = scanner.nextInt();
        scanner.nextLine();

        Group group = findGroupById(groupId);

        if (group != null) {
            System.out.println("\n--- Hikers in Group " + groupId + " ---");
            for (Hiker hiker : group.getHikers()) {
                System.out.println(hiker);
            }
        } else {
            System.out.println("Group not found.");
        }
    }

    private static void addHikerToGroup() {
        System.out.print("Enter Group ID to add hiker to: ");
        int groupId = scanner.nextInt();
        scanner.nextLine();

        Group group = findGroupById(groupId);

        if (group != null) {
            System.out.println("Available Hikers to add:");
            List<Hiker> hikers = planner.viewAllHikers();
            for (int i = 0; i < hikers.size(); i++) {
                System.out.println((i + 1) + ". " + hikers.get(i).getName());
            }

            System.out.print("Enter the number of the hiker to add: ");
            int hikerNumber = scanner.nextInt();
            scanner.nextLine();

            if (hikerNumber > 0 && hikerNumber <= hikers.size()) {
                Hiker hikerToAdd = hikers.get(hikerNumber - 1);
                group.addHiker(hikerToAdd);
                System.out.println("Added hiker: " + hikerToAdd.getName());
            } else {
                System.out.println("Please enter a number between 1 and " + hikers.size() + ".");
            }
        } else {
            System.out.println("Group not found.");
        }
    }

    private static void removeHikerFromGroup() {
        System.out.print("Enter Group ID to remove hiker from: ");
        int groupId = scanner.nextInt();
        scanner.nextLine();

        Group group = findGroupById(groupId);

        if (group != null) { //list hikers in group
            System.out.println("Hikers in the group:");
            List<Hiker> hikers = group.getHikers();
            for (Hiker hiker : hikers) {
                System.out.println(hiker.getName());
            }

            System.out.print("Enter the name of the hiker to remove: ");
            String hikerName = scanner.nextLine();

            boolean removed = hikers.removeIf(hiker -> hiker.getName().equals(hikerName)); // remove elem from collection

            if (removed) {
                System.out.println("Removed hiker: " + hikerName);
            } else {
                System.out.println("Hiker not found in the group.");
            }
        } else {
            System.out.println("Group not found.");
        }
    }

    private static void assignGroupToTrip() { // New method to assign a group to a trip
        System.out.print("Enter Trip ID to assign group to: ");
        int tripId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Group ID to assign: ");
        int groupId = scanner.nextInt();
        scanner.nextLine();

        Group group = findGroupById(groupId);

        if (group != null) {
            planner.addGroupToTrip(tripId, group);
            System.out.println("Group " + groupId + " assigned to Trip " + tripId);
        } else {
            System.out.println("Group not found.");
        }
    }

    private static Group findGroupById(int groupId) { // search hiking trips with ID to assign a group to a trip
        for (HikingTrip trip : planner.getTrips()) {
            for (Group group : trip.getGroups()) {
                if (group.getGroupId() == groupId) {
                    return group;
                }
            }
        }
        return null;
    }
}
