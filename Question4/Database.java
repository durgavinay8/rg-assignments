package Question4;

public class Database {

   // Step 1: Create a private static instance (initially null)
    private static Database instance;

  // Step 2: Make the constructor private to prevent instantiation from outside
    private Database() {
        System.out.println("Database connection created.");
    }

    // Step 3: Provide a public method to get the instance
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    // Example business logic method
    public void query(String sql) {
        System.out.println("Executing query: " + sql);
    }
}