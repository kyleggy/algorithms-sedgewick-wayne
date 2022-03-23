package chapter1.scott.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise6 {

    /**
     * i = 0, f = 0, current_f = 1, current_g = 0
     * i = 1, f = 1, current_f = 1, current_g = 1;
     * i = 2, f = 1, current_f = 2, current_g = 1;
     * i = 3, f = 2, current_f = 3, current_g = 2;
     * i = 4, f = 3, current_f = 5, current_g = 3;
     * i = 5, f = 5, current_f = 8, current_g = 5;
     * ......
     *
     */

    public static void main(String[] args) {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++)
        {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }


    }
}

