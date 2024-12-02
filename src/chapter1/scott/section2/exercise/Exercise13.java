package chapter1.scott.section2.exercise;

public class Exercise13 {

    public static void main(String[] args) {
         Date date = new Date(9, 19, 2024);
         Transaction transaction = new Transaction("Scott", date, 59.32);
         System.out.println(transaction);

    }

    public static class Transaction implements Comparable<Transaction> {
        private String transaction;
        private String who;
        private Date when;
        private double amount;

        public Transaction(String transaction) {
            this.transaction = transaction;
        }

        Transaction(String who, Date when, double amount) {
            this.who = who;
            this.when = when;
            this.amount = amount;
        }

        public String who() {
            return who;
        }

        public Date when() {
            return when;
        }

        public double amount() {
            return amount;
        }

        @Override
        public int compareTo(Transaction o) {
            return 0;
        }

        @Override
        public String toString() {
            return who() + " transaction " + amount() + " on " + when();
        }
    }
    public static class Date
    {
        private final int month;
        private final int day;
        private final int year;

        public Date(int m, int d, int y)
        {  month = m; day = d; year = y; }

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
            return day;
        }

        public String toString()
        {
            return month() + "/" + day() + "/" + year();
        }
    }

}
