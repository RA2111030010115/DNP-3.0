import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeManagement {
    List<Employee> employees;

    
    public EmployeeManagement() {
        this.employees = new ArrayList<>();
    }

    
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    
    public void removeEmployee(int employeeId) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getId() == employeeId) {
                iterator.remove();
                System.out.println("Employee removed successfully.");
                return;
            }
        }
        System.out.println("Employee with ID " + employeeId + " not found.");
    }

    
    public void updateEmployee(int employeeId, String newAddress) {
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                employee.setAddress(newAddress);
                System.out.println("Employee address updated successfully.");
                return;
            }
        }
        System.out.println("Employee with ID " + employeeId + " not found.");
    }

    
    public void displayEmployees() {
        System.out.println("Employee List:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
