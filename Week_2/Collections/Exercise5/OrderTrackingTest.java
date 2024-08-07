import java.util.Scanner;

public class OrderTrackingTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderTracking orderTracking = new OrderTracking();

        while (true) {
            System.out.println("1. Add Order");
            System.out.println("2. Process Order");
            System.out.println("3. Display Orders");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Order ID: ");
                    int orderId = scanner.nextInt();
                    scanner.nextLine(); // consume the newline
                    System.out.print("Enter Order Details: ");
                    String orderDetails = scanner.nextLine();
                    Order order = new Order(orderId, orderDetails);
                    orderTracking.addOrder(order);
                    break;
                case 2:
                    Order processedOrder = orderTracking.processOrder();
                    if (processedOrder != null) {
                        System.out.println("Processed Order: " + processedOrder);
                    } else {
                        System.out.println("No orders to process.");
                    }
                    break;
                case 3:
                    System.out.println("Current Orders:");
                    orderTracking.displayOrders();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
