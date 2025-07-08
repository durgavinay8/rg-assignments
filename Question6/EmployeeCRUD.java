package Question6;

import java.util.ArrayList;
import java.util.Iterator;

public class EmployeeCRUD {
    private ArrayList<Employee> employees = new ArrayList<>();

    // Create
    public void addEmployee(int id, String name, String Department) {
        Employee e = new Employee(id, name, Department);
        employees.add(e);
        System.out.println("Employee added: " + e);
    }

    public void addEmployee(Employee e) {
        employees.add(e);
        System.out.println("Employee added: " + e);
    }

    // Read
    public void listEmployees() {
        System.out.println("Employee List:");
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    // Update
    public boolean updateEmployee(int id, String newName, String newDept) {
        for (Employee e : employees) {
            if (e.getId() == id) {
                e.setName(newName);
                e.setDepartment(newDept);
                System.out.println("Employee updated: " + e);
                return true;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
        return false;
    }

    // Delete
    public boolean deleteEmployee(int id) {
        Iterator<Employee> it = employees.iterator();
        while (it.hasNext()) {
            Employee e = it.next();
            if (e.getId() == id) {
                it.remove();
                System.out.println("Employee deleted: " + e);
                return true;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
        return false;
    }

    // Main method to test CRUD
    public static void main(String[] args) {
        EmployeeCRUD crud = new EmployeeCRUD();

        // Create
        crud.addEmployee(new Employee(1, "Vinay", "HR"));
        crud.addEmployee(2, "Sita", "IT");
        crud.addEmployee(new Employee(3, "Ram", "Finance"));

        // Read
        crud.listEmployees();

        // Update
        crud.updateEmployee(2, "Pikachu", "Tech");

        // Delete
        crud.deleteEmployee(1);

        // Read again
        crud.listEmployees();
    }
}
