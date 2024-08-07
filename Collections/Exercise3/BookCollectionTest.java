import java.util.Scanner;

public class BookCollectionTest {
    public static void main(String[] args) {
        BookCollection collection = new BookCollection();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nBook Collection Menu:");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Display all books");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.print("Enter book title to add: ");
                    String addBook = scanner.nextLine();
                    collection.addbook(addBook);
                    break;
                case 2:
                    System.out.print("Enter book title to remove: ");
                    String removeBook = scanner.nextLine();
                    collection.removebook(removeBook);
                    break;
                case 3:
                    collection.displayBooks();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting Book Collection.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        scanner.close();
    }
}
