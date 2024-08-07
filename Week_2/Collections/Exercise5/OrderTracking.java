import java.util.LinkedList;

public class OrderTracking {
    private LinkedList<Order> orders;

    public OrderTracking() {
        orders = new LinkedList<>();
    }

    // Method to add an order to the list
    public void addOrder(Order order) {
        orders.add(order);
    }

    // Method to process an order (FIFO)
    public Order processOrder() {
        if (orders.isEmpty()) {
            System.out.println("No orders to process.");
            return null;
        }
        return orders.removeFirst();
    }

    // Method to display all orders in the list
    public void displayOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders to display.");
        } else {
            System.out.println("Current Orders:");
            for (Order order : orders) {
                System.out.println(order);
            }
        }
    }
}
