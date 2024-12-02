package chapter1.scott.section2.exercise;

import java.util.Date;

public class Exercise12 {

    public static void main(String[] args) {
        SmartDate smartDate = new SmartDate(2023, 9, 20);
        System.out.println("Day Of Week is " + smartDate.dayOfTheWeek());
    }

    enum DayOfWeek {
        MONDAY("Monday"), TUESDAY("Tuesday"), WEDNESDAY("Wednesday"), THURSDAY("Thursday"), FRIDAY("Friday"), SATURDAY("Saturday"), SUNDAY("Sunday");
        private String day;

        DayOfWeek(String day) {
            this.day = day;
        }

        public String getDay() {
            return day;
        }

    }

    private static class SmartDate {
        private final int month;
        private final int day;
        private final int year;

        public SmartDate(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public String dayOfTheWeek() {
            String dayInWeek = "";
            Date date = new Date(year, month, day);
            switch (date.getDay()) {
                case 1:
                    dayInWeek = DayOfWeek.SUNDAY.getDay();
                    break;
                case 2:
                    dayInWeek = DayOfWeek.MONDAY.getDay();
                    break;
                case 3:
                    dayInWeek = DayOfWeek.TUESDAY.getDay();
                    break;
                case 4:
                    dayInWeek = DayOfWeek.WEDNESDAY.getDay();
                    break;
                case 5:
                    dayInWeek = DayOfWeek.THURSDAY.getDay();
                    break;
                case 6:
                    dayInWeek = DayOfWeek.FRIDAY.getDay();
                    break;
                case 7:
                    dayInWeek = DayOfWeek.SATURDAY.getDay();
                    break;
            }
            return dayInWeek;
        }

        public void validate() {
            if (month < 1 || month > 12) {
                throw new IllegalArgumentException("Month must be between 1 and 12");
            }
            if (day < 1 || day > 31) {
                throw new IllegalArgumentException("Day must be between 1 and 31");
            }
            if (year < 1 || year > 9999) {
                throw new IllegalArgumentException("Year must be between 1 and 9999");
            }
        }

        // Support valid day
        private boolean isDateValid(int month, int day, int year) {
            boolean valid = true;
            int[] maxNumberOfDaysPerMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            if (year < 1 || month < 1 || month > 12 || day < 1 || day > maxNumberOfDaysPerMonth[month - 1]) {
                valid = false;
            }
            return valid;
        }

        public int month()
        {  return month;  }
        public int day()
        {  return day;  }
        public int year()
        {  return year;  }

        public String toString()
        {  return month() + "/" + day() + "/" + year();  }

        public boolean equals(Object x)
        {
            if (this == x) return true;
            if (x == null) return false;
            if (this.getClass() != x.getClass()) return false;
            Exercise12.SmartDate that = (Exercise12.SmartDate) x;
            if (this.day != that.day)
                return false;
            if (this.month != that.month)
                return false;
            if (this.year != that.year)
                return false;
            return true;
        }


    }
}
