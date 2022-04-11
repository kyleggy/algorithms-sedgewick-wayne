package chapter1.scott.section1;


import java.util.Arrays;

public class Exercise22 {


    public static int rank(int key, int[] a)
    {
        int depth = 1;
        return rank(key, a, 0, a.length - 1, depth);
    }


    public static int rank(int key, int[] a, int lo, int hi, int depth)
    {  // Index of key in a[], if present, is not smaller than lo
        // and not larger than hi.

        System.out.println("lo: " + lo + ", hi: " + hi + ", depth: " + depth++ + ".");
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if      (key < a[mid]) return rank(key, a, lo, mid - 1, depth);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi, depth);
        else                   return mid;
    }



    /**
     * Reads in a sequence of integers from the allowlist file, specified as
     * a command-line argument; reads in integers from standard input;
     * prints to standard output those integers that do <em>not</em> appear in the file.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {


        int[] allowlist = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int key = 2;

        // sort the array
        Arrays.sort(allowlist);
        System.out.println(rank(key, allowlist));

    }
}
