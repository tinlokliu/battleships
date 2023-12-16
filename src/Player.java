//part 1
import java.util.Scanner;
public class Player {
    //attributes
    private String name;
    private int score;
    private Board board;

    //constructor
    public Player(String name, Board board) {
        this.name = name;
        this.score = 0;
        this.board = board;
    }

    //getter & setter for name attribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //getter & setter for score attribute
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    //method for players to take turn.
    public boolean takeTurn(Board board) {         //takes in the board object
        Scanner s = new Scanner(System.in);
        System.out.println("Where do you want to attack - enter x then follow up with y");
        int x = s.nextInt();
        int y = s.nextInt();

        if (x < 0 || x >= board.getRow() || y < 0 || y >= board.getCol()) {            //checks if the input is within the boards & if not it will return false & it will be the other player's turn.
            System.out.println("Invalid co-ordinates, out of bound. Turn used");
            return false;
        }

       Square square = board.board[x][y];

        if (square.isShot()) {                                                         //checks if square has already been attacked
            System.out.println("Square already has been attacked. Turn used");
            return false;
        } else {
            square.setShot(true);

            if (square.isHasShip()) {                                   //checks to see if a ship is on the square
                System.out.println("Hit!");
                Battleship ship = square.getShip();
                ship.gotHit();

                if (ship.isSunk()) {                                    //checks to see if a ship is sunk, if sunk increase the score of the player by 1
                    System.out.println("You sank a ship!");
                    this.score++;
                    System.out.println(this.getName() + " has " + this.getScore() + " points.");
                }
            } else {
                System.out.println("Miss.");                         //if a square in a board has not been fired before or is empty, prints miss.
            }

            if (board.areAllShipsSunk()){
                return true;
            }
            return false;
        }
    }

}
