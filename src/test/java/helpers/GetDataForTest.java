package helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GetDataForTest {
    private static String firstDate;

    public static String setDateInNumberOfDays(LocalDate startDate, int days, String format) {
        LocalDate date = startDate.plusDays(days);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return date.format(formatter);
    }

    public static String setDateInNumberOfMonths(LocalDate startDate, int months, String format) {
        LocalDate date = startDate.plusMonths(months);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return date.format(formatter);
    }

    public static String setDateInNumberOfYears(LocalDate startDate, int years, String format) {
        LocalDate date = startDate.plusYears(years);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return date.format(formatter);
    }

    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }
    public static LocalDate getFirstDate() {
        return LocalDate.parse(firstDate, DateTimeFormatter.ofPattern("d MMMM yyyy"));
    }

    public static void setDate(String dateRange, LocalDate startDate){
        if (dateRange.contains("day")){
            int dayNumber = Integer.parseInt(StringUtils.substringBefore(dateRange, " "));
            String targetDate = GetDataForTest.setDateInNumberOfDays(startDate, dayNumber, "d MMMM yyyy");
            firstDate = targetDate;
            DataStorage.setValue("targetDate", targetDate);
        }else if (dateRange.contains("month")){
            int monthNumber = Integer.parseInt(StringUtils.substringBefore(dateRange, " "));
            String targetDate = GetDataForTest.setDateInNumberOfMonths(startDate, monthNumber, "d MMMM yyyy");
            firstDate = targetDate;
            DataStorage.setValue("targetDate", targetDate);
        }else if (dateRange.contains("year")){
            int yearNumber = Integer.parseInt(StringUtils.substringBefore(dateRange, " "));
            String targetDate = GetDataForTest.setDateInNumberOfYears(startDate, yearNumber, "d MMMM yyyy");
            firstDate = targetDate;
            DataStorage.setValue("targetDate", targetDate);
        }
    }
}