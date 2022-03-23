package chapter1.scott.section1;

import java.util.Arrays;

public class Exercise15 {

    public static void main(String[] args) {
        int[] test = new int[10];
        test[0] = 0;
        test[1] = 2;
        test[2] = 2;
        test[3] = 2;
        test[4] = 80;
        test[5] = 5;
        test[6] = 6;
        test[7] = 7;
        test[8] = 8;
        test[9] = 9;

        int[] result = histogram(test, 8);
        Arrays.stream(result).forEach(System.out::println);
    }

    private static int[] histogram(int[] input, int m) {
        int[] result = new int[m];
        for (int i = 0; i < result.length; i ++) {
            result[i] = 0;
            for (int j = 0; j < input.length; j ++) {
                if (i == input[j]) {
                    result[i] ++;
                }
            }

        }

        return result;
    }
}
