package chapter1.scott.section1;

public class Exercise8 {

    /**
     * '1' is a digit, not a number, and is encoded in ASCII to be of value 49.
     *
     * Chars in Java can be promoted to int, so if you ask to add an int like 1 to a char like '1', alias 49, the more narrow type char is promoted to int, getting 49, + 1 => 50.
     *
     * Note that every non-digit char can be added the same way:
     *
     * 'a' + 0 = 97
     * 'A' + 0 = 65
     * ' ' + 0 = 32
     * Share
     * @param args
     */
    public static void main(String[] args) {
        System.out.println('b');
        System.out.println('b' + 'c');  //197
        System.out.println((char) ('a' + 4));
    }
}
