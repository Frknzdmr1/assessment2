package HikingExampleTest;

public class Trail {
    private String name;
    private String location;
    private String difficulty;
    private double length;
    private boolean isOpen;
    private boolean isCompleted;

    public Trail(String name, String location, String difficulty, double length) {
        this.name = name;
        this.location = location;
        this.difficulty = difficulty;
        this.length = length;
        this.isOpen = true;
        this.isCompleted = false;
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

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        return "Trail{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", length=" + length +
                ", isOpen=" + isOpen +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
