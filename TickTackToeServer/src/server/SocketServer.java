package server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    private static final int PORT = 5000;

    public SocketServer() {
        // Call the parameterized constructor with the default port value of 5000
        this(PORT);
    }

    public SocketServer(int port) {
        // Constructor that sets the constant port number
        // You can use this constructor to set a custom port if needed
    }

    public void setup() {
        // A method that sets up the server for connection
        // You can implement server setup logic here
    }

    public void startAcceptingRequests() {
        // A method that starts accepting client requests
        // You can implement the logic for accepting and handling client connections here
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                // Handle the client connection in a separate thread or method
                // You can create a new thread or delegate to a method to handle the client
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return
     */
    public int getPort() {
        // Getter for the PORT attribute
        return PORT;
    }

    public static void main(String[] args) {
        // The static main method that instantiates the class, sets up the server, and starts accepting requests
        SocketServer server = new SocketServer();
        server.setup();
        server.startAcceptingRequests();
    }
}
