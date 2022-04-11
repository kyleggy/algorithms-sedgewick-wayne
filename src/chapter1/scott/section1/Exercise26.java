package chapter1.scott.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise26 {

    public static void main(String[] args) {
        int a = 5, b = 9, c = 2, t;
        StdOut.println("Before: a = " + a + ", b = " + b + ", c = " + c + ";");
        if (a > b) { t = a; a = b; b = t; }
        if (a > c) { t = a; a = c; c = t; }
        if (b > c) { t = b; b = c; c = t; }
        StdOut.println("After: a = " + a + ", b = " + b + ", c = " + c + ";");
    }


}
