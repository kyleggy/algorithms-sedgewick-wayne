package chapter1.scott.section2.exercise;

import edu.princeton.cs.algs4.*;

public class Exercise3 {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);

        if (min > max) {
            double temp = min;
            min = max;
            max = temp;
        }

        ExtendedInterval2D[] intervals = new ExtendedInterval2D[n];
        drawAndCreateInterval2D(intervals, min, max);
        calculateIntersectAndContainedPairs(intervals);
    }

    private static void calculateIntersectAndContainedPairs(ExtendedInterval2D[] intervals) {
        int intersectCounter = 0;
        int containedCounter = 0;
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j ++) {
                if (intervals[i].intersects(intervals[j])) {
                    intersectCounter ++;
                }
                if (intervals[i].isContained(intervals[j])) {
                    containedCounter ++;
                }
            }
        }
        StdOut.println(String.format("The intersect count is %d.", intersectCounter));
        StdOut.println(String.format("The contained count is %d.", containedCounter));
    }

    private static void drawAndCreateInterval2D(ExtendedInterval2D[] intervals, double min, double max) {
        StdDraw.setCanvasSize(1024, 512);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.setPenRadius(0.01);
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);

        for (int i = 0; i < intervals.length; i ++) {
            double x = StdRandom.uniform(min, max);
            double y = StdRandom.uniform(min, max);
            Interval1D intervalX = generateInterval1D(min, max);
            Interval1D intervalY = generateInterval1D(min, max);
            ExtendedInterval2D interval2D = new ExtendedInterval2D(intervalX, intervalY);
            interval2D.draw();
            intervals[i] = interval2D;
        }

    }
    private static Interval1D generateInterval1D(double min, double max) {
        double firstValue = StdRandom.uniform(min, max);
        double secondValue = StdRandom.uniform(min, max);

        if (firstValue > secondValue) {
            double temp = firstValue;
            firstValue = secondValue;
            secondValue = temp;
        }
        return new Interval1D(firstValue, secondValue);
    }

    private static class ExtendedInterval2D extends Interval2D {
        private Interval1D x;
        private Interval1D y;

        /**
         * Initializes a two-dimensional interval.
         *
         * @param x the one-dimensional interval of x-coordinates
         * @param y the one-dimensional interval of y-coordinates
         */
        public ExtendedInterval2D(Interval1D x, Interval1D y) {
            super(x, y);
            this.x = x;
            this.y = y;
        }

        public Interval1D getInterval1DX() {
            return x;
        }

        public Interval1D getInterval1DY() {
            return y;
        }

        public Boolean isContained(ExtendedInterval2D extendedInterval2D) {
            Boolean isContained = false;
            Double xmin = this.getInterval1DX().min();
            Double xmax = this.getInterval1DX().max();
            Double ymin = this.getInterval1DY().min();
            Double ymax = this.getInterval1DY().max();

            Double thatXMin = extendedInterval2D.getInterval1DX().min();
            Double thatXMax = extendedInterval2D.getInterval1DX().max();
            Double thatYMin = extendedInterval2D.getInterval1DY().min();
            Double thatYMax = extendedInterval2D.getInterval1DY().max();

            if((xmin < thatXMin) && (xmax > thatXMax) && (ymin < thatYMin) && (ymax > thatYMax)) {
                isContained = true;
            } else if((thatXMin < xmin) && (thatXMax > xmax) && (thatYMin < ymin) && (thatYMax > ymax)) {
                isContained = true;
            }
            return isContained;
        }


    }
}
