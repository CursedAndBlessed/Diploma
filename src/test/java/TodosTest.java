import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


class TodosTests {

    private Todos todos;

    @BeforeAll
    public static void startTesting() {
        System.out.println("Запуск тестов");
    }

    @AfterAll
    public static void endTest() {
        System.out.println("Тесты завершены");
    }

    @BeforeEach
    public void setUp() {
        todos = new Todos();
        String testTask1 = "Сходить в магазин";
        String testTask2 = "Выйти на пробежку";
        String testTask3 = "Работать на дядю";
        todos.addTask(testTask1);
        todos.addTask(testTask2);
        todos.addTask(testTask3);

    }


    @Test
    public void addNewTaskTest() {
        Assertions.assertEquals(todos.getListTask().size(), 3);
        todos.addTask("Учить java");
        Assertions.assertEquals(todos.getListTask().size(), 4);
    }

    @Test
    public void removeTaskTest() {
        todos.removeTask("Работать на дядю");
        ArrayList<String> taskList = todos.getListTask();
        Assertions.assertEquals(taskList.size(), 2);
    }

    @Test
    public void getAllTasksTest() {
        String testStr = "Выйти на пробежку Работать на дядю Сходить в магазин ";
        Assertions.assertEquals(testStr, todos.getAllTasks());
    }
}