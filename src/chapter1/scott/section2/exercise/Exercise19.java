package chapter1.scott.section2.exercise;

public class Exercise19 {

    public static void main(String[] args) {
        Date date = new Date("11/09/2024");
        System.out.println(date);

        Transaction transaction = new Transaction("Turing 5/22/2023 11.99");
        System.out.println(transaction);
    }

    public static class Transaction implements Comparable<Transaction> {
        private String transaction;
        private String who;
        private Date when;
        private double amount;

        Transaction(String who, Date when, double amount) {
            this.who = who;
            this.when = when;
            this.amount = amount;
        }

        public Transaction(String transactionInput) {
            //Whitespace Matching Regex - Java In Java, you can use the following regular expression to match any amount of whitespace:
            // "\s+" This regular expression uses the s character class, which matches any whitespace character (such as a space, tab, or newline).
            //The + quantifier indicates that one or more whitespace characters should be matched.
            String[] tokens = transactionInput.split("\\s+");
            this.who = tokens[0];
            this.when = new Date(tokens[1]);
            this.amount = Double.parseDouble(tokens[2]);
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

        @Override
        public boolean equals(Object x) {
            if (this == x) return true;
            if (x == null) return false;
            if (getClass() != x.getClass()) return false;
            Transaction that = (Transaction) x;
            if (this.transaction != that.transaction) return false;
            if (this.who != that.who) return false;
            if (this.when != that.when) return false;
            if (this.amount != that.amount) return false;
            return true;
        }
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
