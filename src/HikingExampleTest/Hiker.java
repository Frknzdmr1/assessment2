package HikingExampleTest;

import java.util.List;
import java.util.Scanner;

public class Hiker {
    private TrailManager trailManager;

    public Hiker(TrailManager trailManager) {
        this.trailManager = trailManager;
    }

    public void searchTrails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter search query (name or location): ");
        String query = scanner.nextLine();

        List<Trail> searchResults = trailManager.searchByNameOrLocation(query);
        if (searchResults.isEmpty()) {
            System.out.println("No trails found matching the query.");
        } else {
            System.out.println("Search results:");
            for (Trail trail : searchResults) {
                System.out.println(trail.toString());
            }
        }
    }

    public void displayAllTrails() {
        List<Trail> allTrails = trailManager.getAllTrails();
        System.out.println("All trails in the system:");
        for (Trail trail : allTrails) {
            System.out.println(trail);
        }
    }

    public void displayOpenTrails() {
        List<Trail> openTrails = trailManager.getOpenTrails();
        System.out.println("Open trails in the system:");
        for (Trail trail : openTrails) {
            System.out.println(trail);
        }
    }

    public void markTrailAsCompleted() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter trail name to mark as completed: ");
        String trailName = scanner.nextLine();

        trailManager.markTrailAsCompleted(trailName);
        System.out.println("Trail marked as completed: " + trailName);
    }

    public void unmarkTrailAsCompleted() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter trail name to unmark as completed: ");
        String trailName = scanner.nextLine();

        trailManager.unmarkTrailAsCompleted(trailName);
        System.out.println("Trail unmarked as completed: " + trailName);
    }
}