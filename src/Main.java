// 2868480L - Assessment 2
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(10, 10);   //creates a new board object called board
        board.generateBoard();                       //generates board full of square objects
        board.generateBattleships();                 //adds battleships randomly within the parameters of the row & col

        //scanner prompt to ask for users name
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter a username for player 1");
        String username = s.nextLine();
        Player player1 = new Player(username, board);                   //object for player 1 is created

        System.out.println("Please enter a username for player 2");
        String username2 = s.nextLine();
        Player player2 = new Player(username2, board);                   //object for player 2 is created

        int currentPlayerIndex = 0;
        Player[] players = {player1, player2};      //created an array of player object, so I can call a method that changes between players for take turn.

        while (!board.isGameOver()) {                                               //while statement to change between players until all ships have been sunk
            Player currentPlayer = players[currentPlayerIndex];
            System.out.println(currentPlayer.getName() + "'s turn: ");
            boolean hit = currentPlayer.takeTurn(board);

            System.out.println(board);

            if (board.isGameOver()) {
                System.out.println("Game over!");

                if (player1.getScore() > player2.getScore()) {
                    System.out.println(player1.getName() + " wins!");
                } else if (player1.getScore() < player2.getScore()) {
                    System.out.print(player2.getName() + " wins!");
                } else {
                    System.out.println("It's a draw!");
                }
            }

            currentPlayerIndex = 1 - currentPlayerIndex;
        }
    }
}

