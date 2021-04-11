/**
 * Author: Cassidy Baldin
 * Revised: April 12th, 2021
 * 
 * Description: View class to visualize the state of the game
 */

package src;

import java.util.*;

/**
* @brief This class represents a way to view the current state of the input board
*/

public class View
{
   /**
    * @brief Visiualizer for the game, prints board state to the screen
    */
    public View(int[][] game_board)
    {
        System.out.println(" ");
        System.out.println("Score: " + Score.get_score());
        System.out.println(Arrays.toString(game_board[0]));
        System.out.println(Arrays.toString(game_board[1]));
        System.out.println(Arrays.toString(game_board[2]));
        System.out.println(Arrays.toString(game_board[3]));
    }
}
