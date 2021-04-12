/**
 * Author: Cassidy Baldin
 * Revised: April 12th, 2021
 * 
 * Description: Move class that takes in user input to change the board state
 */

package src;

import java.util.*;

/**
* @brief This class represents the start state of the game
* @details Two random tiles will be added in random spots on the 4x4 board. 
*/

public class Move
{
    private int[][] game_board;
   /**
    * @brief Visiualizer for the game, prints board state to the screen
    */
    public Move(int[][] board)
    {
        game_board = board;
    }

    public void up() {
        //loop through the grid starting at top
        for (int i = 1; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (game_board[i][j] != 0) {
                    if (game_board[i][j] == game_board[i-1][j]) {
                        merge(new int[] {i, j}, new int[] {i-1, j});
                    }
                    else if(game_board[i-1][j] == 0) {
                        game_board[i-1][j] = game_board[i][j];
                        game_board[i][j] = 0; 
                    }
                }
            }
        }
        add_new_block();
    }

    public void down() {
        //loop through the grid starting at bottom
        for (int i = 2; i >= 0; i--) {
            for (int j = 0; j < 4; j++) {
                if (game_board[i][j] != 0) {
                    if (game_board[i][j] == game_board[i+1][j]) {
                        merge(new int[] {i, j}, new int[] {i+1, j});
                    }
                    else if(game_board[i+1][j] == 0) {
                        game_board[i+1][j] = game_board[i][j];
                        game_board[i][j] = 0; 
                    }
                }
            }
        }
        add_new_block();
    }

    public void left() {
        //loop through the grid starting at leftmost column
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                if (game_board[i][j] != 0) {
                    if (game_board[i][j] == game_board[i][j-1]) {
                        merge(new int[] {i, j}, new int[] {i, j-1});
                    }
                    else if(game_board[i][j-1] == 0) {
                        game_board[i][j-1] = game_board[i][j];
                        game_board[i][j] = 0; 
                    }
                }
            }
        }
        add_new_block();
    }

    public void right() {
        //loop through the grid starting at rightmost column
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j >= 0; j--) {
                if (game_board[i][j] != 0) {
                    if (game_board[i][j] == game_board[i][j+1]) {
                        merge(new int[] {i, j}, new int[] {i, j+1});
                    }
                    else if(game_board[i][j+1] == 0) {
                        game_board[i][j+1] = game_board[i][j];
                        game_board[i][j] = 0; 
                    }
                }
            }
        }
        add_new_block();
    }

    private void merge(int[] cell1, int[] cell2) {
        int value = game_board[cell1[0]][cell1[1]];

        game_board[cell1[0]][cell1[1]] = 0;
        game_board[cell2[0]][cell2[1]] = value*2; 
        Score.set_score(Score.get_score() + value*2); 
    }

    private void add_new_block() {
        int[] random_spot = random_entry();
        while (game_board[random_spot[0]][random_spot[1]] != 0) {
            random_spot = random_entry();
        }
        game_board[random_spot[0]][random_spot[1]] = random_num();
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