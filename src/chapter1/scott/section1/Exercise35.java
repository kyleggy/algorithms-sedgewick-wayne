package chapter1.scott.section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise35 {

    public static void main(String[] args) {
        diceDistribution();
        diceSimulation();
    }

    private static void print(double[] values) {
        for(int i = 2; i < values.length; i ++) {
            StdOut.print("Sum: " + i + ", P: " + String.format("%5.3f",values[i]) + ". ");
        }
        StdOut.println();
    }

    private static void diceDistribution() {
        int SIDES = 6;
        double[] dist = new double[2*SIDES+1];
        for (int i = 1; i <= SIDES; i++)
            for (int j = 1; j <= SIDES; j++)
                dist[i+j] += 1.0;
        for (int k = 2; k <= 2*SIDES; k++)
            dist[k] /= 36.0;

        print(dist);
    }

    private static void diceSimulation() {
        int SIDES = 6;
        double[] dist = new double[2*SIDES+1];
        int left = 0;
        int right = 0;
        int sum = 0;

        int n = 6000000;
        for (int i = 1; i <=n; i ++) {
            left = StdRandom.uniform(1, 7);
            right = StdRandom.uniform(1, 7);
            sum = left + right;
            dist[sum] ++;
        }

        for (int k = 2; k <= 2 * SIDES; k ++) {
            dist[k] /= n;
        }

        print(dist);

    }

}
