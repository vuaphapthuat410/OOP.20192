/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab02;

import java.util.*;

/**
 *
 * @author vuaphapthuat410
 */
public class SortNumericArr {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Integer> arrli = new ArrayList<Integer>();
        int tmp, sum=0;
        double avg;
        
        System.out.println("Enter the number of array elements: ");
        int iCount = keyboard.nextInt();
        
        for(int i=0; i<iCount; i++){
            System.out.println("Enter the " + Integer.toString(i+1) + " element: ");
            arrli.add(keyboard.nextInt());
        }
        Collections.sort(arrli);
        for(int i=0; i<iCount; i++){
             sum += arrli.get(i);
             System.out.println(arrli.get(i));
        }          
        avg = sum/iCount;
        
        System.out.println("Sum of array: " + Integer.toString(sum));
        System.out.println("Sum of array: " + Double.toString(avg));
    }
}
