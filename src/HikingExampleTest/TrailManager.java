package HikingExampleTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrailManager {
    private List<Trail> trails;

    public TrailManager() {
        this.trails = new ArrayList<>();
    }

    public void addTrail(Trail trail) {
        trails.add(trail);
    }

    public void removeTrail(String trailName) {
        trails.removeIf(trail -> trail.getName().equals(trailName));
    }

    public List<Trail> searchByNameOrLocation(String query) {
        String lowerCaseQuery = query.toLowerCase();
        return trails.stream()
                .filter(trail -> trail.getName().toLowerCase().contains(lowerCaseQuery) ||
                        trail.getLocation().toLowerCase().contains(lowerCaseQuery))
                .collect(Collectors.toList());
    }

    public List<Trail> getAllTrails() {
        return trails;
    }

    public List<Trail> getOpenTrails() {
        return trails.stream()
                .filter(Trail::isOpen)
                .collect(Collectors.toList());
    }

    public void markTrailAsCompleted(String trailName) {
        for (Trail trail : trails) {
            if (trail.getName().equals(trailName)) {
                trail.setCompleted(true);
                return;
            }
        }
    }

    public void unmarkTrailAsCompleted(String trailName) {
        for (Trail trail : trails) {
            if (trail.getName().equals(trailName)) {
                trail.setCompleted(false);
                return;
            }
        }
    }
}
