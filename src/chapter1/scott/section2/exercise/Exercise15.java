package chapter1.scott.section2.exercise;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

public class Exercise15 {

    public static void main(String[] args) {
        int[] input = In.readInts("/Users/scott/Documents/GitHub/algorithms-sedgewick-wayne/resources/algs4-data/1Kints.txt");
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }

    public static int[] readInts(String name)
    {
        In in = new In(name);
        String input = StdIn.readAll();
        String[] words = input.split("\\s+");
        int[] ints = new int[words.length];
        for (int i = 0; i < words.length; i++)
        ints[i] = Integer.parseInt(words[i]);
        return ints;
    }
}
