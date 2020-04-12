/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.lab02;
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author vuaphapthuat410
 */
public class CalDaysInMonth {
    public static boolean isNumeric(String strNum) {
    if (strNum == null) {
        return false;
    }
    try {
        double d = Double.parseDouble(strNum);
    } catch (NumberFormatException nfe) {
        return false;
    }
    return true;
}
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int iYear;
        String strMonth, strYear;
        int exitMon = 0;
        String[] month = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        String[] monthAb = {"Jan.","Feb.","Mar.","Apr.","May","June","July","Aug.","Sept.","Oct.","Nov.","Dec."};
        String[] month3L = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        int[] daysNLeap = {31,28,31,30,31,30,31,31,30,31,30,31};
        int[] daysLeap = {31,29,31,30,31,30,31,31,30,31,30,31};
        
        do {
            System.out.println("Enter the month: ");
            strMonth = keyboard.nextLine();
            if(isNumeric(strMonth))
            {
                int iMonth = Integer.parseInt(strMonth);
                if(iMonth > 0 && iMonth < 13)
                    exitMon = Integer.parseInt(strMonth);
            }
            else if (strMonth.length() == 3){
                for(int i = 0; i<12; i++)
                    if(strMonth.equals(month3L[i])) {
                        exitMon = i+1;
                        break;
                    }
            }
            else if (strMonth.length() == 4 || strMonth.length() == 5){
                for(int i = 0; i<12; i++)
                    if(monthAb[i].equals(strMonth)) {
                        exitMon = i+1;
                        break;
                    }
                }
            else{
                for(int i = 0; i<12; i++)
                    if(month[i].equals(strMonth)) {
                        exitMon = i+1;
                        break;
                    }
            }
        } while(exitMon == 0);
        do{
            System.out.println("Enter the year: ");
            strYear = keyboard.nextLine();     
            iYear = Integer.parseInt(strYear);
        } while(iYear < 0 || strYear.length() != 4 );
        
        if((iYear%4 == 0 && iYear%100 != 0) || iYear%400 == 0)
            System.out.println("The number of days of " + strMonth + " is: " + daysLeap[exitMon-1]);
        else 
            System.out.println("The number of days of " + strMonth + " is: " + daysNLeap[exitMon-1]);
}
}
