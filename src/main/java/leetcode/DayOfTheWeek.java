package main.java.leetcode;

// 01/01/1971 --> Friday
// LocalDate.of(2012, Month.DECEMBER, 12); // from values
public class DayOfTheWeek {

    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int numOfDays = getNumOfDays(day, month, year);
        int calculatedDay = (numOfDays+5)%7;
        return days[calculatedDay];
    }

    private int getNumOfDays(int day, int month, int year) {
        int numOfDays=0;
        int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
        if(year%4 == 0)
            daysInMonth[1] = 29;

        for(int currYear=1971; currYear<year;currYear++) {
            if(currYear%4 == 0)
                numOfDays+=366;
            else
                numOfDays+=365;
        }

        for(int currMonth=0; currMonth<month-1; currMonth++) {
            numOfDays+=daysInMonth[currMonth];
        }

        numOfDays+=day-1;
        return numOfDays;
    }


    public static void main(String[] args) {
        DayOfTheWeek dayOfTheWeek = new DayOfTheWeek();
        System.out.println(dayOfTheWeek.dayOfTheWeek(6, 12, 1992));
    }
}
