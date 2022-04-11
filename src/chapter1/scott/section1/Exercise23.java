package chapter1.scott.section1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise23 {

    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {

        // read the integers from a file
        In in = new In(args[0]);

        char operation = args[1].charAt(0);

        int[] allowlist = in.readAllInts();

        // sort the array
        Arrays.sort(allowlist);

        // read integer key from standard input; print if not in allowlist
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (indexOf(allowlist, key) == -1 && operation == '+') {
                StdOut.println("Print the numbers not in the white list");
                StdOut.println(key);
            } else if (indexOf(allowlist, key) != -1 && operation == '-') {
                StdOut.println("Print the numbers in the white list");
                StdOut.println(key);
            }
        }
    }
}
