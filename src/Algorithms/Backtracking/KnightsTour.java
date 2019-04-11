// Created by Kranthi on 2019-04-11.


// Question
// Problem is to find a pattern for the knight to travel the entire chess board
//

// Things to Learn
// Backtracking
//

package Algorithms.Backtracking;

public class KnightsTour {

    public static void main(String[] args){

        findPath(4);
    }

    private static void findPath(int n) {

        int[][] board = new int[n][n];

        int iterationNumber = 0;

        boolean pathFound = true;

        int currentX = 0;

        int currentY = 0;

        while (iterationNumber <= n*n) {

            if(makeMove(board, currentX, currentY)) {

                iterationNumber++;

            }else {

                pathFound = false;

                return;
            }
        }

        if(pathFound) {

            System.out.println(board.toString());
        }

    }

    private static boolean makeMove(int[][] board, int currentX, int currentY) {

        for (int i = 0; i < 8; i++) {


        }

        return false;
    }


}
