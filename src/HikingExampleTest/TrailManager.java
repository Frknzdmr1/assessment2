package HikingExampleTest;

import java.util.ArrayList;
import java.util.List;

public class TrailManager {
    List<Trail> trails = new ArrayList<Trail>();

    public void addTrail(Trail trail) {
        trails.add(trail);
    }

    public void removeTrail(Trail trail) {
        trails.remove(trail);
    }

    public List<Trail> searchTrail (String query) {
        List<Trail> result = new ArrayList<>();
        for (int i = 0; i < trails.size(); i++) {
            if (trails.get(i).getName().equals(query)) {
                return trails;
            }
        }
        return result;
    }

    public List<Trail> listAllTrails() {
        return new ArrayList<>(trails);
    }
}


