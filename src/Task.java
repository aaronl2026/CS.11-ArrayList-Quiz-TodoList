public class Task {

    private String name;
    private int urgency;

    public Task(String name, int urgency) {
        this.name = name;
        this.urgency = urgency;
    }

    public Task(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) { this.name = newName; }

    public int getUrgency() {
        return urgency;
    }

    public void setUrgency(int newUrgency) {
        this.urgency = newUrgency;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", urgency=" + urgency +
                '}';
    }
}
