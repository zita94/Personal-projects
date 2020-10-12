/**
 *
 * @author Zita Cathcart
 * Simple tictactoe game
 */
import java.util.*;

public class Game {
    
    //checking each round if someone won the game

    public static boolean checkWin(String[] location, String letter) {
        if (location[0].equals(letter) && location[1].equals(letter) && location[2].equals(letter)) {
            return true;
        }
        if (location[3].equals(letter) && location[4].equals(letter) && location[5].equals(letter)) {
            return true;
        }
        if (location[6].equals(letter) && location[7].equals(letter) && location[8].equals(letter)) {
            return true;
        }
        if (location[0].equals(letter) && location[3].equals(letter) && location[6].equals(letter)) {
            return true;
        }
        if (location[1].equals(letter) && location[4].equals(letter) && location[7].equals(letter)) {
            return true;
        }
        if (location[2].equals(letter) && location[5].equals(letter) && location[8].equals(letter)) {
            return true;
        }
        if (location[6].equals(letter) && location[4].equals(letter) && location[2].equals(letter)) {
            return true;
        }
        if (location[0].equals(letter) && location[4].equals(letter) && location[8].equals(letter)) {
            return true;
        }

        return false;
    }
    
    //printing out the board to console

    public static void printBoard(String[] location) {

        System.out.println(" " + location[0] + " | " + location[1] + " | " + location[2]);
        System.out.println("---+---+---");
        System.out.println(" " + location[3] + " | " + location[4] + " | " + location[5]);
        System.out.println("---+---+---");
        System.out.println(" " + location[6] + " | " + location[7] + " | " + location[8]);

    }

    public static void main(String[] args) {
        String[] location = new String[9];

        int count1 = 0;
        int count2 = 0;
        boolean game = true;

        while (game) {
            int turn = 0;
            for (int i = 0; i >= 0 && i <= 8; i++) {
                location[i] = "" + (i + 1);
            }
            printBoard(location);
            while (true) {
                
                //input for Player 1, making sure the user entered a valid location (1-9), putting X on that location, checking if player won and printing out corresponding message

                Scanner reader = new Scanner(System.in);
                System.out.print("Player 1: ");
                int p1 = Integer.parseInt(reader.nextLine());
                turn++;

                while (p1 <= 0 || p1 >= 10 || location[p1 - 1].equalsIgnoreCase("X") || location[p1 - 1].equalsIgnoreCase("O")) {
                    System.out.println("Invalid entry, try again:");
                    System.out.print("Player 1: ");
                    p1 = Integer.parseInt(reader.nextLine());
                }
                location[p1 - 1] = "X";
                printBoard(location);
                if (checkWin(location, "X")) {
                    System.out.println("Congrats You Won");
                    count1++;
                    break;
                }
                if (turn == 9) {
                    System.out.println("It's a draw");
                    break;
                }
                
                //input for Player 2, making sure the user entered a valid location (1-9), putting O on that location, checking if player won and printing out corresponding message

                System.out.print("Player 2: ");
                int p2 = Integer.parseInt(reader.nextLine());
                turn++;

                while (p2 <= 0 || p2 >= 10 || location[p2 - 1].equalsIgnoreCase("X") || location[p2 - 1].equalsIgnoreCase("O")) {
                    System.out.println("Invalid entry, try again:");
                    System.out.print("Player 2: ");
                    p2 = Integer.parseInt(reader.nextLine());
                }
                location[p2 - 1] = "O";
                printBoard(location);
                if (checkWin(location, "O")) {
                    System.out.println("Congrats You Won");
                    count2++;
                    break;
                }
                if (turn == 9) {
                    System.out.println("It's a draw");
                    break;
                }

            }
            
            // win count, option to play again,
            
            System.out.println("Player 1 wins: " + count1 + "\nPlayer 2 wins:" + count2);
            System.out.println("Play again? Y/N ");
            Scanner ask = new Scanner(System.in);
            String again = ask.nextLine();
            if (again.equals("Y")) {
                game = true;
            } else {
                game = false;
            }
        }
    }
}
