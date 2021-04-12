package src;

import java.util.*;

public class Board
{
    private static int[][] game_board;

    public static void start()
    {
        SetUp s = new SetUp();
        game_board = s.get_board();
    }

    public static void view()
    {
        View v = new View(game_board);
    }

    public static void move(String direction)
    {
        Move m = new Move(game_board);
        
        if (direction.equals("w")) { m.up(); }
        else if (direction.equals("s")) { m.down(); }
        else if (direction.equals("a")) { m.left(); }
        else if (direction.equals("d")) { m.right(); }
        else { System.out.println("Hmmm"); }
    }
}
