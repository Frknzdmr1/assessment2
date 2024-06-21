package assessment2;

import java.util.ArrayList;
import java.util.List;

public class HikingTrip {
    private int tripId;
    private String difficultyLevel;
    private int maxParticipants;
    private List<Group> groups;

    public HikingTrip(int tripId, String difficultyLevel, int maxParticipants) {
        this.tripId = tripId;
        this.difficultyLevel = difficultyLevel;
        this.maxParticipants = maxParticipants;
        this.groups = new ArrayList<>();
    }

    public int getTripId() {
        return tripId;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public boolean isFullyBooked() {
        int totalParticipants = 0;
        for (Group group : groups) {
            totalParticipants += group.getHikers().size();
        }
        return totalParticipants >= maxParticipants;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }
}
