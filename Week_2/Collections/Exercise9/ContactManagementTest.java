import java.util.Scanner;

public class ContactManagementTest {
    public static void main(String[] args) {
        ContactManagement contactManagement = new ContactManagement();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nContact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Display Contacts");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Contact ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    System.out.print("Enter Contact Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Contact Phone Number: ");
                    String phoneNumber = scanner.nextLine();

                    Contact contact = new Contact(id, name, phoneNumber);
                    contactManagement.addContact(contact);
                    break;

                case 2:
                    System.out.print("Enter Contact ID to remove: ");
                    int contactId = scanner.nextInt();
                    contactManagement.removeContact(contactId);
                    break;

                case 3:
                    contactManagement.displayContacts();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
