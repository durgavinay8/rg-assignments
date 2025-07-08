package Question4;

public class Application {
    public static void main(String[] args) {
        Database foo = Database.getInstance();
        foo.query("SELECT * FROM users");

        Database bar = Database.getInstance();
        bar.query("SELECT * FROM orders");

        if (foo == bar) {
            System.out.println("Both foo and bar refer to the same Database instance.");
        }
    }
}