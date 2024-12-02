package chapter1.scott.section2.exercise;

import edu.princeton.cs.algs4.StdOut;

public class Exercise9 {



    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int searchValue = 8;
        Integer count = 0;
        Counter counter = new Counter();
        rank(searchValue, a, counter);
        StdOut.println(String.format("The number of counted keys are %d", counter.getCount()));


    }

    private static int rank(int key, int[] a, Counter count)
    {  // Array must be sorted.
        int lo  = 0;
        int hi = a.length - 1;
        while (lo <= hi)
        {  // Key is in a[lo..hi] or not present.
            count.increaseCount();
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else                   return mid;
        }
        return -1;
    }

    private static class Counter {
        private Integer count = 0;

        public Counter() {
        }

        public void increaseCount() {
            ++count;
        }

        public Integer getCount() {
            return count;
        }
    }
}
