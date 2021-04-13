/**
 * Author: Cassidy Baldin
 * Revised: April 12th, 2021
 * 
 * Description: SetUp Class to start the game
 */

package src;

import java.util.*;

/**
* @brief This class represents the start state of the game
* @details Two random tiles will be added in random spots on the 4x4 board. 
*/
public class SetUp
{
    private int[][] game_board = new int[4][4];

   /**
    * @brief Initializes game start state by filling two random spots on the board with a random number (2 or 4)
    * @details Assumes SetUp will be called on a new Board object. 
    */
    public SetUp()
    {
        int[] random_spot1 = random_entry();
        int[] random_spot2 = random_entry();

        while (Arrays.equals(random_spot1, random_spot2)) {
            random_spot2 = random_entry();
        }

        game_board[random_spot1[0]][random_spot1[1]] = random_num();
        game_board[random_spot2[0]][random_spot2[1]] = random_num();
    }

    /**
    * @brief A random number where 2 is 90% likely, and 4 is 10% likely.
    * @return The number 2 or 4.
    */
    private int random_num() {
        Random r = new Random();
        int x = r.nextInt(100);

        if (x < 10) { return 4; }
        else { return 2; }
    }

    /**
    * @brief A random entry (cell) on a 4x4 grid.
    * @return A set of values representing coordinates on a 4x4 grid.
    */
    private int[] random_entry() {
        Random r = new Random();
        int row = r.nextInt(4);
        int column = r.nextInt(4);

        int[] index = new int[] {row, column};
        return index;
    }

    /**
    * @brief Gets the start state of the board.
    * @return The game_board in its current start state. 
    */
    public int[][] get_board() {
        return game_board;
    }
}