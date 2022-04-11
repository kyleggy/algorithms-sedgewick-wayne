package chapter1.scott.section1;

import java.util.Arrays;

public class Exercise29 {

    public static void main(String[] args) {
        int[] allowlist = new int[]{1, 10, 5, 5, 4};
        Arrays.sort(allowlist); // 1, 4, 5, 5, 10
        int key = 5;
        System.out.println(indexOf(allowlist, key));
        int smallerCount = rank(key, allowlist);
        int equalCount = count(key, allowlist);
        System.out.println("Number of elements : " +smallerCount + " are smaller than key: " + key);
        System.out.println("Number of elements : " + equalCount + " are equal than key: " + key);
        if (allowlist[smallerCount] == key) {
            System.out.println(" a[smallerCount] is equal to key");
        }
        if (allowlist[smallerCount + equalCount -1] == key) {
            System.out.println("a[smallerCount + equalCount -1] is equal to key");
        }

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

    public static int rank(int key, int[] sortedInput) {
        int count = 0;
        for (int i = 0; i < sortedInput.length; i ++) {
            if (key > sortedInput[i]) {
                count ++;
            }
        }
        return count;
    }

    public static int count(int key, int[] sortedInput) {
        int count = 0;
        for (int i = 0; i < sortedInput.length; i ++) {
            if (key == sortedInput[i]) {
                count ++;
            }
        }
        return count;
    }
}
