package chapter1.scott.section2.example;

import edu.princeton.cs.algs4.StdRandom;

public class TestisualAccumulator {
    public static void main(String[] args)
    {
        int T = Integer.parseInt(args[0]);
        VisualAccumulator a = new VisualAccumulator(T, 1.0);
        for (int t = 0; t < T; t++)
            a.addDataValue(StdRandom.random());
        //StdOut.println(a);
    }

}
