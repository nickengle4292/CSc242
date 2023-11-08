package server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class SocketServer {
    private static int PORT = 5000;
    private ServerSocket serverSocket;

    private static final Logger logger = Logger.getLogger(SocketServer.class.getName());

    public SocketServer() {
        // Call the parameterized constructor with the default port value of 5000
        this(PORT);
    }

    public SocketServer(int x) {
        if (x <= 0) {
            throw new IllegalArgumentException("Port number must be a positive value.");
        }
        PORT = x;
    }

    public void setup() {
        try {
            // Create the server socket and log server information
            serverSocket = new ServerSocket(PORT);
            InetAddress serverAddress = serverSocket.getInetAddress();

            // Log server information
            logger.info("Server is listening on port " + PORT);
            logger.info("Server hostname: " + serverAddress.getHostName());
            logger.info("Server host address: " + serverAddress.getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startAcceptingRequests() {
        // A method that starts accepting client requests
        // You can implement the logic for accepting and handling client connections here
        try {
            int clientCount = 0;
            while (clientCount < 2) {
                Socket clientSocket = serverSocket.accept();

                // Generate a unique username for each client, e.g., "User1", "User2"
                String username = "User" + (clientCount + 1);

                // Create a new ServerHandler instance for the client and start the thread
                ServerHandler handler = new ServerHandler(clientSocket, username);
                handler.start();

                // Increment the client count
                clientCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


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
