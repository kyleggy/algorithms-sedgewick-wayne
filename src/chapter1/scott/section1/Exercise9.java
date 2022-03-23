package chapter1.scott.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise9 {

    public static void main(String[] args) {
        Integer a = Integer.parseInt(args[0]);
        StdOut.println(toBinaryString(a));

    }

    private static String toBinaryString(final Integer input) {
        String s = "";
        for (int n = input; n > 0; n /=2) {
            s = (n % 2) + s;
        }
        return s;
    }
}
