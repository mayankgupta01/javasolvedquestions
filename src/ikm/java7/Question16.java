package ikm.java7;

import java.io.BufferedReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Created by mayank.gupta on 31/12/16.
 */
public class Question16 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a year in YYYY : ");
        Question16 q16 = new Question16();
        int year = sc.nextInt();
        boolean result = q16.isLeapYear1(year);
//        boolean result = q16.isLeapYear2(year);
//        boolean result = q16.isLeapYear3(year);
        System.out.println("The year " + year + " is a leap year? : " + result);
    }

    public boolean isLeapYear1(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(year,1,1);
        int days = cal.getMaximum(Calendar.DAY_OF_MONTH); // this will give maximum possible days in any month, not in feb. getActualMaximum gives the result for feb of that year
        System.out.println( " Days in February of year : " + year + " are : " + days);
        return (days == 29);
    }

    public boolean isLeapYear2(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        int days = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
        return days > 365;
    }

    public boolean isLeapYear3(int year) {
        GregorianCalendar cal = new GregorianCalendar();  // Gregorian calendar omits century years not divisible by 400. Julian calendar specifies leap years every 4 years.
        return cal.isLeapYear(year);
    }

    public boolean isLeapYear4(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(year,Calendar.FEBRUARY,1);
//        int days = cal.getLastDay(Calendar.DAY_OF_MONTH);   no such method getLastDay
        return false;
    }

    public boolean isLeapYear5(int year) {
        Calendar cal = Calendar.getInstance();
//        return cal.isLeapYear(); nosuch method
        return false;
    }
}
