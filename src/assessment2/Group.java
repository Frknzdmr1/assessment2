package assessment2;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private int groupId;
    private List<Hiker> hikers;


    public Group(int groupId) {
        this.groupId = groupId;
        this.hikers = new ArrayList<>();
    }

    public int getGroupId() {
        return groupId;
    }

    public List<Hiker> getHikers() {
        return hikers;
    }

    public void addHiker(Hiker hiker) {
        hikers.add(hiker);
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", hikers=" + hikers +
                '}';
    }
}

