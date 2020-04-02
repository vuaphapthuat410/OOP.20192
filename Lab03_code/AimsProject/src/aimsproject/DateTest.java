/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aimsproject;

/**
 *
 * @author vuaphapthuat410
 */
public class DateTest {
    public static void main(String[] args) {
        MyDate aDate = new MyDate("feb 18th 2019");
        //aDate.setMonth(2);
        //aDate.setDay(29);
        //aDate.setYear(2100);
        //aDate.accept();
        aDate.print();
        System.out.println(aDate.getDay()+"/"+aDate.getMonth()+"/"+aDate.getYear());
    }
}
