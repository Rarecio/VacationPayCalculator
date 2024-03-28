package ru.zhaleykin.vacationpaycalculator.entity;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

public class Holiday {

    private static final Set<Holiday> holidaysDates = new HashSet<>();

    int month;
    int day;

    static {
        addHolidays(LocalDate.of(0, Month.JANUARY, 1),
                LocalDate.of(0, Month.JANUARY, 8));
        addHoliday(Month.FEBRUARY, 23);
        addHoliday(Month.MARCH, 8);
        addHoliday(Month.MAY, 1);
        addHoliday(Month.MAY, 9);
        addHoliday(Month.JUNE, 12);
        addHoliday(Month.NOVEMBER, 4);
    }

    public Holiday(int month, int day) {
        this(LocalDate.of(0, month, day));
    }

    public Holiday(Month month, int day) {
        this(LocalDate.of(0, month, day));
    }

    public Holiday(LocalDate localDate) {
        this.month = localDate.getMonthValue();
        this.day = localDate.getDayOfMonth();
    }

    public static void addHoliday(Holiday holiday){
        holidaysDates.add(holiday);
    }

    public static void addHoliday(LocalDate date){
        addHoliday(new Holiday(date));
    }

    public static void addHoliday(int month, int day){
        addHoliday(new Holiday(month, day));
    }

    public static void addHoliday(Month month, int day){
        addHoliday(new Holiday(month, day));
    }

    public static void addHolidays(LocalDate start, LocalDate end){
        for(LocalDate date = start; !date.equals(end); date = date.plusDays(1)){
            addHoliday(date);
        }
        addHoliday(end);
    }

    public static boolean isHoliday(LocalDate date){
        return holidaysDates.contains(new Holiday(date));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Holiday holiday = (Holiday) o;

        if (month != holiday.month) return false;
        return day == holiday.day;
    }

    @Override
    public int hashCode() {
        int result = month;
        result = 31 * result + day;
        return result;
    }
}
