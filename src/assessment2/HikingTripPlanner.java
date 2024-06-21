package assessment2;

import java.util.ArrayList;
import java.util.List;

public class HikingTripPlanner {
    private List<Hiker> hikers;
    private List<HikingTrip> trips;

    public HikingTripPlanner() {
        this.hikers = new ArrayList<>();
        this.trips = new ArrayList<>();
    }

    public void addHiker(Hiker hiker) {
        hikers.add(hiker);
    }

    public void createHikingTrip(int tripId, String difficultyLevel, int maxParticipants) {
        HikingTrip trip = new HikingTrip(tripId, difficultyLevel, maxParticipants);
        trips.add(trip);
    }

    public List<Hiker> viewAllHikers() {
        return hikers;
    }

    public List<Hiker> searchHikerByName(String name) {
        List<Hiker> result = new ArrayList<>();
        for (Hiker hiker : hikers) {
            if (hiker.getName().equalsIgnoreCase(name)) {
                result.add(hiker);
            }
        }
        return result;
    }

    public List<HikingTrip> getTripsNotFullyBooked() {
        List<HikingTrip> notFullyBookedTrips = new ArrayList<>();
        for (HikingTrip trip : trips) {
            if (!trip.isFullyBooked()) {
                notFullyBookedTrips.add(trip);
            }
        }
        return notFullyBookedTrips;
    }

    public List<HikingTrip> getTrips() {
        return trips;
    }
}
