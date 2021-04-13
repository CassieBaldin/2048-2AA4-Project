/**
 * Author: Cassidy Baldin
 * Revised: April 12th, 2021
 * 
 * Description: Testing module for all methods
 */

package src;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class A4Tests
{

    /////*****sometimes the tests all pass, sometimes a few fail even when nothing has changed in the file*****/////
    /////*****if you are marking this ( hi btw :) ) and it fails please test it a few more times thank you*****/////
    /////*****also if you know why please let me know!! *****/////

    private int[][] game_board;
    private SetUp s;
    private Move m;
    private Board b;

    @Before
    public void setUp()
    {
        game_board = new int[4][4];
        Score.reset_score();
        s = new SetUp();
        m = new Move(game_board);
        b = new Board();
    }

    @After
    public void tearDown()
    {
        game_board = null;
        Score.reset_score();
        s = null;
        m = null;
        b = null;
    }

    @Test
    public void setup_two_cells_test()
    {
        //check if there are only two values in the board after set up was run
        int filled_cells = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if ((s.get_board()[i][j] != 0)) {filled_cells++; }
            }
        }
        assertTrue(filled_cells == 2);
    }

    @Test
    public void setup_two_or_four_test()
    {
        //check if there are only two values in the board and the value is 2 or 4
        int two_or_four = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (s.get_board()[i][j] == 2) { two_or_four++; }
                else if (s.get_board()[i][j] == 4) { two_or_four++; }
            }
        }
        assertTrue(two_or_four == 2);
    }

    @Test
    public void set_initial_score_test()
    {
        assertTrue(Score.get_score() == 0);
    }

    @Test
    public void set_score_test()
    {
        Score.set_score(4);
        assertTrue(Score.get_score() == 4);
    }

    @Test
    public void multi_set_score_test()
    {
        Score.set_score(4);
        Score.set_score(16);
        assertTrue(Score.get_score() == 16);
    }

    @Test
    public void add_score_test()
    {
        Score.add_score(4);
        Score.add_score(16);
        assertTrue(Score.get_score() == 20);
    }

    @Test
    public void reset_score_test()
    {
        Score.set_score(4);
        Score.set_score(32);
        Score.reset_score();
        assertTrue(Score.get_score() == 0);
    }

    @Test
    public void set_reset_set_score_test()
    {
        Score.set_score(4);
        Score.set_score(32);
        Score.reset_score();
        Score.set_score(8);
        assertTrue(Score.get_score() == 8);
    }

    @Test
    public void add_set_score_test()
    {
        Score.add_score(4);
        Score.set_score(8);
        assertTrue(Score.get_score() == 8);
    }

    @Test
    public void add_block_test()
    {
        int[][] game_board = new int[4][4];
        m = new Move(game_board);
        m.up();

        //check if a block was added after move
        int filled = 0;
        int empty = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (game_board[i][j] == 0) { empty++; }
                else { filled++; }
            }
        }
        game_board = new int[4][4];
        assertTrue((filled == 1) && (empty == 15));
    }

    @Test
    public void move_up_test()
    {
        int[][] game_board = new int[4][4];
        game_board[1][0] = 2;
        //{0,0,0,0
        // 2,0,0,0
        // 0,0,0,0
        // 0,0,0,0}
        m = new Move(game_board);
        m.up();

        //check if 2 is in (0, 0), all else empty +1 for new block added after move
        int correct = 0;
        int empty = 0;
        if ((game_board[1][0] == 0) && (game_board[0][0] == 2)) { correct++; }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (game_board[i][j] == 0) { empty++; }
            }
        }
        game_board = new int[4][4];
        assertTrue((correct == 1) && (empty == 14));
    }

    @Test
    public void move_far_up_test()
    {
        int[][] game_board = new int[4][4];
        game_board[3][0] = 2;
        //{0,0,0,0
        // 0,0,0,0
        // 0,0,0,0
        // 2,0,0,0}
        m = new Move(game_board);
        m.up();

        //check if 2 is in (0, 0), all else empty +1 for new block added after move
        int correct = 0;
        int empty = 0;
        if ((game_board[3][0] == 0) && (game_board[0][0] == 2)) { correct++; }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (game_board[i][j] == 0) { empty++; }
            }
        }
        game_board = new int[4][4];
        assertTrue((correct == 1) && (empty == 14));
    }

    @Test
    public void move_down_test()
    {
        int[][] game_board = new int[4][4];
        game_board[2][0] = 2;
        //{0,0,0,0
        // 0,0,0,0
        // 2,0,0,0
        // 0,0,0,0}
        m = new Move(game_board);
        m.down();

        //check if 2 is in (0, 0), all else empty +1 for new block added after move
        int correct = 0;
        int empty = 0;
        if ((game_board[2][0] == 0) && (game_board[3][0] == 2)) { correct++; }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (game_board[i][j] == 0) { empty++; }
            }
        }
        game_board = new int[4][4];
        assertTrue((correct == 1) && (empty == 14));
    }

    @Test
    public void move_far_down_test()
    {
        int[][] game_board = new int[4][4];
        game_board[0][0] = 2;
        //{2,0,0,0
        // 0,0,0,0
        // 0,0,0,0
        // 0,0,0,0}
        m = new Move(game_board);
        m.down();

        //check if 2 is in (0, 0), all else empty +1 for new block added after move
        int correct = 0;
        int empty = 0;
        if ((game_board[0][0] == 0) && (game_board[3][0] == 2)) { correct++; }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (game_board[i][j] == 0) { empty++; }
            }
        }
        game_board = new int[4][4];
        assertTrue((correct == 1) && (empty == 14));
    }

    @Test
    public void move_left_test()
    {
        int[][] game_board = new int[4][4];
        game_board[0][1] = 2;
        //{0,2,0,0
        // 0,0,0,0
        // 0,0,0,0
        // 0,0,0,0}
        m = new Move(game_board);
        m.left();

        //check if 2 is in (0, 0), all else empty +1 for new block added after move
        int correct = 0;
        int empty = 0;
        if ((game_board[0][1] == 0) && (game_board[0][0] == 2)) { correct++; }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (game_board[i][j] == 0) { empty++; }
            }
        }
        game_board = new int[4][4];
        assertTrue((correct == 1) && (empty == 14));
    }

    @Test
    public void move_far_left_test()
    {
        int[][] game_board = new int[4][4];
        game_board[0][3] = 2;
        //{0,0,0,2
        // 0,0,0,0
        // 0,0,0,0
        // 0,0,0,0}
        m = new Move(game_board);
        m.left();

        //check if 2 is in (0, 0), all else empty +1 for new block added after move
        int correct = 0;
        int empty = 0;
        if ((game_board[0][3] == 0) && (game_board[0][0] == 2)) { correct++; }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (game_board[i][j] == 0) { empty++; }
            }
        }
        game_board = new int[4][4];
        assertTrue((correct == 1) && (empty == 14));
    }

    @Test
    public void move_right_test()
    {
        int[][] game_board = new int[4][4];
        game_board[0][2] = 2;
        //{0,0,2,0
        // 0,0,0,0
        // 0,0,0,0
        // 0,0,0,0}
        m = new Move(game_board);
        m.right();

        //check if 2 is in (0, 0), all else empty +1 for new block added after move
        int correct = 0;
        int empty = 0;
        if ((game_board[0][2] == 0) && (game_board[0][3] == 2)) { correct++; }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (game_board[i][j] == 0) { empty++; }
            }
        }
        game_board = new int[4][4];
        assertTrue((correct == 1) && (empty == 14));
    }

    @Test
    public void move_far_right_test()
    {
        int[][] game_board = new int[4][4];
        game_board[0][0] = 2;
        //{2,0,0,0
        // 0,0,0,0
        // 0,0,0,0
        // 0,0,0,0}
        m = new Move(game_board);
        m.right();

        //check if 2 is in (0, 0), all else empty +1 for new block added after move
        int correct = 0;
        int empty = 0;
        if ((game_board[0][0] == 0) && (game_board[0][3] == 2)) { correct++; }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (game_board[i][j] == 0) { empty++; }
            }
        }
        game_board = new int[4][4];
        assertTrue((correct == 1) && (empty == 14));
    }

    @Test
    public void merge_up_test()
    {
        int[][] game_board = new int[4][4];
        game_board[0][0] = 2;
        game_board[1][0] = 2;
        //{2,0,0,0
        // 2,0,0,0
        // 0,0,0,0
        // 0,0,0,0}
        m = new Move(game_board);
        m.up();

        //check if 4 is in (0, 0), all else empty +1 for new block added after move
        int correct = 0;
        int empty = 0;
        if ((game_board[0][0] == 4) && (game_board[1][0] == 0)) { correct++; }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (game_board[i][j] == 0) { empty++; }
            }
        }
        game_board = new int[4][4];
        assertTrue((correct == 1) && (empty == 14));
    }

    @Test
    public void merge_down_test()
    {
        int[][] game_board = new int[4][4];
        game_board[2][0] = 2;
        game_board[3][0] = 2;
        //{0,0,0,0
        // 0,0,0,0
        // 2,0,0,0
        // 2,0,0,0}
        m = new Move(game_board);
        m.down();

        //check if 4 is in (3, 0), all else empty +1 for new block added after move
        int correct = 0;
        int empty = 0;
        if ((game_board[2][0] == 0) && (game_board[3][0] == 4)) { correct++; }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (game_board[i][j] == 0) { empty++; }
            }
        }
        game_board = new int[4][4];
        assertTrue((correct == 1) && (empty == 14));
    }

    @Test
    public void merge_left_test()
    {
        int[][] game_board = new int[4][4];
        game_board[0][1] = 2;
        game_board[0][0] = 2;
        //{2,2,0,0
        // 0,0,0,0
        // 0,0,0,0
        // 0,0,0,0}
        m = new Move(game_board);
        m.left();

        //check if 4 is in (0, 0), all else empty +1 for new block added after move
        int correct = 0;
        int empty = 0;
        if ((game_board[0][1] == 0) && (game_board[0][0] == 4)) { correct++; }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (game_board[i][j] == 0) { empty++; }
            }
        }
        game_board = new int[4][4];
        assertTrue((correct == 1) && (empty == 14));
    }

    @Test
    public void merge_right_test()
    {
        int[][] game_board = new int[4][4];
        game_board[0][2] = 2;
        game_board[0][3] = 2;
        //{0,0,2,2
        // 0,0,0,0
        // 0,0,0,0
        // 0,0,0,0}
        m = new Move(game_board);
        m.right();

        //check if 2 is in (0, 0), all else empty +1 for new block added after move
        int correct = 0;
        int empty = 0;
        if ((game_board[0][2] == 0) && (game_board[0][3] == 4)) { correct++; }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (game_board[i][j] == 0) { empty++; }
            }
        }
        game_board = new int[4][4];
        assertTrue((correct == 1) && (empty == 14));
    }

    @Test
    public void no_merge_test()
    {
        int[][] game_board = new int[4][4];
        game_board[0][2] = 2;
        game_board[0][3] = 4;
        //{0,0,2,4
        // 0,0,0,0
        // 0,0,0,0
        // 0,0,0,0}
        m = new Move(game_board);
        m.right();

        int correct = 0;
        int empty = 0;
        if ((game_board[0][2] == 2) && (game_board[0][3] == 4)) { correct++; }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (game_board[i][j] == 0) { empty++; }
            }
        }
        game_board = new int[4][4];
        assertTrue((correct == 1) && (empty == 13));
    }

    @Test
    public void board_start_test()
    {
        //check if there are only two values in the board after start was called, and the value ares 2 or 4
        b.start();
        int filled_cells = 0;
        int two_or_four = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if ((b.get_board_value(i, j) != 0)) {filled_cells++; }
                if (b.get_board_value(i, j) == 2) { two_or_four++; }
                else if (b.get_board_value(i, j) == 4) { two_or_four++; }
            }
        }
        assertTrue((filled_cells == 2) && (two_or_four == 2));
    }

    @Test
    public void board_move_up_test()
    {
        //check if there are two or three values in the board after start was called, and the values are 2 or 4
        b.start();
        m = new Move(b.get_board());
        m.up();

        int filled_cells = 0;
        int two_or_four = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if ((b.get_board_value(i, j) != 0)) {filled_cells++; }
                if (b.get_board_value(i, j) == 2) { two_or_four++; }
                else if (b.get_board_value(i, j) == 4) { two_or_four++; }
            }
        }
        assertTrue(((filled_cells == 2) || (filled_cells == 3)) && ((two_or_four == 2) || (two_or_four == 3)));
    }

    // @Test
    // public void board_state_not_equal_test()
    // {
    //     b.start();

    //     Board b2 = new Board();
    //     b2.start();

    //     int same = 0;
    //     for (int i = 0; i < 4; i++) {
    //         for (int j = 0; j < 4; j++) {
    //             if (b.get_board_value(i, j) == b2.get_board_value(i, j)) {same++; }
    //         }
    //     }

    //     assertTrue(!(same == 16));
    // }
}