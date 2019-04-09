package com.company;

import jdk.nashorn.internal.ir.WhileNode;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
    int [][] matrix = getDefaultFrid();
    Random rnd = new Random();
    for(int i = 0; i < new Random().nextInt(99) + 1; i ++) {
        matrix = getRandomMethod(matrix);
    }
    Solver slv = new Solver(matrix);
    for (int i = 0; i < 50; i ++)
    while (true){
        int X = rnd.nextInt(9);
        int Y = rnd.nextInt(9);
        int temp = matrix[X][Y];
        matrix = deleteSingleElement(matrix, X, Y);
        if(slv.checkedSingleElement(matrix, X, Y))
            break;
        matrix[X][Y] = temp;
    }
    printMatrix(matrix);
}


    public static int[][] getDefaultFrid()  {
        int [][] grid = {{1, 2, 3, 4, 5, 6, 7, 8 ,9},
                        {4, 5, 6, 7, 8, 8, 1, 2, 3},
                        {7, 8, 9, 1, 2, 3, 4, 5, 6},
                        {2, 3, 4, 5, 6, 7, 8, 9, 1},
                        {5, 6, 7, 8, 9, 1, 2, 3, 4},
                        {8, 9, 1, 2, 3, 4, 5, 6, 7},
                        {3, 4, 5, 6, 7, 8, 9, 1, 2},
                        {6, 7, 8, 9, 1, 2, 3, 4, 5},
                        {9, 1, 2, 3, 4, 5, 6, 7, 8}};
        return grid;
    }

    public static int[][] transponMatrix(int [][] matrix) {
        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return matrix;
    }

    public static int [][] swapTwoColumnsInField(int [][] matrix, int numberOfFirstColumns, int numberOfSecondColumns) {
        for(int i = 0; i < 9; i ++) {
            int temp = matrix[numberOfFirstColumns][i];
            matrix[numberOfFirstColumns][i] = matrix[numberOfSecondColumns][i];
            matrix[numberOfSecondColumns][i] = temp;
        }
        return matrix;
    }

    public static int [][] swapTwoRowsInField(int [][] matrix, int numberOfFirstRows, int numberOfSecondRows) {
        for(int i = 0; i < 9; i ++) {
            int temp = matrix[i][numberOfFirstRows];
            matrix[i][numberOfFirstRows] = matrix[i][numberOfSecondRows];
            matrix[i][numberOfSecondRows] = temp;
        }
        return matrix;
    }

    public  static int [][] swapTwoFieldsVertical(int [][] matrix, int numberOfFirstFields, int numberOfSecondFields) {
        int startIndexFirstArea =  numberOfFirstFields * 3;
        int startIndexSecondArea =  numberOfSecondFields * 3;
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 3; j ++) {
                int temp = matrix[i][j + startIndexFirstArea];
                matrix[i][j + startIndexFirstArea] = matrix[i][j + startIndexSecondArea];
                matrix[i][j + startIndexSecondArea] = temp;
            }
        }
        return matrix;
    }

    public  static int [][] swapTwoFieldsHorizontal(int [][] matrix, int numberOfFirstFields, int numberOfSecondFields) {
        int startIndexFirstArea =  numberOfFirstFields * 3;
        int startIndexSecondArea =  numberOfSecondFields * 3;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 9; j ++) {
                int temp = matrix[i + startIndexFirstArea][j];
                matrix[i + startIndexFirstArea][j] = matrix[i + startIndexSecondArea][j];
                matrix[i + startIndexSecondArea][j] = temp;
            }
        }
        return matrix;
    }

    public static int [][] getRandomMethod(int [][] matrix) {
        Random rnd = new Random();
        int number = rnd.nextInt(5);
        int count = rnd.nextInt(3) + 1;
        int numberOfFirstFields = rnd.nextInt(3);
        int numberOfSecondFields = rnd.nextInt(3);
        int numberOfFirstElement = rnd.nextInt(3) + 3 * numberOfFirstFields;
        int numberOfSecondElement = rnd.nextInt(3) + 3 * numberOfFirstFields;
        for(int i = 0; i < count; i ++)
        switch (number) {
            case 0:
                transponMatrix(matrix);
                break;
            case 1:
                swapTwoColumnsInField(matrix, numberOfFirstElement, numberOfSecondElement);
                break;
            case 2:
                swapTwoRowsInField(matrix, numberOfFirstElement, numberOfSecondElement);
                break;
            case 3:
                swapTwoFieldsVertical(matrix, numberOfFirstFields, numberOfSecondFields);
                break;
            case 4:
                swapTwoFieldsHorizontal(matrix, numberOfFirstFields, numberOfSecondFields);
                break;
        }
        return matrix;
    }

    public static void printMatrix(int [][] matrix) {
        for(int i = 0; i < 9; i ++) {
            for(int j = 0; j < 9; j ++) {
                System.out.print(matrix[i][j]);
            }
            System.out.print("\n");
        }
    }

    public static int [][] deleteSingleElement(int [][] matrix, int X, int Y) {
        matrix[X][Y] = 0;
        return matrix;
    }
}



