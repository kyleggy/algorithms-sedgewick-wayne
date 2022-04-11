package chapter1.scott.section1;

import edu.princeton.cs.algs4.StdRandom;

public class Exercise36 {

    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);


    }

    public static void shuffle(double[] a)
    {
        int N = a.length;
        for (int i = 0; i < N; i++)
        {  // Exchange a[i] with random element in a[i..N-1]
            int r = i + StdRandom.uniform(N-i);
            double temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
}
