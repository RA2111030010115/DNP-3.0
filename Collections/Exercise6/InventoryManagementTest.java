import java.util.Scanner;

public class InventoryManagementTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManagement inventoryManagement = new InventoryManagement();

        while (true) {
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Update Product Quantity");
            System.out.println("4. Display Products");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume the newline
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Product Quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // consume the newline
                    Product product = new Product(id, name, quantity);
                    inventoryManagement.addProduct(product);
                    break;
                case 2:
                    System.out.print("Enter Product ID to Remove: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine(); // consume the newline
                    inventoryManagement.removeProduct(removeId);
                    break;
                case 3:
                    System.out.print("Enter Product ID to Update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter New Quantity: ");
                    int newQuantity = scanner.nextInt();
                    scanner.nextLine(); // consume the newline
                    inventoryManagement.updateProductQuantity(updateId, newQuantity);
                    break;
                case 4:
                    System.out.println("Current Inventory:");
                    inventoryManagement.displayProducts();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
