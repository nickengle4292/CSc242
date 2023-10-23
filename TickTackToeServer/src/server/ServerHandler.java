package server;
import java.io.IOException;
import java.net.Socket;

public class ServerHandler extends Thread {
    private Socket clientSocket;

    public ServerHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        // Implement the logic for handling client communication here
        // This method will handle I/O between the server and the client
        // You can add your communication logic here.
    }

    public void close() {
        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
