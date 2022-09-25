package core;

import model.Board;

public class Mapper {
    public int[][] createCells(String[][] board, int m, int n) {
        int[][] cells = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(board[i][j]);
                cells[i][j] = value;
            }
        }
        return cells;
    }

    public Board createBoard(int[][] cells, int goalValue, int row, int col) {
        return new Board(row, col, cells, goalValue);
    }

}
