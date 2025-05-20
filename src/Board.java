//part 2
import java.util.Random;
public class Board {

    //attributes
    private int row;
    private int col;
    protected Square[][] board;             //protected to allow take turn method in player class to reference.
    private Battleship[][] battleships;

    //constructor
    public Board(int row, int col) {
        this.row = row;
        this.col = col;
        this.board = new Square[this.row][this.col];  //array to create board parameters
        this.battleships = new Battleship[this.row][this.col];
    }

    //method to generate board
    public void generateBoard() {

        for (int i = 0; i < this.row; i++) {
            for (int k = 0; k < this.col; k++) {
                this.board[i][k] = new Square(i, k);
                System.out.print(this.board[i][k]);
            }
            System.out.println();
        }
    }

    //method to generate battleships
    public void generateBattleships() {
        for (int i = 0; i < SmallBattleship.Total_Small_Battleships; i++) {                 //generates 3 small battleships
            placeBattleship(new SmallBattleship());
        //   System.out.println("Small generated");
        }

        for (int i = 0; i < MediumBattleship.Total_Medium_Battleships; i++) {               //generates 2 medium battleships
            placeBattleship(new MediumBattleship());
           // System.out.println("Medium generated");
        }

        for (int i = 0; i < LargeBattleship.Total_Large_Battleships; i++) {                 //generates 1 large battleship
            placeBattleship(new LargeBattleship());
          //  System.out.println("Large generated");
        }
    }
    //method to place battleships
    private void placeBattleship(Battleship battleship) {
        int shipSize = battleship.getSize();
        int randomRow;
        int randomCol;
        boolean vertical;                       //boolean vertical to determine whether ship should be vertical
        Random r = new Random();                //imported & created a new randomizer to set random co-ords for the battleship

        do {
            randomRow = r.nextInt(this.row ); //sets a random row
            randomCol = r.nextInt(this.col ); //sets a random col 
            vertical = r.nextBoolean();
        } while (!isSuitable(randomRow, randomCol, vertical, shipSize));         //checks to determine if is suitable

        //System.out.println("Placing battleship at coordinates: (" + randomRow + ", " + randomCol + ")");

        for (int k = 0; k < shipSize; k++) {            //ship size is used to ensure that the ship occupies the correct amount of squares
            if (vertical) {
                if (randomRow + k >= this.row) {
                    break;
                }
                this.board[randomRow + k][randomCol].setHasShip(true);
                this.board[randomRow + k][randomCol].setShip(battleship);
                this.battleships[randomRow + k][randomCol] = battleship;
            } else {
                if (randomCol + k >= this.col) {
                    break;
                }
                this.board[randomRow][randomCol + k].setHasShip(true);
                this.board[randomRow][randomCol + k].setShip(battleship);
                this.battleships[randomRow][randomCol + k] = battleship;
            }
        }

      }

        private boolean isSuitable ( int row, int col, boolean vertical, int size) {                                        //method to return a boolean to determine whether the space is suitable for a battleship
            for (int i = 0; i < 5; i++) {                                                                                 //for loop goes through 5 iterations which is necessary to determine whether the space is suitable
                if (row < 0 || col < 0 || row >= this.row || col >= this.col || this.board[row][col].isHasShip()) {    //ensure that the random row & col is not less than 0 as that is outside the array & also checks if there is already a ship on the space
                    return false;                                                                                   //returns false which leads the code back to the start of the generateBattleships loop
                }
                if (vertical) {
                    if (row >= this.row) {
                        return false;
                    }
                    row++;
                } else {
                    if (col >= this.col) {
                        return false;
                    }
                    col++;
                }
            }
            return true;

        }

        public String toString () {
            String boardString = "";

            for (int i = 0; i < row; i++) {
                for (int k = 0; k < col; k++) {
                    boardString += board[i][k].toString();
                }
                boardString += "\n";
            }
            return boardString;
        }

    public boolean isGameOver() {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                if (battleships[i][j] != null && !battleships[i][j].isSunk()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }


}
