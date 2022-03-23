package chapter1.scott.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise14 {

    public static void main(String[] args) {
        StdOut.println(lg(9));
        double a = 9 / 2.0;
        StdOut.println(a); //4.5

        int b = 9 / 2;
        StdOut.println(b); //4

    }

    private static int lg(int n) {
        int result = 0;
        while (n > 1) {
            n = n/2;
            result++;
        }
        return result;
    }
}
