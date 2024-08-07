import java.util.TreeMap;

class CustomerAccounts {
    TreeMap<Integer, Customer> customers;

    public CustomerAccounts() {
        customers = new TreeMap<>();
    }

    public void addCustomer(Customer customer) {
        customers.put(customer.id, customer);
    }

    public void removeCustomer(int customerId) {
        customers.remove(customerId);
    }

    public void displayCustomers() {
        for (Customer customer : customers.values()) {
            System.out.println(customer);
        }
    }
}
