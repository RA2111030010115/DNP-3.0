public class Consumer extends Thread {
    private DataQueue queue;

    public Consumer(DataQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                int data = queue.remove();
                System.out.println("Consumed: " + data);
                Thread.sleep(150); // Simulate time taken to consume
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
