package model;

import static model.Movement.*;

public class Board {
    int row;
    int col;
    int goalValue;
    int[][] cells;

    public Board(int row, int col, int[][] cells, int goalValue) {
        this.cells = cells;
        this.row = row;
        this.col = col;
        this.goalValue = goalValue;
    }


    public boolean isGoal() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (cells[i][j] == goalValue) {
                    return true;
                }
            }
        }
        return false;
    }

    public Board moveLeft() {
        int[][] tempCells = createTempCells();
        for (int j = 0; j < col; j++) {
            for (int i = 0; i < row; i++) {
                if (canMoveTo(i, j, LEFT)) {
                    tempCells[i][j - 1] += tempCells[i][j];
                    tempCells[i][j] = 0;
                }
            }
        }
        return new Board(row, col, tempCells, this.goalValue);//same ref ?

    }

    public Board moveRight() {
        int[][] tempCells = createTempCells();
        for (int j = col - 1; j >= 0; j--) {
            for (int i = 0; i < row; i++) {
                if (canMoveTo(i, j, RIGHT)) {
                    tempCells[i][j + 1] += tempCells[i][j];
                    tempCells[i][j] = 0;
                }
            }
        }
        return new Board(row, col, tempCells, this.goalValue);//same ref ?
    }

    public Board moveUp() {
        int[][] tempCells = createTempCells();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (canMoveTo(i, j, UP)) {
                    tempCells[i - 1][j] += tempCells[i][j];
                    tempCells[i][j] = 0;
                }
            }
        }
        return new Board(row, col, tempCells, this.goalValue);//same ref ?
    }

    public Board moveDown() {
        int[][] tempCells = createTempCells();
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                if (canMoveTo(i, j, DOWN)) {
                    tempCells[i + 1][j] += tempCells[i][j];
                    //ye rule kam dare - > age yeksan boodan in anjam she but anyway
                    tempCells[i][j] = 0;
                }
            }
        }
        return new Board(row, col, tempCells, this.goalValue);//same ref ?
    }

    public boolean canMoveTo(int i, int j, Movement direction) {
        switch (direction) {
            case LEFT -> {
                return j > 0;
            }
            case RIGHT -> {
                return j < col - 1;
            }
            case DOWN -> {
                return i < row - 1;
            }
            case UP -> {
                return i > 0;
            }
            default -> {
                return false;
            }
        }
    }


    @Override
    public String toString() {
        //todo needs a refactor
        StringBuilder map = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map.append(this.cells[i][j]);
                map.append("\t");
            }
            map.append("\n");
        }
        return map.toString();
    }

    public String hash() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result.append(cells[i][j]).append(".");
            }
        }
        return result.toString();
    }

    private int[][] createTempCells() {
        int[][] temp = new int[row][col];
        for (int i = 0; i < row; i++) {
            if (col >= 0) System.arraycopy(cells[i], 0, temp[i], 0, col);
        }
        return temp;
    }
}
