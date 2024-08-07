public class TaskScheduler {

    public static void main(String[] args) {
        Task task1 = new Task("Task 1");
        Task task2 = new Task("Task 2");
        Task task3 = new Task("Task 3");

        
        task2.setDependentTask(task1);
        task3.setDependentTask(task2);

        task1.start();
        task2.start();
        task3.start();
    }
}