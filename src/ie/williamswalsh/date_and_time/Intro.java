package ie.williamswalsh.date_and_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class Intro {
    public static void main(String[] args) {
        // Java1.0 - Date
        // Java1.1 - Calendar
        // Java8
        // LocalDate, LocalTime, LocalDateTime, Instant, Duration, Period

        // Construction .of(...) and .now()
        LocalDate easterRisingStart = LocalDate.of(1916, 4, 24);
        LocalDate easterRisingEnd = LocalDate.of(1916, 4, 29);

        LocalDate myBirthday = LocalDate.of(1990, 11, 26);
        System.out.println("Year: " + myBirthday.getYear());
        System.out.println("Month: " + myBirthday.getMonthValue());
        System.out.println("Day of month: " + myBirthday.getDayOfMonth());
        System.out.println("Day of week: " + myBirthday.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH));
        System.out.println("Number of Days in month: " + myBirthday.lengthOfMonth());
        System.out.println("Leap Year: " + myBirthday.isLeapYear());

        LocalDate today = LocalDate.now();

        // Can also use .get(<TemporalField>)
        // ChronoField implements TemporalField interface
        int year = today.get(ChronoField.YEAR);
        int month = today.get(ChronoField.MONTH_OF_YEAR);
        int dayOfMonth = today.get(ChronoField.DAY_OF_MONTH);


        // LocalTime
        LocalTime timeRightNow = LocalTime.now();
        LocalTime dinnerTime = LocalTime.of(17, 30, 00);
        int hour = dinnerTime.getHour();

        // Parse Methods LocalDate, LocalTime
        // can throw DateTimeParseException
        LocalTime detectedTime = LocalTime.parse("16:49:51");


        LocalDateTime startJobAtDigitary = LocalDateTime.of(2020, 7, 18, 12, 0, 0);
        LocalDateTime now = LocalDateTime.now();

        // Composing
        // Combining LocalTime with a LocalDate
        LocalDate date1 = LocalDate.of(1989, 11,24);
        LocalDateTime dateTime1 = date1.atTime(12, 15, 30);

        // Combining LocalDate with a LocalTime
        LocalTime time1 = LocalTime.of(12, 15, 30);
        LocalDateTime dateTime2 = time1.atDate(date1);


        // Breaking Down
        // LocalDateTime -> LocalDate
        LocalDate date2 = dateTime1.toLocalDate();

        // LocalDateTime -> LocalTime
        LocalTime time2 = dateTime1.toLocalTime();
    }
}
