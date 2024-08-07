import java.util.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

class ProductCatalog {
    HashSet<String> products = new HashSet<>();

    public void addProduct(String pname) {
        if (products.contains(pname)) {
            System.out.println("Product name already exists");
        } else {
            products.add(pname);
            System.out.println("Product added successfully");
        }
    }

    public void removeProduct(String pname) {
        if (products.contains(pname)) {
            products.remove(pname);
            System.out.println("Product removed successfully");
        } else {
            System.out.println("Product not found");
        }
    }

    public boolean searchProduct(String pname) {
        return products.contains(pname);
    }

    public void displayProducts() {
        System.out.println("Products:");
        Iterator<String> itr = products.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}

