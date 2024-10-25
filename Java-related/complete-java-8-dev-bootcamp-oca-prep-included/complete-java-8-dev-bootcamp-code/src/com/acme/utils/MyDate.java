package com.acme.utils;

import java.time.Month;
import java.util.Objects;

public class MyDate {
    private short year;
    private byte month;
    private byte day;

    private static MyDate[] holidays;

    static {
        holidays = new MyDate[]
                {
                        new MyDate(Month.JANUARY.getValue(), 1, 2023),
                        new MyDate(Month.MAY.getValue(), 30, 2023),
                        new MyDate(Month.JULY.getValue(), 4, 2023),
                        new MyDate(Month.SEPTEMBER.getValue(), 5, 2023),
                        new MyDate(Month.NOVEMBER.getValue(), 24, 2023),
                        new MyDate(Month.DECEMBER.getValue(), 25, 2023)
                };
    }

    {
        // Default date on initialization.  1st of January the year 2000.
        setDate(1, 1, 2000);
    }
    public MyDate() {
        // To have an explicit empty constructor.
    }

    public MyDate(int month, int day, int year) {
        // A constructor in the most horrible date format (month-day-year)... But this is to follow the intruction from the course.
        setDate(month, day, year);
    }

    public static MyDate[] getHolidays() {
        return holidays;
    }
    public static void listHolidays(){
        System.out.println("the holidays are:");
        for (int i = 0; i < holidays.length; i++){
            System.out.println(holidays[i]);
        }
    }
    public static boolean isHoliday(MyDate date){
        for(int i = 0; i < holidays.length; i++){
            if(holidays[i].equals(date)){
                return true;
            }
        }
        return false;
    }
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setDate (int month, int day, int year){
        if(isDateInvalid(day, month, year)){
            System.out.println("Tried to set date to '', which is not valid");
            return;
        }
        this.year = (short) year;
        this.month = (byte) month;
        this.day = (byte) day;
    }

    public void setYear(int year) {
        if(isDateInvalid(day, month, year)){
            System.out.println(year + " is not a valid value for year");
            return;
        }
        this.year = (short) year;
    }



    public void setMonth(int month) {
        if(isDateInvalid(day, month, year)){
            System.out.println(month + " is not a valid value for month");
            return;
        }
        this.month = (byte) month;
    }



    private static boolean monthHas30Days(int month) {
        if (month == Month.APRIL.getValue()) return true;
        if (month == Month.JUNE.getValue()) return true;
        if (month == Month.SEPTEMBER.getValue()) return true;
        return month == Month.NOVEMBER.getValue();
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }


    public void setDay(int day) {
        if(isDateInvalid(day, month, year)){
            System.out.println(day + " is not a valid value for day");
            return;
        }
        this.day = (byte) day;
    }

    @Override
    public String toString() {
        return month + "/"+ day + "/" + year;
    }
    public String toStringYearMonthDay(){
        return year + "/"+ month + "/" + day;
    }

    private boolean isDateInvalid(int day, int month, int year) {
        if (month < 1 || month > 12)
            return true;
        if (day < 1 || day > 31)
            return true;
        if (month == 2) {
            if (isLeapYear(year))
                return day > 29;
            else
                return day > 28;
        }
        if (monthHas30Days(month)) return day > 30;
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return getYear() == myDate.getYear() && getMonth() == myDate.getMonth() && getDay() == myDate.getDay();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getMonth(), getDay());
    }
}
