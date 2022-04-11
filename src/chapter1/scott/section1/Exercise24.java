package chapter1.scott.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise24 {

    public static void main(String[] args) {
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);

        System.out.println(gcd(p, q));

    }

    public static int gcd(int p, int q)
    {
        StdOut.println(p + " and " + q);
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }
}
