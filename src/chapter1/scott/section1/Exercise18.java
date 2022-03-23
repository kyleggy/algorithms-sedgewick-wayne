package chapter1.scott.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise18 {
    private static final long[] arraysF = new long[100];

    public static void main(String[] args) {
        for (int i = 0; i < arraysF.length; i ++) {
            arraysF[i] = 0;
        }

        for (int N = 0; N < 100; N ++) {
            arraysF[N] = saveArrayF(N);
            StdOut.println(N + " " + arraysF[N]);
        }

    }

    private static long saveArrayF(int N) {
        if ( N == 0) return 0;
        if ( N == 1) return 1;
        long leftValue = arraysF[N-1] != 0 ? arraysF[N-1] : saveArrayF(N-1);
        long rightValue = arraysF[N-2] !=0 ? arraysF[N-2] : saveArrayF(N-2);
        return leftValue + rightValue;
    }

    private static class Fibonacci
    {
        public static long F(int N)
        {
            if (N == 0) return 0;
            if (N == 1) return 1;
            return F(N-1) + F(N-2);
        }
        public static void main(String[] args)
        {
            for (int N = 0; N < 100; N++)
                StdOut.println(N + " " + F(N));
        } }
}

