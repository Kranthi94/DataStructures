// Created by Kranthi on 2019-04-11.


// Question
// Problem is to find a pattern for the knight to travel the entire chess board
//

// Things to Learn
// Backtracking
//

package Algorithms.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class KnightsTour {

    private static List<Position> list = new ArrayList<>();

    private static int iterationNumber = 1;

    private static int n = 7;

    public static void main(String[] args){

        list.add(new Position(0, 0));

        int[][] board = new int[n][n];

        board[0][0] = 1;

        if(makeMove(board, list.get(list.size() - 1))){

            System.out.println("Solution Exists");

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    System.out.println(board[i][j] + "  ");
                }
            }

        }else {

            System.out.println("Solution Doesn't exist");
        }
    }

    private static boolean makeMove(int[][] board, Position position) {

        List<Position> possibleMoves = findPossibleMoves(board, position);

        if(possibleMoves.isEmpty()) {

            if(iterationNumber == n*n) {

                return true;

            }else {

                Position lastPosition = list.get(list.size() - 1);

                board[lastPosition.getX()][lastPosition.getY()] = 0;

                list.remove(lastPosition);

                iterationNumber--;

                if(iterationNumber == 1 && list.size() == 1 && list.get(0).getCurrentIterationNumber() == 2){

                    return false;

                }else {

                    makeMove(board, list.get(list.size() - 1));

                    return true;
                }
            }

        }else {

            Position move = possibleMoves.get(0);

            iterationNumber++;

            board[move.getX()][move.getY()] = iterationNumber;

            list.add(move);

            makeMove(board, list.get(list.size() - 1));

            return true;
        }
    }

    private static List<Position> findPossibleMoves(int[][] board, Position position) {

        int currentX = position.getX();

        int currentY = position.getY();

        List<Position> possiblePositions = new ArrayList<>(8);

        for (int i = 0; i < 8; i++) {

            int x = -1;

            int y = -1;

            if(i == 0) {

                x = currentX - 1;

                y = currentY + 2;
            }

            if(i == 1) {

                x = currentX + 1;

                y = currentY + 2;
            }

            if(i == 2) {

                x = currentX - 2;

                y = currentY + 1;
            }

            if(i == 3) {

                x = currentX + 2;

                y = currentY + 1;
            }

            if(i == 4) {

                x = currentX - 2;

                y = currentY - 1;
            }

            if(i == 5) {

                x = currentX + 2;

                y = currentY - 1;
            }

            if(i == 6) {

                x = currentX - 1;

                y = currentY - 2;
            }

            if(i == 7) {

                x = currentX + 1;

                y = currentY - 2;
            }

            if(x >= 0 && x < n && y >= 0 && y < n && board[x][y] == 0) {

                Position p = new Position(x, y);

                possiblePositions.add(p);
            }
        }

        int currentIterationNumber = position.getCurrentIterationNumber();

        position.setCurrentIterationNumber(currentIterationNumber + 1);

        return possiblePositions.subList(currentIterationNumber, possiblePositions.size());
    }

    private static class Position {

        private int x;

        private int y;

        private int currentIterationNumber;

        public Position(int x, int y) {

            this.x = x;

            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getCurrentIterationNumber() {
            return currentIterationNumber;
        }

        public void setCurrentIterationNumber(int currentIterationNumber) {
            this.currentIterationNumber = currentIterationNumber;
        }
    }
}
