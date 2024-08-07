import java.util.Scanner;

public class CustomerAccountsTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerAccounts customerAccounts = new CustomerAccounts();

        while (true) {
            System.out.println("1. Add Customer");
            System.out.println("2. Remove Customer");
            System.out.println("3. Display Customers");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume the newline
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Customer Email: ");
                    String email = scanner.nextLine();
                    Customer customer = new Customer(id, name, email);
                    customerAccounts.addCustomer(customer);
                    break;
                case 2:
                    System.out.print("Enter Customer ID to Remove: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine(); // consume the newline
                    customerAccounts.removeCustomer(removeId);
                    break;
                case 3:
                    System.out.println("Current Customers:");
                    customerAccounts.displayCustomers();
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
