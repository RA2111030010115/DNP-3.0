public class NumberPrinterThread extends Thread {

    @Override
    public void run() {
        System.out.println("Thread is running.");
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Printing number: " + i);
                Thread.sleep(1000); 
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
        System.out.println("Thread execution completed.");
    }
}
