package test;
import model.User;

public class UserTest {
    public static void main(String[] args) {
        // Instantiate User objects with default and parameterized constructors
        User user1 = new User();
        User user2 = new User("testUser", "password123", "JohnDoe", true);

        // Test getters and setters
        System.out.println("User 1 - Default Constructor");
        System.out.println("Username: " + user1.getUsername());
        System.out.println("Password: " + user1.getPassword());
        System.out.println("Display Name: " + user1.getDisplayName());
        System.out.println("Online: " + user1.isOnline());

        System.out.println("\nUser 2 - Parameterized Constructor");
        System.out.println("Username: " + user2.getUsername());
        System.out.println("Password: " + user2.getPassword());
        System.out.println("Display Name: " + user2.getDisplayName());
        System.out.println("Online: " + user2.isOnline());

        // Test setters
        user1.setUsername("newUser");
        user1.setPassword("newPassword123");
        user1.setDisplayName("NewUserDisplayName");
        user1.setOnline(false);

        System.out.println("\nUser 1 - After Setters");
        System.out.println("Username: " + user1.getUsername());
        System.out.println("Password: " + user1.getPassword());
        System.out.println("Display Name: " + user1.getDisplayName());
        System.out.println("Online: " + user1.isOnline());

        // Test the equals method
        System.out.println("\nTesting equals method:");
        System.out.println("user1.equals(user2): " + user1.equals(user2)); // Should be false
        System.out.println("user1.equals(user1): " + user1.equals(user1)); // Should be true
    }
}
