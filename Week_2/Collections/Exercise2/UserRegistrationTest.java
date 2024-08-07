import java.util.Scanner;

public class UserRegistrationTest {
    public static void main(String[] args) {
        UserRegistration registration = new UserRegistration();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nUser Registration Menu:");
            System.out.println("1. Register a user");
            System.out.println("2. Remove a user");
            System.out.println("3. Display all users");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter user name to register: ");
                    String registerUser = scanner.nextLine();
                    registration.registerUser(registerUser);
                    break;
                case 2:
                    System.out.print("Enter user name to remove: ");
                    String removeUser = scanner.nextLine();
                    registration.removeUser(removeUser);
                    break;
                case 3:
                    registration.displayUsers();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting User Registration.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        scanner.close();
    }
}
