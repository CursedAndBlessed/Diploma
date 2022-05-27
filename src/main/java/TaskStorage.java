public class TaskStorage {

    static String type;
    static String task;

    public TaskStorage(String type, String task) {
        this.task = task;
        this.type = type;
    }

    public static String getType() {
        return type;
    }

    public static String getTask() {
        return task;
    }


}
