public class Producer extends Thread {
    private DataQueue queue;

    public Producer(DataQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                queue.add(i);
                System.out.println("Produced: " + i);
                Thread.sleep(100); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
