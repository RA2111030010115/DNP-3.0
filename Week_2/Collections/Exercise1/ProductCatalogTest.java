import java.util.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
class ProductCatalogTest {

    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nProduct Catalog Menu:");
            System.out.println("1. Add a product");
            System.out.println("2. Remove a product");
            System.out.println("3. Search for a product");
            System.out.println("4. Display all products");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.print("Enter product name to add: ");
                    String addProduct = scanner.nextLine();
                    catalog.addProduct(addProduct);
                    break;
                case 2:
                    System.out.print("Enter product name to remove: ");
                    String removeProduct = scanner.nextLine();
                    catalog.removeProduct(removeProduct);
                    break;
                case 3:
                    System.out.print("Enter product name to search: ");
                    String searchProduct = scanner.nextLine();
                    boolean found = catalog.searchProduct(searchProduct);
                    if (found) {
                        System.out.println("Product " + searchProduct + " found in the catalog.");
                    } else {
                        System.out.println("Product " + searchProduct + " not found in the catalog.");
                    }
                    break;
                case 4:
                    catalog.displayProducts();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting Product Catalog.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        scanner.close();
    }
}
