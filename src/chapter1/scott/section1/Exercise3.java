package chapter1.scott.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise3 {

    public static void main(String[] args) {
        int integer1 = Integer.parseInt(args[0]);
        int integer2 = Integer.parseInt(args[1]);
        int integer3 = Integer.parseInt(args[2]);

        compareInteger(integer1, integer2, integer3);
    }

    private static void compareInteger(int integer1, int integer2, int integer3) {
        if (integer1 == integer2 && integer2 == integer3) {
            StdOut.println("equal");
        } else {
            StdOut.println("not equal");
        }
    }
}
