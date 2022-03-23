package chapter1.scott.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise5 {

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);

        if (isBetweenZeroAndOne(x) && isBetweenZeroAndOne(y)) {
            StdOut.println("true");
        } else {
            StdOut.println("false");
        }

    }

    private static boolean isBetweenZeroAndOne(double input) {
        return input >= 0 && input <= 1;
    }
}
