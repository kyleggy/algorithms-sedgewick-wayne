package chapter1.scott.section1;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Exercise39 {

    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        int count = 4;
        int[][] summary = new int[T][count];
        for (int i = 0 ; i < T; i ++) {
            int N = 1000;
            for (int begin = 0; begin < count; begin ++) {
                int[] firstRandomArray = generateSixDigitIntArray(N);
                int[] secondRandomArray = generateSixDigitIntArray(N);

                Arrays.sort(firstRandomArray);
                Arrays.sort(secondRandomArray);

                int number = 0;

                for (int k = 0; k < N; k ++) {
                    if (k > 0 && firstRandomArray[k] == firstRandomArray[k - 1]) {
                        continue;
                    }
                    if (binarySearch(secondRandomArray, firstRandomArray[k]) != -1) {
                        number ++;
                    }

//                    if(binarySearch(firstRandomArray[k], secondRandomArray, 0, firstRandomArray.length - 1)) {
//                        number ++;
//                    }
                }
                summary[i][begin] = number;
                N = N * 10;
            }
        }
        printArray(summary);
    }


    private static int[] generateSixDigitIntArray(int length) {
        int[] intArrays = new int[length];
        for (int i = 0; i < intArrays.length; i ++) {
            intArrays[i] = generateSixDigitInt();
        }
        return intArrays;
    }

    private static int generateSixDigitInt() {
        return  StdRandom.uniform(100000, 1000000);
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

    private static boolean binarySearch(int key, int[] arr, int lo, int hi) {
        if (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (key < arr[mid]) {
                return binarySearch(key, arr, lo, mid - 1);
            } else if (key > arr[mid]) {
                return binarySearch(key, arr, mid + 1, hi);
            } else {
                return true;
            }
        }
        return false;
    }

    private static void printArray(int[][] input) {
        int length = input.length;
        int width = input[0].length;
        for (int i = 0; i < length; i ++ ) {
            for (int j = 0; j < width; j ++) {
                System.out.print(i + " " + j + " " + input[i][j] + ";");
            }
            System.out.println();
        }
    }
}
