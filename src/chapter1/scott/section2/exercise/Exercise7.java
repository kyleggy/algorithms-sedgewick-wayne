package chapter1.scott.section2.exercise;

import edu.princeton.cs.algs4.StdOut;

public class Exercise7 {

    public static void main(String[] args) {
        String s = "American";
        StdOut.println(mystery(s));
        StdOut.println("Expected: naciremA");

        StdOut.println(notMystery(s));
        StdOut.println(s);
        StdOut.println("Expected: American");


    }

    public static String mystery(String s)
    {
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N/2);
        String b = s.substring(N/2, N);
        return mystery(b) + mystery(a);
    }

    public static String notMystery(String s)
    {
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N/2);
        String b = s.substring(N/2, N);
        StdOut.println(String.format("a is [%s] and b is [%s]", a, b));
        return notMystery(a) + notMystery(b) ;
    }
}
