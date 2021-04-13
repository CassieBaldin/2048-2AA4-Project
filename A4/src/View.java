/**
 * Author: Cassidy Baldin
 * Revised: April 12th, 2021
 * 
 * Description: View class to visualize the state of the board.
 */

package src;

import java.util.*;

/**
* @brief This class represents a way to view the current state of the input board.
*/

public class View
{
   /**
    * @brief Visualizer for the game, prints board state to the screen.
    * @param game_board Grid representing the current game board.
    */
    public View(int[][] game_board)
    {
        System.out.println(" ");
        System.out.println("Score: " + Score.get_score());
        for (int i = 0; i < game_board[0].length; i++) {
            System.out.println(Arrays.toString(game_board[i]));
        }
    }
}
