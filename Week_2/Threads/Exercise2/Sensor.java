
import java.util.Random;

public class Sensor extends Thread {
    private String sensorName;

    public Sensor(String sensorName) {
        this.sensorName = sensorName;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int data = random.nextInt(100); // Simulate collecting random data
            System.out.println(sensorName + " collected data: " + data);
            try {
                Thread.sleep(1000); // Simulate data collection interval
            } catch (InterruptedException e) {
                System.out.println(sensorName + " interrupted.");
            }
        }
        System.out.println(sensorName + " has finished data collection.");
    }
}
