package lab.O2second;

import java.util.Random;

public class SecondLabClass {

    private static final String FORMAT = "%11.5f";

    public static void main(String[] args) {
        float[][] matrix = generateMatrix(3, 3);
        System.out.println("Initial matrix:");
        printMatrix(matrix);
        System.out.println("Matrix after first operation:");
        firstOperation(matrix, 2.5f);
        printMatrix(matrix);
        System.out.println("Result of second operation");
        float[] result = secondOperation(matrix);
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            s.append(String.format(FORMAT, result[i])).append(" ");
        }
        System.out.println(s);
    }


    /*
    variant 20
    C5 = 0 -> C=a×B, a - const
    C7 = 6 -> float
    C11 = 9 -> Знайти середнє значення елементів кожного стовпчика матриця
     */
    private static void firstOperation(float[][] matrix, float a) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] *= a;
            }
        }
    }

    private static float[] secondOperation(float[][] matrix) {
        float[] result = new float[matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            float sum = 0;
            for (int j = 0; j < matrix.length; j++) {
                sum += matrix[j][i];
            }
            result[i] = sum / matrix[i].length;
        }
        return result;
    }

    private static float[][] generateMatrix(int rows, int columns) {
        float[][] matrix = new float[rows][columns];
        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = rand.nextFloat() * 100f;
            }
        }
        return matrix;
    }

    private static void printMatrix(float[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                row.append(String.format(FORMAT, matrix[i][j])).append(" ");
            }
            System.out.println(row);
        }
    }
}
