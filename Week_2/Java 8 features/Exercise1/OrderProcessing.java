import java.util.ArrayList;
import java.util.List;

public class OrderProcessing {

    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, "Alice", 250.0, "NEW"));
        orders.add(new Order(2, "Bob", 150.0, "NEW"));
        orders.add(new Order(3, "Charlie", 300.0, "NEW"));
        orders.add(new Order(4, "David", 100.0, "NEW"));

        OrderFilter highValueOrderFilter = order -> order.orderAmount > 200.0;

        OrderProcessor markAsProcessed = order -> order.status = "PROCESSED";

        List<Order> filteredOrders = filterOrders(orders, highValueOrderFilter);
        System.out.println("Filtered Orders:");
        filteredOrders.forEach(System.out::println);

        processOrders(filteredOrders, markAsProcessed);
        System.out.println("\nProcessed Orders:");
        filteredOrders.forEach(System.out::println);
    }

    public static List<Order> filterOrders(List<Order> orders, OrderFilter filter) {
        List<Order> result = new ArrayList<>();
        for (Order order : orders) {
            if (filter.filter(order)) {
                result.add(order);
            }
        }
        return result;
    }

    public static void processOrders(List<Order> orders, OrderProcessor processor) {
        for (Order order : orders) {
            processor.process(order);
        }
    }
}
