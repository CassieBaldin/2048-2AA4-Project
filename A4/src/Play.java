/**
 * Author: Cassidy Baldin
 * Revised: March 29th, 2021
 * 
 * Description: Controller method to play the game 2048!
 */
package src;

import java.util.*;

public class Play
{
    private static boolean play_again = true;
    private static boolean game_over = false;
    private static Board b = new Board();

    /**
    * @brief Initializes game start by printing controls and making new Board object to play
    * @details Assumes SetUp will be called on a new Board object. 
    */
    public static void Play()
    {
        while (play_again) {
            play_again = false;
            game_over = false;

            Score.reset_score();
            b.start();

            System.out.println(" ");
            Scanner user = new Scanner(System.in);
            System.out.println("Welcome to 2048!! :)");
            System.out.println("Controls: Move the tiles using wasd (up, left, down, right)");
            System.out.println("Merge similar tiles to increase your score");
            System.out.println("Join the tiles, get to 2048!");
            b.view();
            System.out.println("Which way would you like to move first? (w, a, s, d)");

            String move = user.nextLine();
            while (!game_over) {
                b.move(valid_move_check(move));
                b.view();

                if (check_win()) {
                    System.out.println("You win!");
                    System.out.println("Would you like to keep going (k) or try again (t)?");
                    String ans = user.nextLine(); 
                    if ((ans.equals("t")) || (ans.equals("T"))) {
                        play_again = true;
                    break;
                    }
                }
                else {
                    System.out.println("Next move? (w, a, s, d)");
                    move = user.nextLine();
                    check_game_over();
                }
            }

            System.out.println("Game over :(");
            System.out.println("Would you like to play again? (y/n)");
            String ans = user.nextLine(); 
            if ((ans.equals("y")) || (ans.equals("Y"))) {
                play_again = true;
            }
        }
    }

    /**
    * @brief Goes through current game board and check if a move/merge can be made; if not game over
    * @return Boolean representing if the game is over (all cells full and no merges available)
    */
    private static boolean check_game_over() {
        int check = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int value = b.get_board_value(i, j);
                if (value == 0) {check++; }
                if ((i-1 >= 0) && (b.get_board_value(i-1, j) == value)) {check++; } //check above cell
                if ((i+1 <= 3) && (b.get_board_value(i+1, j) == value)) {check++; } //check below cell
                if ((j-1 >= 0) && (b.get_board_value(i, j-1) == value)) {check++; } //check left cell
                if ((j+1 <= 3) && (b.get_board_value(i, j+1) == value)) {check++; } //check right cell
                
                if (check > 0) {
                    return game_over;
                }
            }
        }
        if (check == 0) { 
            game_over = true;
            return game_over;
        }
        return game_over;
    }

    /**
    * @brief Checks if any tile in current board has value 2048, if so the user wins!!
    * @return Boolean representing if the user won or not
    */
    private static boolean check_win() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (b.get_board_value(i, j) == 2048) {
                    return true;
                }
            }
        }
        else {return false; }
    }

    /**
    * @brief Checks if the direction the user input is valid, if not asks the user to try again
    * @return String representing the accepted move that the user input
    */
    private static String valid_move_check(String move) {
        while (!move.equals("w") && !move.equals("a") && !move.equals("s") && !move.equals("d")) {
            Scanner user = new Scanner(System.in);
            System.out.println("Sorry that is not a valid move, please try again: (wasd)");
            move = user.nextLine();
        }
        return move;
    }
}
