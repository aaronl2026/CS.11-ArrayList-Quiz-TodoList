import java.util.ArrayList;

public class TodoList {

    private String owner;
    private ArrayList<Task> tasks;

    public TodoList(String owner) {
        this.owner = owner;
        this.tasks = new ArrayList<Task>();
    }

    public boolean addTask(String name, int urgency) {
        for (Task task: tasks) {
            if (task.getName().equals(name))
                return false;
        }
        tasks.add(new Task(name, urgency));
        return true;
    }

    public boolean removeTask(String name) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getName().equals(name)) {
                tasks.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean updateTaskUrgency(String name, int urgency) {

        for (Task task : tasks) {
            if (task.getName().equals(name)) {
                task.setUrgency(urgency);
                return true;
            }
        }
        return false;
    }

    /**
     * The method mostUrgent will return the name of the task that is the most urgent (i.e. the task with the
     * highest urgency). If there are multiple tasks whose urgency is equal to the maximum, the first task
     * with that urgency will be returned.
     * @return the name of the task with the current highest urgency (a String).
     */
    public String mostUrgent() {
        int maximumUrgency = 0;
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).getUrgency() > maximumUrgency){
                maximumUrgency = tasks.get(i).getUrgency();
            }
        }
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).getUrgency() == maximumUrgency){
                return tasks.get(i).getName();
            }
        }
        return null;

    }

    /**
     * The method averageUrgency will return the average (arithmetic mean) of the urgency across all tasks
     * @return the average urgency across all tasks (a double).
     */
    public double averageUrgency() {
        double sum = 0.0;
        int entities = tasks.size();
        for(int i = 0; i < tasks.size(); i++){
            int average = tasks.get(i).getUrgency();
            double averageD = average;
            sum = sum + averageD;
        }
        sum = sum/entities;
        return sum;

    }

    /**
     * The method toString will return all tasks with their urgency in the form of a String.
     * The returned String will be in the following format:
     *
     * To-do List of [owner]
     * [Task 1] [tab] [urgency]
     * [Task 2] [tab] [urgency]
     * [Task 3] [tab] [urgency]
     * [Task 4] [tab] [urgency]
     * ...
     * @return the printable representation of the to-do list (a String).
     *
     * BONUS Challenge:  Sort your to-do list in descending order of urgency
     */
    public String toString() {
        String string = "To-do List of "+owner;
        for(int i = 0; i < tasks.size(); i++){
            string = string + "\n" + "Task " + (i+1) + "\t" + tasks.get(i).getUrgency();
        }
        return string;
    }

}
