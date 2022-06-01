import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class TodoServer {
    public TodoServer(int port, Todos todos) {
        GsonBuilder builder;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (
                        Socket clientSocket = serverSocket.accept();
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ) {
                    System.out.println("Соединение установлено");

                    while (true) {
                        String line = in.readLine();
                        builder = new GsonBuilder();
                        Gson gson = builder.create();
                        TaskStorage task = gson.fromJson(line, TaskStorage.class);
                        if (task.type == TaskStorage.Type.ADD) {
                            todos.addTask(task.task);
                            out.println(todos.getAllTasks());
                        } else if (task.type == TaskStorage.Type.REMOVE) {
                            todos.removeTask(task.task);
                            out.println(todos.getAllTasks());
                        }
                    }
                } catch (Exception exception) {
                    System.out.println(exception);
                }
            }
        } catch (Exception exception) {
            System.out.println("Соединение не установлено");
            exception.printStackTrace();

        }
    }

    public void start() throws IOException {
        int port = 8989;
        System.out.println("Starting server at " + port + "...");

    }
}