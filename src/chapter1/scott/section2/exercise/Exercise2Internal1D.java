package chapter1.scott.section2.exercise;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * It first initializes the array with smaller value located at left and larger value located at right
 * Then it filters by excluding the un intersect intervals
 */
public class Exercise2Internal1D {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Interval1D interval1D = new Interval1D(n);
        interval1D.generateRandomIntervals();
        interval1D.printPairIntervals();
    }

    private static class Interval {
        private double min;
        private double max;

        public Interval(double begin, double end) {
            this.min = begin;
            this.max = end;
        }

        public double getBegin() {
            return min;
        }

        public double getEnd() {
            return max;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "begin=" + min +
                    ", end=" + max +
                    '}';
        }
    }

    private static class Interval1D {
        Interval[] intervals;

        public Interval1D(int n) {
            intervals = new Interval[n];
        }

        public void generateRandomIntervals() {
            for (int i = 0; i < intervals.length; i ++) {
                double begin = StdRandom.uniform();
                double end = StdRandom.uniform();
                Interval interval;
                if (begin < end) {
                    interval = new Interval(begin, end);
                } else {
                    interval = new Interval(end, begin);
                }

                intervals[i] = interval;
            }
        }

        public void printPairIntervals() {
            for (int i = 0; i < intervals.length; i ++) {
                for (int j = i + 1; j < intervals.length; j ++) {
                    boolean isIntersect = true;
                    Interval first = intervals[i];
                    Interval second = intervals[j];
                    if (first.getEnd() < second.getBegin()) {
                        isIntersect = false;
                    } else if (second.getEnd() < first.getBegin()) {
                        isIntersect = false;
                    }
                    if (isIntersect) {
                        StdOut.println(String.format("[%s] and [%s] are intersect", first, second));
                    }
                }
            }
        }
    }
}
