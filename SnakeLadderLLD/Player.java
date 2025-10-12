package SnakeLadderLLD;

public class Player {
    String id;
    String name;
    int currentPosition;
    
    public Player(String id, String name,  int currentPosition) {
        this.id = id;
        this.name = name;
        this.currentPosition = 0; // Starting position
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getCurrentPosition() {
       return currentPosition;
    }
    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
