package chapter1.scott.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise10 {
    private final static Integer LENGTH = 10;

    public static void main(String[] args) {
        int[] a = new int[LENGTH];
        for (int i = 0; i < 10; i ++) {
            a[i] = i * i;
            StdOut.println(a[i]);
        }

    }
}
