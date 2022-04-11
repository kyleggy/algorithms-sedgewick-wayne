package chapter1.scott.section1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise38 {

    enum SearchType {
        BinarySearch,
        BruteForceSearch
    }

    public static void main(String[] args) {
        execute(SearchType.BinarySearch);

        execute(SearchType.BruteForceSearch);

    }



    private static void execute(SearchType searchType) {
        String userDirectory = System.getProperty("user.dir") + "/src/chapter1/scott/section1/";
        String whiteList = userDirectory + "largeW.txt";
        String filter = userDirectory + "largeT.txt";
        // read the integers from a file

        In white = new In(whiteList);
        int[] allowlist = white.readAllInts();

        // sort the array
        Arrays.sort(allowlist);

        In input = new In(filter);
        // read integer key from standard input; print if not in allowlist
        Long current = System.currentTimeMillis();
        while ( !input.isEmpty()) {
            int key = input.readInt();
            if (search(searchType, allowlist, key) == -1)
                StdOut.println(key);
        }

        Long finish = System.currentTimeMillis();
        System.out.println("Cost Time in seconds: " + (finish - current)/1000);
    }

    private static int search(SearchType searchType, int[] a, int key) {
        switch (searchType) {
            case BinarySearch:
                return binarySearch(a, key);
            case BruteForceSearch:
                return bruteForceSearch(a, key);
            default:
                throw new UnsupportedOperationException();
        }
    }

    private static int binarySearch(int[] a, int key) {
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

    private static int bruteForceSearch(int[] a, int key)
    {
        for (int i = 0; i < a.length; i++)
            if (a[i] == key) return i;
        return -1;
    }

}
