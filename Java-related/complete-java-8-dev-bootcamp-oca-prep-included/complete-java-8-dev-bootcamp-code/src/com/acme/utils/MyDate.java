package com.acme.utils;

public class MyDate {
    public int year;
    public int month;
    public int day;
    {
        setDate(1, 1, 2000); // 1st of January the year 2000.
    }
    public MyDate() {
        // To have an explicit empty constructor.
    }

    public MyDate(int month, int day, int year) {
        // A constructor in the most horrible date format (month-day-year)... But this is to follow the intruction from the course.
        setDate(month, day, year);
    }
    public void setDate (int month, int day, int year){
        this.month = month;
        this.day = day;
        this.year = year;
    }
    @Override
    public String toString() {
        return month + "/"+ day + "/" + year;
    }
    public String toStringYearMonthDay(){
        return year + "/"+ month + "/" + day;
    }
}
