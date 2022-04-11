package chapter1.scott.section1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise32Scott {

    public static void main(String[] args) {
        Integer count = Integer.parseInt(args[0]);
        Double left = Double.parseDouble(args[1]);
        Double right = Double.parseDouble(args[2]);

        StdOut.println("count: " + count);
        StdOut.println("Left: " + left);
        StdOut.println("Right: " + right);

        Double[] filteredSamples = filter_samples(left, right);
        Arrays.stream(filteredSamples).forEach(StdOut::println);

        Integer[] filterNumbers = filter_numbers(count, left, right, filteredSamples);
        Arrays.stream(filterNumbers).forEach(StdOut::println);

        draw_histogram(filterNumbers, filteredSamples);
    }

    private static Double[] filter_samples(Double left, Double right) {
        String filterString = "";
        String space = " ";
        while (!StdIn.isEmpty()) {
            String singleValue = StdIn.readString();
            Double doubleValue = Double.parseDouble(singleValue);
            if (doubleValue >= left && doubleValue <= right) {
                filterString += singleValue + space;
            }
        }
        Double[] samples = null;
        if (!filterString.isEmpty()) {
            String[] splitStrings = filterString.split(space);
            int length = splitStrings.length;
            samples = new Double[length];
            for (int i = 0; i < length; i ++) {
                samples[i] = Double.parseDouble(splitStrings[i]);
            }
        }
        return samples;
    }

    private static Integer[] filter_numbers(Integer N, Double left, Double right, Double[] filteredSamples) {
        Double interval = (right - left) / N;
        Integer[] counts = new Integer[N];

        for (int i = 0; i < N; i ++) {
            Double begin = left + i * interval;
            Double end = left + (i + 1) * interval;
            counts[i] = 0;
            for (int j = 0; j < filteredSamples.length; j++ ) {
                if (filteredSamples[j] >= begin && filteredSamples[j] < end) {
                    counts[i] ++;
                }
            }
        }

        return counts;
    }

    public static void draw_histogram(Integer[] intervals, Double[] samples) {

//        StdDraw.setPenRadius(.006);
//        StdDraw.line(0, 0, 1, 0);
//        StdDraw.line(0, 0, 0, 1);

        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
        StdDraw.setPenRadius(.01);
        int n = intervals.length;
        int total = samples.length;
        double interval_width = 1.0 / n;
        double x, y;
        double halfWidth = interval_width / 2;

        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.setPenRadius(0.006);
        for (int i = 0; i < n; i++) {
            x = i * interval_width + halfWidth;
            y = (double)intervals[i] / total / 2;
            StdDraw.rectangle(x, y, halfWidth, y);
        }

    }
}
