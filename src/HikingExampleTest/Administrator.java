package HikingExampleTest;

import java.util.Scanner;

public class Administrator {
    private TrailManager trailManager;

    public Administrator(TrailManager trailManager) {
        this.trailManager = trailManager;
    }

    public void addNewTrail() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter trail name: ");
        String name = scanner.nextLine();
        System.out.print("Enter trail location: ");
        String location = scanner.nextLine();
        System.out.print("Enter trail difficulty: ");
        String difficulty = scanner.nextLine();
        System.out.print("Enter trail length: ");
        double length = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        boolean nameExists = trailManager.getAllTrails().stream()
                .anyMatch(trail -> trail.getName().equals(name));

        if (!nameExists) {
            Trail newTrail = new Trail(name, location, difficulty, length);
            trailManager.addTrail(newTrail);
            System.out.println(newTrail.getName() + " added successfully.");
        } else {
            System.out.println("Trail name already exists. Please enter a different name.");
        }
    }

    public void removeTrail() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter trail name to remove: ");
        String trailName = scanner.nextLine();

        boolean nameExists = false;
        for (Trail trail : trailManager.getAllTrails()) {
            if (trail.getName().equals(trailName)) {
                nameExists = true;
                break;
            }
        }

        if (nameExists) {
            trailManager.removeTrail(trailName);
            System.out.println(trailName + " removed successfully.");
        } else {
            System.out.println("Trail name not found. Please enter a different name.");
        }
    }
}