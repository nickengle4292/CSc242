package test;
import socket.Request;

import static socket.Request.RequestType.ACCEPT_INVITATION;
import static socket.Request.RequestType.LOGIN;

public class RequestTest {
    public static void main(String[] args) {
        // Instantiate Request objects with default and parameterized constructors
        Request request1 = new Request();
        Request request2 = new Request(LOGIN, "additionalData");

        // Test getters and setters
        System.out.println("Request 1 - Default Constructor");
        System.out.println("Type: " + request1.getType());
        System.out.println("Data: " + request1.getData());

        System.out.println("\nRequest 2 - Parameterized Constructor");
        System.out.println("Type: " + request2.getType());
        System.out.println("Data: " + request2.getData());

        // Test setters
        request1.setType(ACCEPT_INVITATION);
        request1.setData("newData");

        System.out.println("\nRequest 1 - After Setters");
        System.out.println("Type: " + request1.getType());
        System.out.println("Data: " + request1.getData());
    }
}
