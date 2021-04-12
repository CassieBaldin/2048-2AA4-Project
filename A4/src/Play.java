package src;

import java.util.*;

public class Play
{
    private static boolean play_again = true;
    private static boolean game_over = false;

    public static void Play()
    {
        while (play_again) {
            play_again = false;
            game_over = false;

            Score.set_score(0);
            Board b = new Board();
            b.start();

            System.out.println(" ");
            Scanner user = new Scanner(System.in);
            System.out.println("Controls: Move the tiles using wasd (up, left, down, right)");
            System.out.println("Merge similar tiles to increase your score");
            System.out.println("Join the tiles, get to 2048!");
            b.view();
            System.out.println("Which way would you like to move first? (w, a, s, d)");

            String move = user.nextLine();
            while (!check_game_over()) {
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

    private static boolean check_game_over() {
        //go through all the values, if all non-zero it is full, and if no possible merges, game over
        game_over = false;
        return game_over;
    }

    private static boolean check_win() {
        if (Score.get_score() == 2048) {
            return true;
        }
        else {return false; }
    }

    private static String valid_move_check(String move) {
        while (!move.equals("w") && !move.equals("a") && !move.equals("s") && !move.equals("d")) {
            Scanner user = new Scanner(System.in);
            System.out.println("Sorry that is not a valid move, please try again: (wasd)");
            move = user.nextLine();
        }
        return move;
    }
}
