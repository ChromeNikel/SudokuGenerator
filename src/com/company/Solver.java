package com.company;

import java.util.LinkedList;

public class Solver {

    private int [][] matrixForSolve;
    private int [][] matrixSolved;

    Solver(int [][] matrix) {
        matrixForSolve = matrix;
    }

    public int [][] getSolvedMatrix() {
        return matrixSolved;
    }

    private int [] defoultLine = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    private int [] getDefaultLine() {
        for (int i = 1; i < 10; i ++) {
            defoultLine[i - 1] = i;
        }        return defoultLine;
    }

    private int [] checkedHorizontal(int [][] matrix, int numberX,  int numberY) {
        for(int k = 0; k < 9; k ++) {
            for (int i = 0; i < 9; i++) {
                if (i != numberX && defoultLine[k] == matrix[i][numberY]) {
                    defoultLine[i] = 0;
                }
            }
        }
        return defoultLine;
    }

    private int [] checkedVertical(int [][] matrix, int numberX,  int numberY) {
        for(int k = 0; k < 9; k ++) {
            for (int i = 0; i < 9; i++) {
                if (i != numberY && defoultLine[k] == matrix[numberX][i]) {
                    defoultLine[i] = 0;
                }
            }
        }
        return defoultLine;
    }

    private int [] checkedSquare(int [][] matrix, int numberX,  int numberY) {
        for(int k = 0; k < 9; k ++)
        for(int i = 3 * (int)(numberX / 3) ; i < 3 + 3 * (int)(numberX / 3); i ++) {
            for(int j = 3 * (int)(numberY / 3) ; j < 3 + 3 * (int)(numberY / 3); j ++) {
                if (i == 9 || j == 9)
                if (i != numberX && j != numberY && defoultLine[k] == matrix[i][j]) {
                    defoultLine[k] = 0;
                }
            }
        }
        return defoultLine;
    }

    private int countOfSolve() {
        int countOfSolve = 0;
        for (int i = 0; i < defoultLine.length; i ++)
            if (defoultLine[i] != 0)
                countOfSolve ++;
        return countOfSolve;
    }

    public boolean checkedSingleElement(int [][] matrix, int numberX,  int numberY) {
        defoultLine = getDefaultLine();
        defoultLine = checkedHorizontal(matrix, numberX, numberY);
        defoultLine = checkedVertical(matrix, numberX, numberY);
        defoultLine = checkedSquare(matrix, numberX, numberY);
        return countOfSolve() > 1 ? false : true;
    }
}
