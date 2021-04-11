package src;

import java.util.*;

public class SetUp
{
    private int[][] game_board = new int[4][4];

    public SetUp()
    {
        int[] random_spot1 = random_entry();
        int[] random_spot2 = random_entry();

        //make sure two spots are filled instead of 1
        while (Arrays.equals(random_spot1, random_spot2)) {
            random_spot2 = random_entry();
        }

        game_board[random_spot1[0]][random_spot1[1]] = random_num();
        game_board[random_spot2[0]][random_spot2[1]] = random_num();
    }

    private int random_num() {
        Random r = new Random();
        int x = r.nextInt(100);

        if (x < 10) { return 4; }
        else { return 2; }
    }

    private int[] random_entry() {
        Random r = new Random();
        int row = r.nextInt(4);
        int column = r.nextInt(4);

        int[] index = new int[] {row, column};
        return index;
    }
}