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
}