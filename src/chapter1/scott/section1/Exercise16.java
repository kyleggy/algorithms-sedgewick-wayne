package chapter1.scott.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise16 {

    public static void main(String[] args) {
        //311361142246  sum= 34
        StdOut.println(exR1(6));

        StdOut.println(exR1(200));
    }

    /*
    n = 6, 6 + 6 + exR1(3) + exR1(4);
    n = 3, 3 + 3 + exR1(0) + exR1(1);
    n = 0, 0;
    n = 1, 1 + 1 ....;
    n = 4, 4 + 4 + exR1(1) + exR1(2);
    n = 2, 2 + 2
    sum = 6 + 6 + 3 + 3 + 2 + 4 + 4 + 1 + 1 + 2 + 2
        = 34;
     */
    public static String exR1(int n)
    {
        if (n <= 0) return "";
        return exR1(n-3) + n + exR1(n-2) + n;
    }
}
