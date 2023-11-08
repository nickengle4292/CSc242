package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Event;
import socket.Request;
import socket.Response;

public class ServerHandler extends Thread {
    private final Socket clientSocket;
    private final String currentUsername;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private Gson gson;
    private static Event gameEvent; // Static variable to store game event

    public ServerHandler(Socket clientSocket, String username) {
        this.clientSocket = clientSocket;
        this.currentUsername = username;

        try {
            // Initialize the DataInputStream and DataOutputStream
            inputStream = new DataInputStream(clientSocket.getInputStream());
            outputStream = new DataOutputStream(clientSocket.getOutputStream());

            // Initialize Gson with the configuration to serialize null values
            gson = new GsonBuilder().serializeNulls().create();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Initialize the game event with default values
        gameEvent = new Event();
        gameEvent.setPlayer1(null); // Set to default value
        gameEvent.setPlayer2(null); // Set to default value
        gameEvent.setMove(-1); // Set move attribute to -1 (no move)
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Read the client's serialized request
                String clientRequest = inputStream.readUTF();

                // Deserialize the request using Gson
                Request request = gson.fromJson(clientRequest, Request.class);

                // Check for client disconnection
                if (clientRequest == null) {
                    break;
                }

                // Get the response for the particular request
                Response response = handleRequest(request);

                // Serialize the response and write it to the output stream
                String responseJson = gson.toJson(response);
                outputStream.writeUTF(responseJson);
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the connection when a client disconnects
            close();
        }
    }

    public void close() {
        try {
            // Close the input and output streams
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }

            // Close the client socket
            if (clientSocket != null && !clientSocket.isClosed()) {
                clientSocket.close();
            }

            System.out.println("Connection closed for user: " + currentUsername);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 7: Handle request and send response
    public Response handleRequest(Request request) {
        switch (request.getType()) {
            case SEND_MOVE:
                int move = Integer.parseInt(request.getData()); // Convert the string to an integer
                int result = handleSendMove(move);
                return new Response(Response.ResponseStatus.SUCCESS, "Move sent: " + result);
            case REQUEST_MOVE:
                int requestedMove = handleRequestMove();
                return new Response(Response.ResponseStatus.SUCCESS, "Requested move: " + requestedMove);
            default:
                return new Response(Response.ResponseStatus.FAILURE, "Invalid request type");
        }
    }

    // Handle SEND_MOVE request
    private int handleSendMove(int move) {
        // Check if the move is valid (e.g., not made by the same user)
        if (gameEvent.getMove() != -1 && !currentUsername.equals(gameEvent.getTurn())) {
            gameEvent.setMove(move);
            // Update the turn attribute if needed
            // Implement any other logic you need
        }
        return gameEvent.getMove();
    }

    // Handle REQUEST_MOVE request
    private int handleRequestMove() {
        int requestedMove = gameEvent.getMove();
        // Set the move to -1 after it's sent to the opponent
        gameEvent.setMove(-1);
        return requestedMove;
    }
}
