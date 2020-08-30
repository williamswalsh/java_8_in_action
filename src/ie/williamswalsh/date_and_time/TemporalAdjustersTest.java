package ie.williamswalsh.date_and_time;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.time.temporal.TemporalAdjusters.*;

public class TemporalAdjustersTest {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        LocalDate date2 = date1.with(nextOrSame(DayOfWeek.SATURDAY));
        LocalDate date3 = date1.with(lastDayOfMonth());

        System.out.println(date1 + ", " + date2 + ", " + date3);
    }
}
