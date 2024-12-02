package chapter1.scott.section2.exercise;

import edu.princeton.cs.algs4.StdOut;

public class Exercise4 {

   /*
   world
   hello
    */
    public static void main(String[] args) {
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        StdOut.println(string1);
        StdOut.println(string2);
    }
}
