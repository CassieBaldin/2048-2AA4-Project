/**
 * Author: Cassidy Baldin
 * Revised: April 12th, 2021
 * 
 * Description: Score abstract object to keep track of current score of the game
 */

package src;


/**
* @brief This class represents the current score in the game.
* @details Assumes that it will initially be set to 0 before modifying, and will be reset for new games. 
*/
public class Score
{
    private static int score;

    /**
    * @brief A setter for the score variable.
    * @details Assumes that it will be set to 0 at the start of each game.
    */
    public static void set_score(int s)
    {
        score = s;
    }

    /**
    * @brief Gets the score of the game.
    */
    public static int get_score()
    {
    	return score;
    }

    /**
    * @brief Adds to the current score in the game.
    * @details Assumes new_score is greater than zero.
    * @param new_score Integer value to be added to current score
    */
    public static void add_score(int new_score)
    {
        score = score + new_score;
    }

    /**
    * @brief Reset method for score that changes the score to 0.
    * @details Assumes that it will be used at the start of each game.
    */
    public static void reset_score()
    {
    	score = 0;
    }
}
