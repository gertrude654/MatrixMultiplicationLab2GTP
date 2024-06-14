package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Matrix {
    public static void main(String[] args) {

        Scanner sc  = new Scanner(System.in);

        //declaring variables for matrix a and b
        int [][] matrixA,matrixB;

        //assigning values to matrices
        System.out.println("The first matrix: ");
        matrixA =  formMatrix(sc);
        System.out.println("The second matrix: ");
        matrixB =  formMatrix(sc);

        //multiply matrices
        multiplyMatrices(matrixA,matrixB);

    }
    private static void multiplyMatrices(int[][] matrixA, int[][] matrixB) {

        int rowsMatrixA = matrixA.length;
        int columnsMatrixB = matrixB[0].length;
        int rowsMatrixB = matrixB.length;
        int columnsMatrixA = matrixA[0].length;
        int[][] matrixC = new int[rowsMatrixA][columnsMatrixB];
        //initialize product of rows and columns to 0
        int product = 0;

        //validating matrix multiplication condition
        if(columnsMatrixA != rowsMatrixB){
            System.out.println("Your matrix is invalid; valid matrix has columns of matrix A == rows of matrix B");

        } else {

            // Outer loop: iterate through each row of matrixA
            for (int i = 0; i < rowsMatrixA ; i++) {
                // Middle loop: iterate through each column of matrixB
                for (int j = 0; j < columnsMatrixB; j++) {
                    // Inner loop: iterate through each element of the current row of matrixA and current column of matrixB
                    for (int k = 0; k < columnsMatrixA; k++) {
                        // Accumulate the product of the corresponding elements in the current row of matrixA and the current column of matrixB
                        product += matrixA[i][k] * matrixB[k][j];
                    }
                    matrixC[i][j] = product;
                    product = 0;
                }
            }
            System.out.println();
            System.out.println("The output: ");
            for (int i = 0; i < rowsMatrixA ; i++) {
                System.out.print("| ");
                for (int j = 0; j < columnsMatrixB; j++) {

                    System.out.print(matrixC[i][j] + " ");
                }
                System.out.print("|");
                System.out.println();
            }
        }
    }

    private static int [][] formMatrix(Scanner sc) {

        int[][] matrixA = null;

        while (true){
            try {

                System.out.println("Enter number of rows: ");
                int rows = sc.nextInt();

                System.out.println("Enter number of columns: ");
                int columns = sc.nextInt();

                if(rows <= 0||columns <= 0){
                    System.out.println("Please enter positive integer: ");

                    //if condition is satisfied skip the rest and continue asking valid input
                    continue;
                } else {
                    matrixA = new int[rows][columns];

                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < columns; j++) {
                            System.out.println("Enter number for ["+i+"]["+j+"]: ");
                            int input = sc.nextInt();
                            matrixA[i][j] = input;
                        }
                    }
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < columns; j++) {
                            System.out.print(matrixA[i][j] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                }
            } catch (InputMismatchException e) {
            System.out.println("Enter a positive integer");
            }
            return matrixA;
        }
    }
}
