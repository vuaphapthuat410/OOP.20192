/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aimsproject;
import java.text.ParseException;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author vuaphapthuat410
 */
public class MyDate {
    private int iDay;
    private int iMonth; //Calendar using 0-11 month while LocalTime is 1-12
    private int iYear;

    public MyDate() {
        Calendar curDate = Calendar.getInstance();
        this.iDay = curDate.get(Calendar.DAY_OF_MONTH);
        this.iMonth = curDate.get(Calendar.MONTH);
        this.iYear = curDate.get(Calendar.YEAR);
    }

    public MyDate(int day, int month, int year) {
        Calendar fDate = Calendar.getInstance();
        fDate.set(year, month-1, 1);
        if(day < 1 || day > fDate.getActualMaximum(Calendar.DAY_OF_MONTH) ){ //getActualMaximum to get the last day of month
            System.out.println("Not valid date.");
            return;
        }
        
        this.iDay = day;
        this.iMonth = month-1;
        this.iYear = year;
    }

    public MyDate(String iDate) {
        String dateFormat = "MMMMM dd yyyy";
        Date bDate;
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        Calendar fDate = Calendar.getInstance();
        formatter.setLenient(false);
        try {
            if(iDate.contains("1st"))
               bDate = formatter.parse((iDate.replaceAll("st", "")).trim());
            else if(iDate.contains("2nd"))
                bDate = formatter.parse((iDate.replaceAll("nd", "")).trim());
            else if(iDate.contains("3rd"))
                bDate = formatter.parse((iDate.replaceAll("rd", "")).trim());
            else
                bDate = formatter.parse((iDate.replaceAll("th", "")).trim()); //replaceAll(): replace all st|nd|rd|th = ""
                                                                        //trim() to remove blank before and after the str
        } catch (ParseException pe) {
            System.out.println("Not a valid date or wrong format.");
            return;
        }      
        
        fDate.setTime(bDate);
        this.iDay = fDate.get(Calendar.DAY_OF_MONTH);
        this.iMonth = fDate.get(Calendar.MONTH);
        this.iYear = fDate.get(Calendar.YEAR);
    }    

    public int getDay() {
        return iDay;
    }

    public void setDay(int day) {
        Calendar fDate = Calendar.getInstance();
        fDate.set(iYear, iMonth, 1); //set the time
        if(day < 1 || day > fDate.getActualMaximum(Calendar.DAY_OF_MONTH) ){ //getActualMaximum to get the last day of month
            System.out.println("Not valid day.");
            return;
        }
            
        this.iDay = day;
    }

    public int getMonth() {
        return iMonth+1;
    }

    public void setMonth(int month) {
        Calendar fDate = Calendar.getInstance();
        fDate.set(iYear, month-1, 1); //get the first day of input month only for getting month, 1 or 2 day is not important
        if(iDay > fDate.getActualMaximum(Calendar.DAY_OF_MONTH)) { 
            System.out.println("Not valid month.");
            return;
        }
            
        this.iMonth = month-1;
    }

    public int getYear() {
        return iYear;
    }

    public void setYear(int year) {
        Calendar fDate = Calendar.getInstance();
        fDate.set(year, iMonth, 1); //get the first day of input month only for getting month, 1 or 2 day is not important
        if(iDay > fDate.getActualMaximum(Calendar.DAY_OF_MONTH)) { 
            System.out.println("Not valid year.");
            return;
        }
        
        this.iYear = year;
    }
        
    public void accept() {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Please enter a date: ");
        String strDate = keyboard.nextLine();
        String dateFormat = "MMMMMM dd yyyy";
        Date bDate;
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        Calendar fDate = Calendar.getInstance();
        formatter.setLenient(false);
        try {
            bDate = formatter.parse((strDate.replaceAll("st|nd|rd|th", "")).trim());
        } catch (ParseException pe) {
            System.out.println("Invalid date or format");
            return;
        }
        
        fDate.setTime(bDate);
        this.iDay = fDate.get(Calendar.DAY_OF_MONTH);
        this.iMonth = fDate.get(Calendar.MONTH);
        this.iYear = fDate.get(Calendar.YEAR);
        
        System.out.println("Updated sucessfully");
        keyboard.close();
    }
    
    public void print() {
        System.out.printf("%02d/%02d/%4d\n", iDay, iMonth+1, iYear); //iMonth is less than real month 1 point cuz of Calendar lib
                                                                    // %02d mean that if only 1 digit, the other wwill be filled with 0
    }
}
