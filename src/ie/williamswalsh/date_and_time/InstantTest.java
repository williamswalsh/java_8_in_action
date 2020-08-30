package ie.williamswalsh.date_and_time;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class InstantTest {
    /**
     * Computers don't think in months, weeks, hours, seconds
     * Computers can use a single time line with a point on the timeline to Represent an instant
     * Not intended for human readability
     * Only for machine use
     */

    public static void main(String[] args) {
        // An instant is an number of seconds and nano seconds
        // All below Instants are the same: 3 seconds after the epoch
        Instant instant1 = Instant.ofEpochSecond(3);
        Instant instant2 = Instant.ofEpochSecond(3, 0);
        Instant.ofEpochSecond(2, 1_000_000_000);
        Instant.ofEpochSecond(4, -1_000_000_000);

        // Duration
        // Can measure between
        // Times
        // Dates
        // DateTimes
        // Instants
        Duration d1 = Duration.between(LocalTime.now(), LocalTime.now());
        Duration d3 = Duration.between(
                LocalDateTime.of(2000, 12, 1, 1, 1, 1),
                LocalDateTime.of(2000, 12, 1, 1, 1, 1));
        Duration d4 = Duration.between(instant1, instant2);


        // A period is quantified in human readable amounts - weeks, days, months
        Period tenDays = Period.between(
                LocalDate.of(2018, 2, 10),
                LocalDate.of(2018, 2, 20));


        // Digitary Example
        LocalDate startJobAtDigitary = LocalDate.of(2018, 7, 18);
        LocalDate now = LocalDate.now();

//        Duration throws UnsupportedTemporalTypeException: Unsupported unit: Seconds
//        Duration durationAtDigitary = Duration.between(startJobAtDigitary, now);
//        System.out.println("Days at Digitary: " + durationAtDigitary.toDays());

        Period period = Period.between(startJobAtDigitary, now);
        System.out.println(period.getYears() + " Year(s), "
                + period.getMonths() + " Month(s), "
                + period.getDays() + " Day(s)");


        Duration fiveMinutes = Duration.ofMinutes(5);
        Duration fourDays = Duration.of(4, ChronoUnit.DAYS);

        Period threeDays = Period.ofDays(3);
        Period twoWeeks = Period.ofWeeks(2);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);

        Period tenDaysCopy = Period.parse(tenDays.toString());
        System.out.println(tenDaysCopy);        // P10D
        System.out.println(tenDays);            // P10D


        // Can create new LocalDates using the .with<TIME_UNIT>() methods
        // Methods don't modify existing objects, they create new Objects
        LocalDate date3 = LocalDate.of(2001, 8, 11);
        LocalDate date4 = date3.withYear(2020);
        LocalDate date5 = date3.withMonth(8);
        LocalDate date6 = date3.withDayOfMonth(30);

        // Relative time
        LocalDate date7 = date3.plusWeeks(100);
        LocalDate date8 = date3.minusYears(1);
        LocalDate date9 = date3.plus(1, ChronoUnit.DECADES);    // Note: Many different ChronoUnits, like A LOT

    }
}
