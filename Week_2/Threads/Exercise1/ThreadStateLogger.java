public class ThreadStateLogger {

    public static void main(String[] args) {
        NumberPrinterThread thread = new NumberPrinterThread();

        
        System.out.println("Thread state just created: " + thread.getState());

        
        thread.start();
        System.out.println("Thread state after starting: " + thread.getState());

        
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread state after execution: " + thread.getState());
    }
}
