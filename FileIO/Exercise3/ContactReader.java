import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ContactReader {

    public Contact readContact(String fileName) {
        Contact contact = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            contact = (Contact) ois.readObject();
            System.out.println("Contact loaded from file: " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading contact from file: " + e.getMessage());
        }
        return contact;
    }
}
