package chapter1.scott.section1;

public class Exercise30 {

    public static void main(String[] args) {
        int N = 10;
        boolean[][] arrays = new boolean[N][N];
        boolean[][] assignedArrays = assignedValues(arrays);
        printArray(assignedArrays);

    }

    private static void printArray(boolean[][] input) {
        int length = input.length;
        for (int i = 0; i < length; i ++ ) {
            for (int j = 0; j < length; j ++) {
                System.out.println(i + " " + j + " " + input[i][j]);
            }
        }
    }

    private static boolean[][] assignedValues(boolean[][] input) {
        boolean[][] output = input.clone();
        int length = input.length;
        for (int i = 0; i < length; i ++ ) {
            for (int j = 0; j < length; j ++) {
                if (isRelativePrime(i, j)) {
                    output[i][j] = true;
                } else {
                    output[i][j] = false;
                }
            }
        }
        return output;
    }

    public static boolean isPrime(int N)
    {
        if (N < 2) return false;
        for (int i = 2; i*i <= N; i++)
            if (N % i == 0) return false;
        return true;
    }

    public static boolean isRelativePrime(int i, int j) {
        if (i < 2 || j < 2) {
            return false;
        }
        int reference = i < j ? i: j;
        for (int count = 2; count <= reference; count ++) {
            if (i % count == 0 && j % count == 0) {
                return false;
            }
        }
        return true;
    }

    public static int gcd(int p, int q)
    {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

}
