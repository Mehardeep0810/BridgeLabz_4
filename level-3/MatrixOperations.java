package Assigned4.level3;

import java.util.Random;

public class MatrixOperations {

    public static int[][] generateMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = rand.nextInt(10); 
        return matrix;
    }

    public static int[][] addMatrices(int[][] A, int[][] B) {
        int[][] result = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                result[i][j] = A[i][j] + B[i][j];
        return result;
    }

    public static int[][] subtractMatrices(int[][] A, int[][] B) {
        int[][] result = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                result[i][j] = A[i][j] - B[i][j];
        return result;
    }

    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < B[0].length; j++)
                for (int k = 0; k < A[0].length; k++)
                    result[i][j] += A[i][k] * B[k][j];
        return result;
    }

    public static int[][] transposeMatrix(int[][] A) {
        int[][] result = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                result[j][i] = A[i][j];
        return result;
    }

    public static int determinant2x2(int[][] A) {
        return A[0][0] * A[1][1] - A[0][1] * A[1][0];
    }

    public static int determinant3x3(int[][] A) {
        return A[0][0] * (A[1][1] * A[2][2] - A[1][2] * A[2][1])
             - A[0][1] * (A[1][0] * A[2][2] - A[1][2] * A[2][0])
             + A[0][2] * (A[1][0] * A[2][1] - A[1][1] * A[2][0]);
    }

    public static double[][] inverse2x2(int[][] A) {
        int det = determinant2x2(A);
        if (det == 0) return null;
        double[][] inv = new double[2][2];
        inv[0][0] = A[1][1] / (double)det;
        inv[0][1] = -A[0][1] / (double)det;
        inv[1][0] = -A[1][0] / (double)det;
        inv[1][1] = A[0][0] / (double)det;
        return inv;
    }

    public static double[][] inverse3x3(int[][] A) {
        int det = determinant3x3(A);
        if (det == 0) return null;

        double[][] inv = new double[3][3];
        inv[0][0] =  (A[1][1]*A[2][2] - A[1][2]*A[2][1]) / (double)det;
        inv[0][1] = -(A[0][1]*A[2][2] - A[0][2]*A[2][1]) / (double)det;
        inv[0][2] =  (A[0][1]*A[1][2] - A[0][2]*A[1][1]) / (double)det;
        inv[1][0] = -(A[1][0]*A[2][2] - A[1][2]*A[2][0]) / (double)det;
        inv[1][1] =  (A[0][0]*A[2][2] - A[0][2]*A[2][0]) / (double)det;
        inv[1][2] = -(A[0][0]*A[1][2] - A[0][2]*A[1][0]) / (double)det;
        inv[2][0] =  (A[1][0]*A[2][1] - A[1][1]*A[2][0]) / (double)det;
        inv[2][1] = -(A[0][0]*A[2][1] - A[0][1]*A[2][0]) / (double)det;
        inv[2][2] =  (A[0][0]*A[1][1] - A[0][1]*A[1][0]) / (double)det;
        return inv;
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row)
                System.out.printf("%4d", val);
            System.out.println();
        }
    }

    public static void displayMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row)
                System.out.printf("%8.2f", val);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] A = generateMatrix(2, 2);
        int[][] B = generateMatrix(2, 2);

        System.out.println("Matrix A:");
        displayMatrix(A);
        System.out.println("Matrix B:");
        displayMatrix(B);

        System.out.println("Addition:");
        displayMatrix(addMatrices(A, B));

        System.out.println("Subtraction:");
        displayMatrix(subtractMatrices(A, B));

        System.out.println("Multiplication:");
        displayMatrix(multiplyMatrices(A, B));

        System.out.println("Transpose of A:");
        displayMatrix(transposeMatrix(A));

        System.out.println("Determinant of A: " + determinant2x2(A));

        System.out.println("Inverse of A:");
        double[][] invA = inverse2x2(A);
        if (invA != null) displayMatrix(invA);
        else System.out.println("Matrix A is not invertible.");
    }
}
