package chapter1.scott.section1;

public class Exercise27 {
    private static int  count = 0;
    public static int countOld = 0;

    public static void main(String[] args) {
        System.out.println(binomial(10, 4, 0.25));

        //System.out.println(binomialOld(10, 4, 0.25));

    }

    private static double[][] initializeArrays(int N, int k) {
        double[][] twoDimension = new double[N+1][k+1];
        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < k; j ++) {
                twoDimension[i][j] = 0;
            }
        }
        return twoDimension;
    }

    public static double binomial(int N, int k, double p)
    {
        double[][] twoDimension = initializeArrays(N, k);
        System.out.println(count++);
        if ((N == 0) || (k < 0)) return 1.0;
        twoDimension[N][k] = (1.0 - p)*binomial(N-1, k) + p*binomial(N-1, k-1);
        return twoDimension[N][k];
    }

    private static double binomial(int N, int k) {
        return binomial(N, k, 0);
    }

    public static double binomialOld(int N, int k, double p)
    {
        System.out.println(countOld++);
        if ((N == 0) || (k < 0)) return 1.0;
        return (1.0 - p)*binomialOld(N-1, k) + p*binomial(N-1, k-1);
    }

    private static double binomialOld(int N, int k) {
        return binomialOld(N, k, 0);
    }
}
