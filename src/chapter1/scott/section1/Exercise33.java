package chapter1.scott.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise33 {

    public static void main(String[] args) {
        double[] x = {2.3, 4.3, 4.1};
        double[] y = {9.3, 5.4, 7.3};
        StdOut.println(String.format("%.2f", dot(x, y)));

        double[][] a = new double[2][3];
        a[0][0] = 1.0;
        a[0][1] = 2.0;
        a[0][2] = 3.0;
        a[1][0] = 4.0;
        a[1][1] = 5.0;
        a[1][2] = 6.0;

        double[][] b = new double[3][2];
        b[0][0] = 7.0;
        b[0][1] = 8.0;
        b[1][0] = 9.0;
        b[1][1] = 10.0;
        b[2][0] = 11.0;
        b[2][1] = 12.0;

        double[][] mulResult = mult(a, b);
        printArray(mulResult);

        double[][] transposeresult = transpose(mulResult);
        printArray(transposeresult);

        double[] z = {3, 4, 5};
        StdOut.println(mult(a, z));
    }

    //vector dot product
    /*
    https://en.wikipedia.org/wiki/Dot_product
     */
    private static double dot(double[] x, double[] y) {

        if (x == null || y == null || x.length != y.length) {
            throw new IllegalArgumentException();
        }

        double result = 0;
        for (int i = 0; i < x.length; i ++) {
            result += x[i] * y[i];
        }
        return result;
    }

    //https://en.wikipedia.org/wiki/Matrix_multiplication
    private static double[][] mult(double[][] a, double[][] b) {
        if (a == null || b == null || a[0].length != b.length) {
            throw new IllegalArgumentException();
        }
        int n = a[0].length;
        int m = a.length;
        int p = b[0].length;

        double[][] results = new double[m][p];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < p; j ++) {
                double value = 0;
                for (int k = 0; k < n; k ++) {
                    value += a[i][k] * b[k][j];
                }
                results[i][j] = value;
            }
        }
        return results;
    }

    //https://www.math.net/transpose
    private static double[][] transpose(double[][] x) {
        int i = x.length;
        int j = x[0].length;
        double[][] output = new double[j][i];
        for (int width = 0 ; width < j; width ++) {
            for (int length = 0; length < i; length++) {
                output[width][length] = x[length][width];
            }
        }
        return output;
    }

    //https://people.math.umass.edu/~havens/m235Lectures/Lecture05.pdf
//    private static double mult(double[][] a, double[] x) {
//        int i = a.length;
//        int j = a[0].length;
//        double output = 0;
//        for (int k = 0; k < j; k ++) {
//            for (int m = 0; m < i; m ++) {
//                output += a[m][k] * x[k];
//            }
//        }
//        return output;
//    }

    // Matrix-vector product
    private static double[] mult(double[][] a, double[] x) {

        // Number of columns in matrix must be the same as the number of elements in vector
        if (a == null || x == null || a[0].length != x.length) {
            throw new IllegalArgumentException();
        }

        double[] b = new double[a.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < x.length; j++) {
                b[i] += a[i][j] * x[j];
            }
        }

        return b;
    }

    // Vector-matrix product
    private static double[] mult(double[] y, double[][] a) {

        // Number of rows in matrix must be the same as the number of elements in vector
        if (a == null || y == null || a.length != y.length) {
            throw new IllegalArgumentException();
        }

        double[] b = new double[a[0].length];

        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < y.length; j++) {
                b[i] += a[j][i] * y[j];
            }
        }

        return b;
    }
    private static void printArray(double[][] input) {
        int length = input.length;
        for (int i = 0; i < length; i ++ ) {
            for (int j = 0; j < length; j ++) {
                System.out.print(i + " " + j + " " + input[i][j] + ";");
            }
            System.out.println();
        }
    }

}
