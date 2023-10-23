package socket;

public class GamingResponse {
    private int move;
    private boolean active;

    public GamingResponse() {
        // Default constructor, make sure to call the superclass constructor if needed
        super();
    }

    public GamingResponse(int move, boolean active) {
        // Call the superclass constructor if needed
        super();

        this.move = move;
        this.active = active;
    }

    public int getMove() {
        return move;
    }

    public boolean isActive() {
        return active;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}