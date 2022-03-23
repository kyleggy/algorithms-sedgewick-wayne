package chapter1.scott.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise20 {

    public static void main(String[] args) {
        Integer input = Integer.parseInt(args[0]);
        Integer sum = getValue(input);
        StdOut.println(getNaturalLog(sum));

        //correct one
        StdOut.println(lnFactorial(input));
    }

    //ln(N!) = ln(N * (N-1)!) = ln(N) + ln((N-1)!)
    private static double lnFactorial(int n) {
        if (n == 1) {
            return 0;
        }
        return Math.log(n) + lnFactorial(n - 1);
    }

    private static double getNaturalLog(Integer i) {
        double result = i;
        int count = 0;
        while(result > 1) {
            result = result/Math.E;
            count ++;
        }
        result = count + result;
        return result;
    }

    private static Integer getValue(Integer i) {
        int sum = i;
        while (i > 1) {
            sum = sum * (i - 1);
            i--;
        }
        return sum;
    }
}
