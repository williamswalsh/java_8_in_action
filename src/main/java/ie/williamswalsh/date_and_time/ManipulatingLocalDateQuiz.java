package ie.williamswalsh.date_and_time;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class ManipulatingLocalDateQuiz {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2014, 3, 18);                 // 18-03-2014
        date = date.with(ChronoField.MONTH_OF_YEAR, 9);                          // 18-09-2014
        date = date.plusYears(2).minusDays(10);                                           // 08-09-2016
        date.withYear(2011);                                                              // 08-09-2016 - same
    }
}
