package test;
import socket.GamingResponse;
import socket.Response;

import static socket.Response.ResponseStatus.FAILURE;
import static socket.Response.ResponseStatus.SUCCESS;

public class ResponseTest {
    public static void main(String[] args) {
        // Instantiate Response objects with default and parameterized constructors
        Response response1 = new Response();
        Response response2 = new Response(SUCCESS, "Operation was successful.");

        // Instantiate GamingResponse objects with default and parameterized constructors
        GamingResponse gamingResponse1 = new GamingResponse();
        GamingResponse gamingResponse2 = new GamingResponse(42, true);

        // Test getters and setters for Response class
        System.out.println("Response 1 - Default Constructor");
        System.out.println("Status: " + response1.getStatus());
        System.out.println("Message: " + response1.getMessage());

        System.out.println("\nResponse 2 - Parameterized Constructor");
        System.out.println("Status: " + response2.getStatus());
        System.out.println("Message: " + response2.getMessage());

        // Test setters for Response class
        response1.setStatus(FAILURE);
        response1.setMessage("An error occurred.");

        System.out.println("\nResponse 1 - After Setters");
        System.out.println("Status: " + response1.getStatus());
        System.out.println("Message: " + response1.getMessage());

        // Test getters and setters for GamingResponse class
        System.out.println("\nGamingResponse 1 - Default Constructor");
        System.out.println("Move: " + gamingResponse1.getMove());
        System.out.println("Active: " + gamingResponse1.isActive());

        System.out.println("\nGamingResponse 2 - Parameterized Constructor");
        System.out.println("Move: " + gamingResponse2.getMove());
        System.out.println("Active: " + gamingResponse2.isActive());

        // Test setters for GamingResponse class
        gamingResponse1.setMove(10);
        gamingResponse1.setActive(false);

        System.out.println("\nGamingResponse 1 - After Setters");
        System.out.println("Move: " + gamingResponse1.getMove());
        System.out.println("Active: " + gamingResponse1.isActive());
    }
}
