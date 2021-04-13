/**
 * Author: Cassidy Baldin
 * Revised: April 12th, 2021
 * 
 * Description: Board class that represents the possible functions that can be done to the board state
 */

package src;

import java.util.*;


/**
* @brief This class represents the functions of the game board
* @details Assumes start() will be called before move().
*/
public class Board
{
    private static int[][] game_board;

    /**
    * @brief Represents the start state of the board, calls SetUp class
    */
    public static void start()
    {
        SetUp s = new SetUp();
        game_board = s.get_board();
    }

    /**
    * @brief Represents a way to view current game_board state, calls View class
    */
    public static void view()
    {
        View v = new View(game_board);
    }

    /**
    * @brief Represents a way to shift the board cells in a specified direction
    * @details Assumed direction is only "wasd"
    * @param direction String representing the desired direction the board should move
    */
    public static void move(String direction)
    {
        Move m = new Move(game_board);
        
        if (direction.equals("w")) { m.up(); }
        else if (direction.equals("s")) { m.down(); }
        else if (direction.equals("a")) { m.left(); }
        else { m.right(); } 
    }

    /**
    * @brief Gets the state of the current game board.
    * @return Coordinates in the game_board.
    */
    public static int[][] get_board() {
        return game_board;
    }

    /**
    * @brief Gets the value of the game board at a certain index.
    * @return Coordinates in the game_board
    */
    public static int get_board_value(int i, int j) {
        return game_board[i][j];
    }
}
