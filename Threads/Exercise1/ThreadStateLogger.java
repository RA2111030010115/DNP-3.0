public class ThreadStateLogger {

    public static void main(String[] args) {
        NumberPrinterThread thread = new NumberPrinterThread();

        // Log initial state
        System.out.println("Thread state just created: " + thread.getState());

        // Start the thread and log its state
        thread.start();
        System.out.println("Thread state after starting: " + thread.getState());

        // Wait for the thread to finish execution and log its state
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread state after execution: " + thread.getState());
    }
}