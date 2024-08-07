import java.util.*;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Scanner;

class UserRegistration {
    TreeSet<String> users = new TreeSet<>();

    public void registerUser(String username) {
        if (users.contains(username)) {
            System.out.println("User name already exists");
        } else {
            users.add(username);
            System.out.println("Username added successfully");
        }
    }

    public void removeUser(String username) {
        if (users.contains(username)) {
            users.remove(username);
            System.out.println("Username removed successfully");
        } else {
            System.out.println("Username not found");
        }
    }

    public void displayUsers() {
        System.out.println("Products:");
        Iterator<String> itr = users.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}

