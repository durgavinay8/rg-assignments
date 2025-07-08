package Question7;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeJDBC {

    private static final String URL = "jdbc:mysql://localhost:3306/org";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Create
    public void addEmployee(Employee emp) {
        String sql = "INSERT INTO employee (id, name, department) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, emp.getId());
            stmt.setString(2, emp.getName());
            stmt.setString(3, emp.getDepartment());
            stmt.executeUpdate();
            System.out.println("Employee added: " + emp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("department")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Update
    public void updateEmployee(Employee emp) {
        String sql = "UPDATE employee SET name = ?, department = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getDepartment());
            stmt.setInt(3, emp.getId());
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee updated: " + emp);
            } else {
                System.out.println("Employee not found with ID: " + emp.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee deleted with ID: " + id);
            } else {
                System.out.println("Employee not found with ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Main method to test CRUD
    public static void main(String[] args) {
        EmployeeJDBC db = new EmployeeJDBC();

        Employee e1 = new Employee(1, "Vinay", "HR");
        Employee e2 = new Employee(2, "Sita", "IT");

        // Create
        db.addEmployee(e1);
        db.addEmployee(e2);

        // Read
        List<Employee> employees = db.getAllEmployees();
        System.out.println("All Employees:");
        for (Employee e : employees) {
            System.out.println(e);
        }

        // Update
        e2.setName("Ram");
        e2.setDepartment("Tech");
        db.updateEmployee(e2);

        // Delete
        db.deleteEmployee(1);

        // Read again
        System.out.println("After changes:");
        for (Employee e : db.getAllEmployees()) {
            System.out.println(e);
        }
    }
}

