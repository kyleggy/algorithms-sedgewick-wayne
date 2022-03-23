package chapter1.scott.section1;

public class Exercise13 {

    public static void main(String[] args) {
        int[][] abc = new int[5][2];
        abc[0][0] = 0;
        abc[0][1] = 1;
        abc[1][0] = 2;
        abc[1][1] = 3;
        abc[2][0] = 4;
        abc[2][1] = 5;
        abc[3][0] = 6;
        abc[3][1] = 7;
        abc[4][0] = 8;
        abc[4][1] = 9;

        int[][] outArray = switchArrays(abc);
        print(outArray);

    }

    private static int[][] switchArrays(int[][] input) {
        int outLength = input.length;
        int innerLength = input[0].length;
        int[][] outputArray = new int[innerLength][outLength];
        for (int i = 0; i < outLength; i ++) {
            int inputInnerLength = input[i].length;
            for (int j = 0; j < inputInnerLength; j ++) {
                outputArray[j][i] = input[i][j];
            }
        }
        return outputArray;
    }

    private static void print(int[][] input) {
        int outLength = input.length;
        for (int i = 0; i < outLength; i ++) {
            int inputInnerLength = input[i].length;
            for (int j = 0; j < inputInnerLength; j ++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
