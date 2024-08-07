public class Task extends Thread {

    String taskName;
    Task dependentTask; 

    public Task(String taskName) {
        this.taskName = taskName;
    }

    public void setDependentTask(Task dependentTask) {
        this.dependentTask = dependentTask;
    }

    @Override
    public void run() {
        System.out.println(taskName + " started.");

        
        try {
           
            System.out.println(taskName + " is sleeping.");
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       
        System.out.println(taskName + " is yielding.");
        Thread.yield();

        
        if (dependentTask != null) {
            try {
                System.out.println(taskName + " is waiting for " + dependentTask.taskName + " to complete.");
                dependentTask.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(taskName + " completed.");
    }
}