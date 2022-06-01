import java.util.*;


public class Todos {
    private ArrayList<String> tasks = new ArrayList<>();


    public void addTask(String task) {
        tasks.add(task);
        Collections.sort(tasks);
    }

    public void removeTask(String task) {
        tasks.remove(task);

    }

    public String getAllTasks() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String task : tasks) {
            stringBuilder.append(task);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    public ArrayList<String> getListTask() {
        return this.tasks;
    }


}