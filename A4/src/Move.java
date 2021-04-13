/**
 * Author: Cassidy Baldin
 * Revised: April 12th, 2021
 * 
 * Description: Move class that takes in user input to change the board state.
 */

package src;

import java.util.*;

/**
* @brief This class represents the start state of the game.
* @details Two random tiles will be added in random spots on the 4x4 board. 
*/

public class Move
{
    private int[][] game_board;

   /**
    * @brief Constructor for the Move class.
    * @param board Represents the state of the current game board.
    */
    public Move(int[][] board)
    {
        game_board = board;
    }

    /**
    * @brief Moves all non-empty values in the game_board up, merges if possible.
    */
    public void up() {
        for (int i = 1; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (game_board[i][j] != 0) {
                    if (game_board[i][j] == game_board[i-1][j]) {
                        merge(new int[] {i, j}, new int[] {i-1, j});
                    }
                    else if(game_board[i-1][j] == 0) {
                        game_board[i-1][j] = game_board[i][j];
                        game_board[i][j] = 0; 
                        dir_check(i-1, j, "u");
                    }
                }
            }
        }
        add_new_block();
    }

    /**
    * @brief Check if the value in the grid can be moved any more in the specified direction
    * @param i Represents the row in the game board grid.
    * @param j Represents the column in the game board grid.
    * @param direction Represents the direction that the cell could move. 
    */
    private void dir_check(int i, int j, String direction) {
        if (direction == "u") {
            if ((i == 0) || (game_board[i-1][j] != 0)) { return; } 
            else { 
                game_board[i-1][j] = game_board[i][j];
                game_board[i][j] = 0; 
                dir_check(i-1, j, "u");
            }
        }
        else if (direction == "d") {
            if (i == 3) { return; } 
            else if (game_board[i+1][j] != 0) { return; }
            else { 
                game_board[i+1][j] = game_board[i][j];
                game_board[i][j] = 0; 
                dir_check(i+1, j, "d");
            }
        }
        else if (direction == "L") {
            if (j == 0) { return; }
            else if (game_board[i][j-1] != 0) { return; }
            else { 
                game_board[i][j-1] = game_board[i][j];
                game_board[i][j] = 0; 
                dir_check(i, j-1, "L");
            }
        }
        else {
            if (j == 3) { return; } 
            else if (game_board[i][j+1] != 0) { return; }
            else { 
                game_board[i][j+1] = game_board[i][j];
                game_board[i][j] = 0; 
                dir_check(i, j+1, "r");
            }
        }
    }

    /**
    * @brief Moves all non-empty values in the game_board down, merges if possible.
    */
    public void down() {
        for (int i = 2; i >= 0; i--) {
            for (int j = 0; j < 4; j++) {
                if (game_board[i][j] != 0) {
                    if (game_board[i][j] == game_board[i+1][j]) {
                        merge(new int[] {i, j}, new int[] {i+1, j});
                    }
                    else if(game_board[i+1][j] == 0) {
                        game_board[i+1][j] = game_board[i][j];
                        game_board[i][j] = 0; 
                        dir_check(i+1, j, "d");
                    }
                }
            }
        }
        add_new_block();
    }

    /**
    * @brief Moves all non-empty values in the game_board right, merges if possible.
    */
    public void left() {
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                if (game_board[i][j] != 0) {
                    if (game_board[i][j] == game_board[i][j-1]) {
                        merge(new int[] {i, j}, new int[] {i, j-1});
                    }
                    else if(game_board[i][j-1] == 0) {
                        game_board[i][j-1] = game_board[i][j];
                        game_board[i][j] = 0; 
                        dir_check(i, j-1, "L");
                    }
                }
            }
        }
        add_new_block();
    }

    /**
    * @brief Moves all non-empty values in the game_board right, merges if possible.
    */
    public void right() {
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j >= 0; j--) {
                if (game_board[i][j] != 0) {
                    if (game_board[i][j] == game_board[i][j+1]) {
                        merge(new int[] {i, j}, new int[] {i, j+1});
                    }
                    else if(game_board[i][j+1] == 0) {
                        game_board[i][j+1] = game_board[i][j];
                        game_board[i][j] = 0; 
                        dir_check(i, j+1, "r");
                    }
                }
            }
        }
        add_new_block();
    }

    /**
    * @brief Moves all non-empty values in the game_board right, merges if possible.
    * @param cell1 Represents the cell that is being merged away from.
    * @param cell2 Represents the cell that is being merged into.
    */
    private void merge(int[] cell1, int[] cell2) {
        int value = game_board[cell1[0]][cell1[1]];

        game_board[cell1[0]][cell1[1]] = 0;
        game_board[cell2[0]][cell2[1]] = value*2; 
        Score.add_score(value*2); 
    }

    /**
    * @brief Adds new block to game board.
    * @details Assumes it will only be called after a move is finished all merges.
    */
    private void add_new_block() {
        int full_spots = 0;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++) {
                if (game_board[i][j] != 0) {full_spots++; }
            }
        if (full_spots == 16) {return; }

        int[] random_spot = random_entry();
        while (game_board[random_spot[0]][random_spot[1]] != 0) {
            random_spot = random_entry();
        }
        game_board[random_spot[0]][random_spot[1]] = random_num();
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
}