import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


class TodosTests {

    private Todos todos;

    @BeforeAll
    public static void startTesting() {
        System.out.println("Запуск тестов");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Начало тестирования");
        String testTask1 = "Сходить в магазин";
        String testTask2 = "Выйти на пробежку";
        String testTask3 = "Работать на дядю";
        Todos.tasks.add(testTask1);
        Todos.tasks.add(testTask2);
        Todos.tasks.add(testTask3);
        todos = new Todos();
    }

    @AfterEach
    public void refresh() {
        Todos.tasks.clear();
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
        String testStr = "Сходить в магазин Выйти на пробежку Работать на дядю ";
        Assertions.assertEquals(testStr, todos.getAllTasks());
    }
}