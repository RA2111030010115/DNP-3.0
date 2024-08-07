public class ContactApp {

    public static void main(String[] args) {
        String fileName = "contact.ser";
        ContactWriter contactWriter = new ContactWriter();
        ContactReader contactReader = new ContactReader();

        
        Contact contact = new Contact(1, "John Doe", "1234567890", "john.doe@example.com");

        
        contactWriter.saveContact(fileName, contact);

        
        Contact loadedContact = contactReader.readContact(fileName);
        if (loadedContact != null) {
            System.out.println("Loaded Contact Details:");
            System.out.println(loadedContact);
        }

        
        String nonExistentFile = "nonexistentfile.ser";
        System.out.println("\nAttempting to read from a non-existent file...");
        contactReader.readContact(nonExistentFile);
    }
}
