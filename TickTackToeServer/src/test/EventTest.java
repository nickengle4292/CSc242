package test;
import model.Event;
import model.Event.EventStatus;

public class EventTest {
    public static void main(String[] args) {
        // Instantiate Event objects with default and parameterized constructors
        Event event1 = new Event();
        Event event2 = new Event(1, "userA", "userB", EventStatus.PENDING, "userA", 0);

        // Test getters and setters
        System.out.println("Event 1 - Default Constructor");
        System.out.println("Event ID: " + event1.getEventId());
        System.out.println("Sender: " + event1.getSender());
        System.out.println("Opponent: " + event1.getOpponent());
        System.out.println("Status: " + event1.getStatus());
        System.out.println("Turn: " + event1.getTurn());
        System.out.println("Move: " + event1.getMove());

        System.out.println("\nEvent 2 - Parameterized Constructor");
        System.out.println("Event ID: " + event2.getEventId());
        System.out.println("Sender: " + event2.getSender());
        System.out.println("Opponent: " + event2.getOpponent());
        System.out.println("Status: " + event2.getStatus());
        System.out.println("Turn: " + event2.getTurn());
        System.out.println("Move: " + event2.getMove());

        // Test setters
        event1.setEventId(2);
        event1.setSender("userX");
        event1.setOpponent("userY");
        event1.setStatus(EventStatus.ACCEPTED);
        event1.setTurn("userX");
        event1.setMove(3);

        System.out.println("\nEvent 1 - After Setters");
        System.out.println("Event ID: " + event1.getEventId());
        System.out.println("Sender: " + event1.getSender());
        System.out.println("Opponent: " + event1.getOpponent());
        System.out.println("Status: " + event1.getStatus());
        System.out.println("Turn: " + event1.getTurn());
        System.out.println("Move: " + event1.getMove());

        // Test the equals method
        System.out.println("\nTesting equals method:");
        System.out.println("event1.equals(event2): " + event1.equals(event2)); // Should be false
        System.out.println("event1.equals(event1): " + event1.equals(event1)); // Should be true
    }
}
