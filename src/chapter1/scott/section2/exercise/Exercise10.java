package chapter1.scott.section2.exercise;

import edu.princeton.cs.algs4.StdDraw;

public class Exercise10 {

    public static void main(String[] args) {
        VisualCounter visualCounter = new VisualCounter(12, 10);
        visualCounter.increment();
        visualCounter.increment();
        visualCounter.increment();
        visualCounter.increment();
        visualCounter.increment();
        visualCounter.increment();
        visualCounter.decrement();
        visualCounter.decrement();
        visualCounter.decrement();
        visualCounter.decrement();
        visualCounter.increment();
        visualCounter.increment();
        visualCounter.increment();


    }

    static class VisualCounter {
        int maxNumberOfOperations;
        int maxAbsoluteValue;

        private int totalOperations = 0;
        private int counter = 0;

        public VisualCounter(int N, int max) {
            maxNumberOfOperations = N;
            maxAbsoluteValue = Math.abs(max);
            StdDraw.setCanvasSize(1024, 768);
            StdDraw.setPenRadius(.015);
            StdDraw.setXscale(0, N + 1);
            StdDraw.setYscale(-3 - max, max + 3);
        }

        public void increment() {
            if (totalOperations < maxNumberOfOperations && counter < maxAbsoluteValue) {
                totalOperations++;
                counter++;
                drawPlot();
            }
        }

        public void decrement() {
            if (totalOperations < maxNumberOfOperations && Math.abs(counter) < maxAbsoluteValue) {
                totalOperations++;
                counter--;
                drawPlot();
            }

        }

        private void drawPlot() {
            StdDraw.point(totalOperations, counter);
        }
    }
}
