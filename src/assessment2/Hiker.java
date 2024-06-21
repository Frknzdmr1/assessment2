package assessment2;

public class Hiker {
    private String name;

    public Hiker(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Hiker{" +
                "name='" + name + '\'' +
                '}';
    }
}