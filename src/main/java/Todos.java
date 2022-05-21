import java.util.*;


public class Todos {
    static ArrayList<String> tasks = new ArrayList<>();
    private String type;
    private String task;



    public void addTask(String task) {
        tasks.add(task);
        Collections.sort(tasks);
        //...
    }

    public void removeTask(String task) {
        tasks.remove(task);
        //...
    }
    public String getTask() {
        return task;
    }

    public String getType() {
        return type;
    }

    public String getAllTasks() {
        return tasks.toString();
    }
    public ArrayList<String> getListTask() {
        return tasks;
    }

}