package chapter1.scott.section2.exercise;

import edu.princeton.cs.algs4.StdOut;

public class Exercise6 {

    public static void main(String[] args) {
        String s = "ACTGACG";
        String t = "TGACGAC";
        String combine = "ACTGACGTGACGAC";
        StdOut.println(isCircularRotation(s, t));
        StdOut.println(isCircularShift(s, t));
        String k = "abcdef";
        String p = "fabcde";
        StdOut.println(isCircularRotation(k, p));
        StdOut.println(isCircularShift(k, p));
        String kd = "abcdea";
        String pd = "fabcde";
        StdOut.println(isCircularRotation(kd, pd));
        StdOut.println(isCircularShift(kd, pd));

    }

    private static boolean  isCircularRotation(String s, String t) {
        boolean isCircular = false;
        if ((s.length() != t.length())) {
            isCircular = false;
        }
        if (s.equals(t)) {
            isCircular = true;
            return isCircular;
        }

        for (int i = 1; i < s.length(); i ++) {
            String temp = s.substring(i, s.length()).concat(s.substring(0, i));
            if (temp.equals(t)) {
                isCircular = true;
                break;
            }
        }
        return isCircular;
    }

    //One liner solution - does not safe check for null values
    private static boolean isCircularShift(String s, String t) {
        return s.length() == t.length() && (s + s).contains(t);
    }
}
