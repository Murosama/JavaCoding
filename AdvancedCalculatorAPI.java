import java.util.Arrays;

public class AdvancedCalculatorAPI {

    // Method to calculate the factorial of a number
    public static long factorial(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        return n == 0 ? 1 : n * factorial(n - 1);
    }

    // Method to solve quadratic equations: ax^2 + bx + c = 0
    public static double[] solveQuadratic(double a, double b, double c) throws IllegalArgumentException {
        if (a == 0) {
            throw new IllegalArgumentException("Coefficient 'a' cannot be zero for a quadratic equation");
        }
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            throw new IllegalArgumentException("No real roots exist for the given quadratic equation");
        }
        double sqrtDiscriminant = Math.sqrt(discriminant);
        double root1 = (-b + sqrtDiscriminant) / (2 * a);
        double root2 = (-b - sqrtDiscriminant) / (2 * a);
        return new double[]{root1, root2};
    }

    // Method to multiply two matrices
    public static double[][] multiplyMatrices(double[][] matrix1, double[][] matrix2) throws IllegalArgumentException {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;

        if (cols1 != rows2) {
            throw new IllegalArgumentException("Number of columns in the first matrix must be equal to the number of rows in the second matrix");
        }

        double[][] result = new double[rows1][cols2];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    // Method to display a matrix
    public static void displayMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        try {
            // Factorial example
            int num = 5;
            System.out.println("Factorial of " + num + " is " + factorial(num));

            // Quadratic equation example
            double a = 1, b = -3, c = 2;
            double[] roots = solveQuadratic(a, b, c);
            System.out.println("Roots of the quadratic equation are: " + Arrays.toString(roots));

            // Matrix multiplication example
            double[][] matrix1 = {
                    {1, 2, 3},
                    {4, 5, 6}
            };
            double[][] matrix2 = {
                    {7, 8},
                    {9, 10},
                    {11, 12}
            };
            double[][] resultMatrix = multiplyMatrices(matrix1, matrix2);
            System.out.println("Result of matrix multiplication:");
            displayMatrix(resultMatrix);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
