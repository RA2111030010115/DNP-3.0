import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ContactWriter {

    public void saveContact(String fileName, Contact contact) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(contact);
            System.out.println("Contact saved to file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving contact to file: " + e.getMessage());
        }
    }
}
