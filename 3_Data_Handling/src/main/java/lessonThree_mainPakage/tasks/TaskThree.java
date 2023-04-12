package lessonThree_mainPakage.tasks;

import lessonThree_mainPakage.primaryPakage.AllFunctions;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.lastDayOfYear;

public class TaskThree {
//By number, return the name of the month.
    public static void numberOfMonths(){
        System.out.println("In this task you need to return the name of the month corresponding to entered number (1 - January). " +
                "If the original number is outside the range of 1-12, return an error message.\nEnter the number");
        int month = AllFunctions.scannerInt();
        if (month<=12) {
            System.out.println("Needs month is:" + Month.of(month));
        }
        else {
            System.out.println("Try again! ");
        }
    }
//Find all Fridays 13 in the year.
    public static void fridayOfYear(int year){
        System.out.println("In this task you need to find all Fridays 13 in the year.");
        System.out.println("Enter the year in format 'yyyy' :");
        LocalDate inputDate = LocalDate.of(year,1,1);
        while(inputDate.getYear()!= year + 1){
            if (inputDate.getDayOfWeek() == DayOfWeek.FRIDAY && inputDate.getDayOfMonth() == 13){
                System.out.println("Needs value is : " + inputDate);
            }
            inputDate = inputDate.plusDays(1);
        }
    }
//Find the last day of the month of the transmitted date.
    public static void findLastDayOfMonth(int day, int month, int year){
        System.out.println("Find the last day of the month of the transmitted date, return " +
                "a string in the format Sunday Jan 31, 2021.");
        System.out.println("Enter the YEAR(in format 'yyyy'), MONTH(in format 'M' or 'MM') " +
                "AND DAY(in format 'd' or 'dd') values via ENTER : ");
        LocalDate inputDate = LocalDate.of(year,month,day);
        LocalDate date = inputDate.with(lastDayOfMonth());
        System.out.println("Needs value is : " +
                date.format(DateTimeFormatter.ofPattern("EEE, MMMM d, yyyy",Locale.ENGLISH)));
    }
//Find the date-time that is furthest from the current day.
    public static void mostRemoteDate(){
        System.out.println("In this task we need to find the date-time that is furthest from the current day " +
                "(in the past or future) in the LocalDateTime array.");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime lastDayOfYear = now.with(lastDayOfYear());
        LocalDateTime firstDayOfYear = now.with(TemporalAdjusters.firstDayOfYear());
        LocalDateTime maxRemove;
        if (lastDayOfYear.compareTo(now) > (firstDayOfYear.compareTo(now))){
            maxRemove = firstDayOfYear;
        }
        else {
            maxRemove = lastDayOfYear;
        }
        System.out.println("Needs value is : " +
                maxRemove.format(DateTimeFormatter.ofPattern("EEE, MMMM d, yyyy,HH:mm:ss ",Locale.ENGLISH)));
    }
//Time from the transmitted time to midnight.
    public static void timeUntilMidnight(int hours , int minutes) {
        System.out.println("In this task you need to calculate how many hours are " +
                "left from the transmitted time to midnight.");
        System.out.println("Enter the our in format 'HH' than click to ENTER in your keyboard and enter the minutes" +
                "in format 'mm'.");
        LocalTime inputTime = LocalTime.of(hours, minutes);
        LocalTime midNightTime = LocalTime.MIDNIGHT;
        Duration duration = Duration.between(midNightTime, inputTime);
        long secondPassed = duration.getSeconds();
        double needsHour = 24 - secondPassed / 3600.0;
        int needsMinutes = (int) (secondPassed / 60)%60;
        System.out.println("Time remaining until midnight is : " + (int)needsHour
                + " hours and " + needsMinutes + " minutes.");
    }
}