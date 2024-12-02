package chapter1.scott.section2.exercise;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise1 {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Point2D[] point2D = new Point2D[n];
        drawAndCreatePoints(point2D);
        StdOut.println(String.format("Shortest Distance is %f", calculateShortestDistance(point2D)));
    }

    private static double calculateShortestDistance(Point2D[] points) {
        double shortestDistance = points[0].distanceTo(points[1]);
        //It can also be defined as MaxValue of Double
        //Double shortestDistance = Double.MAX_VALUE;
        for(int i = 0; i < points.length; i ++) {
            for (int j = i + 1; j < points.length; j++) {
                double temp = points[i].distanceTo(points[j]);
                if (temp < shortestDistance) {
                    shortestDistance = temp;
                }
            }
        }
        return shortestDistance;
    }

    private static void drawAndCreatePoints(Point2D[] points) {
        StdDraw.setCanvasSize(1024, 512);
        StdDraw.setPenRadius(.015);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);

        for (int i = 0; i < points.length; i++) {
            double pointX = StdRandom.uniform();
            double pointY = StdRandom.uniform();

            Point2D point = new Point2D(pointX, pointY);
            StdDraw.point(point.x(), point.y()); //The exercise doesn't require drawing, but it adds a nice touch

            points[i] = point;
        }
    }
}
