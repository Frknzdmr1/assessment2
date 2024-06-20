package HikingExampleTest;

public class Trail {
    private int id;
    private String name;
    private String location;
    private String difficulty;
    private double length;
    private boolean isOpen;

    public Trail(int id, String name, boolean isOpen, double length, String difficulty, String location) {
        this.id = id;
        this.name = name;
        this.isOpen = isOpen;
        this.length = length;
        this.difficulty = difficulty;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public double getLength() {
        return length;
    }

    public boolean isOpen() {
        return isOpen;
    }
    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public String toString() {
        return "Trail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", length=" + length +
                ", isOpen=" + isOpen +
                '}';
    }
}
