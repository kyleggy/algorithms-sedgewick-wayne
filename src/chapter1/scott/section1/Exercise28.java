package chapter1.scott.section1;

import java.util.Arrays;

public class Exercise28 {

    public static void main(String[] args) {
        int[] allowlist = new int[]{1, 10, 10, 4, 5, 4};
        int[] sortedWithoutDup = sort(withoutDup(allowlist));
        Arrays.stream(sortedWithoutDup).forEach(System.out::println);

        int key = 10;

        System.out.println(indexOf(sortedWithoutDup, key));
    }

    private static int[] withoutDup(int[] input) {
        int length = input.length;
        int[] output = new int[length];
        output[0] = input[0];
        int k = 0;
        for (int i = 1; i < length; i ++) {
            boolean isDup = false;
            for (int j = 0; j < i; j ++) {
                if(output[j] == input[i]) {
                    isDup = true;
                    break;
                }
            }
            if(!isDup) {
                output[++k] = input[i];
            }
        }

        //output is 1, 10, 4, 5, 0, 0 for output
        int[] realOutputWithoutZero = new int[k +1];
        for (int i = 0; i < k + 1; i ++) {
            realOutputWithoutZero[i] = output[i];
        }
        return realOutputWithoutZero;
    }

    public static int[] sort(int[] input) {
        int length = input.length;
        int[] outPut = input;
        for (int i = 0; i < length-1; i ++){
            if (outPut[i] > outPut [i+1]){
                int temp = outPut[i];
                outPut[i] = outPut[i+1];
                outPut[i+1] = temp;
            }
        }
        return outPut;
    }


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
}
