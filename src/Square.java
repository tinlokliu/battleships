//part 1
public class Square {
    //attributes
    protected int row;
    protected int column;
    protected boolean hasShip;
    protected Battleship ship;
    protected boolean shotFired;

    //constructor
    public Square (int row, int col){
        this.row = row;
        this.column = col;
        this.hasShip = false;
        this.ship = null;
        this.shotFired = false;
    }

    //getters & setters
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isHasShip() {
        return hasShip;
    }

    public void setHasShip(boolean hasShip) {
        this.hasShip = hasShip;
    }

    public Battleship getShip() {
        return ship;
    }

    public void setShip(Battleship ship) {
        this.ship = ship;
    }

    public boolean isShot() {
        return shotFired;
    }

    public void setShot(boolean shot) {
        this.shotFired = shot;
    }

    public String toString() {                              //toString method to visually see the board
        if (shotFired && !hasShip) {
            return " x ";
        }
            if (shotFired && hasShip) {
                return " o ";
            }
            else {
                return " - ";
            }
        }

    }



