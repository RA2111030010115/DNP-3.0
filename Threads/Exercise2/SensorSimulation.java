public class SensorSimulation {

    public static void main(String[] args) {
         
        Sensor sensor1 = new Sensor("Sensor1");
        Sensor sensor2 = new Sensor("Sensor2");
        Sensor sensor3 = new Sensor("Sensor3");

        sensor1.start();
        sensor2.start();
        sensor3.start();

        
        try {
            sensor1.join();
            sensor2.join();
            sensor3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All sensors have completed data collection. Exiting main thread.");
    }
}
