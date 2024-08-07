import java.util.LinkedList;
import java.util.Queue;

public class DataQueue {
    private Queue<Integer> queue = new LinkedList<>();
    private final int LIMIT = 10;
    
    public synchronized void add(int data) throws InterruptedException {
        while (queue.size() == LIMIT) {
            wait();
        }
        queue.add(data);
        notifyAll();
    }
    
    public synchronized int remove() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        int data = queue.poll();
        notifyAll();
        return data;
    }
}
