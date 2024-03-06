import static org.junit.jupiter.api.Assertions.*;

class TodoListTest {

    private TodoList bobsList;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        bobsList = new TodoList("Bob Wick");
        bobsList.addTask("Math homework", 10);
        bobsList.addTask("Physics homework", 8);
        bobsList.addTask("Do the dishes", 5);
        bobsList.addTask("Walk the dog", 6);
        bobsList.addTask("Computer Science", 11);
        bobsList.addTask("Witchcraft and Wizardry", 7);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {

        bobsList = null;

    }

    @org.junit.jupiter.api.Test
    void mostUrgent() {

        assertEquals("Computer Science", bobsList.mostUrgent());
        bobsList.updateTaskUrgency("Do the dishes", 2);
        assertEquals("Computer Science", bobsList.mostUrgent());
        bobsList.updateTaskUrgency("Computer Science", 6);
        assertEquals("Math homework", bobsList.mostUrgent());

    }

    @org.junit.jupiter.api.Test
    void averageUrgency() {

        assertEquals(7.8, ((int) (bobsList.averageUrgency()*10))/10.0);
        bobsList.updateTaskUrgency("Math homework", 4);
        assertEquals(6.8, ((int) (bobsList.averageUrgency()*10))/10.0);
        bobsList.updateTaskUrgency("Walk the dog", 10);
        assertEquals(7.5, ((int) (bobsList.averageUrgency()*10))/10.0);

    }

    @org.junit.jupiter.api.Test
    void toStringTest() {

        String expectedTodoList = "To-do List of Bob Wick\nMath homework\t10\nPhysics homework\t8\nDo the dishes\t5\nWalk the dog\t6\nComputer Science\t11\nWitchcraft and Wizardry\t7";
        String sortedList = "To-do List of Bob Wick\nComputer Science\t11\nMath homework\t10\nPhysics homework\t8\nWitchcraft and Wizardry\t7\nWalk the dog\t6\nDo the dishes\t5";
        String actualTodoList = bobsList.toString().trim();
        if (actualTodoList.equals(sortedList))
            assertTrue(true);
        else
            assertEquals(expectedTodoList, actualTodoList);
    }
}