import com.google.gson.Gson;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class TodoServer {
    //...

    public TodoServer(int port, Todos todos) {
        Gson gson = new Gson();

        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(port);
                 Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                System.out.println("Соединение установлено");

                String json = in.readLine();
                todos = new Gson().fromJson(json, Todos.class);

                switch (TaskStorage.getType()) {
                    case "ADD":
                        todos.addTask((TaskStorage.getTask()));
                        break;
                    case "REMOVE":
                        todos.removeTask((TaskStorage.getTask()));
                        break;
                }
                out.println(todos.getAllTasks());

            } catch (IOException exception) {
                System.out.println("Соединение не установлено");
                exception.printStackTrace();
            }
        }
    }

    public void start() throws IOException {
        int port = 8989;
        System.out.println("Starting server at " + port + "...");

        //...
    }
}