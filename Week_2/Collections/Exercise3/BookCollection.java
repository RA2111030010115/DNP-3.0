import java.util.*;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Scanner;

class BookCollection {
    LinkedHashSet<String> Books = new LinkedHashSet<>();

    public void addbook(String bookTitle) {
        if (Books.contains(bookTitle)) {
            System.out.println("BookTitle already exists");
        } else {
            Books.add(bookTitle);
            System.out.println("BookTitle added successfully");
        }
    }

    public void removebook(String BookTitle) {
        if (Books.contains(BookTitle)) {
            Books.remove(BookTitle);
            System.out.println("BookTitle removed successfully");
        } else {
            System.out.println("BookTitle not found");
        }
    }

    public void displayBooks() {
        System.out.println("Books:");
        Iterator<String> itr = Books.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}

