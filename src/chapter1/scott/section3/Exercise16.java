package chapter1.scott.section3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

public class Exercise16 {

    public static void main(String[] args) {
        Date[] dates = readDates();
        Arrays.stream(dates).forEach(System.out::println);

    }

    public static int[] readInts(String name)
    {
        In in = new In(name);
        Queue<Integer> q = new Queue<>();
        while (!in.isEmpty())
            q.enqueue(in.readInt());
        int N = q.size();
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = q.dequeue();
        return a;
    }

    public static Date[] readDates() {
        Queue<Date> dateQueue = new Queue<>();
        while(!StdIn.isEmpty()) {
            String stdInDate = StdIn.readString();
            Date date = new Date(stdInDate);
            dateQueue.enqueue(date);
        }
        Date[] returnedDates = new Date[dateQueue.size()];
        for ( int i = 0; i < returnedDates.length; i ++) {
            returnedDates[i] = dateQueue.dequeue();
        }
        return returnedDates;
    }

    public static class Date
    {
        private final int month;
        private final int day;
        private final int year;

        public Date(String date) {
            String[] parts = date.split("/");
            month = Integer.parseInt(parts[0]);
            day = Integer.parseInt(parts[1]);
            year = Integer.parseInt(parts[2]);
            if(!isDateValid(month, day, year))
                throw new IllegalArgumentException("Invalid date format");
        }

        public Date(int m, int d, int y)
        {

            if(!isDateValid(m, d, y))
                throw new IllegalArgumentException("Invalid date format");
            month = m; day = d; year = y;
        }

        public int month()
        {
            return month;
        }

        public int day()
        {
            return day;
        }

        public int year()
        {
            return year;
        }

        public String toString()
        {
            return month() + "/" + day() + "/" + year();
        }

        // Support valid day
        private static boolean isDateValid(int month, int day, int year) {
            boolean valid = true;
            int[] maxNumberOfDaysPerMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            if (year < 1 || month < 1 || month > 12 || day < 1 || day > maxNumberOfDaysPerMonth[month - 1]) {
                valid = false;
            }
            return valid;
        }
    }
}
