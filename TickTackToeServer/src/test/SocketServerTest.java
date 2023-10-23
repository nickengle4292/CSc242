package test;
import server.SocketServer;
public class SocketServerTest {
    public static void main(String[] args) {
        testDefaultConstructor();
        testParameterizedConstructor();
        testNegativePortNumber();
    }

    public static void testDefaultConstructor() {
        SocketServer server = new SocketServer();
        assert server.getPort() == 5000;
    }

    public static void testParameterizedConstructor() {
        SocketServer server = new SocketServer(6000);
        assert server.getPort() == 6000;
    }

    public static void testNegativePortNumber() {
        try {
            SocketServer server = new SocketServer(-100);
            System.out.println("Negative port number was accepted."); // This line should not be reached.
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }
}