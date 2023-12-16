//part 2
public class Battleship {
    //attributes
    private boolean sunk;
    private int health;
    private int size;

    //constructor
    public Battleship (int size) {
        this.sunk = false;
        this.size = size;
        this.health = size;
    }

    //getters & setters for battleship attributes
    public boolean isSunk() {
        return sunk;
    }

    public void setSunk(boolean sunk) {
        this.sunk = sunk;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void gotHit() {
        health--;
        if (health == 0){
            sunk = true;
        }
    }


}
